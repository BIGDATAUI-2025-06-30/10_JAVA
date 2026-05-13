package Ch17;

/* ----------------------------------------------------------
   1. 람다식 기본 (Lambda Expression)
   ----------------------------------------------------------
   설명 : 익명 함수를 간결하게 표현하는 문법 ( (인자) -> { 처리 } )
   비유 : 일회용 함수 - 이름 없이 즉석에서 정의해서 그 자리에서 사용
   용도 : - Collection / Stream 의 forEach 반복
          - List 정렬 시 Comparator 대체
          - 익명 클래스 코드를 짧게 줄일 때
   ---------------------------------------------------------- */

import java.util.ArrayList;
import java.util.List;

// 1. Person 데이터 클래스 (이름 / 나이 / 주소)
class Person {
	private String name;
	private int age;
	private String addr;

	public Person() {}

	public Person(String name, int age, String addr) {
		this.name = name;
		this.age  = age;
		this.addr = addr;
	}

	public String getName()              { return name; }
	public void   setName(String name)   { this.name = name; }
	public int    getAge()               { return age; }
	public void   setAge(int age)        { this.age = age; }
	public String getAddr()              { return addr; }
	public void   setAddr(String addr)   { this.addr = addr; }

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}

public class C01Lamda {

	public static void main(String[] args) {

		// 2. 리스트 생성 및 데이터 추가
		List<Person> list = new ArrayList<>();
		list.add(new Person("홍길동", 55, "대구"));
		list.add(new Person("티모",   100, "안드로메다"));
		list.add(new Person("김범수", 45, "서울"));

		// 3. 람다식 + forEach 로 전체 출력
		System.out.println("[정렬 전]");
		list.stream().forEach(item -> System.out.println(item));

		// 4. 람다식 Comparator 로 나이 내림차순 정렬
		list.sort((a, b) -> b.getAge() - a.getAge());

		System.out.println("[나이 내림차순 정렬 후]");
		list.stream().forEach(item -> System.out.println(item));
	}
}
