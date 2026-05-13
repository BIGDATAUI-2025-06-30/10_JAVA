package Ch18_;

/* ----------------------------------------------------------
   4. sorted - 정렬
   ----------------------------------------------------------
   설명 : 스트림 요소를 정렬해서 다음 단계로 흘려보냄.
          - sorted()                : 자연 순서 (Comparable 구현 필요)
          - sorted(Comparator)      : 사용자 지정 순서 (람다 Comparator)
          - Comparator.reverseOrder : 자연 순서 역방향
          - Comparator.comparing    : 객체 필드 추출해 정렬
   비유 : 수도관에 정렬기를 끼우는 것. 들어온 물(데이터) 을 순서대로 내보냄.
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C04Sorted {

	// 정렬 실험용 데이터 클래스
	static class Product {
		String name;
		int price;
		Product(String name, int price) { this.name = name; this.price = price; }
		@Override
		public String toString() { return name + "(" + price + ")"; }
	}

	public static void main(String[] args) {

		// ====================================================
		// (1) 기본 정렬 - 자연 순서 (오름차순)
		// ====================================================
		List<Integer> nums = Arrays.asList(5, 2, 8, 1, 4);
		List<Integer> asc = nums.stream()
				.sorted()
				.collect(Collectors.toList());
		System.out.println("(1) 원본       : " + nums);
		System.out.println("(1) 오름차순   : " + asc);

		// ====================================================
		// (2) 역순 정렬 - Comparator.reverseOrder()
		// ====================================================
		List<Integer> desc = nums.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("(2) 내림차순   : " + desc);

		// ====================================================
		// (3) 람다 Comparator - 직접 정의
		//     (a, b) -> b - a  : 내림차순
		// ====================================================
		List<Integer> descLambda = nums.stream()
				.sorted((a, b) -> b - a)
				.collect(Collectors.toList());
		System.out.println("(3) 람다 역순 : " + descLambda);

		// ====================================================
		// (4) 객체 정렬 - 가격 오름차순
		// ====================================================
		List<Product> products = Arrays.asList(
				new Product("우유",  3500),
				new Product("커피",  4500),
				new Product("물",     900),
				new Product("빵",    2800),
				new Product("케이크", 12000)
		);

		System.out.println("(4) 원본 : " + products);

		List<Product> byPriceAsc = products.stream()
				.sorted((a, b) -> a.price - b.price)
				.collect(Collectors.toList());
		System.out.println("(4) 가격 오름차순 : " + byPriceAsc);

		// ====================================================
		// (5) Comparator.comparing + reversed - 더 깔끔한 방식
		// ====================================================
		List<Product> byPriceDesc = products.stream()
				.sorted(Comparator.comparingInt((Product p) -> p.price).reversed())
				.collect(Collectors.toList());
		System.out.println("(5) 가격 내림차순 : " + byPriceDesc);

		// ====================================================
		// (6) 다중 정렬 - thenComparing (가격 → 같으면 이름순)
		// ====================================================
		List<Product> extra = Arrays.asList(
				new Product("우유", 3500),
				new Product("쥬스", 3500),
				new Product("물",    900),
				new Product("콜라", 3500)
		);
		List<Product> sorted = extra.stream()
				.sorted(Comparator
						.comparingInt((Product p) -> p.price)   // 1차 : 가격
						.thenComparing(p -> p.name))             // 2차 : 이름
				.collect(Collectors.toList());
		System.out.println("(6) 가격→이름 정렬 : " + sorted);
	}
}
