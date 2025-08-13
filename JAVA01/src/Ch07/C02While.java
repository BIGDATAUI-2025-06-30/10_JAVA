package Ch07;

import java.util.Scanner;

public class C02While {

	public static void main(String[] args) {
		//-------------------------	
		//2단 - 9단 출력	
		//-------------------------
//		dan	i
//		2	1-9
//		3	1-9
//		...
//		9	1-9
//		---------------------------
//		dan=2	i=1
//		dan++	i++
//		dan<10   i<10
		
//		int dan = 2;
//		while(dan<10) {
////			System.out.printf("%d\n", dan);
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
		//-------------------------
		//2단 - 9단 (2x9 , 2x8, 2x7 ..... 9x9 .. 9x1)
		//-------------------------
//		dan	i
//		2	9-1
//		3	9-1
//		4	9-1
//		,,,
//		9	9-1
//		-------------------
//		dan=2	i=9
//		dan++	i--
//		dan<10	i>0
		
//		int dan = 2;
//		while(dan<10) {
//			int i=9;
//			while(i>0) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			dan++;
//		}	
		//-------------------------		
		//9단 - 2단 (9x9 , 9x8, 9x7 ..... 2x9 .. 2x1)
		//-------------------------
//		dan	i
//		9	9-1
//		8	9-1
//		7	9-1
//		,,,
//		2	9-1
//		-------------------
//		dan=9	i=9
//		dan--	i--
//		dan>1	i>0
		
//		int dan = 9;
//		while(dan>1) {
//			int i=9;
//			while(i>0) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i--;
//			}
//			System.out.println();
//			dan--;
//		}
		//-------------------------		
		//2단 - n단 (n>2) 
		//-------------------------	
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		if(n<=2) {
//			System.out.println("n>2 입니다 - !");
//			System.exit(-1);
//		}
//		
//		int dan = 2;
//		while(dan<=n) {
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
		
		//-------------------------
		//n단 - m단 (n<m)
		//-------------------------	
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int m = sc.nextInt();
//
//		if(n>=m) {
//			int tmp = n;
//			n = m ;
//			m = tmp;
//		}
//		
//		int dan = n;
//		while(dan<=m) {
//			int i=1;
//			while(i<10) {
//				System.out.printf("%d x %d = %d\n", dan,i,dan*i);
//				i++;
//			}
//			System.out.println();
//			dan++;
//		}
		
		//-------------------------
		//별찍기(기본높이:4)
		//반드시 반복을 사용할것, 반복시마다 하나의 * 만 찍어낼 것
		//개행처리: System.out.println();
		//별찍기 : system.out.print("*");
		//-------------------------
		//*****
		//*****
		//*****
		//*****	
		//-------------------------
//		i(개행)	j(별)
//		0	0-4
//		1	0-4
//		2	0-4
//		3	0-4
//		---------------
//		i=0	j=0
//		i++	j++
//		i<4	j<5
//		int i=0;
//		while(i<4)
//		{
//			int j=0;
//			while(j<5) 
//			{
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//			
//		}
		//-------------------------
		//높이 : h
		//-------------------------
		//*****
		//*****
		//*****
		//*****
		//*****	
//		---------------
//		i(개행)	j(별)
//		0	0-4
//		1	0-4
//		2	0-4
//		3	0-4
//		...
//		h-1	0-4
//		---------------
//		i=0	j=0
//		i++	j++
//		i<h	j<5
		Scanner  sc = new Scanner(System.in);
		int h = sc.nextInt();
		int i=0;
		while(i<h)
		{
			int j=0;
			while(j<5) 
			{
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
			
		}
		

		//-------------------------
		//높이 : 4(고정)
		//-------------------------
		//*
		//**
		//***
		//****
		
		
		//-------------------------
		//-------------------------
		//-------------------------
		//-------------------------
		
		
		
		
	}

}
