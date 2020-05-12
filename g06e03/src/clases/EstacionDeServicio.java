package clases;

import java.util.ArrayList;

public class EstacionDeServicio {
	
	
	private static EstacionDeServicio instance = null;
	private ArrayList<Surtidor> surtidores = new ArrayList<Surtidor>();
	
	private EstacionDeServicio() {}
	
	public static EstacionDeServicio getInstance() {
		if (EstacionDeServicio.instance==null)
			EstacionDeServicio.instance= new EstacionDeServicio();
		return instance;
	}

	public void agregarSurtidor(Surtidor surtidor) {
		this.surtidores.add(surtidor);
	}
	
	public void quitarSurtidor(Surtidor surtidor) {
		this.surtidores.remove(surtidor);
	}
	
	public ArrayList<Surtidor> getSurtidores() {
		return surtidores;
	}
	
	

}
