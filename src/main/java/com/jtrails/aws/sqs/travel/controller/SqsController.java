package com.jtrails.aws.sqs.travel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jtrails.aws.sqs.model.TravelDestination;
import com.jtrails.aws.sqs.service.publsh.PublisherService;

/**
 * @author Lejil
 *
 */

@RestController
@RequestMapping("/travelBooking")
public class SqsController {

	private final PublisherService publisherService;

	SqsController(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	@PostMapping("/publishDestination")
	public ResponseEntity<String> pushMessageToQueue(@RequestBody TravelDestination travelDestination) {
		publisherService.publishMessage(travelDestination);
		return new ResponseEntity<>("Pushed the Message to Queue", HttpStatus.OK);
	}
}
