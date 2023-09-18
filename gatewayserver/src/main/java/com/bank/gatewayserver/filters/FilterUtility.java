package com.bank.gatewayserver.filters;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.http.HttpHeaders;

@Component
public class FilterUtility {
	
	public static final String CORRELATION_ID = "correlation-id";
	
	public String getCorrelationId(HttpHeaders headers) {
		if(headers.get(CORRELATION_ID) != null) {
			List<String> requestHeaderList = headers.get(CORRELATION_ID);
			return requestHeaderList.stream().findFirst().get();
		}else {
			return null;
		}
	}
	
	public ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String val) {
		return exchange.mutate().request(exchange.getRequest().mutate().header(name, val).build()).build();
	}
	
	public ServerWebExchange setCorrelationId(ServerWebExchange exchange, String correlationId) {
		return this.setRequestHeader(exchange, CORRELATION_ID, correlationId);
	}

}
