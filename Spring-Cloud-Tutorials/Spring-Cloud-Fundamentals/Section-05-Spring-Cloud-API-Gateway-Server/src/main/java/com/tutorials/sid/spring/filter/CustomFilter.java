/**
 * 
 */
package com.tutorials.sid.spring.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * @author Lenovo
 *
 */
@Component
public class CustomFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("Pre Processing Logic Goes here " + exchange.getRequest().getPath());
		System.out.println("Pre Processing Logic Goes here " + exchange.getRequest().getId());
		System.out.println("Pre Processing Logic Goes here " + exchange.getRequest().getLocalAddress());
		System.out.println("Pre Processing Logic Goes here " + exchange.getRequest().getRemoteAddress());
		System.out.println("Pre Processing Logic Goes here " + exchange.getRequest().getHeaders());
		System.out.println("Pre Processing Logic Goes here " + exchange.getRequest().getURI());
		System.out.println("Pre Processing Logic Goes here " + exchange.getRequest().getQueryParams());
		return chain.filter(exchange).then(Mono.fromRunnable(() -> {
			System.out.println("Post Processing Logic Goes Here " + exchange.getResponse());
		}));
	}
}
