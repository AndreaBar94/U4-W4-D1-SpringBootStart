package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 
public abstract class Consumazione {
	
	 String productName = "";
	 
	 public String getProductName() {
		 
		 return productName;
		 
	 }
	 
	 public abstract double getPrice();
	
}
