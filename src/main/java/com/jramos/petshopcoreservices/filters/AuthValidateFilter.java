package com.jramos.petshopcoreservices.filters;



import ch.qos.logback.core.net.SyslogOutputStream;
import com.jramos.petshopcoreservices.services.JwtService;
import com.jramos.petshopcoreservices.services.interfaces.IJwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class AuthValidateFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(AuthValidateFilter.class);
    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "mySecretKey";

    private final IJwtService _jwtService;


    public AuthValidateFilter() {
        _jwtService = new JwtService();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("Do filter ....");

       // if (WhiteList(request)) filterChain.doFilter(request, response);
        try{
           isTokenValid(request);
            String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
           _jwtService.validateToken(jwtToken);
            filterChain.doFilter(request, response);
        }catch (Exception ex)
        {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, ex.getMessage());
            return;

        }

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
         final List<String> EXCLUDE_URL = Arrays.asList(
                // -- Swagger UI v2
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/swagger-ui.html",
                "/webjars/springfox-swagger-ui/swagger-ui.css",
                "/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-300.woff",
                "/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-300.woff2",
                "/webjars/springfox-swagger-ui/springfox.js?v=2.9.2",
                // -- Swagger UI v3 (OpenAPI)
                "/v3/api-docs/**",
                "/swagger-ui/**",
                ".js",
                ".css",
                 "/swagger-uui.html", "/webjars/springfox-swagger-ui/springfox.css",
                 "/webjars/springfox-swagger-ui/swagger-ui-bundle.js", "/webjars/springfox-swagger-ui/swagger-ui.css",
                 "/webjars/springfox-swagger-ui/swagger-ui-standalone-preset.js",
                 "/webjars/springfox-swagger-ui/springfox.js", "/swagger-resources/configuration/ui",
                 "/webjars/springfox-swagger-ui/favicon-32x32.png", "/swagger-resources/configuration/security",
                 "/swagger-resources", "/v2/api-docs",
                 "/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-700.woff2",
                 "/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-regular.woff2",
                 "/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-700.woff2",
                 "/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-600.woff2",
                 "/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-600.woff2",
                 "/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-regular.woff2",
                 "/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-regular.woff",
                 "/webjars/springfox-swagger-ui/favicon-16x16.png",
                "/login"

                // other public endpoints of your API may be appended to this array
        );
        return EXCLUDE_URL.stream().anyMatch(exclude -> exclude.equalsIgnoreCase(request.getServletPath()));
    }

    private boolean isTokenValid(HttpServletRequest request){
        var header = request.getHeader(HEADER);
        if(header == null || header.isEmpty() || !header.startsWith(PREFIX)) throw new RuntimeException("Token didnt exist");

        return true;
    }



}
