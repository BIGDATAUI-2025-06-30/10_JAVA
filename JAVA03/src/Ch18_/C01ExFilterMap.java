package Ch18_;

/* ----------------------------------------------------------
   1-Ex. [학생용 문제] filter / map 기초
   ----------------------------------------------------------
   학습 단계 : C01STREAMMAIN 학습 직후
   준비 :   filter(Predicate), map(Function), collect(toList) 이해
   풀이 :   각 Q 의 TODO 부분에 stream 파이프라인 작성
            (정답은 C01ExFilterMapAns.java 참고)
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;

public class C01ExFilterMap {

	public static void main(String[] args) {

		// ====================================================
		// Q1. nums 에서 짝수만 골라 List<Integer> 반환
		//     기대 : [2, 4, 6, 8, 10]
		// ====================================================
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> q1 = null; // TODO

		System.out.println("Q1. 짝수만        : " + q1);

		// ====================================================
		// Q2. mixed 에서 음수만 골라 절댓값으로 변환
		//     기대 : [3, 1, 7]
		// ====================================================
		List<Integer> mixed = Arrays.asList(-3, 5, -1, 8, -7, 2);

		List<Integer> q2 = null; // TODO

		System.out.println("Q2. 음수의 절댓값  : " + q2);

		// ====================================================
		// Q3. 5글자 이상의 단어만 골라 모두 대문자로
		//     기대 : [APPLE, BANANA, ELEPHANT]
		// ====================================================
		List<String> words = Arrays.asList("apple", "hi", "banana", "cat", "elephant");

		List<String> q3 = null; // TODO

		System.out.println("Q3. 5글자+대문자  : " + q3);

		// ====================================================
		// Q4. 1~20 중 3의 배수만 골라 제곱
		//     기대 : [9, 36, 81, 144, 225, 324]
		//     힌트 : IntStream.rangeClosed(1, 20).boxed()
		// ====================================================
		List<Integer> q4 = null; // TODO

		System.out.println("Q4. 3배수의 제곱  : " + q4);

		// ====================================================
		// Q5. words2 에서 'a' 로 시작하는 것만 골라 첫 글자만 추출
		//     기대 : [a, a, a]  (apple, ant, avocado)
		// ====================================================
		List<String> words2 = Arrays.asList("apple", "banana", "ant", "kiwi", "avocado");

		List<String> q5 = null; // TODO

		System.out.println("Q5. a로 시작 첫글자: " + q5);
	}
}
