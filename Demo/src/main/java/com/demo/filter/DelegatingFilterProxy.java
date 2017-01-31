package com.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class DelegatingFilterProxy extends GenericFilterBean {
	private volatile Filter delegate;
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		this.delegate = new FilterChainProxy();
		invokeDelegate(delegate, request, response, filterChain);
	}
	
	public void invokeDelegate(Filter delegate, ServletRequest request, 
			ServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		delegate.doFilter(request, response, filterChain);
	}
}
