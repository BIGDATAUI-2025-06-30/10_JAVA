package Ch19;

/* ----------------------------------------------------------
   2. [학생용 문제] 사칙연산 함수형 인터페이스 + Stream + Lambda
   ----------------------------------------------------------
   조건 :
     - sum / sub / mul / div 람다를 람다 + Stream 으로 구현
     - 모든 인자를 받을 수 있도록 가변인자 처리
     - 뺄셈 / 나눗셈은 큰 수 → 작은 수로 정렬 후 누적 감산 / 누적 제산
       (예: sub(1,4,2,9) → 정렬 9,4,2,1 → 9-4-2-1 = 2)

   정답 참고 : C02ExAns.java
   ---------------------------------------------------------- */

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
		// TODO sum 람다 작성
		// TODO sub 람다 작성
		// TODO mul 람다 작성
		// TODO div 람다 작성
	}
}

public class C02Ex {

	public static void main(String[] args) {
		Calc calc = new Calc();

		// 람다 채우면 아래 실행 가능
		// 기대 출력 :
		//   합     : 210
		//   차     : 2
		//   곱     : 720000000
		//   나눗셈 : 0
		// TODO 답안 작성 후 calc.sum / sub / mul / div 호출
	}
}
