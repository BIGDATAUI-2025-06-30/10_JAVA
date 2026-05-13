package Ch19;

/* ----------------------------------------------------------
   6. [학생용 문제] Predicate 활용 + 조합 메서드 (and / or / negate)
   ----------------------------------------------------------
   학습 포인트 :
     - Predicate<T> : T → boolean
     - 조합 메서드 : a.and(b) / a.or(b) / a.negate()
     - Stream.filter(Predicate) 결합
     - Predicate.isEqual / Predicate.not (정적)

   풀이 :   각 Predicate 람다 + 결과 변수 채우기
            (정답은 C06ExPredicateAns.java)
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
		//     TODO : isPositive (양수) / isEven (짝수) / lessThan10 (10미만) 람다
		// ====================================================
		Predicate<Integer> isPositive = null; // TODO
		Predicate<Integer> isEven     = null; // TODO
		Predicate<Integer> lessThan10 = null; // TODO

		// 단일 Predicate 활용
		if (isPositive != null && isEven != null && lessThan10 != null) {
			System.out.println("(1-1) 양수만        : " + filter(nums, isPositive));
			System.out.println("(1-2) 짝수만        : " + filter(nums, isEven));
			System.out.println("(1-3) 10 미만만     : " + filter(nums, lessThan10));

			// 조합 : and / or / negate
			System.out.println("(1-4) 양수 AND 짝수 : " + filter(nums, isPositive.and(isEven)));
			System.out.println("(1-5) 양수 OR 짝수  : " + filter(nums, isPositive.or(isEven)));
			System.out.println("(1-6) NOT 양수      : " + filter(nums, isPositive.negate()));
			System.out.println("(1-7) 양수&10미만&짝수 : "
					+ filter(nums, isPositive.and(lessThan10).and(isEven)));
		}

		// ====================================================
		// (2) 문자열 Predicate
		//     TODO : isEmpty (빈문자열) / startsWithA (a로 시작) / lenGE5 (길이 5 이상)
		// ====================================================
		Predicate<String> isEmpty     = null; // TODO  (힌트 : String::isEmpty)
		Predicate<String> startsWithA = null; // TODO
		Predicate<String> lenGE5      = null; // TODO

		if (isEmpty != null && startsWithA != null && lenGE5 != null) {
			System.out.println();
			System.out.println("(2-1) 비어있지 않은 것 : " + filter(words, isEmpty.negate()));
			System.out.println("(2-2) a 로 시작        : " + filter(words, startsWithA));
			System.out.println("(2-3) 길이 5 이상      : " + filter(words, lenGE5));
		}

		// ====================================================
		// (3) Predicate.isEqual / negate
		//     TODO : isApple 변수에 Predicate.isEqual("apple") 할당
		// ====================================================
		Predicate<String> isApple = null; // TODO

		if (isApple != null) {
			System.out.println();
			System.out.println("(3-1) 값이 apple 인 것  : " + filter(words, isApple));
			System.out.println("(3-2) 값이 apple 아닌 것: " + filter(words, isApple.negate()));
		}
	}

	private static <T> List<T> filter(List<T> list, Predicate<T> p) {
		return list.stream().filter(p).collect(Collectors.toList());
	}
}
