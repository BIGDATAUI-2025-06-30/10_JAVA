package Ch16.C03행위패턴;

/* ----------------------------------------------------------
   3. 커맨드 패턴 (Command)
   ----------------------------------------------------------
   설명 : 요청(메서드 호출)을 객체로 만들어 전달/저장/실행
   비유 : TV 리모컨 버튼 (명령을 캡슐화해서 누름)
   용도 : - 작업 큐(Job Queue), 매크로 기능
          - 실행 취소(Undo) / 다시 실행(Redo)
          - 호출자(리모컨)와 실행자(TV) 분리
   ---------------------------------------------------------- */

// 1. 명령 인터페이스
interface Command {
    void execute();
}

// 2. 실제 동작을 수행하는 객체 (Receiver)
class TV {
    public void turnOn()  { System.out.println("TV가 켜졌습니다"); }
    public void turnOff() { System.out.println("TV가 꺼졌습니다"); }
}

// 3. 구체 명령 클래스들
class TurnOnCommand implements Command {
    private TV tv;
    public TurnOnCommand(TV tv) { this.tv = tv; }
    public void execute() { tv.turnOn(); }
}

class TurnOffCommand implements Command {
    private TV tv;
    public TurnOffCommand(TV tv) { this.tv = tv; }
    public void execute() { tv.turnOff(); }
}

// 4. 명령을 실행시키는 호출자 (Invoker)
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class C03커맨드패턴 {
    public static void main(String[] args) {
        TV tv = new TV();
        RemoteControl remote = new RemoteControl();

        // 켜기 버튼 누르기
        remote.setCommand(new TurnOnCommand(tv));
        remote.pressButton();

        // 끄기 버튼 누르기
        remote.setCommand(new TurnOffCommand(tv));
        remote.pressButton();
    }
}
