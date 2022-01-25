package com.stepik.demo.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure( HttpServletRequest request, HttpServletResponse response,
                                         AuthenticationException exception ) throws IOException, ServletException
    {
        response.setContentType( "application/json;charset=UTF-8" );
        response.setStatus( HttpServletResponse.SC_UNAUTHORIZED );
        response.getWriter().write( "check login password" );
        response.getWriter().flush();
        response.getWriter().close();
    }

}