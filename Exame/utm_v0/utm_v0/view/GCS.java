package view;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import presenter.Position;
import presenter.CLOUD;

public class GCS implements Observer {
	private HashMap<ARP, Position> sainfo;
	private ARP arp;
	private Observable o;
	private String name;
	
	public GCS(String name, CLOUD o) {
		arp = new ARP(name,o);
		this.o = o;
		o.addObserver(this);
		this.name = name;
		
		System.out.println("Iniciando GCS de " + name);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.sainfo = ((CLOUD) o).getSAInfo(this.arp);
	}
	
	public ARP getARP() {
		return this.arp;
	}
	
	public Position getPosition() {
		System.out.println("Coordenadas do ARP de " + this.name +
				": (" + String.valueOf(arp.getX()) + ", " + 
				String.valueOf(arp.getY()) + ")");
		return arp.getPosition();
	}
	
	public void move(double x, double y) {
		System.out.print("Movendo ARP de " + this.name + " de (" +
				String.valueOf(arp.getX()) + ", " + String.valueOf(arp.getY()) + ")");
		this.arp.move(x, y);
		System.out.println(" para (" + String.valueOf(arp.getX()) + ", " + String.valueOf(arp.getY()) + ")");
	}
	
	public void showARPinRange() {
		System.out.print("ARPs no range de 50km dos seguintes GCSs:");
		for (ARP key : sainfo.keySet()) {
			System.out.print(" " + key.getName());
		}
		System.out.println();
	}
}
