package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.JhipsterSample3ApplicationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/jhipster-sample-3-application-kafka")
public class JhipsterSample3ApplicationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterSample3ApplicationKafkaResource.class);

    private JhipsterSample3ApplicationKafkaProducer kafkaProducer;

    public JhipsterSample3ApplicationKafkaResource(JhipsterSample3ApplicationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
