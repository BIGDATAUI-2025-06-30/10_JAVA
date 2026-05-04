package Ch16.C01생성패턴;

/* ----------------------------------------------------------
   3. 프로토타입 패턴 (Prototype)
   ----------------------------------------------------------
   설명 : 기존 객체를 복제(clone)해서 새 객체를 생성하는 패턴
   비유 : 문서 복사 (원본 두고 사본 만들기)
   용도 : 생성 비용이 큰 객체, 비슷한 객체를 다량 만들 때
          → Java의 Cloneable + clone() 메서드 사용
   ---------------------------------------------------------- */

class Computer implements Cloneable {
    String cpu;

    public Computer(String cpu) { this.cpu = cpu; }

    @Override
    protected Computer clone() throws CloneNotSupportedException {
        return (Computer) super.clone();
    }
}

public class C03프로토타입패턴 {
	public static void main(String[] args) throws CloneNotSupportedException {
		// 1. 원본 객체 생성
		Computer original = new Computer("Intel i7");

		// 2. clone()으로 복제 (new 사용 X)
		Computer copy = original.clone();
		copy.cpu = "AMD Ryzen";   // 복사본만 변경

		// 3. 원본은 그대로, 복사본만 바뀜 → 서로 독립된 객체
		System.out.println("원본 CPU: " + original.cpu);   // Intel i7
		System.out.println("복사 CPU: " + copy.cpu);       // AMD Ryzen
	}
}
