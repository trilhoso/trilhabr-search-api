package br.com.trilhabr.api.model.dto.foursquare;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "address",
        "crossStreet",
        "lat",
        "lng",
        "distance",
        "postalCode",
        "cc",
        "city",
        "state",
        "country",
        "formattedAddress"
})
@Getter
@Setter
public class Location {

    @JsonProperty("address")
    private String address;
    @JsonProperty("crossStreet")
    private String crossStreet;
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lng")
    private Double lng;
    @JsonProperty("distance")
    private Integer distance;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("cc")
    private String cc;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;
    @JsonProperty("formattedAddress")
    private List<String> formattedAddress = null;
}
