package Ch19;

/* ----------------------------------------------------------
   4. [정답] Function + Stream 으로 List 가공
   ----------------------------------------------------------
   대응 문제 : C04Ex.java
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class C04ExAns {

	// (1) List<String> → Integer : 길이 5 이상 문자열의 개수
	public static Function<List<String>, Integer> func1 =
			list -> (int) list.stream()
			                  .filter(s -> s.length() >= 5)
			                  .count();

	// (2) List<Integer> → Integer : 각 숫자 제곱 후 합
	public static Function<List<Integer>, Integer> func2 =
			list -> list.stream()
			            .mapToInt(Integer::intValue)
			            .map(n -> n * n)
			            .sum();

	// (3) List<String> → List<String> : 각 문자열의 첫 글자만 추출해 대문자로
	public static Function<List<String>, List<String>> func3 =
			list -> list.stream()
			            .filter(s -> s != null && !s.isEmpty())
			            .map(s -> s.substring(0, 1).toUpperCase())
			            .collect(Collectors.toList());

	public static void main(String[] args) {
		List<String>  words = Arrays.asList("apple", "hi", "banana", "cat", "elephant");
		List<Integer> nums  = Arrays.asList(1, 2, 3, 4, 5);
		List<String>  names = Arrays.asList("kim", "park", "lee", "choi");

		System.out.println("(1) 길이 5 이상 개수 : " + func1.apply(words)); // 3
		System.out.println("(2) 제곱 합          : " + func2.apply(nums));  // 55
		System.out.println("(3) 첫 글자 대문자   : " + func3.apply(names)); // [K, P, L, C]
	}
}
