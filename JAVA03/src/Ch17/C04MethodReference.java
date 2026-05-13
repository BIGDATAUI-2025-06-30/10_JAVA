package Ch17;

/* ----------------------------------------------------------
   4. 메서드 참조 (Method Reference)
   ----------------------------------------------------------
   설명 : 람다식이 "기존 메서드를 그대로 호출"만 할 때
          ClassName::methodName 형태로 더 짧게 표현하는 문법
   비유 : 람다가 "이 일은 저 사람이 잘함" 이라고 지정만 하는 것
          (직접 일하는 코드를 쓰지 않고 담당자만 가리킴)
   용도 : - 람다 본문이 메서드 1개만 호출 → 메서드 참조로 치환
          - Stream / Collection API 와 결합해서 가독성 ↑
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class C04MethodReference {

	// 정적 메서드 참조용 (예시 메서드)
	public static int parse(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {

		// ----------------------------------------------------
		// (1) 정적(static) 메서드 참조  :  ClassName::staticMethod
		//     람다 : s -> Integer.parseInt(s)
		//     참조 : Integer::parseInt
		// ----------------------------------------------------
		Function<String, Integer> toInt1 = s -> Integer.parseInt(s); // 람다
		Function<String, Integer> toInt2 = Integer::parseInt;        // 메서드 참조
		System.out.println("(1) 정적 메서드 참조 : " + toInt2.apply("123"));

		// ----------------------------------------------------
		// (2) 특정 객체의 인스턴스 메서드 참조  :  instance::method
		//     람다 : msg -> System.out.println(msg)
		//     참조 : System.out::println   (System.out 이라는 특정 인스턴스에 바인딩)
		// ----------------------------------------------------
		java.util.function.Consumer<String> printer = System.out::println;
		printer.accept("(2) 특정 객체의 인스턴스 메서드 참조");

		// ----------------------------------------------------
		// (3) 특정 클래스의 임의 객체 인스턴스 메서드 참조  :  ClassName::method
		//     람다 : str -> str.toUpperCase()
		//     참조 : String::toUpperCase
		//     - 첫 번째 인자(str) 가 자동으로 메서드의 호출 대상이 됨
		// ----------------------------------------------------
		Function<String, String> upper = String::toUpperCase;
		System.out.println("(3) 임의 객체 인스턴스 메서드 참조 : " + upper.apply("hello"));

		// 인자 2개짜리 예시 : (a, b) -> a.compareTo(b)  →  String::compareTo
		BiFunction<String, String, Integer> cmp = String::compareTo;
		System.out.println("    \"apple\".compareTo(\"banana\") = " + cmp.apply("apple", "banana"));

		// ----------------------------------------------------
		// (4) 생성자 참조  :  ClassName::new
		//     람다 : () -> new ArrayList<>()
		//     참조 : ArrayList::new
		// ----------------------------------------------------
		Supplier<java.util.ArrayList<String>> listFactory = java.util.ArrayList::new;
		java.util.ArrayList<String> list = listFactory.get();
		list.add("AAA");
		list.add("BBB");
		System.out.println("(4) 생성자 참조 결과 : " + list);

		// ----------------------------------------------------
		// (5) Stream + 메서드 참조 조합 (실전 예시)
		//     map(String::toUpperCase)  ← 람다 (s -> s.toUpperCase()) 대비 훨씬 깔끔
		// ----------------------------------------------------
		System.out.println("(5) Stream + 메서드 참조 :");
		List<String> names = Arrays.asList("kim", "park", "lee");
		names.stream()
		     .map(String::toUpperCase)
		     .forEach(System.out::println);
	}
}
