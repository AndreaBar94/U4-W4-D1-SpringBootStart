package andreab.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.BeansConfiguration;
import entities.Consumazione;
import entities.ExtraCheeseDecorator;
import entities.ExtraHamDecorator;
import entities.ExtraPineappleDecorator;
import lombok.extern.slf4j.Slf4j;


@SpringBootApplication(scanBasePackages = "config")
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		log.info("HELLO WORLD!");

		configWithComponent();
	}
	
	
	public static void configWithComponent() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		ctx.register(BeansConfiguration.class);
	    ctx.refresh();
	    
	    Consumazione margherita = (Consumazione) ctx.getBean("Margherita");
	    log.info(margherita.toString());
	    
	    Consumazione hawaii = new ExtraPineappleDecorator(new ExtraHamDecorator((Consumazione) ctx.getBean("Margherita")));
		log.info(hawaii.toString());
		
		Consumazione custom =new ExtraPineappleDecorator(new ExtraCheeseDecorator(new ExtraHamDecorator((Consumazione)ctx.getBean("Margherita"))));
		custom.setProductName("Custom");//non funziona, ho sbagliato un toString() da qualche parte
		log.info(custom.toString());

		ctx.close();
	}
	
}
