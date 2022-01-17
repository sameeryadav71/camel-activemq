package com.web.routebuilder;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("file:files/input")//read file from folder
		
		.routeId("fileTransferRoute") // assign routeId(optional)
		
		.transform().body(String.class) // converting body to string class
		
//		.log("Printing absoulte path :  ${file:absolute.path}")
//	   	.log("${file:name} ${file:name.ext} ${file:name.noext} ${file:onlyname}")
//	   	.log("${file:onlyname.noext} ${file:parent} ${file:path} ${file:absolute}")
//	   	.log("${file:size} ${file:modified}")
//	   	.log("${routeId} ${camelId} ${body}")

		
		.choice()
		.when(simple("${file:ext} == 'xml' ")) // check if file is of type XML
		.to("file:files/output/xml")
		
		.when(simple("${file:ext} == 'json' "))// check if file is of type JSON
		.to("file:files/output/json")

		.when(simple("${file:ext} == 'csv' "))// check if file is of type CSV
		.to("file:files/output/csv")
		
		.otherwise() // noraml txt file
		.to("file:files/output/txt")
		.end()
		
		.log("${body}")// printing the message
		
		.to("file:files/output");// move all files to destination folder
		
	}

	
}
