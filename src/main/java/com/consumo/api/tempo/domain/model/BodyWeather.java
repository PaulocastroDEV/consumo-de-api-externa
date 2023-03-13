package com.consumo.api.tempo.domain.model;

import lombok.Data;

@Data
public class BodyWeather {
	private Coord coord;
	private Weather[] weather;
	private String base;
	private Main main;
	private Integer visibility;
	private Wind wind;
	private Clouds clouds;
	private Integer dt;
	private Sys sys;
	private Integer timezone;
	private Long id;
	private String name;
	private Integer cod;
}