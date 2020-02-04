package br.com.trilhabr.api.model.dto.tripadvisor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "street1",
        "street2",
        "city",
        "state",
        "country",
        "postalcode",
        "address_string"
})
@Getter
@Setter
public class AddressObj {

    @JsonProperty("street1")
    private String street1;
    @JsonProperty("street2")
    private String street2;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;
    @JsonProperty("postalcode")
    private String postalcode;
    @JsonProperty("address_string")
    private String addressString;

}
