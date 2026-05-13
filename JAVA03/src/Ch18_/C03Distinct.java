package Ch18_;

/* ----------------------------------------------------------
   3. distinct - 중복 제거
   ----------------------------------------------------------
   설명 : 스트림 안의 중복 원소를 제거 (앞쪽 순서 유지).
          ★ 중복 판별 기준은 equals() / hashCode() ★
   비유 : 양동이에서 같은 모양의 구슬을 골라내고 하나만 남기는 것.
   용도 : - 기본 타입(Integer/String) 의 중복 제거
          - 객체의 중복 제거 → 그 객체 클래스에 equals/hashCode 가
            정의되어 있어야 의도대로 동작함 (안 되어 있으면 객체 주소 기준)
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class C03Distinct {

	// 객체 distinct 실험용 (equals/hashCode 직접 구현)
	static class City {
		String name;
		City(String name) { this.name = name; }

		// 이름이 같으면 같은 도시로 본다
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (!(o instanceof City)) return false;
			return Objects.equals(name, ((City) o).name);
		}
		@Override
		public int hashCode() { return Objects.hash(name); }

		@Override
		public String toString() { return name; }
	}

	public static void main(String[] args) {

		// ====================================================
		// (1) 기본 타입(Integer) 의 중복 제거
		// ====================================================
		List<Integer> nums = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5);
		List<Integer> distinctNums = nums.stream()
				.distinct()
				.collect(Collectors.toList());

		System.out.println("(1) 원본 : " + nums);
		System.out.println("(1) 중복 제거 : " + distinctNums);

		// ====================================================
		// (2) 문자열 중복 제거 - String 은 equals/hashCode 가 이미 잘 정의돼 있음
		// ====================================================
		List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
		System.out.println("(2) 원본 : " + words);
		System.out.println("(2) 중복 제거 : "
				+ words.stream().distinct().collect(Collectors.toList()));

		// ====================================================
		// (3) 객체 중복 제거 - equals/hashCode 가 핵심
		//     City 는 name 이 같으면 같은 도시로 본다고 정의함 (위 City 클래스 참조)
		// ====================================================
		List<City> cities = Arrays.asList(
				new City("서울"),
				new City("대구"),
				new City("서울"),   // 중복
				new City("부산"),
				new City("대구")    // 중복
		);

		List<City> distinctCities = cities.stream()
				.distinct()
				.collect(Collectors.toList());

		System.out.println("(3) 원본 도시 : " + cities);
		System.out.println("(3) 중복 제거 : " + distinctCities);

		// 주의 : equals/hashCode 안 만들었으면 서로 다른 객체 주소라
		//        모두 다르다고 판단해 distinct 가 무의미해진다.
	}
}
