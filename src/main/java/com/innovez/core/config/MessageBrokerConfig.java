package com.innovez.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Configuration of simple STOMP message broker over WebSocket.
 * 
 * <p><strong>NOTE</strong> This configuration should be loaded in root
 * application context instead of dispatcher servlet application context.
 * 
 * @author zakyalvan
 *
 */
@Configuration
@EnableWebSocketMessageBroker
public class MessageBrokerConfig extends AbstractWebSocketMessageBrokerConfigurer {
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/notify").withSockJS();
	}
}
