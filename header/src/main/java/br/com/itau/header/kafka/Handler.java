package br.com.itau.header.kafka;

public interface Handler<T> {
	public void handle(T obj) throws HandlerException;
	
}
