package com.web.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * 
 * @author s.yadav
 *
 */
@Component
public class ActiveMqProducer extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("timer:my-timer?period=10000")
		.transform()
		.constant("My message to activemq ")
		.bean("simpleLoggingProcessor")
		.log("${body}")
		.to("activemq:my-activemq");
	}

}
