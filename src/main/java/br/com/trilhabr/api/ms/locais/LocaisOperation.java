package br.com.trilhabr.api.ms.locais;

import br.com.trilhabr.api.exception.TrilhaBusinessException;
import br.com.trilhabr.api.model.dto.foursquare.*;
import br.com.trilhabr.api.model.trilhabr.Address;
import br.com.trilhabr.api.model.trilhabr.Locais;
import br.com.trilhabr.api.model.trilhabr.Local;
import br.com.trilhabr.api.model.trilhabr.Photo;
import br.com.trilhabr.api.repository.LocalRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service
public class LocaisOperation {

    @Value("${trilhabr.userlessAuth:config}")
    private String userlessAuth;
    @Value("${trilhabr.pathUrlPostInsertLocaisByRegion:config}")
    private String pathUrlPostInsertLocaisByRegion;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LocaisFourSquareDetailedBuilder locaisFourSquareDetailedBuilder;
    @Autowired
    private LocalRepository localRepository;

    public ResponseEntity<Void> insertLocaisByRegionPost(String region) {
        Void avoid = null;
        String url = this.pathUrlPostInsertLocaisByRegion;
        url = url + "?near=" + region + "&"+ userlessAuth;

        Locais locais = null;
        LocaisFourSquare locaisFourSquare = null;
        LocaisFourSquare detailedLocaisFourSquare = null;
        try {
            locaisFourSquare = restTemplate.getForObject(url, LocaisFourSquare.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new TrilhaBusinessException("Erro ao consulta locais na APIFourSquare");
        }

        if (locaisFourSquare != null && locaisFourSquare.getResponseFourSquare() != null
                && locaisFourSquare.getResponseFourSquare().getVenues() != null
                && !locaisFourSquare.getResponseFourSquare().getVenues().isEmpty()) {
            detailedLocaisFourSquare =
                    locaisFourSquareDetailedBuilder.buildDetailedLocaisFourSquare(locaisFourSquare, userlessAuth, restTemplate);
        }

        if (detailedLocaisFourSquare != null && detailedLocaisFourSquare.getResponseFourSquare() != null) {
            locais = buildLocais(detailedLocaisFourSquare);
        }

        if (locais != null && locais.getLocalList() != null && !locais.getLocalList().isEmpty()) {
            for (Local saveLocal : locais.getLocalList()) {
                try {
                    if (localRepository.existsByIdFourSquare(saveLocal.getIdFourSquare())
                            || localRepository.existsByIdTripAdvisor(saveLocal.getIdTripAdvisor())) {
                        localRepository.saveAndFlush(saveLocal);
                    } else {
                        localRepository.save(saveLocal);
                    }
                } catch (Exception e) {
                    throw new TrilhaBusinessException("Erro ao salvar local: "
                            + saveLocal.getName());
                }
            }
        }

        return new ResponseEntity<Void>(avoid, HttpStatus.OK);
    }

    private Locais buildLocais(LocaisFourSquare detailedLocaisFourSquare) {
        Locais locais = new Locais();
        locais.setLocalList(buildLocalList(detailedLocaisFourSquare));
        return locais;
    }

    private List<Local> buildLocalList(LocaisFourSquare detailedLocaisFourSquare) {
        List<Local> localList = null;
        if (detailedLocaisFourSquare.getResponseFourSquare().getVenues() != null
                && !detailedLocaisFourSquare.getResponseFourSquare().getVenues().isEmpty()) {
            localList = new ArrayList<Local>();

            for (Venue venue : detailedLocaisFourSquare.getResponseFourSquare().getVenues()) {
                localList.add(buildLocal(venue));
            }
        }
        return localList;
    }

    private Local buildLocal(Venue venue) {
        Local local = new Local();
        if (venue.getName() != null)
            local.setName(venue.getName());

        if (venue.getId() != null)
            local.setIdFourSquare(venue.getId());

        if (venue.getLocation() != null) {
            if (venue.getLocation().getLat() != null)
                local.setLatitude(String.valueOf(venue.getLocation().getLat()));

            if (venue.getLocation().getLng() != null)
                local.setLongitude(String.valueOf(venue.getLocation().getLng()));

            local.setAddress(buildAddress(venue.getLocation()));
        }

        if (venue.getPrice() != null && venue.getPrice().getTier() != null) {
            if (venue.getPrice().getTier() == 1) {
                local.setPriceLevel("$");
            } else if (venue.getPrice().getTier() == 2) {
                local.setPriceLevel("$$");
            } else if (venue.getPrice().getTier() == 3) {
                local.setPriceLevel("$$$");
            }
        }

        if (venue.getRating() != null)
            local.setRating(String.valueOf(venue.getRating()));

        if (venue.getContact() != null && venue.getContact().getPhone() != null)
            local.setPhoneNumber(venue.getContact().getPhone());

        if (venue.getPhotos() != null && venue.getPhotos().getGroups() != null
                && !venue.getPhotos().getGroups().isEmpty()) {
            List<Photo> photoList = new ArrayList<>();
            for (Group group : venue.getPhotos().getGroups()) {
                for (Item item : group.getItems()) {
                    StringBuilder photo = new StringBuilder();
                    photo.append(item.getPrefix());
                    photo.append(item.getWidth());
                    photo.append("x");
                    photo.append(item.getHeight());
                    photo.append(item.getSuffix());
                    photoList.add(new Photo(photo.toString(), local));
                }
            }
            local.setPhotoList(photoList);

        }

        return local;
    }

    private Address buildAddress(Location location) {
        Address address = new Address();

        if (location.getAddress() != null)
            address.setStreet(location.getAddress());

        if (location.getCity() != null)
            address.setCity(location.getCity());

        if (location.getState() != null)
            address.setState(location.getState());

        if (location.getCountry() != null)
            address.setCountry(location.getCountry());

        if (location.getPostalCode() != null)
            address.setPostCode(location.getPostalCode());

        return address;
    }
}
