package Ch18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person
{
	private String name;
	private Integer age;
	//디폴트 생성자
	public Person() {}
	//모든인자 생성자
	//getter and setter
	//toString
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	
}

public class C01Map {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
		//filter
		List<Integer> list2 = list.stream()
							.filter((n)->{return n%2==0;})
							.collect(Collectors.toList());
		System.out.println(list2);
		
		//map
		List<Integer> list3 =
		list.stream()
			.filter((n)->{return n%2==1;})
			.map((n)->{return n*n;})
			.collect(Collectors.toList());
		System.out.println(list3);
		
		//sorted
		List<Person> list4 = Arrays.asList(
					new Person("홍길동",45),
					new Person("김범수",35),
					new Person("유재석",53),
					new Person("서장훈",65),
					new Person("남길동",27)
				);
		
//		System.out.println(list4);
		//나이순으로 내림차순정렬해서 출력 .sorted((a,b)->{return b-a;})//내림차순 - 배열새롭게 구성
		
		List<Person> list5 = 
		list4.stream()
			.sorted((a,b)->{return b.getAge()-a.getAge();})
			.collect(Collectors.toList());
		
		list5.forEach(System.out::println);
		
		//
		
		List<Integer> list6 = 
		list4.stream()
//			 .map((el)->{return el.getAge();})
//			 .map(el->el.getAge())
			 .map(Person::getAge)
			 .collect(Collectors.toList());
		System.out.println(list6);
		
		
	}

}
