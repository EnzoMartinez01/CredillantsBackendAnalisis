package com.credillants.credillants.Config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.credillants.credillants.Service.Imp.UserDetailsServiceImpl;

@Component
public class AutenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsImp;
	
	@Autowired
	private JwtUtilies jwtUtilies;
	
	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String headerToken = request.getHeader("Authorization");
        String username = null;
        String tokenJWT = null;

        if (headerToken != null && headerToken.startsWith("Bearer ")){
            tokenJWT = headerToken.substring(7);
            try{
                username = this.jwtUtilies.extractUsername(tokenJWT);

            } catch (Exception e){
                e.printStackTrace();
            }

        } else{
            System.out.println("Token Invalido o no comienza con Bearer");
        }

        if(username != null){
            UserDetails userD = userDetailsImp.loadUserByUsername(username);
            Boolean validacion = this.jwtUtilies.validateToken(tokenJWT, userD);
            if(validacion){
                UsernamePasswordAuthenticationToken upatoken = new UsernamePasswordAuthenticationToken(userD, null, userD.getAuthorities());
                upatoken.setDetails(userD);
                SecurityContextHolder.getContext().setAuthentication(upatoken);
            }

        }else{
            System.out.println("El usuario esta vacio, no asociado al token");
        }

        filterChain.doFilter(request, response);

    }
}
