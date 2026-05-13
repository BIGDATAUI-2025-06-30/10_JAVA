package Ch18_;

/* ----------------------------------------------------------
   1-Ex. [정답] filter / map 기초
   ----------------------------------------------------------
   대응 문제 : C01ExFilterMap.java
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C01ExFilterMapAns {

	public static void main(String[] args) {

		// Q1. nums 에서 짝수만 골라 List<Integer> 반환
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> q1 = nums.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());
		System.out.println("Q1. 짝수만        : " + q1);

		// Q2. mixed 에서 음수만 골라 절댓값으로 변환 (메서드 참조 Math::abs)
		List<Integer> mixed = Arrays.asList(-3, 5, -1, 8, -7, 2);

		List<Integer> q2 = mixed.stream()
				.filter(n -> n < 0)
				.map(Math::abs)
				.collect(Collectors.toList());
		System.out.println("Q2. 음수의 절댓값  : " + q2);

		// Q3. 5글자 이상의 단어만 골라 모두 대문자로
		List<String> words = Arrays.asList("apple", "hi", "banana", "cat", "elephant");

		List<String> q3 = words.stream()
				.filter(s -> s.length() >= 5)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		System.out.println("Q3. 5글자+대문자  : " + q3);

		// Q4. 1~20 중 3의 배수만 골라 제곱
		List<Integer> q4 = IntStream.rangeClosed(1, 20)
				.boxed()
				.filter(n -> n % 3 == 0)
				.map(n -> n * n)
				.collect(Collectors.toList());
		System.out.println("Q4. 3배수의 제곱  : " + q4);

		// Q5. 'a' 로 시작하는 것만 골라 첫 글자만 추출
		List<String> words2 = Arrays.asList("apple", "banana", "ant", "kiwi", "avocado");

		List<String> q5 = words2.stream()
				.filter(s -> s.startsWith("a"))
				.map(s -> s.substring(0, 1))
				.collect(Collectors.toList());
		System.out.println("Q5. a로 시작 첫글자: " + q5);
	}
}
