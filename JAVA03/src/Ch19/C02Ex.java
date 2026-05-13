package Ch19;

/* ----------------------------------------------------------
   2. [학생용 문제] 사칙연산 함수형 인터페이스 + Stream + Lambda
   ----------------------------------------------------------
   조건 :
     - sum / sub / mul / div 람다를 람다 + Stream 으로 구현
     - 모든 인자를 받을 수 있도록 가변인자 처리
     - 뺄셈 / 나눗셈은 큰 수 → 작은 수로 정렬 후 누적 감산 / 누적 제산
       (예: sub(1,4,2,9) → 정렬 9,4,2,1 → 9-4-2-1 = 2)

   풀이 :   Calc 생성자 안의 sum / sub / mul / div 람다 채우기
            (정답은 C02ExAns.java)
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
		// TODO Functional sum 람다 작성  (힌트 : Arrays.stream(args).reduce(0, (a,b)->a+b))
		// TODO Functional sub 람다 작성  (힌트 : boxed().sorted((a,b)->b-a).reduce((a,b)->a-b).orElse(0))
		// TODO Functional mul 람다 작성  (힌트 : reduce(1, (a,b)->a*b))
		// TODO Functional div 람다 작성  (힌트 : boxed().sorted((a,b)->b-a).reduce((a,b)->a/b).orElse(0))
	}
}

public class C02Ex {

	public static void main(String[] args) {
		Calc calc = new Calc();

		// 람다가 비어 있으면 NullPointerException - 학생이 채워야 동작
		System.out.println("합     : " + (calc.sum == null ? "TODO" : calc.sum.execute(10, 20, 30, 40, 50, 60)));
		System.out.println("차     : " + (calc.sub == null ? "TODO" : calc.sub.execute(1, 4, 2, 9)));
		System.out.println("곱     : " + (calc.mul == null ? "TODO" : calc.mul.execute(10, 20, 30, 40, 50, 60)));
		System.out.println("나눗셈 : " + (calc.div == null ? "TODO" : calc.div.execute(10, 20, 30, 40, 50, 60)));
	}
}
