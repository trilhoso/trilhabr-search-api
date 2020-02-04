package br.com.trilhabr.api.model.dto.foursquare;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "phone",
        "formattedPhone",
        "twitter",
        "instagram",
        "facebook",
        "facebookUsername",
        "facebookName"
})
@Getter
@Setter
public class Contact {

    @JsonProperty("phone")
    private String phone;
    @JsonProperty("formattedPhone")
    private String formattedPhone;
    @JsonProperty("twitter")
    private String twitter;
    @JsonProperty("instagram")
    private String instagram;
    @JsonProperty("facebook")
    private String facebook;
    @JsonProperty("facebookUsername")
    private String facebookUsername;
    @JsonProperty("facebookName")
    private String facebookName;
}
