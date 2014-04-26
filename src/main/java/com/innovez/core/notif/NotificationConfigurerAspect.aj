package com.innovez.core.notif;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * Configuring notification.
 * 
 * @author zakyalvan
 */
public aspect NotificationConfigurerAspect {
	@Autowired(required=false)
	private SimpMessagingTemplate messagingTemplate;
	
	private final String WEBSOCKET_TOPIC = "/topic/notify";
	
	pointcut executionsOfNotifyClientsAnnotatedControllerMethod() : execution(@NotifyClients public * (@Controller *).*(..));
	/**
	 * TODO Make this notification finer-grainer.
	 */
	after() : executionsOfNotifyClientsAnnotatedControllerMethod() {
		messagingTemplate.convertAndSend(WEBSOCKET_TOPIC, new Date());
	}
}