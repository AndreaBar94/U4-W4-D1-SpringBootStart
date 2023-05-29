package andreab.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.BeansConfiguration;
import entities.Consumazione;
import entities.ExtraCheeseDecorator;
import entities.Pizza;
import entities.Pizza2;
import lombok.extern.slf4j.Slf4j;


@SpringBootApplication(scanBasePackages = "config")
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		//esempio con decorator
		Consumazione pizzaCustom = new Pizza2("La Zozzona");
		pizzaCustom.setProductName("La Zozzona");
		Consumazione zozzonaConCheeeeeeaseee = new ExtraCheeseDecorator(new ExtraCheeseDecorator(new ExtraCheeseDecorator(pizzaCustom)));
		log.info(zozzonaConCheeeeeeaseee.getProductName());
		
		
		configWithConfigurationAnnotation();
	}
	
	
	public static void configWithConfigurationAnnotation() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class);
		
		log.info(ctx.getBean("Margherita").toString());
		log.info(ctx.getBean("Hawaii").toString());
		
		
		Consumazione p = new ExtraCheeseDecorator(new ExtraCheeseDecorator(new ExtraCheeseDecorator(ctx.getBean(Pizza2.class)))) ;
		p.setProductName("caio");
		log.info(p.getProductName());
	
		ctx.close();
	}

}
