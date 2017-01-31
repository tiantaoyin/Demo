package com.demo.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class FilterChainProxy extends GenericFilterBean {
	//private Map<RequestMatcher, List<Filter>> filterChainMap;
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		//封装FilterInvocation 
		FilterInvocation fi = new FilterInvocation(fc, request, response);
		List<Filter> filters = getFilters(fi.getRequest());
		
		if(filters == null || filters.size() == 0){
			fc.doFilter(request, response);
			return;
		}
		VirtualFilterChain virtualFilterChain = new VirtualFilterChain(fi, filters);
		virtualFilterChain.doFilter(request, response);
	}
	
	private List<Filter> getFilters(ServletRequest request) {
		List<Filter> filters = new ArrayList<Filter>(); 
		filters.add(new ConcurrentSessionFilter());
		filters.add(new LogoutFilter());
		return filters;
	}
	
	public static class VirtualFilterChain implements FilterChain{
		private final FilterInvocation fi;
        private final List<Filter> additionalFilters;
        private final int size;
        private int currentPosition = 0;

        private VirtualFilterChain(FilterInvocation filterInvocation, 
        		List<Filter> additionalFilters) {
            this.fi = filterInvocation;
            this.additionalFilters = additionalFilters;
            this.size = additionalFilters.size();
        }

		public void doFilter(ServletRequest request, ServletResponse response)
				throws IOException, ServletException{
			if(currentPosition == size){
				fi.getChain().doFilter(request, response);
			}else{
				currentPosition++;
				Filter nextFilter = additionalFilters.get(currentPosition - 1);
				nextFilter.doFilter(request, response, this);
			}
		}
	}
}
