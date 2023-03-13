package com.consumo.api.tempo.domain.model;

import lombok.Data;

@Data
public class Wind {
	private Double speed;
	private Integer deg;
	private Double gust;
}