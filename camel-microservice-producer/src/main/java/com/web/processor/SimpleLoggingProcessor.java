package com.web.processor;

import java.time.LocalDate;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleLoggingProcessor implements Processor {
	
	private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		String message = (String) exchange.getIn().getBody();
		logger.info("SimpleLoggingProcessor {}", message);
		exchange.getIn().setBody(message+LocalDate.now());
	}

}