package Ch01;

import java.util.Scanner;

class C06Simple 
{
	
	// 속성
 
	// 기능
	public int sum(int n1, int n2) {
		System.out.println("sum1(int n1, int n2)");
		return n1 + n2;
	}
	public int sum(int n1, int n2,int n3) {
		System.out.println("sum2(int n1, int n2,int n3)");
		return n1 + n2 + n3;
	}
	public int sum(int n1, int n2,int n3 , int n4) {
		System.out.println("sum3(int n1, int n2,int n3 , int n4)");
		return n1 + n2 + n3 + n4;
	}

}

public class C06MethodOverloadingMain {

	public static void main(String[] args) {
		C06Simple obj = new C06Simple();
		obj.sum(10, 20);
		obj.sum(10, 20,30);
		obj.sum(10, 20,30,40);

	}

}
