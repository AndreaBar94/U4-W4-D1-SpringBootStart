package andreab.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import config.BeansConfiguration;
import entities.Pizza;
import lombok.extern.slf4j.Slf4j;


@SpringBootApplication(scanBasePackages = "config")
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		configWithConfigurationAnnotation();
	}
	
	
	public static void configWithConfigurationAnnotation() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class);
		
		log.info(ctx.getBean("Margherita").toString());
		log.info(ctx.getBean("Hawaii").toString());
	
		ctx.close();
	}

}
