package com.hardik.email;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
 
@Configuration
public class EmailConfiguration 
{
    @Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        
        message.setTo("xyz@gmail.com");
        message.setFrom("abc@gmail.com");
        message.setSubject("Employee Registration Succesful");
        message.setText("Body Section");
        
        return message;
    }
}