package com.via.Webservice.WebService.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.via.Webservice.WebService.model.Room;
import com.via.Webservice.WebService.service.Room.RoomService;

@RestController
@RequestMapping("/sep4/room")
public class RoomController {
	@Autowired
	RoomService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Room>> getRoomById(@PathVariable("id") Integer id) {
		Optional<Room> room = service.findRoomById(id);
		if (room!=null) {
	
		return new ResponseEntity<Optional<Room>>(room,HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Optional<Room>>(room, HttpStatus.NOT_FOUND);

	}

	@GetMapping("/all")
	public ResponseEntity<Iterable<Room>> findAllRoom() {
		Iterable<Room> list = service.findAllRoom();
		return new ResponseEntity<Iterable<Room>>(list, HttpStatus.OK);

	}
	@GetMapping("/name")
	public ResponseEntity<List<Room>> getRoomByName(@RequestParam("roomName") String roomName) {
		List<Room> room = service.findByRoomName(roomName);
		if (room!=null) {

		return new ResponseEntity<List<Room>>(room,HttpStatus.OK);
		}
		else 
			return new ResponseEntity<>(room, HttpStatus.NOT_FOUND);

	}

}
