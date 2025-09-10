package Ch21.gun;

import Ch21.unit.Unit;

public class Pistol extends Gun{
	public Pistol(){
		this.power=20;
		this.curBullitCnt=0;
		this.maxBullitCnt=10;
	}
	
	@Override
	public void fire(Unit unit) {
		if(curBullitCnt==0) {
			System.out.println("총알 : 0 재장전 필요..");
			return ;
		}
		unit.underAttact(this.power);
		curBullitCnt--;
	}

	@Override
	public void reload(int bullit) {
		if(this.maxBullitCnt>this.curBullitCnt+bullit)
			this.curBullitCnt+=bullit;
		else 
			this.curBullitCnt=maxBullitCnt;
	}


}
