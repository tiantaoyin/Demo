package com.demo.filter;

import lombok.Data;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Data
public class FilterInvocation {
    private FilterChain chain;
    private ServletRequest request;
    private ServletResponse response;

    public FilterInvocation(FilterChain fc, ServletRequest request, ServletResponse response) {

    }
}
