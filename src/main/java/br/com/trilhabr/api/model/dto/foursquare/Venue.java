package br.com.trilhabr.api.model.dto.foursquare;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "location",
        "categories",
        "contact",
        "canonicalUrl",
        "rating",
        "photos",
        "price"
})
@Getter
@Setter
public class Venue {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("categories")
    private List<Category> categories = null;
    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("canonicalUrl")
    private String canonicalUrl;
    @JsonProperty("rating")
    private Double rating;
    @JsonProperty("photos")
    private Photos photos;
    @JsonProperty("price")
    private Price price;
    
}
