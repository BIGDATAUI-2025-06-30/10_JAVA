package Ch18_;

/* ----------------------------------------------------------
   7-Ex. [학생용 연습] 최종 연산 (Terminal Operations)
   ----------------------------------------------------------
   학습 단계 : C07최종연산 학습 직후
   준비 :   forEach / collect / reduce / count / min / max
            anyMatch / allMatch / noneMatch / findFirst / findAny
   목표 :   각 최종 연산을 실제 시나리오에서 활용 - 5문제
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class C07ExTerminal {

	public static void main(String[] args) {

		List<Integer> nums  = Arrays.asList(15, 8, 23, 42, 4, 16, 30);
		List<String>  names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

		// ====================================================
		// Q1. nums 의 합 / 평균 / 최댓값 / 최솟값을 모두 구하기
		//     힌트 : reduce / mapToInt + sum / average / min / max
		// ====================================================
		int               q1_sum = nums.stream().mapToInt(Integer::intValue).sum();
		double            q1_avg = nums.stream().mapToInt(Integer::intValue).average().orElse(0);
		Optional<Integer> q1_max = nums.stream().max(Comparator.naturalOrder());
		Optional<Integer> q1_min = nums.stream().min(Comparator.naturalOrder());

		System.out.println("Q1. 합="    + q1_sum
				+ " / 평균=" + q1_avg
				+ " / 최댓="   + q1_max.orElse(0)
				+ " / 최솟="   + q1_min.orElse(0));

		// ====================================================
		// Q2. nums 가 모두 양수인지 / 음수가 하나라도 있는지 / 100 초과가 전혀 없는지
		//     힌트 : allMatch / anyMatch / noneMatch
		// ====================================================
		boolean q2_allPos    = nums.stream().allMatch(n -> n > 0);
		boolean q2_anyNeg    = nums.stream().anyMatch(n -> n < 0);
		boolean q2_noneOver  = nums.stream().noneMatch(n -> n > 100);
		System.out.println("Q2. 모두양수=" + q2_allPos
				+ " / 음수있나=" + q2_anyNeg
				+ " / 100초과없나=" + q2_noneOver);

		// ====================================================
		// Q3. names 를 ", " 로 이어 붙여 한 문장으로 만들기
		//     기대 : "Alice, Bob, Charlie, David, Eve"
		//     힌트 : collect(Collectors.joining(", "))
		// ====================================================
		String q3 = names.stream().collect(Collectors.joining(", "));
		System.out.println("Q3. joining   : " + q3);

		// 보너스 : 앞/뒤 꾸미기까지
		String q3b = names.stream().collect(Collectors.joining(", ", "[", "]"));
		System.out.println("Q3. joining(꾸미기) : " + q3b);

		// ====================================================
		// Q4. names 를 "이름 길이별" 로 그룹핑
		//     기대 : {3=[Bob, Eve], 5=[Alice, David], 7=[Charlie]}
		//     힌트 : Collectors.groupingBy
		// ====================================================
		Map<Integer, List<String>> q4 = names.stream()
				.collect(Collectors.groupingBy(String::length));
		System.out.println("Q4. 길이별 그룹 : " + q4);

		// ====================================================
		// Q5. nums 에서 첫 번째 짝수 / 임의의 짝수 찾기
		//     힌트 : findFirst / findAny + Optional
		// ====================================================
		Optional<Integer> q5_first = nums.stream().filter(n -> n % 2 == 0).findFirst();
		Optional<Integer> q5_any   = nums.stream().filter(n -> n % 2 == 0).findAny();
		System.out.println("Q5. 첫 짝수    : " + q5_first.orElse(-1));
		System.out.println("Q5. 임의 짝수  : " + q5_any.orElse(-1));
	}
}
