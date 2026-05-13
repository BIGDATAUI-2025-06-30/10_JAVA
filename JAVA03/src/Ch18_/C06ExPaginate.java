package Ch18_;

/* ----------------------------------------------------------
   6-Ex. [학생용 문제] limit / skip 활용
   ----------------------------------------------------------
   학습 단계 : C05Limited / C06Skip 학습 직후
   풀이 :   각 Q 의 TODO 채우기
            (정답은 C06ExPaginateAns.java)
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;

public class C06ExPaginate {

	public static void main(String[] args) {

		// ====================================================
		// Q1. 1~100 중 5의 배수만 골라 상위 3개를 가져온다
		//     기대 : [5, 10, 15]
		//     힌트 : IntStream.rangeClosed(1, 100).boxed()
		// ====================================================
		List<Integer> q1 = null; // TODO
		System.out.println("Q1. 5배수 앞 3개      : " + q1);

		// ====================================================
		// Q2. scores 의 상위 3명 / 하위 3명 점수
		//     기대 상위 : [100, 95, 90]   /   기대 하위 : [55, 60, 72]
		// ====================================================
		List<Integer> scores = Arrays.asList(88, 72, 95, 60, 100, 81, 77, 55, 90);

		List<Integer> top3 = null;    // TODO (내림차순 sorted + limit(3))
		List<Integer> bottom3 = null; // TODO (오름차순 sorted + limit(3))
		System.out.println("Q2. 상위 3            : " + top3);
		System.out.println("Q2. 하위 3            : " + bottom3);

		// ====================================================
		// Q3. 1~30 데이터를 페이지 크기 7 로 잘라 페이지 3 가져오기
		//     기대 : [15, 16, 17, 18, 19, 20, 21]
		//     힌트 : skip((page-1)*size) + limit(size)
		// ====================================================
		int page = 3;
		int size = 7;

		List<Integer> q3 = null; // TODO
		System.out.println("Q3. 페이지 3 (size=7) : " + q3);

		// ====================================================
		// Q4. 무한 스트림으로 피보나치 첫 10개 만들기
		//     기대 : [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
		//     힌트 : Stream.iterate(new int[]{0,1}, p -> new int[]{p[1], p[0]+p[1]})
		//            .limit(10).map(p -> p[0])
		// ====================================================
		List<Integer> q4 = null; // TODO
		System.out.println("Q4. 피보나치 10개     : " + q4);

		// ====================================================
		// Q5. logs 에서 헤더 2줄 스킵 + 데이터 첫 3건만 출력
		// ====================================================
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
		// TODO : logs.stream().skip(2).limit(3).forEach(...)
	}
}
