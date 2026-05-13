package Ch17;

/* ----------------------------------------------------------
   3. 함수형 인터페이스 활용 - 사칙연산 계산기
   ----------------------------------------------------------
   설명 : Calculator 라는 함수형 인터페이스 1개를
          더하기 / 빼기 / 곱하기 / 나누기 람다식으로 각각 구현
   비유 : 계산기 버튼마다 다른 연산이 매핑된 것 (+, -, ×, ÷)
   용도 : - 함수형 인터페이스 활용 패턴
          - 알고리즘만 갈아끼우는 전략 패턴(Strategy) 기반
          - 람다로 코드 중복 줄이기
   ---------------------------------------------------------- */

// 두 정수를 받아 결과(int) 를 반환하는 함수형 인터페이스
interface Calculator {
	int calculate(int num1, int num2);
}

public class C03Lamda {

	public static void main(String[] args) {

		// 1. 더하기 람다
		Calculator add = (n1, n2) -> n1 + n2;
		// 2. 빼기 람다 (큰 수 - 작은 수, 항상 양수)
		Calculator sub = (n1, n2) -> n1 > n2 ? n1 - n2 : n2 - n1;
		// 3. 곱하기 람다
		Calculator mul = (n1, n2) -> n1 * n2;
		// 4. 나누기 람다 (큰 수 / 작은 수, 0 나눗셈 방지)
		Calculator div = (n1, n2) -> n1 > n2 ? n1 / n2 : n2 / n1;

		// 결과 출력
		System.out.println("10 + 20 = " + add.calculate(10, 20));
		System.out.println("30 - 10 = " + sub.calculate(30, 10));
		System.out.println("10 * 20 = " + mul.calculate(10, 20));
		System.out.println("100 / 5 = " + div.calculate(100, 5));
	}
}
