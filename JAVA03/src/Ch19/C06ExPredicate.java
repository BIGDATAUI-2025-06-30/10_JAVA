package Ch19;

/* ----------------------------------------------------------
   6. [연습문제] Predicate 활용 + 조합 메서드 (and / or / negate)
   ----------------------------------------------------------
   문제 :
     - 정수 리스트와 문자열 리스트가 주어졌을 때
     - Predicate<T> 를 람다로 정의하고
     - and / or / negate 로 조합해서 다양한 필터 결과를 출력한다

   학습 포인트 :
     - Predicate<T> : T → boolean 을 반환하는 표준 함수형 인터페이스
     - 조합 메서드 :
         a.and(b)  → 둘 다 true 일 때 true
         a.or(b)   → 하나라도 true 면 true
         a.negate()→ 결과를 반대로 뒤집음
     - Stream.filter(Predicate) 와 자연스럽게 결합
     - Predicate.isEqual / not 등 정적 메서드 활용
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class C06ExPredicate {

	public static void main(String[] args) {

		List<Integer> nums  = Arrays.asList(-5, -3, 0, 2, 7, 8, 11, 13, 15, 20);
		List<String>  words = Arrays.asList("apple", "ant", "banana", "cherry", "", "kiwi", "berry");

		// ====================================================
		// (1) 기본 Predicate 정의 (정수)
		// ====================================================
		Predicate<Integer> isPositive = n -> n > 0;
		Predicate<Integer> isEven     = n -> n % 2 == 0;
		Predicate<Integer> lessThan10 = n -> n < 10;

		// ────── 단일 Predicate
		System.out.println("(1-1) 양수만        : " + filter(nums, isPositive));
		System.out.println("(1-2) 짝수만        : " + filter(nums, isEven));
		System.out.println("(1-3) 10 미만만     : " + filter(nums, lessThan10));

		// ────── and / or / negate 조합
		System.out.println("(1-4) 양수 AND 짝수 : "
				+ filter(nums, isPositive.and(isEven)));            // 2,8,20
		System.out.println("(1-5) 양수 OR 짝수  : "
				+ filter(nums, isPositive.or(isEven)));             // 0,2,7,8,11,13,15,20
		System.out.println("(1-6) NOT 양수      : "
				+ filter(nums, isPositive.negate()));               // -5,-3,0

		// 조합 응용 : 양수이면서 10미만이면서 짝수
		Predicate<Integer> 양수_10미만_짝수 = isPositive.and(lessThan10).and(isEven);
		System.out.println("(1-7) 양수 & 10미만 & 짝수 : "
				+ filter(nums, 양수_10미만_짝수));                    // 2,8

		// ====================================================
		// (2) 문자열 Predicate
		// ====================================================
		Predicate<String> isEmpty       = String::isEmpty;
		Predicate<String> startsWithA   = s -> s.startsWith("a");
		Predicate<String> lenGE5        = s -> s.length() >= 5;

		System.out.println();
		System.out.println("(2-1) 비어있지 않은 것     : " + filter(words, isEmpty.negate()));
		System.out.println("(2-2) a 로 시작            : " + filter(words, startsWithA));
		System.out.println("(2-3) 길이 5 이상          : " + filter(words, lenGE5));
		System.out.println("(2-4) 비어있지 않고 길이 5+ : "
				+ filter(words, isEmpty.negate().and(lenGE5)));

		// ====================================================
		// (3) Predicate.isEqual / Predicate.not (정적 메서드)
		//     isEqual(x)  : 값이 x 와 같으면 true
		//     not(p)      : Predicate.negate() 의 정적 버전 (Java 11+)
		// ====================================================
		Predicate<String> isApple = Predicate.isEqual("apple");
		System.out.println();
		System.out.println("(3-1) 값이 apple 인 것  : " + filter(words, isApple));
		System.out.println("(3-2) 값이 apple 아닌 것: " + filter(words, isApple.negate()));
	}

	// 공통 헬퍼 - 리스트 + Predicate 받아서 filter 결과 리스트 반환
	private static <T> List<T> filter(List<T> list, Predicate<T> p) {
		return list.stream().filter(p).collect(Collectors.toList());
	}
}
