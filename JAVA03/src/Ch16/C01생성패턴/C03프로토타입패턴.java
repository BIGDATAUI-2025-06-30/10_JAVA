package Ch16.C01생성패턴;

/*
 
3. 프로토타입 패턴 (Prototype Pattern)
복제(clone) 를 통해 객체를 생성하는 패턴.
new 대신 기존 객체를 복사해서 성능이나 메모리 효율을 높임.
Java의 Cloneable 인터페이스와 clone() 메서드가 대표적


 */
class Computer implements Cloneable {
    String cpu;

    public Computer(String cpu) { this.cpu = cpu; }

    @Override
    protected Computer clone() throws CloneNotSupportedException {
        return (Computer) super.clone();
    }
}

public class C03프로토타입패턴 {
	public static void main(String[] args) {
		
		
	}
}
