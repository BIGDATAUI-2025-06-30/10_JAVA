package Ch17;

/* ----------------------------------------------------------
   4. 메서드 참조 (Method Reference)
   ----------------------------------------------------------
   설명 : 람다식이 "기존 메서드를 그대로 호출"만 할 때
          ClassName::methodName 형태로 더 짧게 표현하는 문법
   비유 : 람다가 "이 일은 저 사람이 잘함" 하고 담당자만 가리키는 것
          (직접 일하는 코드를 쓰지 않고 메서드 이름만 가리킴)
   용도 : - 람다 본문이 메서드 1개만 호출 → 메서드 참조로 치환
          - 코드 길이를 더 줄여서 가독성 ↑
   참고 : 이 단원은 "람다 문법" 에 집중하기 위해
          java.util.function.* 표준 인터페이스를 쓰지 않고
          직접 만든 커스텀 함수형 인터페이스로만 실습한다.
          (표준 인터페이스는 Ch19 에서 다룸)
   ---------------------------------------------------------- */

import java.util.ArrayList;

// 1. 직접 만든 함수형 인터페이스들 (추상 메서드 1개)
//    - 람다/메서드 참조로 구현해서 사용

// (1) 문자열 → 정수 변환
interface StrToInt {
	int convert(String s);
}

// (2) 문자열을 받아 출력만 (반환 없음)
interface StrConsumer {
	void accept(String s);
}

// (3) 문자열 → 변형된 문자열 반환
interface StrToStr {
	String apply(String s);
}

// (4) 두 문자열 비교 → 정수 결과
interface StrCompare {
	int compare(String a, String b);
}

// (5) 인자 없이 ArrayList<String> 생성
interface ListFactory {
	ArrayList<String> create();
}

// ─────────────────────────────────────────────────────
// 오버로딩 생성자 참조 실습용
//  - C04Person 클래스는 생성자가 4개 (0/1/2/3 인자)
//  - 각 인자 개수별 팩토리 인터페이스를 만들어두면
//    같은 "C04Person::new" 표현이 시그니처에 맞춰 자동 매칭됨
// ─────────────────────────────────────────────────────
class C04Person {
	String name;
	int age;
	String addr;

	public C04Person() {
		this("이름없음", 0, "주소없음");
	}
	public C04Person(String name) {
		this(name, 0, "주소없음");
	}
	public C04Person(String name, int age) {
		this(name, age, "주소없음");
	}
	public C04Person(String name, int age, String addr) {
		this.name = name;
		this.age  = age;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "C04Person[" + name + ", " + age + ", " + addr + "]";
	}
}

// 인자 개수별 팩토리 인터페이스 (오버로딩 생성자 참조용)
interface PersonFactory0 { C04Person create(); }                                  // → C04Person()
interface PersonFactory1 { C04Person create(String name); }                        // → C04Person(String)
interface PersonFactory2 { C04Person create(String name, int age); }               // → C04Person(String,int)
interface PersonFactory3 { C04Person create(String name, int age, String addr); }  // → C04Person(String,int,String)

public class C04MethodReference {

	// 정적 메서드 참조 실습용
	public static int toLength(String s) {
		return s.length();
	}

	public static void main(String[] args) {

		// ----------------------------------------------------
		// (1) 정적(static) 메서드 참조  :  ClassName::staticMethod
		//     람다 형태       :  s -> Integer.parseInt(s)
		//     메서드 참조 형태 :  Integer::parseInt
		// ----------------------------------------------------
		StrToInt lambdaWay1 = s -> Integer.parseInt(s); // 람다
		StrToInt refWay1    = Integer::parseInt;        // 메서드 참조
		System.out.println("(1-1) 람다       : " + lambdaWay1.convert("123"));
		System.out.println("(1-2) 메서드 참조 : " + refWay1.convert("456"));

		// 같은 패턴 - 내가 만든 static 메서드도 참조 가능
		StrToInt refWay1_2 = C04MethodReference::toLength;
		System.out.println("(1-3) 내 static  : " + refWay1_2.convert("HELLO")); // 5

		// ----------------------------------------------------
		// (2) 특정 객체의 인스턴스 메서드 참조  :  instance::method
		//     람다 형태       :  msg -> System.out.println(msg)
		//     메서드 참조 형태 :  System.out::println
		//     - System.out 이라는 "특정 인스턴스" 에 바인딩됨
		// ----------------------------------------------------
		StrConsumer lambdaWay2 = msg -> System.out.println(msg);
		StrConsumer refWay2    = System.out::println;
		lambdaWay2.accept("(2-1) 람다 출력");
		refWay2.accept("(2-2) 메서드 참조 출력");

		// ----------------------------------------------------
		// (3) 임의 객체의 인스턴스 메서드 참조  :  ClassName::method
		//     람다 형태       :  str -> str.toUpperCase()
		//     메서드 참조 형태 :  String::toUpperCase
		//     - 첫 번째 인자(str) 가 자동으로 메서드 호출 대상이 됨
		// ----------------------------------------------------
		StrToStr lambdaWay3 = str -> str.toUpperCase();
		StrToStr refWay3    = String::toUpperCase;
		System.out.println("(3-1) 람다       : " + lambdaWay3.apply("hello"));
		System.out.println("(3-2) 메서드 참조 : " + refWay3.apply("world"));

		// 인자 2개도 가능 : (a, b) -> a.compareTo(b)  →  String::compareTo
		// → 첫 인자(a) 가 호출 대상, 두 번째 인자(b) 가 메서드 파라미터로 들어감
		StrCompare lambdaWay3b = (a, b) -> a.compareTo(b);
		StrCompare refWay3b    = String::compareTo;
		System.out.println("(3-3) 람다 비교    : " + lambdaWay3b.compare("apple", "banana"));
		System.out.println("(3-4) 참조 비교    : " + refWay3b.compare("apple", "banana"));

		// ----------------------------------------------------
		// (4) 생성자 참조  :  ClassName::new
		//     람다 형태       :  () -> new ArrayList<>()
		//     메서드 참조 형태 :  ArrayList::new
		// ----------------------------------------------------
		ListFactory lambdaWay4 = () -> new ArrayList<>();
		ListFactory refWay4    = ArrayList::new;

		ArrayList<String> list = refWay4.create();
		list.add("AAA");
		list.add("BBB");
		System.out.println("(4) 생성자 참조 결과 : " + list);

		// ----------------------------------------------------
		// (4-2) 오버로딩 생성자도 메서드 참조로 사용 가능
		//       ─────────────────────────────────────────
		//       C04Person 은 생성자 4개 (0 / 1 / 2 / 3 인자)
		//       모두 "C04Person::new" 라는 같은 표현을 쓰지만
		//       ★ 어느 생성자가 선택되는지는
		//         타겟 함수형 인터페이스의 추상 메서드 시그니처가 결정함
		// ----------------------------------------------------
		PersonFactory0 t10 = C04Person::new;   // create()                  → C04Person()
		PersonFactory1 t11 = C04Person::new;   // create(String)            → C04Person(String)
		PersonFactory2 t12 = C04Person::new;   // create(String,int)        → C04Person(String,int)
		PersonFactory3 t13 = C04Person::new;   // create(String,int,String) → C04Person(String,int,String)

		System.out.println("(4-2) t10 : " + t10.create());                       // 기본 (0-arg)
		System.out.println("(4-2) t11 : " + t11.create("홍길동"));                // 이름만
		System.out.println("(4-2) t12 : " + t12.create("티모", 100));             // 이름+나이
		System.out.println("(4-2) t13 : " + t13.create("김범수", 45, "서울"));     // 전체

		// 주의 :
		//  - 개발자가 "Person::new(String)" 처럼 어떤 생성자를 쓸지 명시할 수 없음
		//  - 후보 생성자가 2개 이상 동시에 시그니처와 맞으면 모호성(ambiguity) 컴파일 에러
		//  - 그럴 땐 람다로 풀어서 직접 캐스팅 :  () -> new C04Person((int) v)

		// ----------------------------------------------------
		// (5) 정리 - 람다 → 메서드 참조 변환 한눈에 보기
		//     ┌────────────────────────────┬────────────────────────┐
		//     │ 람다                        │ 메서드 참조            │
		//     ├────────────────────────────┼────────────────────────┤
		//     │ s -> Integer.parseInt(s)   │ Integer::parseInt       │
		//     │ msg -> System.out.println  │ System.out::println     │
		//     │ str -> str.toUpperCase()   │ String::toUpperCase     │
		//     │ (a,b) -> a.compareTo(b)    │ String::compareTo       │
		//     │ () -> new ArrayList<>()    │ ArrayList::new          │
		//     └────────────────────────────┴────────────────────────┘
		// ----------------------------------------------------
	}
}
