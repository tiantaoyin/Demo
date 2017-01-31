package com.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class ConcurrentSessionFilter extends GenericFilterBean {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		System.out.println("-------------ConcurrentSessionFilter---------");
		fc.doFilter(request, response);
		System.out.println("-------------ConcurrentSessionFilter---------");
	}
}
