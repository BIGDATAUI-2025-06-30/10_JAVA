package Ch07.삼조;

import java.util.Scanner;

public class Sum implements Ch07.삼조.Calculation {
	
	@Override
	public void Run(int n1, int n2) {
		System.out.println("삼조 장지원 덧셈결과 : " + (n1 + n2));

	}

	@Override
	public void Run1(int... nums) {
		Scanner sc = new Scanner(System.in);
		
		int scSum = 0;
		while(true) {
			System.out.println("숫자 입력(0) 입력 시 종료 : ");
			int b = sc.nextInt();
			if(b == 0) {
				break;
			}
				scSum += b;
		}
		
		System.out.println("입력 받은 수들의 합 : " + scSum);
	}

	@Override
	public void Run(double... doubles) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Run(String... strings) {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {
		Sum sum = new Sum();
		
		sum.Run(3, 5);
		sum.Run1();
	}
	

}
