package andreab.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.BeansConfiguration;
import entities.Consumazione;
import entities.ExtraCheeseDecorator;
import entities.ExtraHamDecorator;
import entities.ExtraPineappleDecorator;
import entities.IPizza;
import entities.Pizza;
import lombok.extern.slf4j.Slf4j;


@SpringBootApplication(scanBasePackages = "config")
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		log.info("HELLO WORLD!");
		//esempio con decorator
		Consumazione pizzaCustom = new Pizza("La Zozzona");
		pizzaCustom.setProductName("La Zozzona");
		Consumazione zozzonaConCheeeeeeaseee = new ExtraCheeseDecorator(new ExtraCheeseDecorator(new ExtraCheeseDecorator(pizzaCustom)));
		log.info(zozzonaConCheeeeeeaseee.getProductName());
		
		
	//	configWithConfigurationAnnotation();
		configWithComponent();
	}
	
//	
//	public static void configWithConfigurationAnnotation() {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class);
//	
//		Consumazione p = new ExtraCheeseDecorator(new ExtraCheeseDecorator(new ExtraCheeseDecorator(ctx.getBean(Pizza2.class)))) ;
//		p.setProductName("caio");
//		log.info(p.getProductName());
//	
//		ctx.close();
//	}
	
	public static void configWithComponent() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		ctx.register(BeansConfiguration.class);
	    ctx.refresh();
	    
	    Consumazione margherita = (Consumazione) ctx.getBean("Margherita");
	    log.info(margherita.toString());
	    
	    Consumazione hawaii = new ExtraPineappleDecorator(new ExtraHamDecorator((Consumazione) ctx.getBean("Margherita")));
		log.info(hawaii.toString());
		
		Consumazione p =new ExtraCheeseDecorator(new ExtraCheeseDecorator(new ExtraHamDecorator(ctx.getBean(Pizza.class))));
		p.setProductName("Custom");
		log.info(p.toString());

		ctx.close();
	}

}
