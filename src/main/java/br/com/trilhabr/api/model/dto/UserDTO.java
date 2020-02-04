package br.com.trilhabr.api.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "email",
        "password",
        "firstName",
        "lastName",
        "primaryTelephone",
        "birthDate",
        "streetName",
        "city",
        "postCode",
        "state",
        "country"
})
public class UserDTO {

    @Email
    @NotBlank
    @JsonProperty("email")
    private String email;
    @NotBlank
    @JsonProperty("password")
    private String password;
    @NotBlank
    @JsonProperty("firstName")
    private String firstName;
    @NotBlank
    @JsonProperty("lastName")
    private String lastName;
    @NotBlank
    @JsonProperty("primaryTelephone")
    private String primaryTelephone;
    @Column(name = "birthDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonProperty("birthDate")
    private Date birthDate;
    @JsonProperty("streetName")
    private String streetName;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postCode")
    private String postCode;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;
}
