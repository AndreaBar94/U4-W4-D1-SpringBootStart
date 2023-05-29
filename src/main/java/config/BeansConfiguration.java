package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import entities.IPizza;
import entities.Pizza;
import entities.Pizza2;

@Configuration
public class BeansConfiguration {
	
	 @Bean(name = "base")
	 String base() {
	        return "Tomato, Mozzarella";
	    }
	 
	 @Bean(name = "Margherita")
	 IPizza margherita() {
		 Pizza2 margherita = new Pizza2("Margherita");
		 margherita.addIngredienti(base());
		 return margherita;
	 }
	 
	 @Bean(name = "Hawaii")
	 IPizza hawaii() {
		 	Pizza hawaii = new Pizza("Hawaii");
		 	hawaii.addIngredienti(base());
		 	hawaii.addIngredienti("Prosciutto");
		 	hawaii.addIngredienti("Ananas");
		 	return hawaii;
	 }
}
