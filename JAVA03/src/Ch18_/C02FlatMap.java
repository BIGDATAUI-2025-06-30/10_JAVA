package Ch18_;

/* ----------------------------------------------------------
   2. flatMap - 중첩 컬렉션 평탄화 (Flattening)
   ----------------------------------------------------------
   설명 : 각 요소를 "스트림" 으로 변환한 뒤,
          그 스트림들을 하나의 평탄한 스트림으로 이어붙임.
   비유 : map  = 양파를 양파로 변환 (1:1)
          flatMap = 양파를 잘라 양파 조각 여러 개로 변환 후 한 바구니에 담기 (1:N)
   용도 : - List<List<X>> → List<X>  (2차원 → 1차원)
          - List<String> 의 각 문장을 단어들로 쪼개기
          - 객체 안의 List 필드를 평탄화
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C02FlatMap {

	public static void main(String[] args) {

		// ====================================================
		// (1) 중첩 리스트 평탄화 - List<List<Integer>> → List<Integer>
		// ====================================================
		List<List<Integer>> numbers = Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(4, 5, 6),
				Arrays.asList(7, 8, 9)
		);

		List<Integer> flatNumbers = numbers.stream()
				.flatMap(List::stream)   // 람다 : (li) -> li.stream()
				.collect(Collectors.toList());

		System.out.println("(1) 원본       : " + numbers);
		System.out.println("(1) 평탄화 후  : " + flatNumbers);

		// ====================================================
		// (2) 문자열 → 단어들로 쪼개기 (flatMap 의 가장 유명한 활용)
		//     "Hello World" → ["Hello", "World"]
		//     여러 문장 → 모든 단어 한 줄
		// ====================================================
		List<String> sentences = Arrays.asList(
				"Hello World",
				"Stream API is powerful",
				"Java is fun"
		);

		List<String> words = sentences.stream()
				.flatMap(s -> Arrays.stream(s.split(" ")))   // 문장 → 단어 스트림
				.collect(Collectors.toList());

		System.out.println("(2) 원본 문장 : " + sentences);
		System.out.println("(2) 모든 단어 : " + words);

		// ====================================================
		// (3) map vs flatMap 비교
		//     map      : 문장 → "단어 배열" 자체를 원소로 (List<String[]>)
		//     flatMap  : 단어들을 풀어서 평탄한 List<String>
		// ====================================================
		List<String[]> withMap = sentences.stream()
				.map(s -> s.split(" "))
				.collect(Collectors.toList());

		System.out.print("(3) map 결과 (각 원소가 배열) : ");
		withMap.forEach(arr -> System.out.print(Arrays.toString(arr) + " "));
		System.out.println();

		List<String> withFlatMap = sentences.stream()
				.flatMap(s -> Arrays.stream(s.split(" ")))
				.collect(Collectors.toList());
		System.out.println("(3) flatMap 결과 (평탄)     : " + withFlatMap);
	}
}
