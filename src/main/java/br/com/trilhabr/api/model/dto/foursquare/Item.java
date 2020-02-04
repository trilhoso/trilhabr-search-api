package br.com.trilhabr.api.model.dto.foursquare;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "prefix",
        "suffix",
        "width",
        "height"
})
@Getter
@Setter
public class Item {

    @JsonProperty("id")
    private String id;
    @JsonProperty("prefix")
    private String prefix;
    @JsonProperty("suffix")
    private String suffix;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
}
