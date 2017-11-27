package presenter;

import java.util.HashMap;
import java.util.Observable;

import model.UMTCTR;
import view.ARP;

public class CLOUD extends Observable {
	private HashMap<ARP, Position> allinfo;
	private UMTCTR umtctr;
	
	public CLOUD() {
		allinfo = new HashMap<ARP, Position>();
		umtctr = UMTCTR.getInstance();
	}

	public void updatePosition(ARP arp) {
		allinfo.put(arp, arp.getPosition());
		this.updateAllInfo();
		this.setChanged();
		this.notifyObservers();
	}
	
	public void updateAllInfo() {
		umtctr.updateAllInfo(allinfo);
	}
	
	public HashMap<ARP,Position> getSAInfo(ARP arp) {
		return umtctr.getSAInfo(arp);
	}
}
