package excepciones;

@SuppressWarnings("serial")
public class FaltaCombustibleException extends CargaInvalidaException {
	
	public FaltaCombustibleException(String msj,String combustible, double cantidadRequerida, double cantidadDisponible) {
		super(msj,combustible,cantidadRequerida,cantidadDisponible);
	}

}
