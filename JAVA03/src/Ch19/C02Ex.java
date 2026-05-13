package Ch19;

/* ----------------------------------------------------------
   2. [연습문제] 사칙연산 함수형 인터페이스 + Stream + Lambda
   ----------------------------------------------------------
   문제 :
     - sum / sub / mul / div 람다를 람다 + Stream 으로 구현
     - 모든 인자를 받을 수 있도록 가변인자 처리
     - 뺄셈 / 나눗셈은 큰 수 → 작은 수로 정렬 후 누적 감산 / 누적 제산
       (예: sub(1,4,2,9) → 정렬 9,4,2,1 → 9-4-2-1 = 2)

   학습 포인트 :
     - 가변인자 (int...) 와 Arrays.stream(int[]) 의 만남
     - sorted 로 람다 Comparator 활용
     - reduce 로 누적 연산 (identity 있는 형태 / 없는 형태 두 가지)
     - boxed() : IntStream → Stream<Integer> 박싱
   ---------------------------------------------------------- */

import java.util.Arrays;

@FunctionalInterface
interface Functional {
	Integer execute(int ...args);
}

class Calc {
	Functional sum;   // 합
	Functional sub;   // 차
	Functional mul;   // 곱
	Functional div;   // 나누기

	Calc() {
		// ----------------------------------------------------
		// (1) 합 - reduce(0, +) 누적 덧셈
		// ----------------------------------------------------
		sum = (args) -> Arrays.stream(args)
				.reduce(0, (a, b) -> a + b);

		// ----------------------------------------------------
		// (2) 차 - 내림차순 정렬 후 누적 감산
		//     reduce(BinaryOperator) 는 첫 원소를 시드(identity) 로 사용
		//     [9,4,2,1] → ((9-4)-2)-1 = 2
		// ----------------------------------------------------
		sub = (args) -> Arrays.stream(args)
				.boxed()                                  // IntStream → Stream<Integer>
				.sorted((a, b) -> b - a)                  // 내림차순 정렬 (람다 Comparator)
				.reduce((a, b) -> a - b)                  // 누적 감산
				.orElse(0);                               // 빈 입력 방어

		// ----------------------------------------------------
		// (3) 곱 - reduce(1, *) 누적 곱셈 (항등원은 1)
		// ----------------------------------------------------
		mul = (args) -> Arrays.stream(args)
				.reduce(1, (a, b) -> a * b);

		// ----------------------------------------------------
		// (4) 나누기 - 내림차순 정렬 후 누적 제산
		//     정수 나눗셈이라 결과가 0이 될 수 있음 (예: 60/50=1 → /40=0 → /30=0…)
		// ----------------------------------------------------
		div = (args) -> Arrays.stream(args)
				.boxed()
				.sorted((a, b) -> b - a)
				.reduce((a, b) -> a / b)
				.orElse(0);
	}
}

public class C02Ex {

	public static void main(String[] args) {
		Calc calc = new Calc();

		System.out.println("합     : " + calc.sum.execute(10, 20, 30, 40, 50, 60));   // 210
		System.out.println("차     : " + calc.sub.execute(1, 4, 2, 9));                 // 9-4-2-1 = 2
		System.out.println("곱     : " + calc.mul.execute(10, 20, 30, 40, 50, 60));    // 720000000
		System.out.println("나눗셈 : " + calc.div.execute(10, 20, 30, 40, 50, 60));    // 정수 나눗셈 결과
	}
}
