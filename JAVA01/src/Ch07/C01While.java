package Ch07;

import java.util.Scanner;

public class C01While {

	public static void main(String[] args) {
		
		//00 기본 문법
		
//		while(조건식) {
//			조건식이 true 인 동안 실행되는 종속문장
//		}
		
		//01 HELLO WORLD 10 회 출력
		// 탈출용 변수 	: i
		// 탈출용 조건식 	: i<10
		// 탈출 연산식 	: i++
//		int i=0;
//		while(i<10) {
//			System.out.println(i+" HELLO WORLD");
//			i++;
//		}
		
		//02 HELLO WORLD N 회 출력(N 은 키보드로 받는 정수값,N>0)
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		if(n<=0) {
//			System.out.printf("n은 0보다 커야 합니다\n");
//			System.exit(-1);
//		}
//		
//		int i=0;
//		while(i<n) {
//			System.out.println(i+" HELLO WORLD");
//			i++;
//		}	
		
		//03 1부터 10까지 누적합 구하기
		
//		int i=1;
//		int sum = 0;
//		while(i<=10) {
//			System.out.println("i : " + i);
//			sum += i;
//			i++;
//		}	
//		System.out.printf("%d 부터 %d 까지의 합 : %d\n", 1,10,sum);
		
		
		//04 1부터 n까지 누적합 구하기(n>1)
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		if(n<=1) {
//			System.out.println("n>1 여야 합니다.");
//			System.exit(-1);
//		}
//		int i=1;
//		int sum = 0;
//		while(i<=n) {
//			System.out.println("i : " + i);
//			sum += i;
//			i++;
//		}	
//		System.out.printf("%d 부터 %d 까지의 합 : %d\n", 1,n,sum);
		
		
		//05 n부터 m까지 누적합 구하기(n<m)
		
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		
//		//n<m을 만족하는 처리(n>=m -> swap(tmp임시공간))
//		if(n>=m) {
//			int tmp = n;
//			n = m;
//			m = tmp;
//		}
//		
//		int i=n;
//		int sum = 0;
//		while(i<=m) {
//			System.out.println("i : " + i);
//			sum += i;
//			i++;
//		}	
//		System.out.printf("%d 부터 %d 까지의 합 : %d\n", n,m,sum);	
		

		//06 n부터 m까지 수중(n<m)에 짝수의 합 , 홀수의 합을 각각 구해서 출력
		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//		
//		//n<m을 만족하는 처리(n>=m -> swap(tmp임시공간))
//		if(n>=m) {
//			int tmp = n;
//			n = m;
//			m = tmp;
//		}
//		
//		int i=n;
//		int oddSum = 0;	//홀수합
//		int evenSum = 0;//짝수합
//		while(i<=m) {
//			System.out.println("i : " + i);
//			if(i%2==0)
//				evenSum+=i;
//			else
//				oddSum+=i;
//			i++;
//		}	
//		System.out.printf("%d 부터 %d 까지의 짝수 합 : %d 홀수 합 : %d\n", n,m,evenSum,oddSum);

		
		//07 n단 구구단 출력(2<= n <=9)
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 유효성 확인( n<2 || n>9 )
		while(n<2 || n>9) {
			System.out.println("2<= n <=9 값을 입력하세요!");
			n = sc.nextInt();
		}
		
		int i=1;
		while(i<10) {
			System.out.printf("%d x %d = %d\n", n,i,n*i);
			i++;
		}
		
		

	}

}







