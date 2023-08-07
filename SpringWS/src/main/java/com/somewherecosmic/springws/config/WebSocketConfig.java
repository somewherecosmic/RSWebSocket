package com.somewherecosmic.springws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // add STOMP endpoint to WS config
        // secure ws -> wss
        // http url to which  a WS client needs to connect for the websocket handshake
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // enable broker
        // app dest prefixes
        // STOMP messages whose dest header begins with /app are routed to
        // @MessageMapping methods in @Controller classes
        registry.setApplicationDestinationPrefixes("/app");
        // built-in message broker for subs, broadcasting and routing messages
        // whose dest header begins with /topic or /queue
        registry.enableSimpleBroker("/topic", "/queue");
    }
}
