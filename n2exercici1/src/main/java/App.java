
public class App {

	public static void main(String[] args) {
		
		Smartphone nuevoTelf = new Smartphone("Huawei", "III");
		nuevoTelf.fotografiar();
		nuevoTelf.alarma();
		System.out.println(nuevoTelf.llamar("678995458"));

	}

}
