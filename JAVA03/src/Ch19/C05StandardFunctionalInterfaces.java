package Ch19;

/* ----------------------------------------------------------
   5. 표준 함수형 인터페이스 카탈로그 (java.util.function.*)
   ----------------------------------------------------------
   설명 : 자바가 미리 만들어 둔 함수형 인터페이스 5종 비교 정리.
          Ch17 에서는 매번 interface 를 직접 만들어 썼지만,
          실무에서는 거의 다 이 표준 인터페이스로 처리한다.
   비유 : 매번 도시락 통을 새로 만들 필요 없이
          편의점에 종류별 도시락 통이 비치돼 있는 셈.
   용도 : - 자주 쓰는 람다 모양을 표준화 → 재사용성 ↑
          - Stream / Optional / CompletableFuture API 와 자연스럽게 결합
          - andThen / compose / and / or / negate 같은 조합 메서드 제공

   ──────────────────────────────────────────────────────────
   Ch17 커스텀 인터페이스  →  Ch19 표준 인터페이스 대응표
   ──────────────────────────────────────────────────────────
   Ch17                         |  Ch19 표준                | 메서드
   -----------------------------|---------------------------|----------
   StrToInt   (String → int)    |  Function<String,Integer> | apply
   StrConsumer(String → void)   |  Consumer<String>         | accept
   ListFactory(() → List)       |  Supplier<List<String>>   | get
   (없음, 새로 보여줌)            |  Predicate<String>        | test
   StrCompare (S,S → int)       |  BiFunction<S,S,Integer>  | apply
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class C05StandardFunctionalInterfaces {

	public static void main(String[] args) {

		// ----------------------------------------------------
		// (1) Function<T, R>  :  T → R (apply)
		//     하나의 인자를 받아 결과를 반환
		// ----------------------------------------------------
		Function<String, Integer> toInt = Integer::parseInt;
		System.out.println("(1) Function  : \"123\" → " + toInt.apply("123"));

		// 함수 합성 - andThen : 먼저 toInt → 이후 *2
		Function<Integer, Integer> twice = n -> n * 2;
		Function<String, Integer> toIntThenTwice = toInt.andThen(twice);
		System.out.println("    andThen   : \"50\" → " + toIntThenTwice.apply("50")); // 100

		// ----------------------------------------------------
		// (2) Consumer<T>  :  T → void (accept)
		//     인자를 받지만 결과를 돌려주지 않음 (=출력/저장 등 부수효과)
		// ----------------------------------------------------
		Consumer<String> printer = System.out::println;
		printer.accept("(2) Consumer : 그냥 출력만 함");

		// andThen 으로 여러 Consumer 연결 가능
		Consumer<String> upperPrinter = s -> System.out.println("    UPPER : " + s.toUpperCase());
		printer.andThen(upperPrinter).accept("(2-2) andThen Consumer");

		// ----------------------------------------------------
		// (3) Supplier<T>  :  () → T (get)
		//     인자 없이 결과만 만들어 돌려줌 (=팩토리)
		// ----------------------------------------------------
		Supplier<java.util.ArrayList<String>> listFactory = java.util.ArrayList::new;
		java.util.ArrayList<String> list = listFactory.get();
		list.add("AAA");
		list.add("BBB");
		System.out.println("(3) Supplier : 새 리스트 생성 → " + list);

		// ----------------------------------------------------
		// (4) Predicate<T>  :  T → boolean (test)
		//     조건 검사용 - filter 와 가장 잘 어울림
		// ----------------------------------------------------
		Predicate<String> isEmpty   = String::isEmpty;
		Predicate<String> isShort   = s -> s.length() < 3;

		System.out.println("(4-1) isEmpty(\"\")    = " + isEmpty.test(""));
		System.out.println("(4-2) isShort(\"hi\")  = " + isShort.test("hi"));

		// 조합 메서드 : and / or / negate
		Predicate<String> notEmptyAndShort = isEmpty.negate().and(isShort);
		System.out.println("(4-3) notEmpty && short (\"ok\") = "
				+ notEmptyAndShort.test("ok"));

		// Stream 결합 예시
		List<String> words = Arrays.asList("a", "bb", "ccc", "dddd", "");
		System.out.println("(4-4) Stream + Predicate :");
		words.stream()
		     .filter(isEmpty.negate())   // 비어있지 않은 것만
		     .filter(isShort)            // 길이 3 미만만
		     .forEach(printer);

		// ----------------------------------------------------
		// (5) BiFunction<T, U, R>  :  (T,U) → R (apply)
		//     인자 2개를 받아 결과를 반환
		// ----------------------------------------------------
		BiFunction<String, String, Integer> cmp = String::compareTo;
		System.out.println("(5) BiFunction \"apple\".compareTo(\"banana\") = "
				+ cmp.apply("apple", "banana"));

		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		System.out.println("    BiFunction 덧셈 3+5 = " + add.apply(3, 5));

		// ----------------------------------------------------
		// (6) 한눈 정리표
		//     ┌──────────────┬───────────────┬──────────┐
		//     │ 인터페이스    │ 시그니처       │ 메서드   │
		//     ├──────────────┼───────────────┼──────────┤
		//     │ Function<T,R>│ T   → R        │ apply    │
		//     │ Consumer<T>  │ T   → void     │ accept   │
		//     │ Supplier<T>  │ ()  → T        │ get      │
		//     │ Predicate<T> │ T   → boolean  │ test     │
		//     │ BiFunction   │ T,U → R        │ apply    │
		//     └──────────────┴───────────────┴──────────┘
		//
		//     숫자 전용 변형도 있다 (boxing 비용 절감용):
		//       IntFunction / IntConsumer / IntSupplier / IntPredicate ...
		//       LongFunction / DoubleFunction ...
		// ----------------------------------------------------
	}
}
