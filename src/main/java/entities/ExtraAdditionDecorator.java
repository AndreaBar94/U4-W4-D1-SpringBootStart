package entities;

public abstract class ExtraAdditionDecorator extends Consumazione{
	
	protected Consumazione consumazione;

	@Override
	public abstract String getProductName();
}
