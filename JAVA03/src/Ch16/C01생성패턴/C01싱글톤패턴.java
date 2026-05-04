package Ch16.C01생성패턴;

/* ----------------------------------------------------------
   1. 싱글톤 패턴 (Singleton)
   ----------------------------------------------------------
   설명 : 클래스의 인스턴스를 단 1개만 만들어 공유하는 패턴
   비유 : 회사의 사장 (조직에 단 한 명만 존재)
   용도 : 설정(Config), 로거(Logger), DB 커넥션 풀, 캐시 등
          → 어디서 호출해도 같은 객체를 써야 할 때
   ---------------------------------------------------------- */

class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private 생성자
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
public class C01싱글톤패턴 {
	public static void main(String[] args) {
		// getInstance()를 두 번 호출해도 같은 객체가 반환됨
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println("s1 == s2 ? " + (s1 == s2));         // true
		System.out.println("s1 hashCode: " + s1.hashCode());
		System.out.println("s2 hashCode: " + s2.hashCode());     // 동일한 값
	}
}
