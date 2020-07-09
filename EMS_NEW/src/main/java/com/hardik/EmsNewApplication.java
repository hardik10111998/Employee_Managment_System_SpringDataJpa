package com.hardik;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class EmsNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsNewApplication.class, args);
	}
	
//	 @Bean
//	    public ServletWebServerFactory servletContainer() {
//	        // Enable SSL Trafic
//	        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//	            @Override
//	            protected void postProcessContext(Context context) {
//	                SecurityConstraint securityConstraint = new SecurityConstraint();
//	                securityConstraint.setUserConstraint("CONFIDENTIAL");
//	                SecurityCollection collection = new SecurityCollection();
//	                collection.addPattern("/*");
//	                securityConstraint.addCollection(collection);
//	                context.addConstraint(securityConstraint);
//	            }
//	        };
//
//	        // Add HTTP to HTTPS redirect
//	        tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
//
//	        return tomcat;
//	    }
//
//	    /*
//	    We need to redirect from HTTP to HTTPS. Without SSL, this application used
//	    port 8082. With SSL it will use port 8443. So, any request for 8082 needs to be
//	    redirected to HTTPS on 8443.
//	     */
//	    private Connector httpToHttpsRedirectConnector() {
//	        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
//	        connector.setScheme("http");
//	        connector.setPort(8082);
//	        connector.setSecure(false);
//	        connector.setRedirectPort(8443);
//	        return connector;
//	    }
	
//	@Bean
//	public MessageSource messageSource() {
//	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//	    messageSource.setBasenames("messages");
//	    return messageSource;
//	}
	

//	Email Configuration Bean
//	 @Bean
//    public SimpleMailMessage emailTemplate()
//    {
//        SimpleMailMessage message = new SimpleMailMessage();
//        
//        message.setTo("hardik10111998@gmail.com");
//        message.setFrom("rp6004442@gmail.com");
//        message.setSubject("Employee Registration Succesful");
//        message.setText("Body Section");
//        
//        return message;
//    }
}
