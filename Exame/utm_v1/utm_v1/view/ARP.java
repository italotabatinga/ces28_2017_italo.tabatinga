package view;

import presenter.CLOUD;
import presenter.Position;

public class ARP {
	private Position p; // Coordenadas
	private CLOUD o;
	private String name;
	
	protected ARP(String name, CLOUD o) {
		this.p = new Position();
		this.o = o;
		o.updatePosition(this);
		this.name = name;
	}
	
	public void avoidCollision() {
		
	}
	
	public void move(double x, double y) {
		p.move(x,y);
		o.updatePosition(this);
	}
	
	public Position getPosition() {
		return this.p;
	}
	
	public double getX() {
		return p.getX();
	}
	
	public double getY() {
		return p.getY();
	}
	
	public String getName() {
		return this.name;
	}
}
