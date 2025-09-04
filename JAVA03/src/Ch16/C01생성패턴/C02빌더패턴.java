package Ch16.C01생성패턴;


class Car {
    // 필수 속성
    private final String engine;
    private final int wheels;

    // 선택 속성
    private final boolean sunroof;
    private final String color;

    // private 생성자 (Builder를 통해서만 객체 생성 가능)
    private Car(Builder builder) {
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.sunroof = builder.sunroof;
        this.color = builder.color;
    }

    // Getter 메소드
    public String getEngine() { return engine; }
    public int getWheels() { return wheels; }
    public boolean hasSunroof() { return sunroof; }
    public String getColor() { return color; }

    // 정적 내부 클래스 Builder
    public static class Builder {
        // 필수 속성
        private final String engine;
        private final int wheels;

        // 선택 속성 (기본값 설정 가능)
        private boolean sunroof = false;
        private String color = "white";

        // 생성자 (필수 속성)
        public Builder(String engine, int wheels) {
            this.engine = engine;
            this.wheels = wheels;
        }

        // 선택 속성 설정 메소드 (체이닝 방식)
        public Builder sunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        // build() 메소드로 최종 객체 생성
        public Car build() {
            return new Car(this);
        }
    }

    // 출력용 toString()
    @Override
    public String toString() {
        return "Car { " +
                "engine='" + engine + '\'' +
                ", wheels=" + wheels +
                ", sunroof=" + sunroof +
                ", color='" + color + '\'' +
                " }";
    }
    
}
public class C02빌더패턴 {
	public static void main(String[] args) {
        Car car1 = new Car.Builder("V6", 4)
                .color("red")
                .sunroof(true)
                .build();

        Car car2 = new Car.Builder("V8", 4)
                .build();

        System.out.println(car1);
        System.out.println(car2);	
	}
}
