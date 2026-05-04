package Ch16.C02구조패턴;

/* ----------------------------------------------------------
   2. 데코레이터 패턴 (Decorator)
   ----------------------------------------------------------
   설명 : 기존 객체를 감싸서 기능을 동적으로 추가하는 패턴
   비유 : 기본 커피 → 우유 추가 → 시럽 추가 (감싸기)
   용도 : 상속 없이 기능 확장, 옵션 조합이 다양할 때
          - 입출력 스트림(BufferedReader 등)
          - UI 위젯에 테두리/스크롤 추가
   ---------------------------------------------------------- */

// 공통 인터페이스
interface Coffee {
    String desc();
    int cost();
}

// 기본 커피
class BasicCoffee implements Coffee {
    public String desc() { return "커피"; }
    public int cost()    { return 3000; }
}

// 데코레이터: 우유 추가
class MilkDecorator implements Coffee {
    private Coffee coffee;
    public MilkDecorator(Coffee coffee) { this.coffee = coffee; }

    public String desc() { return coffee.desc() + " + 우유"; }
    public int cost()    { return coffee.cost() + 500; }
}

// 데코레이터: 시럽 추가
class SyrupDecorator implements Coffee {
    private Coffee coffee;
    public SyrupDecorator(Coffee coffee) { this.coffee = coffee; }

    public String desc() { return coffee.desc() + " + 시럽"; }
    public int cost()    { return coffee.cost() + 700; }
}

public class C02데코레이터패턴 {
    public static void main(String[] args) {
        // 기본 커피
        Coffee c1 = new BasicCoffee();
        System.out.println(c1.desc() + " : " + c1.cost() + "원");

        // 커피 + 우유
        Coffee c2 = new MilkDecorator(new BasicCoffee());
        System.out.println(c2.desc() + " : " + c2.cost() + "원");

        // 커피 + 우유 + 시럽 (계속 감싸기 가능)
        Coffee c3 = new SyrupDecorator(new MilkDecorator(new BasicCoffee()));
        System.out.println(c3.desc() + " : " + c3.cost() + "원");
    }
}
