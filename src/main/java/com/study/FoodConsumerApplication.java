package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


//You can turn a Spring application into a Spring Cloud Stream application
//by applying the @EnableBinding annotation

//The @EnableBinding annotation can take as parameters one or more interface classes,
//that contain methods which represent bindable components

//Sink interface is out of the box Spring implementation for application with single inbound channel
//i.e. it absorbs

@EnableBinding(Sink.class)
@SpringBootApplication
public class FoodConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodConsumerApplication.class, args);
	}
	
	//Streamlistener allows for easier way to handle incoming messages
	@StreamListener(target=Sink.INPUT)
	public void processCheapMeals(String meal) {
		System.out.println( meal + " -> A great meal indeed!!!!");
	}
	
}
