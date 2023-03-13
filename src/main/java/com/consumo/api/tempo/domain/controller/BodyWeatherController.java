package com.consumo.api.tempo.domain.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.consumo.api.tempo.domain.model.BodyWeather;

@RestController
@RequestMapping("/tempo")
public class BodyWeatherController {
	@Value("${api.key}")
	private String apiKey;
	@Value("${url.api}")
	private String urlApi;
	
	@GetMapping("/{cidade}")
	public BodyWeather getDados(@PathVariable String cidade) {
		RestTemplate restTemplate= new RestTemplate();
		StringBuilder stringBuilder= new StringBuilder();
		String urlFinal= stringBuilder.append(urlApi)
				.append(cidade).append("&appid=")
				.append(apiKey).toString();
		ResponseEntity<BodyWeather> entity = restTemplate.getForEntity(urlFinal, BodyWeather.class);

		return entity.getBody();
	}
	
	@GetMapping("/{cidade}/temp")
	public ResponseEntity<?> getTempo(@PathVariable String cidade) {
		BodyWeather body = getDados(cidade);
		return ResponseEntity.status(HttpStatus.OK).body(body.getMain());
		
	}
	@GetMapping("/{cidade}/wind")
	public ResponseEntity<?> getWind(@PathVariable String cidade) {
		BodyWeather body = getDados(cidade);
		return ResponseEntity.status(HttpStatus.OK).body(body.getWind());
		
	}
	@GetMapping("/{cidade}/weather")
	public ResponseEntity<?> getWeather(@PathVariable String cidade) {
		BodyWeather body = getDados(cidade);
		return ResponseEntity.status(HttpStatus.OK).body(body.getWeather());
		
	}
	@GetMapping("/{cidade}/coord")
	public ResponseEntity<?> getCoord(@PathVariable String cidade) {
		BodyWeather body = getDados(cidade);
		return ResponseEntity.status(HttpStatus.OK).body(body.getCoord());
		
	}
}