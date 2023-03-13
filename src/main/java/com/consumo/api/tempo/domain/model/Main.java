package com.consumo.api.tempo.domain.model;

import lombok.Data;

@Data
public class Main {
	private Double temp;
	private Double feels_like;
	private Double temp_min;
	private Double temp_max;
	private Double pressure;
	private Integer humidity;
	private Integer sea_level;
	private Integer grnd_level;
	
}
