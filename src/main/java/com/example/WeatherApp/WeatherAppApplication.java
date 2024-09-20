package com.example.WeatherApp;

import com.example.WeatherApp.EmailSender.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class WeatherAppApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendEmail() {
		emailSenderService.sendEmail("ciritop734@hapied.com","Subject","body" );
	}

}
