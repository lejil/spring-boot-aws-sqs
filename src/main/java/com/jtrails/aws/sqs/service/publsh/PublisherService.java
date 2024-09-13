package com.jtrails.aws.sqs.service.publsh;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jtrails.aws.sqs.model.TravelDestination;

import io.awspring.cloud.sqs.operations.SqsTemplate;
/**
 * @author Lejil
 *
 */
@Service
public class PublisherService {

	@Value("${aws.sqs.queue.name}")
	private String queueName;

	Logger log = LogManager.getLogger(PublisherService.class);

	private final SqsTemplate sqsTemplate;

	PublisherService(SqsTemplate sqsTemplate) {
		this.sqsTemplate = sqsTemplate;
	}

	public void publishMessage(TravelDestination travelDestination) {
		try {
			sqsTemplate.sendAsync(queueName, travelDestination);

			log.debug(String.format("Published the message to SQS"));

		} catch (Exception e) {
			log.error("Queue Exception Message: {}", e.getMessage());
		}

	}

}