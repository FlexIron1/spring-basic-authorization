package com.example.filter;

import com.example.model.Url;
import com.example.model.UserEntity;
import com.example.repository.UserRepository;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Component
@Order(2)
public class OtherFilter implements Filter {



    private UserRepository userRepository;

    public OtherFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = null;
        Url url = new Url();
        httpRequest = (HttpServletRequest) request;
        HttpServletResponse myResponse = (HttpServletResponse) response;
        if (myResponse.getHeader("PROFE") != null) {
            destroy();
        }
        Authentication authenticationResponse = SecurityContextHolder.getContext().getAuthentication();
        String URL = httpRequest.getRequestURL().toString();
        url.setUrls(URL);
        url.setDate(LocalDate.now());
        String username = authenticationResponse.getName();
        UserEntity byUsername = userRepository.findByUsername(username);
        List<Url> urls = byUsername.getUrls();
        urls.add(url);
        byUsername.setUrls(urls);
        userRepository.save(byUsername);
        chain.doFilter(request, response);
    }

}
