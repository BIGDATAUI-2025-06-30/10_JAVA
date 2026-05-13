package Ch19;

/* ----------------------------------------------------------
   3. Function 심화 - 합성 (andThen) + 커링 (Currying)
   ----------------------------------------------------------
   설명 : 표준 함수형 인터페이스 Function<T,R> 한 개를 다양한 방식으로
          활용 / 조합 / 중첩해본다.
   비유 : 작은 함수들을 레고처럼 끼워 맞춰 큰 함수를 만드는 것.
   용도 : - 람다를 여러 단계의 변환 파이프라인으로 연결
          - andThen : 결과 → 다음 함수의 입력
          - 커링 : 인자가 여러 개인 함수를 "함수를 반환하는 함수" 로 쪼개기
   참고 : 표준 함수형 인터페이스 5종의 카탈로그는 C05StandardFunctionalInterfaces 참고
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class C03FunctionalInterfaceMain {

	// ─────────────────────────────────────────────────────
	// 1. 단순 Function 예제
	// ─────────────────────────────────────────────────────

	// (1) Integer → Integer  : 제곱
	public static Function<Integer, Integer> func1 = x -> x * x;
	// (2) Integer → Integer  : 자기자신 + 자기자신
	public static Function<Integer, Integer> func2 = x -> x + x;

	// ─────────────────────────────────────────────────────
	// 2. List 를 받는 Function (Stream + reduce 활용)
	// ─────────────────────────────────────────────────────

	// (3) List<Integer> → Integer : 누적합
	public static Function<List<Integer>, Integer> func3 =
			x -> x.stream().reduce(0, (sum, el) -> sum + el);

	// (4) List<Object> → Integer : Integer 만 필터링 후 누적합
	public static Function<List<Object>, Integer> func4 = (li) ->
			li.stream()
			  .filter(el -> el instanceof Integer)   // Integer 만 통과
			  .map(el -> (Integer) el)                // 캐스팅
			  .reduce(0, (sum, el) -> sum + el);      // 누적합

	// (5) List<Object> → List<String> : String 만 골라 "- xxx -" 모양으로 가공
	public static Function<List<Object>, List<String>> func5 = (li) ->
			li.stream()
			  .filter(el -> el instanceof String)
			  .map(el -> "- " + (String) el + " -")
			  .collect(Collectors.toList());

	// ─────────────────────────────────────────────────────
	// 3. andThen - 두 함수 연결 (앞 함수 결과 → 뒤 함수 입력)
	// ─────────────────────────────────────────────────────

	// (6) func1.andThen(func2) : x*x → 그 결과의 +자기자신
	//     예: 10 → 100 → 200
	public static Function<Integer, Integer> func6 = func1.andThen(func2);

	// (7) func3 → func2 → func1 : 누적합 → 두 배 → 제곱
	//     예: [10,20,30,40] → 100 → 200 → 40000
	public static Function<List<Integer>, Integer> func7 =
			func3.andThen(func2).andThen(func1);

	// ─────────────────────────────────────────────────────
	// 4. 커링(Currying) - 인자 2개짜리 함수를 "함수를 반환하는 함수" 로
	// ─────────────────────────────────────────────────────

	// (8) 풀어 쓴 커링
	public static Function<Integer, Function<Integer, Integer>> func8 = (x) -> {
		System.out.println("    func8 x = " + x);
		return (n) -> {
			System.out.println("    func8 n = " + n);
			return n + x;
		};
	};

	// (9) 같은 의미의 한 줄 람다 - 화살표 두 번
	public static Function<Integer, Function<Integer, Integer>> func9 = x -> y -> x + y;

	public static void main(String[] args) {

		System.out.println("(1) 제곱      : " + func1.apply(10));                                 // 100
		System.out.println("(2) +자기자신 : " + func2.apply(10));                                  // 20
		System.out.println("(3) 누적합    : " + func3.apply(Arrays.asList(10, 20, 30, 50)));      // 110
		System.out.println("(4) Integer 만 누적합 : "
				+ func4.apply(Arrays.asList(11, 10.5, "TEST", true, new StringBuffer(), 20, 40))); // 71
		System.out.println("(5) String 만 가공    : "
				+ func5.apply(Arrays.asList("10", 55, 7, "HELLO", true, "WORLD")));               // [- 10 -, - HELLO -, - WORLD -]
		System.out.println("(6) andThen 2단계     : " + func6.apply(10));                          // (10*10)+(10*10)=200
		System.out.println("(7) andThen 3단계     : "
				+ func7.apply(Arrays.asList(10, 20, 30, 40)));                                    // reduce=100 → +자기자신=200 → 제곱=40000

		// 커링 호출 - apply 두 번 (Function 을 반환하는 Function)
		System.out.println("(8) 커링(풀어쓴)      : " + func8.apply(10).apply(20));               // 30
		System.out.println("(9) 커링(한줄)        : " + func9.apply(10).apply(20));               // 30
	}
}
