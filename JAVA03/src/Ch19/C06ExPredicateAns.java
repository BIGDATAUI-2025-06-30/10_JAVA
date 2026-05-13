package Ch19;

/* ----------------------------------------------------------
   6. [정답] Predicate 활용 + 조합 메서드 (and / or / negate)
   ----------------------------------------------------------
   대응 문제 : C06ExPredicate.java
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class C06ExPredicateAns {

	public static void main(String[] args) {

		List<Integer> nums  = Arrays.asList(-5, -3, 0, 2, 7, 8, 11, 13, 15, 20);
		List<String>  words = Arrays.asList("apple", "ant", "banana", "cherry", "", "kiwi", "berry");

		// (1) 정수 Predicate
		Predicate<Integer> isPositive = n -> n > 0;
		Predicate<Integer> isEven     = n -> n % 2 == 0;
		Predicate<Integer> lessThan10 = n -> n < 10;

		System.out.println("(1-1) 양수만        : " + filter(nums, isPositive));
		System.out.println("(1-2) 짝수만        : " + filter(nums, isEven));
		System.out.println("(1-3) 10 미만만     : " + filter(nums, lessThan10));
		System.out.println("(1-4) 양수 AND 짝수 : " + filter(nums, isPositive.and(isEven)));
		System.out.println("(1-5) 양수 OR 짝수  : " + filter(nums, isPositive.or(isEven)));
		System.out.println("(1-6) NOT 양수      : " + filter(nums, isPositive.negate()));
		System.out.println("(1-7) 양수&10미만&짝수 : "
				+ filter(nums, isPositive.and(lessThan10).and(isEven)));

		// (2) 문자열 Predicate
		Predicate<String> isEmpty     = String::isEmpty;
		Predicate<String> startsWithA = s -> s.startsWith("a");
		Predicate<String> lenGE5      = s -> s.length() >= 5;

		System.out.println();
		System.out.println("(2-1) 비어있지 않은 것 : " + filter(words, isEmpty.negate()));
		System.out.println("(2-2) a 로 시작        : " + filter(words, startsWithA));
		System.out.println("(2-3) 길이 5 이상      : " + filter(words, lenGE5));

		// (3) Predicate.isEqual / negate
		Predicate<String> isApple = Predicate.isEqual("apple");
		System.out.println();
		System.out.println("(3-1) 값이 apple 인 것  : " + filter(words, isApple));
		System.out.println("(3-2) 값이 apple 아닌 것: " + filter(words, isApple.negate()));
	}

	private static <T> List<T> filter(List<T> list, Predicate<T> p) {
		return list.stream().filter(p).collect(Collectors.toList());
	}
}
