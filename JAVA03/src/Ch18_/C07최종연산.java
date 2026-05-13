package Ch18_;

/* ----------------------------------------------------------
   7. 최종 연산 (Terminal Operations) 카탈로그
   ----------------------------------------------------------
   설명 : 스트림 파이프라인의 마지막에 호출되어 실제로 데이터를
          소비하고 결과(값 / 컬렉션 / boolean / Optional)를 반환.
          ★ 최종 연산이 호출돼야 비로소 중간 연산들이 실행된다 (lazy).
          ★ 한 번 소비된 스트림은 재사용 불가.
   비유 : 수도관 끝에서 물을 받는 컵/저울/판단기.
   목록 :
     (1) forEach    - 반복 처리
     (2) collect    - 컬렉션으로 수집 (List / Set / Map)
     (3) reduce     - 누적해서 하나로 줄이기
     (4) count      - 개수 세기
     (5) min / max  - 최소 / 최대
     (6) anyMatch   - 하나라도 조건 만족하면 true
     (7) allMatch   - 모두 만족하면 true
     (8) noneMatch  - 모두 만족 안 하면 true
     (9) findFirst  - 첫 요소
     (10) findAny   - 임의 요소
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class C07최종연산 {

	public static void main(String[] args) {

		List<String>  names = Arrays.asList("John", "Jane", "Mike", "Jane", "Tom");
		List<Integer> nums  = Arrays.asList(5, 2, 8, 1, 4);

		// ====================================================
		// (1) forEach - 각 요소에 대해 작업 수행 (반환값 없음)
		// ====================================================
		System.out.println("(1) forEach :");
		names.stream().forEach(s -> System.out.println("    - " + s));

		// ====================================================
		// (2) collect - 컬렉션 형태로 수집
		//     (2-1) toList  : List<T>
		//     (2-2) toSet   : Set<T>   (중복 제거 됨)
		//     (2-3) toMap   : Map<K,V>
		//     (2-4) joining : 문자열 합치기
		//     (2-5) groupingBy : 그룹핑 → Map<K, List<V>>
		// ====================================================
		List<String> listResult = names.stream().collect(Collectors.toList());
		Set<String>  setResult  = names.stream().collect(Collectors.toSet());
		String       joined     = names.stream().collect(Collectors.joining(", "));
		Map<Integer, List<String>> byLen = names.stream()
				.collect(Collectors.groupingBy(String::length));

		System.out.println("(2-1) toList    : " + listResult);
		System.out.println("(2-2) toSet     : " + setResult);
		System.out.println("(2-4) joining   : " + joined);
		System.out.println("(2-5) groupingBy(길이별) : " + byLen);

		// ====================================================
		// (3) reduce - 누적 연산으로 하나의 값 산출
		//     (3-1) reduce(BinaryOperator)         → Optional<T>
		//     (3-2) reduce(identity, BinaryOperator) → T (Optional 아님)
		// ====================================================
		Optional<Integer> sumOpt = nums.stream().reduce((a, b) -> a + b);
		int sumWithSeed         = nums.stream().reduce(0, (a, b) -> a + b);
		int productWithSeed     = nums.stream().reduce(1, (a, b) -> a * b);

		System.out.println("(3-1) reduce(합/Optional) : " + sumOpt.orElse(0));   // 20
		System.out.println("(3-2) reduce(합/0 시드)   : " + sumWithSeed);         // 20
		System.out.println("(3-3) reduce(곱/1 시드)   : " + productWithSeed);     // 320

		// ====================================================
		// (4) count - 요소 개수 (long)
		// ====================================================
		long total = names.stream().count();
		long jCount = names.stream().filter(s -> s.startsWith("J")).count();
		System.out.println("(4) 전체 count : " + total);
		System.out.println("(4) J로 시작   : " + jCount);

		// ====================================================
		// (5) min / max - Comparator 기반 최소/최대 → Optional
		// ====================================================
		Optional<Integer> minV = nums.stream().min(Comparator.naturalOrder());
		Optional<Integer> maxV = nums.stream().max(Comparator.naturalOrder());
		Optional<String>  longest = names.stream().max(Comparator.comparingInt(String::length));

		System.out.println("(5) min : " + minV.orElse(0));
		System.out.println("(5) max : " + maxV.orElse(0));
		System.out.println("(5) 가장 긴 이름 : " + longest.orElse("(없음)"));

		// ====================================================
		// (6) anyMatch - 하나라도 조건 충족하면 true (단락 평가)
		// ====================================================
		boolean hasEven  = nums.stream().anyMatch(n -> n % 2 == 0);
		boolean hasMike  = names.stream().anyMatch(s -> s.equals("Mike"));
		System.out.println("(6) 짝수 있나?  : " + hasEven);
		System.out.println("(6) Mike 있나?  : " + hasMike);

		// ====================================================
		// (7) allMatch - 모두 조건 충족해야 true
		// ====================================================
		boolean allPositive = nums.stream().allMatch(n -> n > 0);
		boolean allLen4     = names.stream().allMatch(s -> s.length() == 4);
		System.out.println("(7) 모두 양수?  : " + allPositive);
		System.out.println("(7) 모두 길이4? : " + allLen4);

		// ====================================================
		// (8) noneMatch - 어떤 것도 조건 충족 안 해야 true
		// ====================================================
		boolean noneNegative = nums.stream().noneMatch(n -> n < 0);
		System.out.println("(8) 음수 없나? : " + noneNegative);

		// ====================================================
		// (9) findFirst - 첫 번째 요소 (순서 보장)
		// ====================================================
		Optional<String> first = names.stream().findFirst();
		Optional<String> firstJ = names.stream().filter(s -> s.startsWith("J")).findFirst();
		System.out.println("(9) 첫 요소         : " + first.orElse("(없음)"));
		System.out.println("(9) 첫 J 로 시작    : " + firstJ.orElse("(없음)"));

		// ====================================================
		// (10) findAny - 임의의 요소 (병렬 스트림에서 더 빠를 수 있음)
		// ====================================================
		Optional<String> any = names.stream().findAny();
		System.out.println("(10) 임의 요소 : " + any.orElse("(없음)"));
	}
}
