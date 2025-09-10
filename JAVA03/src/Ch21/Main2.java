package Ch21;

import java.util.Scanner;

import Ch21.building.Barrack;
import Ch21.unit.Marine;
import Ch21.unit.Medic;

public class Main2 {
	//배럭 건물
	static Barrack barrack=new Barrack();
	
	public static void main(String[] args) {	
		//건물생성
		new Thread() {
			@Override
			public void run() {
				barrack.buildStructure();
			}		
		}.start();
		
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while(true) {
			System.out.println("1 마린 생성");
			System.out.println("2 메딕 생성");
			System.out.println("3 종료");
			System.out.print("입력 : ");
			num = sc.nextInt();
			switch(num) {
				case 1:
					Marine marine =barrack.getMarine();
					System.out.println("marine : " + marine);
					break;
				case 2:
					Medic medic = barrack.getMedic();
					System.out.println("medic : " + medic);
					break;
				case 3:
					break;
				default :
					
			}
		}
		
		
		
	}
}




