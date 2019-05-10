package com.via.Webservice.WebService.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Co2;
import com.via.Webservice.WebService.model.Humidity;
import com.via.Webservice.WebService.service.Humidity.HumidityService;

@RestController
@RequestMapping("/sep4/humidity")
public class HumidityController {
	@Autowired
	HumidityService service;

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Humidity>> findHumidityById(@PathVariable("id") Integer id) {
		Optional<Humidity> humidity = service.findHumidityById(id);
		if (humidity != null) {

			return new ResponseEntity<Optional<Humidity>>(humidity, HttpStatus.OK);
		} else
			return new ResponseEntity<Optional<Humidity>>(humidity, HttpStatus.NOT_FOUND);

	}

//	@GetMapping("/room/all")
//	public ResponseEntity<Iterable<Humidity>> findAllHumidity(@PathVariable("id") int room_id) {
//		Iterable<Humidity> list = service.findAll(room_id);
//		Humidity humidity = new Humidity();
//		humidity.add(linkTo(methodOn(HumidityController.class).findAllHumidity(room_id)).withSelfRel());
//		return new ResponseEntity<Iterable<Humidity>>(list, HttpStatus.OK);
//	}

	@GetMapping("/room/{id}")
	public ResponseEntity<Iterable<Humidity>> findByHumidityRoom(@PathVariable("id") int room_id) {
		Iterable<Humidity> list = service.findByHumidityRoom(room_id);
		return new ResponseEntity<Iterable<Humidity>>(list, HttpStatus.OK);
	}

}
