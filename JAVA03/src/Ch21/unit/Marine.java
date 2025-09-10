package Ch21.unit;

import Ch21.gun.Gun;

public class Marine extends Unit{
	//hp,amor,type
	//int base_damage;
	
	public Gun myGun;
	boolean isDead;
	public Marine() {
		hp=100;
		amor=100;
		isDead = true;
	}
	public void setType(String type) {
		this.type=type;
	}
	public void setGun(Gun gun) {
		this.myGun = gun;
	}
	public void attact(Unit unit) {
		if(isDead) {
			myGun.fire(unit);
			System.out.println("[ATTACK] "+this.type+" 이 "+unit.type+" 에게 공격합니다");
		}
	}
	
	@Override
	public void move() {
		System.out.println(type + " 이동합니다");
	}
	@Override
	public void underAttact(int damage) {
		//amor-- 0 -> hp--> dead	
		
		if(amor-damage > 0) {
			this.amor-=damage;
		}
		else if(hp-(damage-amor) > 0){
			hp = hp - (damage-amor);
			amor=0;
		}else {
			hp=0;
			amor=0;
			isDead=false;
			System.out.println(this.type + " 전사했습니다...");
		}
	}

}
