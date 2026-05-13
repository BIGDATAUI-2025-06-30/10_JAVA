package Ch18_;

/* ----------------------------------------------------------
   6-Ex. [정답] limit / skip 활용
   ----------------------------------------------------------
   대응 문제 : C06ExPaginate.java
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C06ExPaginateAns {

	public static void main(String[] args) {

		// Q1. 5배수 앞 3개
		List<Integer> q1 = IntStream.rangeClosed(1, 100)
				.boxed()
				.filter(n -> n % 5 == 0)
				.limit(3)
				.collect(Collectors.toList());
		System.out.println("Q1. 5배수 앞 3개      : " + q1);

		// Q2. 상위/하위 3
		List<Integer> scores = Arrays.asList(88, 72, 95, 60, 100, 81, 77, 55, 90);
		List<Integer> top3 = scores.stream()
				.sorted((a, b) -> b - a)
				.limit(3)
				.collect(Collectors.toList());
		List<Integer> bottom3 = scores.stream()
				.sorted()
				.limit(3)
				.collect(Collectors.toList());
		System.out.println("Q2. 상위 3            : " + top3);
		System.out.println("Q2. 하위 3            : " + bottom3);

		// Q3. 페이지 3 (size=7)
		List<Integer> all = IntStream.rangeClosed(1, 30).boxed().collect(Collectors.toList());
		int page = 3, size = 7;
		List<Integer> q3 = all.stream()
				.skip((long) (page - 1) * size)
				.limit(size)
				.collect(Collectors.toList());
		System.out.println("Q3. 페이지 3 (size=7) : " + q3);

		// Q4. 피보나치 10개
		List<Integer> q4 = Stream.iterate(new int[]{0, 1}, p -> new int[]{p[1], p[0] + p[1]})
				.limit(10)
				.map(p -> p[0])
				.collect(Collectors.toList());
		System.out.println("Q4. 피보나치 10개     : " + q4);

		// Q5. 헤더 스킵 + 첫 3건
		List<String> logs = Arrays.asList(
				"# Log start 2026-05-13",
				"# columns: time,level,msg",
				"10:00,INFO,서버 시작",
				"10:01,WARN,느린 응답",
				"10:02,ERROR,DB 연결 실패",
				"10:03,INFO,재시도 성공",
				"10:04,INFO,정상"
		);
		System.out.println("Q5. 로그 데이터 첫 3건 :");
		logs.stream()
				.skip(2)
				.limit(3)
				.forEach(line -> System.out.println("   " + line));
	}
}
