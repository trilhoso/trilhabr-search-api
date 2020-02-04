package br.com.trilhabr.api.ms.locais;

import br.com.trilhabr.api.exception.TrilhaBusinessException;
import br.com.trilhabr.api.model.dto.foursquare.LocaisFourSquare;
import br.com.trilhabr.api.model.dto.foursquare.ResponseFourSquare;
import br.com.trilhabr.api.model.dto.foursquare.Venue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class LocaisFourSquareDetailedBuilder {

    private String pathUrlGetLocalById;

    public LocaisFourSquare buildDetailedLocaisFourSquare(LocaisFourSquare locaisFourSquare, String userlessAuth, RestTemplate restTemplate) {
        LocaisFourSquare detailedLocaisFourSquare = new LocaisFourSquare();
        ResponseFourSquare responseFourSquare = new ResponseFourSquare();
        List<Venue> venueList = new ArrayList<Venue>();

        for (Venue venue: locaisFourSquare.getResponseFourSquare().getVenues()) {
            if (venue.getId() != null) {
                LocaisFourSquare detailed = null;
                String url = pathUrlGetLocalById + venue.getId() + "?" + userlessAuth;
                try {
                    detailed = restTemplate.getForObject(url, LocaisFourSquare.class);
                } catch (Exception e) {
                    throw new TrilhaBusinessException("Erro ao consulta local: "
                            + venue.getName() != null ? venue.getName() : null + " pelo FourSquare");
                }

                if (detailed != null
                        && detailed.getResponseFourSquare() != null
                        && detailed.getResponseFourSquare().getVenue() != null) {
                    venueList.add(detailed.getResponseFourSquare().getVenue());
                }
            }
            responseFourSquare.setVenues(venueList);
            detailedLocaisFourSquare.setResponseFourSquare(responseFourSquare);
        }

        return detailedLocaisFourSquare;
    }
}
