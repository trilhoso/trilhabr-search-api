package br.com.trilhabr.api.model.dto.tripadvisor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "localized_name"
})
@Getter
@Setter
public class Category {

    @JsonProperty("name")
    public String name;
    @JsonProperty("localized_name")
    public String localizedName;
}
