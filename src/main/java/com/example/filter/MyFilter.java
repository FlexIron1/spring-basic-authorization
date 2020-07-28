package com.example.filter;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class MyFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = null;

        httpRequest = (HttpServletRequest) request;
        HttpServletResponse myResponse = (HttpServletResponse) response;
        if (httpRequest.getRequestURL().toString().endsWith("/registration")) {
            myResponse.addHeader("PROFE", "NO_SAVE");
            myResponse.setStatus(HttpStatus.NO_CONTENT.value());
            chain.doFilter(httpRequest, myResponse);
            return;
        }
//        if (httpRequest.getRequestURL().toString().endsWith("/getInfoById/**}")) {
//            myResponse.addHeader("PROFE", "NO_SAVE");
//            myResponse.setStatus(HttpStatus.NO_CONTENT.value());
//            chain.doFilter(httpRequest, myResponse);
//            return;
//        }

        chain.doFilter(request, response);
    }

}
