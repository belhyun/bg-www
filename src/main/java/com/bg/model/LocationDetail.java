package com.bg.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Data
@JsonIgnoreProperties(ignoreUnknown  = true)
public class LocationDetail {
	
	@JsonProperty
	private double rating;
	
	private Double lat;
	private Double lng;
	
	@JsonProperty
	private String id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String formatted_address;
	
	public void setGeometry(ObjectNode geometry){
		lat = geometry.get("location").get("lat").asDouble();
		lng = geometry.get("location").get("lng").asDouble();
	}
}
