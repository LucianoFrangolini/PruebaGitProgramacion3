package clases;

import excepciones.CargaInvalidaException;
import excepciones.FaltaCombustibleException;
import excepciones.TipoCombustibleInvalidoException;

public class Surtidor {

	private double cantidadDiesel = 20000;
	private double cantidadPremium = 20000;
	private double cantidadSuper = 20000;

	public Surtidor() {}

	public void cargarCombustible(String combustible, double cantidad) throws CargaInvalidaException {
		
		if (cantidad > 0) {		
			if (combustible.equals("Diesel")) {				
				if (cantidad <= this.cantidadDiesel) {
					this.cantidadDiesel-=cantidad;
				}
				else {
					throw new FaltaCombustibleException("No hay combustible suficiente en el surtidor, se cargara lo disponible",combustible,cantidad,this.cantidadDiesel);
				}
			}
			else 
				if (combustible.equals("Premium")) {					
					if (cantidad <= this.cantidadPremium) {
						this.cantidadPremium-=cantidad;
					} 
					else {
						
						throw new FaltaCombustibleException("No hay combustible suficiente en el surtidor, se cargara lo disponible",combustible,cantidad,this.cantidadPremium);
					}
				}
				else 
					if (combustible.equals("Super")) {						
						if (cantidad <= this.cantidadSuper) {
							this.cantidadSuper-=cantidad;
						} 
						else {
							
							throw new FaltaCombustibleException("No hay combustible suficiente en el surtidor, se cargara lo disponible",combustible,cantidad,this.cantidadSuper);
						}
					} 
					else
						throw new TipoCombustibleInvalidoException("Ese combustible no existe, ingrese otro.",combustible,cantidad,0);
		}
		else 
			throw new CargaInvalidaException("Esta intentando cargar una cantidad de combustible invalida.",combustible,cantidad,0);
		
	}

	public double getCantidadDiesel() {
		return cantidadDiesel;
	}

	public double getCantidadPremium() {
		return cantidadPremium;
	}

	public double getCantidadSuper() {
		return cantidadSuper;
	}

	public void llenarDiesel() {
		this.cantidadDiesel = 20000;
	}

	public void llenarPremium() {
		this.cantidadPremium = 20000;
	}

	public void llenarSuper() {
		this.cantidadSuper = 20000;
	}

	@Override
	public String toString() {
		return "Surtidor [cantidadDiesel=" + cantidadDiesel + ", cantidadPremium=" + cantidadPremium+ ", cantidadSuper=" + cantidadSuper + "]";
	}
	
	
}
