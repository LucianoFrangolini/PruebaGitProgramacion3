package clases;

public class DatoCargaInvalida {
	
	private double cantidadDisponible;
	private double cantidadRequerida;
	private String combustible;
	
	public DatoCargaInvalida(String combustible, double cantidadDisponible, double cantidadRequerida) {
		this.cantidadDisponible=cantidadDisponible;
		this.cantidadRequerida=cantidadRequerida;
		this.combustible=combustible;
	}//lkj

	public double getCantidadDisponible() {
		return cantidadDisponible;
	}

	public double getCantidadRequerida() {
		return cantidadRequerida;
	}

	public String getCombustible() {
		return combustible;
	}
	

}
