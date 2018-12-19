package br.com.itau.header.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Sender<K, V> {
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);
    private Properties props;
    private String topic;
    
    public Sender(Properties props, String topic) {
    	this.props = props;
    	this.topic = topic;
    }
    
    public void send(K key, V value, String state) {
    	logger.info("Producing...");

    	ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
		JsonNode jsonNode = objectMapper.valueToTree(value);    	    	    	    			
    	KafkaProducer<K, JsonNode> producer = new KafkaProducer<>(props);
    	ProducerRecord<K, JsonNode> record = new ProducerRecord<>(topic, key, jsonNode);
    	
    	record.headers().add("eventType", state.getBytes());
    	
		producer.send(record);
		producer.close();
		
		logger.info("Produced");
    }
}