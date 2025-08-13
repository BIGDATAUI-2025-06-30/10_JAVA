package Ch07;

import java.util.Scanner;

public class C03Continue_Break {

	public static void main(String[] args) {

		//--------------------------
		// 1 break
		//--------------------------
		// -1을 입력하기 전까지 정수값을 누적하여 합을 구하고 출력
//		Scanner sc = new Scanner(System.in);
//		int n;
//		int sum = 0;
//		while(true) {
//			
//			n=sc.nextInt();
//			if(n==-1)
//				break;
//			
//			sum+=n;
//		}
//		System.out.println("SUM : " + sum);
//		
//		sc.close();
		//--------------------------
		// 모든 반복문 탈출 : flag
		//--------------------------
		// 7 x 7 = 49 출력 이후 모든 반복문 탈출
//		boolean flag = false;
//		int dan = 2;
//		while (dan < 10) {
//			
//			int i = 1;
//			while (i < 10) {
//				System.out.printf("%d x %d = %d\n", dan, i, dan * i);
//				// 7 x 7 = 49 출력 이후 모든 반복문 탈출
//				if(dan==7 && i==7) {
//					flag=true;
//					break;
//				}
//				i++;
//			}
//			
//			System.out.println();
//
//			if(flag)
//				break;
//			dan++;
//		}
		
		//--------------------------
		// :EXIT
//		//--------------------------
//		int dan = 2;
//		
//		Exit:
//		while (dan < 10) {
//			
//			int i = 1;
//			while (i < 10) {
//				System.out.printf("%d x %d = %d\n", dan, i, dan * i);
//				// 7 x 7 = 49 출력 이후 모든 반복문 탈출
//				if(dan==7 && i==7) {
//					break Exit;
//				}
//				i++;
//			}
//	
//			System.out.println();
//			dan++;
//		}
		
		//--------------------------
		// continue
		//--------------------------
		// 1부터 10까지의 수중에 3의 배수를 제외한 합 출력
		int i=1;
		int sum = 0;
		while(i<=10) {
			
			if(i%3==0) {
				i++;
				continue;
			}
	
			System.out.println("i : " + i);
			sum+=i;
			i++;
		}
		System.out.println("SUM : " + sum);
		

		
	}

}


