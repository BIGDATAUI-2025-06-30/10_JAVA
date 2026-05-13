package Ch19;

/* ----------------------------------------------------------
   4. [학생용 문제] Function + Stream 으로 List 가공
   ----------------------------------------------------------
   문제 :
     - func1 : List<String>  에서 길이가 5 이상인 문자열의 개수 반환
     - func2 : List<Integer> 의 각 숫자를 제곱해서 누적합 반환
     - func3 : List<String>  의 각 문자열의 "첫 글자만" 대문자로 추출한 리스트 반환

   풀이 :   각 Function 변수에 람다 작성
            (정답은 C04ExAns.java)
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class C04Ex {

	// TODO func1 람다 작성  (List<String> → Integer)
	public static Function<List<String>, Integer> func1 = null;

	// TODO func2 람다 작성  (List<Integer> → Integer)
	public static Function<List<Integer>, Integer> func2 = null;

	// TODO func3 람다 작성  (List<String> → List<String>)
	public static Function<List<String>, List<String>> func3 = null;

	public static void main(String[] args) {
		List<String>  words = Arrays.asList("apple", "hi", "banana", "cat", "elephant");
		List<Integer> nums  = Arrays.asList(1, 2, 3, 4, 5);
		List<String>  names = Arrays.asList("kim", "park", "lee", "choi");

		System.out.println("(1) 길이 5 이상 개수 : "
				+ (func1 == null ? "TODO" : func1.apply(words)));
		System.out.println("(2) 제곱 합          : "
				+ (func2 == null ? "TODO" : func2.apply(nums)));
		System.out.println("(3) 첫 글자 대문자   : "
				+ (func3 == null ? "TODO" : func3.apply(names)));
	}
}
