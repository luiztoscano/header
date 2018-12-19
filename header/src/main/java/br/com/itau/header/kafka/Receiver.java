package br.com.itau.header.kafka;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.header.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author luiz.toscano.menezes
 *
 * @param <K>
 * @param <V>
 */
@Service
public class Receiver<K,V> {
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);
    private static final Long POLL = Long.MAX_VALUE;
    private static final String HEADER_KEY = "eventType";
    private Properties props;
    private String topic;
    private List<String> states;
    private Boolean closed;
    
    /**
     * @param props
     * @param topic
     * @param states
     */
    public Receiver(Properties props, String topic, List<String> states) {
    	this.props = props;
    	this.topic = topic;
    	this.states = states;
    }
        
	/**
	 * @throws Exception
	 */
	public void receive() throws Exception {
		logger.info("Starting consumer...");

		try (KafkaConsumer<K, byte[]> consumer = new KafkaConsumer<>(this.props)) {
			ObjectMapper mapper = new ObjectMapper();
			consumer.subscribe(Collections.singletonList(topic));
			boolean found = false;
	
			while (!found) {
				ConsumerRecords<K, byte[]> records = consumer.poll(POLL);
								
				for (ConsumerRecord<K, byte[]> record : records) {
					byte[] message = record.value();
					Iterator<Header> headers = record.headers().iterator();
					
				    while (headers.hasNext()) {
				    	Header header = headers.next();
				    	
				    	if (HEADER_KEY.equalsIgnoreCase(header.key())) {	
					    	String headerValue = new String(header.value());
					    	logger.info(headerValue);
					    	
					    	if (states.contains(headerValue)) {
					    		try {
					    			V obj = mapper.readValue(message, new TypeReference<V>() {});
					    			if (obj != null) {
					    				logger.debug(obj.toString());
					    			}
					    		}
					    		catch (Exception e) {
					    			logger.error(e.getMessage(), e);
					    		}
					    		finally {
					    			consumer.commitAsync();
					    		}
					    	}
				    	}
				    }		    
				}
			}
		}
		
		logger.info("Consumer finalized");
	}
}
