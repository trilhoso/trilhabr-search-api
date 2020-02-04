package br.com.trilhabr.api.model.dto.tripadvisor;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data"
})
@Getter
@Setter
public class LocaisTripAdvisor {

    @JsonProperty("data")
    private List<LocalTripAdvisor> data = null;
}
