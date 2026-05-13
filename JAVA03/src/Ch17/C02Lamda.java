package Ch17;

/* ----------------------------------------------------------
   2. 함수형 인터페이스 + 람다식 다양한 형태
   ----------------------------------------------------------
   설명 : 추상메서드 1개를 가진 인터페이스(함수형 인터페이스)를
          람다식으로 즉석 구현하는 3가지 형태 비교
   비유 : 채용 공고(인터페이스) → 면접자(람다)가 그 자리에서 일 수행
   용도 : - 함수형 인터페이스 / @FunctionalInterface
          - 람다 축약 표현 ( 한 줄 람다, return 생략 )
          - 인자 / 반환 유무에 따른 람다 작성법 학습
   ---------------------------------------------------------- */

import java.util.Scanner;

// (1) 인자O / 반환X
interface PrinterVoid {
	void print(String message);
}

// (2) 인자O / 반환O
interface PrinterReturn {
	String print(String message);
}

// (3) 인자X / 반환O
interface PrinterInput {
	String print();
}

public class C02Lamda {

	public static void main(String[] args) {

		// 01. (인자) -> { 처리 }  : 인자 받고 출력만
		PrinterVoid printer1 = (message) -> { System.out.println("01." + message); };
		printer1.print("안녕!");

		// 02. message -> "..."   : 한 줄 람다 (괄호/return 생략)
		PrinterReturn printer2 = message -> "02." + message;
		String str = printer2.print("HELLO WORLD");
		System.out.println(str);

		// 03. () -> { ... }      : 인자 없이 처리 후 결과 리턴
		PrinterInput printer3 = () -> {
			Scanner sc = new Scanner(System.in);
			System.out.print("입력 > ");
			String message = sc.nextLine();
			return message;
		};
		System.out.println("03." + printer3.print());
	}
}
