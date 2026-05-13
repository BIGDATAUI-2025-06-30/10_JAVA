package Ch18_;

/* ----------------------------------------------------------
   6-Ex. [학생용 연습] limit / skip 활용
   ----------------------------------------------------------
   학습 단계 : C05Limited / C06Skip 학습 직후
   준비 :   limit, skip, Stream.iterate, sorted 이해
   목표 :   "앞 N 개" / "건너뛰기" / "페이지네이션" / "무한 스트림" 5문제
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C06ExPaginate {

	public static void main(String[] args) {

		// ====================================================
		// Q1. 1~100 중 5의 배수만 골라 상위 3개를 가져온다
		//     기대 : [5, 10, 15]
		// ====================================================
		List<Integer> q1 = IntStream.rangeClosed(1, 100)
				.boxed()
				.filter(n -> n % 5 == 0)
				.limit(3)
				.collect(Collectors.toList());
		System.out.println("Q1. 5배수 앞 3개      : " + q1);

		// ====================================================
		// Q2. 점수 리스트에서 상위 3명 / 하위 3명 점수 출력
		//     원본 : [88, 72, 95, 60, 100, 81, 77, 55, 90]
		// ====================================================
		List<Integer> scores = Arrays.asList(88, 72, 95, 60, 100, 81, 77, 55, 90);

		List<Integer> top3 = scores.stream()
				.sorted((a, b) -> b - a)   // 내림차순
				.limit(3)
				.collect(Collectors.toList());

		List<Integer> bottom3 = scores.stream()
				.sorted()                   // 오름차순
				.limit(3)
				.collect(Collectors.toList());
		System.out.println("Q2. 상위 3            : " + top3);
		System.out.println("Q2. 하위 3            : " + bottom3);

		// ====================================================
		// Q3. 1~30 데이터를 페이지 크기 7 로 잘라 페이지 3 가져오기
		//     페이지 1: skip(0)  limit(7) → [1..7]
		//     페이지 2: skip(7)  limit(7) → [8..14]
		//     페이지 3: skip(14) limit(7) → [15..21]
		// ====================================================
		List<Integer> all = IntStream.rangeClosed(1, 30)
				.boxed()
				.collect(Collectors.toList());

		int page = 3;
		int size = 7;
		List<Integer> q3 = all.stream()
				.skip((long) (page - 1) * size)
				.limit(size)
				.collect(Collectors.toList());
		System.out.println("Q3. 페이지 3 (size=7) : " + q3);

		// ====================================================
		// Q4. 무한 스트림 - 피보나치 첫 10개
		//     힌트 : Stream.iterate(new int[]{0,1}, p -> new int[]{p[1], p[0]+p[1]})
		// ====================================================
		List<Integer> q4 = Stream.iterate(new int[]{0, 1}, p -> new int[]{p[1], p[0] + p[1]})
				.limit(10)
				.map(p -> p[0])
				.collect(Collectors.toList());
		System.out.println("Q4. 피보나치 10개     : " + q4);

		// ====================================================
		// Q5. 로그 데이터에서 헤더 2줄 스킵 + 데이터 첫 3건만
		// ====================================================
		List<String> logs = Arrays.asList(
				"# Log start 2026-05-13",                  // 헤더 1
				"# columns: time,level,msg",               // 헤더 2
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
