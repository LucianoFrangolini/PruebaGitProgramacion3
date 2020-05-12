package excepciones;

@SuppressWarnings("serial")
public class TipoCombustibleInvalidoException extends CargaInvalidaException {

	public TipoCombustibleInvalidoException(String msj, String combustible, double cantidadRequerida, double cantidadDisponible) {
		super(msj, combustible, cantidadRequerida, cantidadDisponible);
	}
	
	

}
