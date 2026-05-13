package Ch18_;

/* ----------------------------------------------------------
   5. limit - 앞에서 N 개만 통과
   ----------------------------------------------------------
   설명 : 스트림의 앞쪽 N 개만 다음 단계로 보내고 나머지는 차단.
   비유 : 수도관에 "N 컵만 받고 잠그는" 차단기를 끼우는 것.
   용도 : - "상위 N 개" 같은 top-N 작업
          - 무한 스트림(Stream.generate / Stream.iterate) 종료 조건
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C05Limited {

	public static void main(String[] args) {

		// ====================================================
		// (1) 앞에서 3개만 가져오기
		// ====================================================
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> top3 = nums.stream()
				.limit(3)
				.collect(Collectors.toList());
		System.out.println("(1) 원본    : " + nums);
		System.out.println("(1) 앞 3개  : " + top3);

		// ====================================================
		// (2) sorted + limit - "상위 N 개" 패턴 (자주 쓰임)
		//     정렬 후 위에서 N 개만
		// ====================================================
		List<Integer> top3Desc = nums.stream()
				.sorted((a, b) -> b - a)   // 내림차순
				.limit(3)
				.collect(Collectors.toList());
		System.out.println("(2) 상위 3개 : " + top3Desc);

		// ====================================================
		// (3) 무한 스트림 + limit - 종료 조건 만들기
		//     Stream.iterate(0, n -> n + 2) : 0, 2, 4, 6, ... 무한
		//     limit(5) 가 없으면 영원히 흐름
		// ====================================================
		List<Integer> evens = Stream.iterate(0, n -> n + 2)
				.limit(5)
				.collect(Collectors.toList());
		System.out.println("(3) 짝수 5개 : " + evens);
	}
}
