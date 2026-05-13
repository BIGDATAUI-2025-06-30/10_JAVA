package Ch19;

/* ----------------------------------------------------------
   4. [연습문제] Function + Stream 으로 List 가공
   ----------------------------------------------------------
   문제 :
     - func1 : List<String>  에서 길이가 5 이상인 문자열의 개수 반환
     - func2 : List<Integer> 의 각 숫자를 제곱해서 누적합 반환
     - func3 : List<String>  의 각 문자열의 "첫 글자만" 대문자로 추출한 리스트 반환

   학습 포인트 :
     - Function<T, R> 의 다양한 T, R 조합
     - Stream.count() / mapToInt(...).sum() / map + collect
     - 원본 C04Ex 의 시그니처가 문제 요구와 어긋났던 부분을 바로잡았다
       (func2 입력은 List<Integer>, func3 반환은 List<String>)
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class C04Ex {

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
			            .filter(s -> s != null && !s.isEmpty())  // 빈 문자열 방어
			            .map(s -> s.substring(0, 1).toUpperCase())
			            .collect(Collectors.toList());

	public static void main(String[] args) {

		// 테스트 데이터
		List<String> words   = Arrays.asList("apple", "hi", "banana", "cat", "elephant");
		List<Integer> nums   = Arrays.asList(1, 2, 3, 4, 5);
		List<String> names   = Arrays.asList("kim", "park", "lee", "choi");

		System.out.println("(1) 길이 5 이상 개수 : " + func1.apply(words));   // apple, banana, elephant → 3
		System.out.println("(2) 제곱 합          : " + func2.apply(nums));    // 1+4+9+16+25 = 55
		System.out.println("(3) 첫 글자 대문자   : " + func3.apply(names));   // [K, P, L, C]
	}
}
