package Ch17;

/* ----------------------------------------------------------
   5. 람다 클로저 (Closure) + effectively final
   ----------------------------------------------------------
   설명 : 람다는 자기 바깥(메서드)의 지역변수를 "캡처" 해서 사용 가능.
          단, 그 지역변수는 사실상 변하지 않아야 함 (effectively final).
   비유 : 람다는 외부 변수 값을 사진 찍어 가져감 - 원본이 바뀌면 헷갈리니
          "한 번 정한 값은 바꾸지 마" 라고 강제하는 규칙.
   용도 : - 람다 안에서 외부 변수 활용
          - 왜 컴파일러가 "must be final or effectively final" 에러를
            내는지 이해
          - 지역변수 vs 인스턴스(static) 필드의 차이
   ---------------------------------------------------------- */

import java.util.function.Supplier;

public class C05ClosureMain {

	// 인스턴스 필드 → 람다에서 자유롭게 읽기/쓰기 가능
	private int instanceCount = 0;

	// 정적 필드 → 람다에서 자유롭게 읽기/쓰기 가능
	private static int staticCount = 0;

	public static void main(String[] args) {

		// ----------------------------------------------------
		// (1) 람다는 외부 지역변수를 "캡처" 해서 사용 가능
		// ----------------------------------------------------
		String greeting = "안녕";  // 한 번 정해진 뒤 바뀌지 않음 → effectively final
		Runnable r1 = () -> System.out.println("(1) 외부 변수 캡처 : " + greeting);
		r1.run();

		// ----------------------------------------------------
		// (2) effectively final 규칙
		//     - 캡처한 변수를 람다 바깥에서 재할당하면 컴파일 에러
		//     - 아래 주석을 풀면 컴파일이 안 됨
		// ----------------------------------------------------
		int number = 10;
		Runnable r2 = () -> System.out.println("(2) number = " + number);
		// number = 20; // ← 활성화하면 위 람다에서 "must be final or effectively final" 에러
		r2.run();

		// ----------------------------------------------------
		// (3) 그래서 지역변수 카운터는 람다 안에서 직접 증가시킬 수 없음
		//     아래는 모두 컴파일 에러:
		//        int count = 0;
		//        Runnable bad = () -> count++;  // ← 컴파일 에러
		//
		//     해결 1) 배열이나 AtomicInteger 같은 "참조형" 사용
		//     해결 2) 인스턴스 / static 필드 사용
		// ----------------------------------------------------
		int[] counter = { 0 }; // 배열 자체는 final, 안의 값은 변경 가능
		Runnable r3 = () -> counter[0]++;
		r3.run(); r3.run(); r3.run();
		System.out.println("(3) 배열 트릭으로 카운터 증가 : " + counter[0]);

		// ----------------------------------------------------
		// (4) 인스턴스 / static 필드는 자유롭게 수정 가능
		// ----------------------------------------------------
		C05ClosureMain obj = new C05ClosureMain();
		Runnable r4 = () -> {
			obj.instanceCount++;  // 인스턴스 필드 OK
			staticCount++;        // static 필드 OK
		};
		r4.run(); r4.run();
		System.out.println("(4) 인스턴스 필드 : " + obj.instanceCount
				+ " / static 필드 : " + staticCount);

		// ----------------------------------------------------
		// (5) 클로저 활용 - 외부 값 기반 람다 "공장" 만들기
		//     prefix 라는 외부 값을 캡처해서 그 값에 특화된 람다를 반환
		// ----------------------------------------------------
		Supplier<String> hello = makeGreeter("HELLO");
		Supplier<String> hi    = makeGreeter("HI");
		System.out.println("(5) " + hello.get());
		System.out.println("(5) " + hi.get());
	}

	// prefix 를 캡처해서 인사 람다를 생성해 돌려줌 (= 클로저)
	private static Supplier<String> makeGreeter(String prefix) {
		return () -> prefix + ", WORLD!";
	}
}
