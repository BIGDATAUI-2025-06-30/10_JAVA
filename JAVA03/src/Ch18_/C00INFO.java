package Ch18_;

/* ----------------------------------------------------------
   0. Stream API 개요 (Java 8+)
   ----------------------------------------------------------
   설명 : 컬렉션(List/Set/Map)이나 배열의 데이터를
          "흘러가는 파이프라인" 형태로 가공하는 API.
          람다 / 메서드 참조와 결합해 선언적(declarative) 으로 코드를 쓴다.
   비유 : 컬렉션 = 양동이의 물 / Stream = 수도관
          - 중간 연산은 수도관에 끼우는 필터/밸브
          - 최종 연산은 마지막에 물을 받아내는 컵
   포인트 :
     1) 중간 연산(intermediate) 은 "지연(lazy)" - 최종 연산이 나오기 전엔 실제로 흐르지 않음
     2) 한 번 소비된 스트림은 재사용 불가 (다시 .stream() 호출해야 함)
     3) 원본 컬렉션을 바꾸지 않고 새 결과를 만든다 (불변성)
   ---------------------------------------------------------- */

public class C00INFO {

	/*
	  ── 중간 연산 (Intermediate Operations) ─────────────────
	     스트림 → 스트림 으로 변환. 여러 번 체이닝 가능. lazy.

	     filter   : 조건에 맞는 요소만 통과               (★★★ 자주 씀)
	     map      : 각 요소를 다른 형태로 변환            (★★★ 자주 씀)
	     flatMap  : 중첩 스트림을 1차원으로 평탄화        (List<List<X>> → List<X>)
	     distinct : 중복 제거 (equals/hashCode 기준)
	     sorted   : 정렬 (자연 순서 / Comparator)
	     limit    : 앞에서 N 개만
	     skip     : 앞 N 개 건너뛰기
	     peek     : 디버깅용 - 흘러가는 값 들여다보기

	  ── 최종 연산 (Terminal Operations) ─────────────────────
	     스트림 → 결과값/컬렉션. 호출되는 순간 파이프라인 실행.

	     forEach    : 각 요소에 대해 동작 수행              (★★ 자주 씀)
	     collect    : 결과를 List/Set/Map 으로 수집         (★★★ 자주 씀)
	     reduce     : 누적 연산으로 하나의 값 산출          (★★★ 자주 씀)
	     count      : 요소 개수 (long)
	     min / max  : 최소 / 최대 (Comparator 기준)
	     anyMatch   : 하나라도 조건 충족하면 true
	     allMatch   : 모두 조건 충족하면 true
	     noneMatch  : 어떤 것도 조건 충족하지 않으면 true
	     findFirst  : 첫 요소 (Optional)
	     findAny    : 임의의 요소 (Optional) - 병렬에서 유리
	*/

	/*
	  ── 파일별 학습 흐름 ──────────────────────────────────
	     C01 : filter / map / sorted / 메서드참조 / 생성자참조 종합 맛보기
	     C02 : flatMap (중첩 평탄화)
	     C03 : distinct (중복 제거)
	     C04 : sorted (정렬 - 기본 / 객체 / 역순)
	     C05 : limit  (앞 N 개)
	     C06 : skip   (앞 N 개 스킵, skip + limit 페이지네이션)
	     C07 : 최종 연산 11종 카탈로그
	     C08 : 종합 연습문제
	*/
}
