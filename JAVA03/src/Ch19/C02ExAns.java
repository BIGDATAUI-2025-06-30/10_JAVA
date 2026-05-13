package Ch19;

/* ----------------------------------------------------------
   2. [정답] 사칙연산 함수형 인터페이스 + Stream + Lambda
   ----------------------------------------------------------
   대응 문제 : C02Ex.java
   참고 : Functional / Calc 인터페이스/클래스 이름은 C02Ex 와 충돌하지 않도록
          여기서는 CalcAns 로 만들고 자체 함수형 인터페이스 FunctionalAns 사용
   ---------------------------------------------------------- */

import java.util.Arrays;

@FunctionalInterface
interface FunctionalAns {
	Integer execute(int ...args);
}

class CalcAns {
	FunctionalAns sum;
	FunctionalAns sub;
	FunctionalAns mul;
	FunctionalAns div;

	CalcAns() {
		// 합 - reduce(0, +) 누적 덧셈
		sum = (args) -> Arrays.stream(args)
				.reduce(0, (a, b) -> a + b);

		// 차 - 내림차순 정렬 후 누적 감산
		//      [9,4,2,1] → ((9-4)-2)-1 = 2
		sub = (args) -> Arrays.stream(args)
				.boxed()
				.sorted((a, b) -> b - a)
				.reduce((a, b) -> a - b)
				.orElse(0);

		// 곱 - reduce(1, *) 누적 곱셈
		mul = (args) -> Arrays.stream(args)
				.reduce(1, (a, b) -> a * b);

		// 나누기 - 내림차순 정렬 후 누적 제산 (정수 나눗셈)
		div = (args) -> Arrays.stream(args)
				.boxed()
				.sorted((a, b) -> b - a)
				.reduce((a, b) -> a / b)
				.orElse(0);
	}
}

public class C02ExAns {

	public static void main(String[] args) {
		CalcAns calc = new CalcAns();

		System.out.println("합     : " + calc.sum.execute(10, 20, 30, 40, 50, 60));   // 210
		System.out.println("차     : " + calc.sub.execute(1, 4, 2, 9));                 // 2
		System.out.println("곱     : " + calc.mul.execute(10, 20, 30, 40, 50, 60));     // 720000000
		System.out.println("나눗셈 : " + calc.div.execute(10, 20, 30, 40, 50, 60));     // 0
	}
}
