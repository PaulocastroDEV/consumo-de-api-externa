package com.consumo.api.tempo.domain.model;

import lombok.Data;

@Data
public class Sys {
	private String Country;
	private Integer sunrise;
	private Integer sunset;
}