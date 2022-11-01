package com.direction.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.direction.demo.pojo.GoogleDirection;
import com.direction.demo.service.DirectionService;


@RestController
@RequestMapping("/api")
public class DirectionController {

	@Autowired
	private DirectionService directionService;

	
	@GetMapping("/heredirection")
	public ResponseEntity<?> retrieveHereDirection() {

		MappingJacksonValue hereDirection = directionService.getHereDirection();

		return new ResponseEntity<>(hereDirection, HttpStatus.OK);
	}

	@GetMapping("/googledirection")
	public ResponseEntity<?> retrieveGoogleDirection() {

		MappingJacksonValue googleDirection = directionService.getGoogleDirection();


		return new ResponseEntity<>(googleDirection, HttpStatus.OK);
	}

	
	

}
