package Ch18_;

/* ----------------------------------------------------------
   4-Ex. [학생용 문제] distinct / sorted 조합
   ----------------------------------------------------------
   학습 단계 : C02FlatMap / C03Distinct / C04Sorted 학습 직후
   정답 참고 : C04ExSortedAns.java
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;

public class C04ExSorted {

	// 연습용 책 클래스 (제목 / 저자 / 가격 / 페이지)
	static class Book {
		String title;
		String author;
		int    price;
		int    pages;
		Book(String title, String author, int price, int pages) {
			this.title = title; this.author = author;
			this.price = price; this.pages = pages;
		}
		@Override
		public String toString() {
			return title + "(" + author + "," + price + "원," + pages + "p)";
		}
	}

	public static void main(String[] args) {

		// ====================================================
		// Q1. 정수 리스트에서 중복 제거 후 내림차순 정렬해서 출력
		//     기대 : [9, 7, 5, 3, 1]
		// ====================================================
		List<Integer> nums = Arrays.asList(3, 1, 5, 3, 7, 1, 9, 5, 7);
		// TODO 답안 작성

		// ====================================================
		// Q2. 단어 중복 제거 후 "길이 짧은 순 → 같으면 알파벳 순" 정렬해서 출력
		//     기대 : [a, an, hi, ant, cat, hello, world]
		// ====================================================
		List<String> words = Arrays.asList("hello","ant","a","hi","ant","world","cat","an","a","hello");
		// TODO 답안 작성

		// ====================================================
		// Q3. 책 리스트에서 "가격 오름차순" 정렬한 뒤 제목만 추출해 출력
		// ====================================================
		List<Book> books = Arrays.asList(
				new Book("자바의 정석", "남궁성", 30000, 1100),
				new Book("이펙티브 자바", "조슈아",  35000,  500),
				new Book("모던 자바 인 액션", "라울",  32000, 600),
				new Book("토비의 스프링", "이일민",  45000, 1200)
		);
		// TODO 답안 작성

		// ====================================================
		// Q4. "페이지 내림차순" → 같으면 "가격 오름차순" → 상위 2권의 제목 출력
		// ====================================================
		// TODO 답안 작성

		// ====================================================
		// Q5. 저자 목록 중복 제거 후 가나다순으로 정렬해서 출력
		// ====================================================
		// TODO 답안 작성
	}
}
