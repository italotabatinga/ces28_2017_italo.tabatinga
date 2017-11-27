package main;

import model.UMTCTR;
import presenter.CLOUD;
import view.GCS;

public class Main {

	public Main() {
	}

	public static void main(String[] args) {
		UMTCTR umtctr = UMTCTR.getInstance();
		CLOUD cloud = new CLOUD();
		
		GCS gcs1 = new GCS("Joao", cloud);
		gcs1.getPosition();
		GCS gcs2 = new GCS("Luiz", cloud);
		gcs2.getPosition();
		GCS gcs3 = new GCS("Mateus", cloud);
		gcs3.getPosition();
		
		gcs1.move(5, 10);
		gcs2.move(40, 80);
		gcs3.move(2, 7);
		
		gcs1.showARPinRange();
		gcs2.showARPinRange();
		gcs3.showARPinRange();
	}

}
