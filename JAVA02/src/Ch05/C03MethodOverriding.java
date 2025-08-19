package Ch05;

// 함수재정의(Method Overriding)
// 상속관계를 전제로 상위클래스의 메서드를 하위클래스가 재정의(고쳐사용)하는것을 허용한 문법
// 메서드의 헤더부분은 동일하고 두고 본체({})의 로직을 수정하게끔 허용함으로 다양한 형태의 객체가
// 형성될 수 있도록 유도(다형성)
// 상위클래스로 부터 동일한 메서드를 물려받더라도 각 하위클래스마다 다른기능구현의 결과물을 만들어
// 낼 수 있다

// 오버로딩 vs 오버라이딩
// 오버로딩?
// 상속전제 x
// 함수헤더변경(함수이름중복허용,파라미터는 다양하게 허용)
// 개발자의 편의성에 중점(함수 이름 단일화)

// 오버라이딩?
// 상속전제 o
// 함수본문변경(헤더 고정)
// 다형성을 목적으로 한 문법요소

class Animal{
	void Sound() {System.out.println("소리낸다...");}
}

class Dog extends Animal{
	void Sound() {System.out.println("멍멍!");}
}
class Cat extends Animal{

	@Override
	void Sound() {
		System.out.println("야옹!");
	}
	
}

public class C03MethodOverriding {
	
	public static void main(String[] args) {
		Animal animal = new Animal();
//		animal.Sound();
		
		Dog dog = new Dog();
		dog.Sound();
		
		Cat cat = new Cat();
		cat.Sound();
		
		System.out.println("---------------");
		animal = dog;	//상위클래스형 참조변수 = 하위객체
		animal.Sound();
		animal = cat;
		animal.Sound();
		
		
		
	}
}







