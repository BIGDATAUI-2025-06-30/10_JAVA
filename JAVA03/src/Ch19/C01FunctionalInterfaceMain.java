package Ch19;

/* ----------------------------------------------------------
   1. 커스텀 함수형 인터페이스 (Custom Functional Interface)
   ----------------------------------------------------------
   설명 : 추상 메서드가 정확히 1개인 인터페이스를 직접 만들어,
          람다식의 "타입 자리" 로 활용한다.
          @FunctionalInterface 어노테이션을 붙이면 추상메서드가
          2개 이상이 되는 순간 컴파일러가 잡아준다.
   비유 : 표준 함수형 인터페이스(Ch19 C05)가 편의점 도시락이라면,
          커스텀 함수형 인터페이스는 직접 도시락통을 깎아 만드는 것.
   용도 : - 람다식이 어떤 타입의 변수에 담길지 정의
          - 표준 인터페이스로 표현하기 애매한 시그니처 (가변인자 등)
          - 도메인 의미를 살린 인터페이스 이름 부여
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// (1) 인자O / 반환X - 표준 Consumer<String> 과 모양 같음
@FunctionalInterface
interface Func1 {
	void say(String message);
}

// (2) 가변인자 Integer... 받아 int 반환 - 표준 인터페이스로는 표현 까다로움
@FunctionalInterface
interface Func2 {
	int sum(Integer ...args);
}

// (3) 가변인자 Object... 받아 List<Integer> 반환 - 마찬가지로 커스텀이 더 깔끔
@FunctionalInterface
interface Func3 {
	List<Integer> sum(Object ...args);
}

public class C01FunctionalInterfaceMain {

	public static void main(String[] args) {

		// ----------------------------------------------------
		// (1) Func1 - 람다와 메서드 참조 두 가지 형태
		// ----------------------------------------------------
		Func1 func1 = (message) -> System.out.println(message + "_!");
		func1.say("HELLO WORLD");

		Func1 func1_2 = System.out::println;   // 메서드 참조 형태
		func1_2.say("HELLO WORLD");

		// ----------------------------------------------------
		// (2) Func2 - 가변인자 Integer... 의 단순 합산
		// ----------------------------------------------------
		Func2 func2 = (arr) -> {
			int sum = 0;
			for (Integer n : arr) sum += n;
			return sum;
		};
		System.out.println("(2) 합 = " + func2.sum(10, 20, 30, 40, 50, 60));

		// ----------------------------------------------------
		// (3) Func3 - 가변인자 Object... 에서 Integer 만 추려 List 반환
		//     Stream + filter(instanceof) + map(캐스팅) + collect(toList)
		// ----------------------------------------------------
		Func3 func3 = (arr) -> Arrays.stream(arr)
				.filter(obj -> obj instanceof Integer)
				.map(obj -> (Integer) obj)
				.collect(Collectors.toList());
		System.out.println("(3) Integer 만 = " + func3.sum(10, 20, 30.5, "홍길동", true));
	}
}
