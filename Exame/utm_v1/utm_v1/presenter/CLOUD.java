package presenter;

import java.util.HashMap;
import java.util.Observable;

import model.UMTCTR;
import view.ARP;

public class CLOUD extends Observable {
	private HashMap<ARP, Position> allinfo;
	private UMTCTR umtctr;
	
	public CLOUD() {
		this.allinfo = new HashMap<ARP, Position>();
		this.umtctr = UMTCTR.getInstance();
	}
	
	public CLOUD(UMTCTR umtctr) {
		this.allinfo = new HashMap<ARP, Position>();
		this.umtctr = umtctr;
	}
	
	public void updatePosition(ARP arp) {
		this.allinfo.put(arp, arp.getPosition());
		this.updateAllInfo();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void updateAllInfo() {
		this.umtctr.updateAllInfo(allinfo);
	}
	
	public HashMap<ARP,Position> getSAInfo(ARP arp) {
		return this.umtctr.getSAInfo(arp);
	}
	
	public HashMap<ARP,Position> getAllInfo() {
		return this.allinfo;
	}
}
