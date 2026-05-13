package Ch18_;

/* ----------------------------------------------------------
   6. skip - 앞에서 N 개 건너뛰기 (+ skip + limit 페이지네이션)
   ----------------------------------------------------------
   설명 : 스트림의 앞쪽 N 개를 무시하고 그 이후만 다음 단계로 보냄.
   비유 : 수도관 앞쪽 물을 N 컵 버리고 그 다음부터 받는 것.
   용도 : - 첫 N 개 무시 (예: 헤더 건너뛰기)
          - skip + limit 조합 → 페이지네이션 (page 단위로 잘라 가져오기)
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class C06Skip {

	public static void main(String[] args) {

		// ====================================================
		// (1) 앞에서 2개 건너뛰기
		// ====================================================
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> skipped = nums.stream()
				.skip(2)
				.collect(Collectors.toList());
		System.out.println("(1) 원본       : " + nums);
		System.out.println("(1) skip(2)    : " + skipped);

		// ====================================================
		// (2) skip + limit = 페이지네이션
		//     pageSize = 3 일 때
		//       page 1 : skip(0) limit(3)
		//       page 2 : skip(3) limit(3)
		//       page 3 : skip(6) limit(3)
		// ====================================================
		List<Integer> all = IntStream.rangeClosed(1, 10)
				.boxed()
				.collect(Collectors.toList());   // [1..10]

		int pageSize = 3;
		System.out.println("(2) 전체 : " + all);
		for (int page = 1; page <= 4; page++) {
			List<Integer> pageData = all.stream()
					.skip((long) (page - 1) * pageSize)
					.limit(pageSize)
					.collect(Collectors.toList());
			System.out.println("(2) " + page + " 페이지 : " + pageData);
		}

		// ====================================================
		// (3) skip 으로 첫 줄(헤더) 건너뛰기 패턴
		// ====================================================
		List<String> csv = Arrays.asList(
				"name,age",   // 헤더
				"홍길동,45",
				"김범수,35",
				"유재석,53"
		);

		System.out.println("(3) 데이터 행 (헤더 제외) :");
		csv.stream()
				.skip(1)
				.forEach(System.out::println);
	}
}
