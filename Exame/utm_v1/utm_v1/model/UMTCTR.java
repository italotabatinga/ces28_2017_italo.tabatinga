package model;

import java.util.HashMap;

import presenter.Position;
import view.ARP;

public class UMTCTR {
	private static boolean _isInstance = false;
	private static UMTCTR instance = null;
	private static HashMap<ARP, Position> allinfo;
	
	private UMTCTR() {
	}
	
	public static UMTCTR getInstance() {
		if(!_isInstance) {
			instance = new UMTCTR();
			_isInstance = true;
		}
		return instance;
	}

	public void updateAllInfo(HashMap<ARP, Position> allinfo2) {
		allinfo = allinfo2;
	}
	
	public HashMap<ARP, Position> getSAInfo(ARP arp) {
		Position p = allinfo.get(arp);
		HashMap<ARP, Position> sainfo = new HashMap<ARP, Position>();
		for(ARP key : allinfo.keySet()) {
			if(p.distance(allinfo.get(key)) < 50.0) {
				sainfo.put(key, allinfo.get(key));
			}
		}
		
		return sainfo;
	}
	
	public HashMap<ARP, Position> getAllInfo() {
		return allinfo;
	}
}
