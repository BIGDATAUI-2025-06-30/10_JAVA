package Ch18_;

/* ----------------------------------------------------------
   7-Ex. [정답] 최종 연산
   ----------------------------------------------------------
   대응 문제 : C07ExTerminal.java
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class C07ExTerminalAns {

	public static void main(String[] args) {

		List<Integer> nums  = Arrays.asList(15, 8, 23, 42, 4, 16, 30);
		List<String>  names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

		// Q1. 합/평균/최댓/최솟
		int               q1_sum = nums.stream().mapToInt(Integer::intValue).sum();
		double            q1_avg = nums.stream().mapToInt(Integer::intValue).average().orElse(0);
		Optional<Integer> q1_max = nums.stream().max(Comparator.naturalOrder());
		Optional<Integer> q1_min = nums.stream().min(Comparator.naturalOrder());
		System.out.println("Q1. 합=" + q1_sum + " / 평균=" + q1_avg
				+ " / 최댓=" + q1_max.orElse(0) + " / 최솟=" + q1_min.orElse(0));

		// Q2. allMatch/anyMatch/noneMatch
		boolean q2_allPos   = nums.stream().allMatch(n -> n > 0);
		boolean q2_anyNeg   = nums.stream().anyMatch(n -> n < 0);
		boolean q2_noneOver = nums.stream().noneMatch(n -> n > 100);
		System.out.println("Q2. 모두양수=" + q2_allPos + " / 음수있나=" + q2_anyNeg
				+ " / 100초과없나=" + q2_noneOver);

		// Q3. joining
		String q3 = names.stream().collect(Collectors.joining(", "));
		System.out.println("Q3. joining   : " + q3);

		String q3b = names.stream().collect(Collectors.joining(", ", "[", "]"));
		System.out.println("Q3. joining(꾸미기) : " + q3b);

		// Q4. groupingBy(길이)
		Map<Integer, List<String>> q4 = names.stream()
				.collect(Collectors.groupingBy(String::length));
		System.out.println("Q4. 길이별 그룹 : " + q4);

		// Q5. findFirst / findAny
		Optional<Integer> q5_first = nums.stream().filter(n -> n % 2 == 0).findFirst();
		Optional<Integer> q5_any   = nums.stream().filter(n -> n % 2 == 0).findAny();
		System.out.println("Q5. 첫 짝수    : " + q5_first.orElse(-1));
		System.out.println("Q5. 임의 짝수  : " + q5_any.orElse(-1));
	}
}
