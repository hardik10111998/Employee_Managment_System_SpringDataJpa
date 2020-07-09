package com.hardik;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	
	private RedirectStrategy redirectStrategy= new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse responce, Authentication authentication)
			throws IOException, ServletException {
		Collection<? extends GrantedAuthority> authorities= authentication.getAuthorities();
		authorities.forEach(authority ->{
			if(authority.getAuthority().equals("ROLE_ADMIN")){
				try{
				redirectStrategy.sendRedirect(request, responce, "/admin/home");
				}
			catch(Exception e){
				e.printStackTrace();
			}
			}else if(authority.getAuthority().equals("ROLE_USER")){
				try{
					redirectStrategy.sendRedirect(request, responce, "/user/home");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});

	}

}
