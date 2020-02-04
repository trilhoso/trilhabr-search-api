package br.com.trilhabr.api.model.dto.foursquare;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "response"
})
@Getter
@Setter
public class LocaisFourSquare {

    @JsonProperty("response")
    public ResponseFourSquare responseFourSquare;
}
