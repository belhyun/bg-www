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
	
	@JsonProperty
	private ObjectNode geometry;
}
