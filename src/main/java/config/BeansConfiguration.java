package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import entities.Consumazione;
import entities.Pizza;

@Configuration
public class BeansConfiguration {
	
	 @Bean(name = "base")
	 String base() {
	        return "Tomato, Mozzarella";
	    }
	 
	 @Bean(name = "Margherita")
	 @Primary
	 Consumazione margherita() {
		 Pizza margherita = new Pizza("Margherita");
		 margherita.addIngredienti(base());
		 return margherita;
	 }
	 
}
