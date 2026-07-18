package com.cognizant.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class LogFilter implements GlobalFilter {

    Logger logger = LoggerFactory.getLogger(LogFilter.class);

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("=====>Request URL {}", exchange.getRequest().getURI());

        return chain.filter(exchange);
    }
}
