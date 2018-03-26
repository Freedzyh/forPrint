package com.github.xuejike.springboot.print.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@WebFilter(urlPatterns = "/")
public class CorsFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Access-Control-Allow-Origin: 指定授权访问的域
        response.addHeader("Access-Control-Allow-Credentials", "true");  //此优先级高于@CrossOrigin配置
        response.addHeader("Access-Control-Allow-Origin", "*");  //此优先级高于@CrossOrigin配置

        // Access-Control-Allow-Methods: 授权请求的方法（GET, POST, PUT, DELETE，OPTIONS等)
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE，OPTIONS");

//        response.addHeader("Access-Control-Allow-Headers", "Content-Type");

//        response.addHeader("Access-Control-Allow-Headers", "X-Requested-With，X- HTTP-Method-Override，Content-Type，Accept");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        response.addHeader("Access-Control-Max-Age", "1800");//30 min
        filterChain.doFilter(request, response);
    }
}
