package br.com.trilhabr.api.model.dto.foursquare;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "tier",
        "message",
        "currency"
})
@Getter
@Setter
public class Price {

    @JsonProperty("tier")
    private Integer tier;
    @JsonProperty("message")
    private String message;
    @JsonProperty("currency")
    private String currency;
}
