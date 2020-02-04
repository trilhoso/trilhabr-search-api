package br.com.trilhabr.api.model.dto.foursquare;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "venues",
        "venue"
})
@Getter
@Setter
public class ResponseFourSquare {

    @JsonProperty("venues")
    private List<Venue> venues = null;
    @JsonProperty("venue")
    private Venue venue = null;
}
