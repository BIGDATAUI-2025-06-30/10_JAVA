package Ch16.C01생성패턴;

/* ----------------------------------------------------------
   4. 팩토리 메서드 패턴 (Factory Method)
   ----------------------------------------------------------
   설명 : 객체 생성 책임을 서브클래스(공장)에 위임하는 패턴
   비유 : 동물 공장 (개공장 → 개, 고양이공장 → 고양이)
   용도 : 조건/타입에 따라 다른 객체를 만들어야 할 때
          - DB 드라이버 선택 (MySQL / Oracle)
          - 파일 파서 (XML / JSON / CSV)
          - OS별 UI 컴포넌트
   ---------------------------------------------------------- */

abstract class Animal {
    public abstract void sound();
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("야옹");
    }
}

//팩토리 Interface,상속관계의 모든 Factoray객체를 받음 
interface AnimalFactory 
{
    Animal createAnimal();	//추상메서드
}

class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

class CatFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}



public class C04팩토리메서드패턴 {
    public static void main(String[] args) {
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();
        dog.sound(); // 멍멍

        AnimalFactory catFactory = new CatFactory();
        Animal cat = catFactory.createAnimal();
        cat.sound(); // 야옹
    }
}


