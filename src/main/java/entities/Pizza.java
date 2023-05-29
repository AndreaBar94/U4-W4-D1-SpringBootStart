package entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter 
@Getter 
@AllArgsConstructor
@Component
public class Pizza extends Consumazione implements IPizza{
	
	private String name;
	private List<String> ingredienti;
	
	public Pizza() {
		this.ingredienti = new ArrayList<>();
	}
	
	public Pizza(String name) {
		this.name = name;
		this.ingredienti = new ArrayList<>();
	}
	

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addIngredienti(String ingrediente) {
        ingredienti.add(ingrediente);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredienti +
                '}';
    }

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
