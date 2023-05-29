package entities;

public class ExtraHamDecorator  extends ExtraAdditionDecorator{
	
	public ExtraHamDecorator(Consumazione consumazione) {
		this.consumazione = consumazione;
	}
	
	
	@Override
	public String getProductName() {
		return consumazione.getProductName()+ " +1 extra ham";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	  @Override
	    public String toString() {
	        return consumazione.toString() + " +1 extra ham";
	    }
}
