package com.sine95.tweetsrv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;


@Component
public class StopApp implements ApplicationListener<ContextClosedEvent >{

	private final Logger log = LoggerFactory.getLogger(StopApp.class);
	
	
	
	@Override
	public void onApplicationEvent(ContextClosedEvent  event) {
		log.info("App refrescada ");
		log.info("Fin App refrescada ");
	}
}
