package br.com.trilhabr.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"address",
	"latitude",
	"longitude",
	"rating",
	"location_id",
	"web_url",
	"price_level",
	"price"
})
public class Local {
	
	@JsonProperty("address")
	private Address address;
	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("longitude")
	private String longitude;
	@JsonProperty("rating")
	private String rating;
	@JsonProperty("location_id")
	private String locationId;
	@JsonProperty("web_url")
	private String webUrl;
	@JsonProperty("price_level")
	private String priceLevel;
	@JsonProperty("price")
	private String price;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
		"street",
		"city",
		"state",
		"country",
		"postalcode"
	})
	private class Address {

		@JsonProperty("street")
		private String street;
		@JsonProperty("city")
		private String city;
		@JsonProperty("state")
		private String state;
		@JsonProperty("country")
		private String country;
		@JsonProperty("postalcode")
		private String postalcode;
	}
}
