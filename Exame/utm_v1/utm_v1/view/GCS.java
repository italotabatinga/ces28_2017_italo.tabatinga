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
		this.arp = new ARP(name,o);
		this.o = o;
		this.o.addObserver(this);
		this.name = name;
		this.sainfo = new HashMap<ARP, Position>();
		System.out.println("Iniciando GCS de " + name);
	}
	
	public GCS(String name, CLOUD o, ARP arp) {
		this.arp = arp;
		this.o = o;
		this.o.addObserver(this);
		this.name = name;
		this.sainfo = new HashMap<ARP, Position>();
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
		this.arp.move(x, y);
	}
	
	public String showARPinRange() {
		String msg;
		msg = "ARPs no range de 50km dos seguintes GCSs:";
		for (ARP key : sainfo.keySet()) {
			msg += " " + key.getName();
		}
		System.out.println(msg);
		return msg;
	}
	
	public HashMap<ARP, Position> getSAInfo() {
		return this.sainfo;
	}
}
