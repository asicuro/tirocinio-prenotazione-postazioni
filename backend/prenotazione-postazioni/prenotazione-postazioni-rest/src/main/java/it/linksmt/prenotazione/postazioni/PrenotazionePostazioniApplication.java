package it.linksmt.prenotazione.postazioni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication( scanBasePackages= {"it.linksmt.prenotazione.postazioni"}, exclude = { 
		DataSourceAutoConfiguration.class,
		SecurityAutoConfiguration.class })
@PropertySources({ @PropertySource("classpath:application.yml")})
public class PrenotazionePostazioniApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrenotazionePostazioniApplication.class, args);
	}

}
