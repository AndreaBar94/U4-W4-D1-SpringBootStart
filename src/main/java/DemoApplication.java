

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import entities.IPizza;
import entities.Pizza;
import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j 
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	@Autowired
	private IPizza margherita;

	public void createPizza() {
	    Pizza pizza = (Pizza) margherita;
	    pizza.addIngredienti("Basil");
	    pizza.addIngredienti("Olive Oil");
	    System.out.println(pizza);
	}
}
