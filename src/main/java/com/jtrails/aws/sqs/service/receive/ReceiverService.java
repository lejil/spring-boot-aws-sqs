package com.jtrails.aws.sqs.service.receive;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jtrails.aws.sqs.model.TravelDestination;

import io.awspring.cloud.sqs.annotation.SqsListener;
import software.amazon.awssdk.services.sqs.model.Message;

/**
 * @author Lejil
 *
 */
@Service
public class ReceiverService {

	@Value("${aws.sqs.queue.name}")
	private String queueName;

	@Autowired
	private ObjectMapper objectMapper;

	Logger log = LogManager.getLogger(ReceiverService.class);

	@SqsListener("${aws.sqs.queue.name}")
	public void listen(Message message) {
		if (null != message && null != message.body()) {
			TravelDestination traveDestination = null;
			try {
				traveDestination = objectMapper.readValue(message.body(), TravelDestination.class);
				log.info("Message received on listen method at {}", traveDestination);
			} catch (JsonProcessingException e) {
				log.error("Exception {}", e.getMessage());
			}
		}

	}

}