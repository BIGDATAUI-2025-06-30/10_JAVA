package Ch17;

/* ----------------------------------------------------------
   6. 클로저 응용 - 박스 메타포 + 값 변경 트릭
   ----------------------------------------------------------
   설명 : C05 에서는 람다가 박제한 값을 "읽기만" 했지만,
          실제로는 람다 안의 값을 바꿔가며 들고 다니는 패턴도 자주 필요.
   비유 : 람다 = 박스. 박스에 단순 값을 넣어두면 못 바꾸지만(C05),
          박스에 "주머니(배열)" 를 넣어두면 주머니 안의 값은 바꿀 수 있다.
   포인트 : 1) 배열 / AtomicInteger 등 가변 객체를 캡처하면 안의 값 변경 가능
            2) 인스턴스 / static 필드는 effectively final 규칙과 무관
            3) 박스(=람다)마다 자기만의 주머니를 들고 다님 → 서로 완전 독립
   이전 단원 : C05ClosureBasic - 단순 인사 클로저
   ---------------------------------------------------------- */

// 박스를 열어 안의 값 꺼내기 (읽기 전용 클로저)
interface ClosureBox {
	String open();
}

// 호출할 때마다 자기 안의 숫자를 1 증가시켜 반환 (가변 클로저)
interface TickBox {
	int tick();
}

// 인자X / 반환X - 단순 실행 작업 (필드 트릭 데모용)
interface Task {
	void run();
}

public class C06ClosureMutable {

	private int instanceCount = 0;
	private static int staticCount = 0;
	// 박스 공장 1 : item 박제해서 박스 반환 (읽기 전용)
	private static ClosureBox makeBox(String item) {
		return () -> "박스 안 : " + item;
	}

	// 박스 공장 2 : start 부터 카운트하는 박스 반환 (가변)
	private static TickBox makeTicker(int start) {
		int[] count = { start };          // 람다가 캡처해서 들고 다닐 "주머니"
		return () -> count[0]++;          // 현재값 반환 후 +1
	}
	public static void main(String[] args) {

		// ====================================================
		// (1) 박스 메타포 - 값을 박제한 람다 박스
		//     ─────────────────────────────────────────────
		//     C05 의 makeGreeter 와 같은 원리, 다른 비유.
		//     - 박스마다 자기 안에 다른 값을 박제하고 있음
		//     - 같은 람다 코드인데 결과가 다른 이유 = 박스 안 값이 다르기 때문
		// ====================================================
		ClosureBox box1 = makeBox("사과");
		ClosureBox box2 = makeBox("바나나");
		ClosureBox box3 = makeBox("포도");

		System.out.println("(1) box1.open() = " + box1.open());   // 박스 안 : 사과
		System.out.println("(1) box2.open() = " + box2.open());   // 박스 안 : 바나나
		System.out.println("(1) box3.open() = " + box3.open());   // 박스 안 : 포도

		// ====================================================
		// (2) 배열 트릭 - 람다 안에서 값을 바꾸는 우회법
		//     ─────────────────────────────────────────────
		//     int count = 0; () -> count++;   // ← 컴파일 에러
		//
		//     해결 : 배열로 감싼다
		//       - 배열 참조(counter) 는 final 이지만
		//       - 배열 안의 값(counter[0]) 은 바꿀 수 있다
		// ====================================================
		int[] counter = { 0 };
		Task incr = () -> counter[0]++;
		incr.run(); incr.run(); incr.run();
		System.out.println("(2) 배열 트릭 카운터 : " + counter[0]);   // 3

		// ====================================================
		// (3) 인스턴스 / static 필드는 자유롭게 수정 가능
		//     effectively final 규칙은 "지역변수" 에만 적용됨
		// ====================================================
		C06ClosureMutable obj = new C06ClosureMutable();
		Task fieldIncr = () -> {
			obj.instanceCount++;   // 인스턴스 필드 OK
			staticCount++;         // static 필드 OK
		};
		fieldIncr.run(); fieldIncr.run();
		System.out.println("(3) 인스턴스 : " + obj.instanceCount
				+ " / static : " + staticCount);

		// ====================================================
		// (4) ★ 가변 클로저 - "자기만의 카운트를 들고 다니는 람다"
		//     ─────────────────────────────────────────────
		//     makeTicker(10) 호출 시 :
		//       - int[] count = { 10 } 배열이 만들어짐
		//       - 람다는 이 배열을 자기 hidden field 로 들고 다님
		//       - tick() 마다 자기 배열의 0번 값을 1 증가
		//
		//     ★ 박스 2개 만들면 배열도 2개 → 서로 완전히 독립
		// ====================================================
		TickBox a = makeTicker(10);     // a 의 주머니 = 10 부터 시작
		TickBox b = makeTicker(100);    // b 의 주머니 = 100 부터 시작

		System.out.println("(4) a.tick() = " + a.tick());   // 10
		System.out.println("(4) a.tick() = " + a.tick());   // 11
		System.out.println("(4) a.tick() = " + a.tick());   // 12
		System.out.println("(4) ----- b 를 호출해도 a 는 영향 없음 -----");
		System.out.println("(4) b.tick() = " + b.tick());   // 100
		System.out.println("(4) b.tick() = " + b.tick());   // 101
		System.out.println("(4) a.tick() = " + a.tick());   // 13  (a 는 자기 흐름 유지)
		// ★ 박스마다 자기 카운트를 따로 기록함 = 가변 클로저
	}


}
