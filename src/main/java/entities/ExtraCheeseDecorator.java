package entities;

public class ExtraCheeseDecorator extends ExtraAdditionDecorator{
	
	public ExtraCheeseDecorator(Consumazione consumazione) {
		this.consumazione = consumazione;
	}
	
	
	@Override
	public String getProductName() {
		return consumazione.getProductName()+ " +1 extra cheese";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
