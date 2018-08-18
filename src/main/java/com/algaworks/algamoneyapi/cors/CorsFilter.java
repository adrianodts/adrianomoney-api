package com.algaworks.algamoneyapi.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.algaworks.algamoneyapi.config.property.AlgamoneyApiProperty;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	@Autowired
	AlgamoneyApiProperty algamoneyApiProperty;
	
	//private String originsPermitidas[] = {algamoneyApiProperty.getOriginPermitida()};

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request; 
		HttpServletResponse res = (HttpServletResponse)response;
		
		res.setHeader("Access-Control-Alow-Origin", algamoneyApiProperty.getOriginPermitida());
		res.setHeader("Access-Control-Alow-Credentials", "true"); //para o Cookie do refresh_token ser enviado
		
		if("OPTIONS".equals(req.getMethod()) && algamoneyApiProperty.getOriginPermitida().equals(req.getHeader("Origin"))) {
			res.setHeader("Access-Control-Alow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
			res.setHeader("Access-Control-Alow-Headers", "Authoriation, Content-type, Accpet");
			res.setHeader("Access-Control-Max-Age", "3600");
			res.setStatus(HttpServletResponse.SC_OK);
		}else {
			chain.doFilter(req, res);
		}	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
