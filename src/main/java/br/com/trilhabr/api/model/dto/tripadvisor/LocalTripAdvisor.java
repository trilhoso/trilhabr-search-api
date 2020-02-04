package br.com.trilhabr.api.model.dto.tripadvisor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "address_obj",
        "latitude",
        "rating",
        "location_id",
        "trip_types",
        "write_review",
        "longitude",
        "location_string",
        "web_url",
        "name",
        "category"
})
@Getter
@Setter
public class LocalTripAdvisor {

    @JsonProperty("address_obj")
    private AddressObj addressObj;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("location_id")
    private String locationId;
    @JsonProperty("trip_types")
    private List<TripType> tripTypes = null;
    @JsonProperty("write_review")
    private String writeReview;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("location_string")
    private String locationString;
    @JsonProperty("web_url")
    private String webUrl;
    @JsonProperty("price_level")
    private String priceLevel;
    @JsonProperty("name")
    private String name;
    @JsonProperty("category")
    private Category category;

}
