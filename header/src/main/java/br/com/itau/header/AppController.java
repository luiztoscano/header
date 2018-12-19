package br.com.itau.header;

import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.header.core.Conta;
import br.com.itau.header.kafka.Receiver;
import br.com.itau.header.kafka.Sender;

@RestController
public class AppController {
    private static final String TOPIC = "HEADER_TOPIC_TEST";
            
	@Autowired
	private Sender<String, Conta> sender;
	@Autowired
	private Receiver<String, Conta> receiver;	
	
	@Bean(name="receiver")
	public Receiver<String, Conta> createReceiver() {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
		props.put("group.id", "grupo-1");
		props.put("enable.auto.commit", "false");
		props.put("session.timeout.ms", 15000);
		props.put("auto.offset.reset", "earliest");
		props.put("heartbeat.interval.ms", 5000);
		props.put("max.poll.interval.ms", 1000);
		List<String> states = Collections.singletonList("TEF_SOLICITADA");
		
		return new Receiver<>(props, TOPIC, states);
	}
	
	@Bean(name="sender")
	public Sender<String, Conta> createSender() {
    	Properties props = new Properties();
    	props.put("bootstrap.servers", "localhost:9092");
    	props.put("acks", "all");
    	props.put("retries", 0);
    	props.put("batch.size", 200000);
    	props.put("linger.ms", 100);
    	props.put("buffer.memory", 33554432);
    	props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    	props.put("value.serializer", "org.apache.kafka.connect.json.JsonSerializer");
    	
    	return new Sender<>(props, TOPIC);
	}
	
	@GetMapping(value = "/header/send")
	public void send() {
		Conta conta = new Conta();
		conta.setIdConta(UUID.randomUUID());
		sender.send(UUID.randomUUID().toString(), conta, "TEF_SOLICITADA");
	}

	@GetMapping(value = "/header/receive")
	public void receive() throws Exception {
		receiver.receive();
	}	

}