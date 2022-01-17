package com.web.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * 
 * @author s.yadav
 *
 */
@Component
public class ActiveMqConsumer extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("activemq:my-activemq")
		.log("${body}")
		.to("log:received-message-from-active-mq");

		
	}

}
