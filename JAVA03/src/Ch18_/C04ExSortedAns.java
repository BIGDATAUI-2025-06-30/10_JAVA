package Ch18_;

/* ----------------------------------------------------------
   4-Ex. [정답] distinct / sorted 조합
   ----------------------------------------------------------
   대응 문제 : C04ExSorted.java
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C04ExSortedAns {

	// 답안용 책 클래스 (문제 파일 Book 과 같은 구조 / 패키지 충돌 방지 위해 BookA)
	static class BookA {
		String title;
		String author;
		int    price;
		int    pages;
		BookA(String title, String author, int price, int pages) {
			this.title = title; this.author = author;
			this.price = price; this.pages = pages;
		}
		@Override
		public String toString() {
			return title + "(" + author + "," + price + "원," + pages + "p)";
		}
	}

	public static void main(String[] args) {

		// Q1. 중복 제거 후 내림차순
		List<Integer> nums = Arrays.asList(3, 1, 5, 3, 7, 1, 9, 5, 7);
		List<Integer> q1 = nums.stream()
				.distinct()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("Q1. 중복제거+내림차순 : " + q1);

		// Q2. 중복 제거 후 길이→알파벳 정렬
		List<String> words = Arrays.asList("hello","ant","a","hi","ant","world","cat","an","a","hello");
		List<String> q2 = words.stream()
				.distinct()
				.sorted(Comparator
						.comparingInt(String::length)
						.thenComparing(Comparator.naturalOrder()))
				.collect(Collectors.toList());
		System.out.println("Q2. 길이→알파벳    : " + q2);

		// Q3. 가격 오름차순 + 제목 추출
		List<BookA> books = Arrays.asList(
				new BookA("자바의 정석", "남궁성", 30000, 1100),
				new BookA("이펙티브 자바", "조슈아",  35000,  500),
				new BookA("모던 자바 인 액션", "라울",  32000, 600),
				new BookA("토비의 스프링", "이일민",  45000, 1200)
		);
		List<String> q3 = books.stream()
				.sorted(Comparator.comparingInt(b -> b.price))
				.map(b -> b.title)
				.collect(Collectors.toList());
		System.out.println("Q3. 가격순 제목    : " + q3);

		// Q4. 페이지 내림차순 → 가격 오름차순 → 상위 2권 제목
		List<String> q4 = books.stream()
				.sorted(Comparator
						.comparingInt((BookA b) -> b.pages).reversed()
						.thenComparingInt(b -> b.price))
				.limit(2)
				.map(b -> b.title)
				.collect(Collectors.toList());
		System.out.println("Q4. 페이지↓가격↑ 상위2 : " + q4);

		// Q5. 저자 중복 제거 후 가나다순
		List<String> q5 = books.stream()
				.map(b -> b.author)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Q5. 저자 가나다순  : " + q5);
	}
}
