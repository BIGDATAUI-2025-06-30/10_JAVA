package Ch21;

import Ch21.gun.Pistol;
import Ch21.gun.Rifle;
import Ch21.unit.Marine;
import Ch21.unit.Medic;

public class Main {
	
	public static void main(String[] args) {
		
		Marine marine1 = new Marine();
		marine1.setGun(new Pistol());
		marine1.myGun.reload(100);
		Medic medic1 = new Medic();
		medic1.type="medic1";
		
		marine1.setType("marine1");
		Marine marine2 = new Marine();
		marine2.setGun(new Rifle());
		marine2.myGun.reload(100);
		marine2.setType("marine2");
		
		//medic -> m1
		new Thread() {
			@Override
			public void run() {
				while(true) {
					medic1.Healing(marine1);
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		//m1 -> m2
		new Thread() {
			@Override
			public void run() {
				
				while(true) {
					marine1.attact(marine2);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}		
		}.start();
		//m2 -> m1
		new Thread() {
			@Override
			public void run() {
				while(true) {
					marine2.attact(marine1);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();;
		
	}
}
