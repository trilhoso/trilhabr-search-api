
package br.com.trilhabr.api.model.trilhabr;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
    "postcode",
    "state",
    "country"
})
@Getter
@Setter
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
    @JsonProperty("birthDate")
    private String birthDate;
    @JsonProperty("streetName")
    private String streetName;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("state")
    private String state;
    @JsonProperty("country")
    private String country;

}
