package entities;

public class ExtraPineappleDecorator  extends ExtraAdditionDecorator{
	
	public ExtraPineappleDecorator(Consumazione consumazione) {
		this.consumazione = consumazione;
	}
	
	
	@Override
	public String getProductName() {
		return consumazione.getProductName()+ " +1 extra pineapple";
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	  @Override
	    public String toString() {
	        return consumazione.toString() + " +1 extra pineapple";
	    }
}
