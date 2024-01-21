
public class Telefono {
	
	    protected String marca;
	    protected String modelo;

	    public Telefono(String marca, String modelo){
	        this.marca = marca;    
	        this.modelo = modelo;

	    }
	    

	    public String getMarca() {
			return marca;
		}


		public void setMarca(String marca) {
			this.marca = marca;
		}


		public String getModelo() {
			return modelo;
		}


		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		
		public String toString() {
			return "El teléfono es de la marca " + marca 
					+ " y el modelo es " + modelo + ".";
		}


		public String llamar(String numTelf){
	        String mensaje = "Estás llamando al " + numTelf;
	        return mensaje;
	    }

}
