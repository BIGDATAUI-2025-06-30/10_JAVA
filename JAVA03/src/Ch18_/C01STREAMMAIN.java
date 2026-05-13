package Ch18_;

/* ----------------------------------------------------------
   1. Stream 종합 맛보기 - filter / map / sorted + 메서드 참조
   ----------------------------------------------------------
   설명 : 가장 자주 쓰는 중간 연산 3종(filter/map/sorted) 과
          람다 / 메서드 참조 / 생성자 참조 활용을 한 번에 본다.
   비유 : 수도관에 필터(filter), 변환기(map), 정렬기(sorted) 를 끼우고
          마지막에 컬렉터(collect) 로 받는 흐름.
   ---------------------------------------------------------- */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// ─────────────────────────────────────────────────────
// Person : 스트림 예제용 데이터 클래스 (이름 / 나이)
// ─────────────────────────────────────────────────────
class Person {
	protected String  name;
	protected Integer age;

	public Person() {}
	public Person(String name, Integer age) {
		this.name = name;
		this.age  = age;
	}

	public String  getName()              { return name; }
	public void    setName(String name)   { this.name = name; }
	public Integer getAge()               { return age; }
	public void    setAge(Integer age)    { this.age = age; }

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

// ─────────────────────────────────────────────────────
// Employee : Person 을 받아 변환하는 예제 (생성자 참조 데모용)
//  - 부서/직책은 임시로 기본값 부여
// ─────────────────────────────────────────────────────
class Employee extends Person {
	private String department;
	private String role;

	public Employee() {}

	// Person → Employee 변환용 생성자 (map(Employee::new) 에서 사용)
	public Employee(Person person) {
		super(person.getName(), person.getAge());
		this.department = "미배정";
		this.role       = "신입";
	}

	public String getDepartment()              { return department; }
	public void   setDepartment(String value)  { this.department = value; }
	public String getRole()                    { return role; }
	public void   setRole(String value)        { this.role = value; }

	@Override
	public String toString() {
		return "Employee [department=" + department + ", role=" + role
				+ ", name=" + name + ", age=" + age + "]";
	}
}

public class C01STREAMMAIN {

	public static void main(String[] args) {

		// ====================================================
		// (1) filter - 조건에 맞는 요소만 통과
		// ====================================================
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println("(1) 원본 : " + list);

		List<Integer> evens = list.stream()
				.filter(n -> n % 2 == 0)
				.collect(Collectors.toList());
		System.out.println("(1) 짝수만 : " + evens);

		// ====================================================
		// (2) filter + map - 홀수만 골라 제곱
		// ====================================================
		List<Integer> oddSquares = list.stream()
				.filter(n -> n % 2 == 1)
				.map(n -> n * n)
				.collect(Collectors.toList());
		System.out.println("(2) 홀수의 제곱 : " + oddSquares);

		// ====================================================
		// (3) sorted - 객체 정렬 (나이 내림차순)
		// ====================================================
		List<Person> persons = Arrays.asList(
				new Person("홍길동",   45),
				new Person("김범수",   35),
				new Person("유재석",   53),
				new Person("서장훈",   65),
				new Person("남궁민",   27)
		);

		System.out.println("(3) 나이 내림차순 :");
		persons.stream()
				.sorted((a, b) -> b.getAge() - a.getAge())
				.forEach(System.out::println);

		// ====================================================
		// (4) map + 메서드 참조 - Person → 나이 (Integer) 만 추출
		// ====================================================
		List<Integer> ages = persons.stream()
				.map(Person::getAge)
				.collect(Collectors.toList());
		System.out.println("(4) 나이 추출 : " + ages);

		// ====================================================
		// (5) map 체이닝 - 이름 추출 후 길이로 변환
		//     Person::getName  → 이름(String)
		//     String::length   → 길이(Integer)
		// ====================================================
		List<Integer> nameLengths = persons.stream()
				.map(Person::getName)
				.map(String::length)
				.collect(Collectors.toList());
		System.out.println("(5) 이름 길이 : " + nameLengths);

		// ====================================================
		// (6) 생성자 참조 - Person → Employee 변환
		//     람다 형태 : el -> new Employee(el)
		//     생성자참조 : Employee::new
		// ====================================================
		List<Employee> employees = persons.stream()
				.map(Employee::new)
				.collect(Collectors.toList());
		System.out.println("(6) Employee 변환 :");
		employees.forEach(System.out::println);
	}
}
