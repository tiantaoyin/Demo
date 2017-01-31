package com.demo.filter;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ConcurrentSessionFilter extends GenericFilterBean {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		System.out.println("-------------ConcurrentSessionFilter---------");
		fc.doFilter(request, response);
		System.out.println("-------------ConcurrentSessionFilter---------");
	}
}
