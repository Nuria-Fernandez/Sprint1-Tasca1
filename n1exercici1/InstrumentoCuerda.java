
public class InstrumentoCuerda extends Instrumento{
	
	public InstrumentoCuerda(String nombre, int precio) {
		super(nombre, precio);
	}
	
	
	public void tocar() {
		System.out.println("Está sonando un instrumento de cuerda");
	}

}
