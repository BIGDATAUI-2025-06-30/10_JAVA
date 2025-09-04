package Ch17;

import java.util.Scanner;

interface Printer
{
//	void print(String name);	//추상메서드
//	String print(String message);
	String print();
}


public class C02Lamda {
	
	public static void main(String[] args) {
		
		//01
//		Printer printer = (message)->{System.out.println("01."+message);};
//		printer.print("안녕!");
		
		//02
		//Printer printer2 =(message)->{return "02."+message ;};
//		Printer printer2 = message->"02."+message;
//		String str = printer2.print("HELLO WORLD");
//		System.out.println(str);
		
		//03
		Printer printer3 = ()->{
			//Scanner 생성
			Scanner sc = new Scanner(System.in);
			//키보드로 문자열 받기
			String message = sc.nextLine();
			
			//입력된값 리턴
			return message;
		};
		System.out.println(printer3.print());
	}
}
