package excepciones;

import clases.DatoCargaInvalida;

@SuppressWarnings("serial")
public class CargaInvalidaException extends Exception{
	
	private DatoCargaInvalida dato;
	
	public CargaInvalidaException(String msj,String combustible, double cantidadRequerida, double cantidadDisponible) {
		super(msj);
		dato = new DatoCargaInvalida(combustible,cantidadDisponible,cantidadRequerida);
	}

	public DatoCargaInvalida getDato() {
		return dato;
	}

}
