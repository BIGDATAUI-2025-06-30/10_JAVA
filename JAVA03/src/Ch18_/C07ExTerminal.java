package Ch18_;

/* ----------------------------------------------------------
   7-Ex. [학생용 문제] 최종 연산 (Terminal Operations)
   ----------------------------------------------------------
   학습 단계 : C07최종연산 학습 직후
   풀이 :   TODO 채우기
            (정답은 C07ExTerminalAns.java)
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class C07ExTerminal {

	public static void main(String[] args) {

		List<Integer> nums  = Arrays.asList(15, 8, 23, 42, 4, 16, 30);
		List<String>  names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

		// ====================================================
		// Q1. nums 의 합 / 평균 / 최댓값 / 최솟값
		//     힌트 : mapToInt(Integer::intValue).sum() / .average() / max(Comparator...) / min(...)
		// ====================================================
		int               q1_sum = 0;             // TODO
		double            q1_avg = 0;             // TODO
		Optional<Integer> q1_max = Optional.empty();  // TODO
		Optional<Integer> q1_min = Optional.empty();  // TODO

		System.out.println("Q1. 합=" + q1_sum + " / 평균=" + q1_avg
				+ " / 최댓=" + q1_max.orElse(0) + " / 최솟=" + q1_min.orElse(0));

		// ====================================================
		// Q2. nums 가 모두 양수인지 / 음수가 하나라도 있는지 / 100 초과 없는지
		//     힌트 : allMatch / anyMatch / noneMatch
		// ====================================================
		boolean q2_allPos   = false; // TODO
		boolean q2_anyNeg   = false; // TODO
		boolean q2_noneOver = false; // TODO

		System.out.println("Q2. 모두양수=" + q2_allPos + " / 음수있나=" + q2_anyNeg
				+ " / 100초과없나=" + q2_noneOver);

		// ====================================================
		// Q3. names 를 ", " 로 이어 붙이기
		//     기대 : Alice, Bob, Charlie, David, Eve
		//     힌트 : Collectors.joining(", ")
		// ====================================================
		String q3 = null; // TODO
		System.out.println("Q3. joining   : " + q3);

		// ====================================================
		// Q4. names 를 "이름 길이별" 로 그룹핑
		//     기대 : {3=[Bob, Eve], 5=[Alice, David], 7=[Charlie]}
		//     힌트 : Collectors.groupingBy(String::length)
		// ====================================================
		Map<Integer, List<String>> q4 = null; // TODO
		System.out.println("Q4. 길이별 그룹 : " + q4);

		// ====================================================
		// Q5. nums 에서 첫 번째 짝수 / 임의 짝수
		//     힌트 : filter + findFirst / findAny
		// ====================================================
		Optional<Integer> q5_first = Optional.empty(); // TODO
		Optional<Integer> q5_any   = Optional.empty(); // TODO

		System.out.println("Q5. 첫 짝수    : " + q5_first.orElse(-1));
		System.out.println("Q5. 임의 짝수  : " + q5_any.orElse(-1));
	}
}
