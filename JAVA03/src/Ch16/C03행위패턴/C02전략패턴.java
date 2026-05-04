package Ch16.C03행위패턴;

/* ----------------------------------------------------------
   2. 전략 패턴 (Strategy)
   ----------------------------------------------------------
   설명 : 알고리즘을 캡슐화해서 실행 시점에 자유롭게 교체
   비유 : 결제 방식 선택 (카드 / 현금 / 카카오페이)
   용도 : - 같은 작업을 여러 방식으로 처리해야 할 때
          - if-else 분기로 알고리즘 선택하던 코드 정리
          - 정렬, 압축, 인증 방식 등 동적 교체
   ---------------------------------------------------------- */

interface Strategy {
    int execute(int num1, int num2);
}

class AddStrategy implements Strategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 + num2;
    }
}
class SubtractStrategy implements Strategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 - num2;
    }
}

class MultiplyStrategy implements Strategy {
    @Override
    public int execute(int num1, int num2) {
        return num1 * num2;
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.execute(num1, num2);
    }
}

public class C02전략패턴 {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        int result = context.executeStrategy(10, 5);
        System.out.println("Addition: " + result);

        context = new Context(new SubtractStrategy());
        result = context.executeStrategy(10, 5);
        System.out.println("Subtraction: " + result);

        context = new Context(new MultiplyStrategy());
        result = context.executeStrategy(10, 5);
        System.out.println("Multiplication: " + result);
    }
}

