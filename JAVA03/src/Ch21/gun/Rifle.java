package Ch21.gun;

import Ch21.unit.Unit;

public class Rifle extends Gun{

	public Rifle(){
		this.maxBullitCnt=100;
		this.curBullitCnt=0;
		this.power=30;
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
