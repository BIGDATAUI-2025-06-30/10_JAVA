package Ch16.C01생성패턴;

/* ----------------------------------------------------------
   5. 추상 팩토리 패턴 (Abstract Factory)
   ----------------------------------------------------------
   설명 : 서로 관련된 객체 "묶음(세트)"를 한 번에 생성
   비유 : OS별 GUI 세트 (Windows 세트 / Mac 세트)
   용도 : 한 번 선택으로 일관된 객체군이 필요할 때
          - 팩토리메서드 = 객체 "1개" 만드는 공장
          - 추상팩토리   = 객체 "세트" 만드는 공장
   ---------------------------------------------------------- */

// ===== 제품군 1: 버튼 =====
interface Button {
    void click();
}
class WinButton implements Button {
    public void click() { System.out.println("[Windows] 버튼 클릭"); }
}
class MacButton implements Button {
    public void click() { System.out.println("[Mac] 버튼 클릭"); }
}

// ===== 제품군 2: 체크박스 =====
interface CheckBox {
    void check();
}
class WinCheckBox implements CheckBox {
    public void check() { System.out.println("[Windows] 체크박스 체크"); }
}
class MacCheckBox implements CheckBox {
    public void check() { System.out.println("[Mac] 체크박스 체크"); }
}

// ===== 추상 팩토리: "세트"를 만드는 공장 =====
interface GUIFactory {
    Button   createButton();
    CheckBox createCheckBox();
}

// Windows 세트 공장
class WinFactory implements GUIFactory {
    public Button   createButton()   { return new WinButton(); }
    public CheckBox createCheckBox() { return new WinCheckBox(); }
}

// Mac 세트 공장
class MacFactory implements GUIFactory {
    public Button   createButton()   { return new MacButton(); }
    public CheckBox createCheckBox() { return new MacCheckBox(); }
}

public class C05추상팩토리패턴 {
    public static void main(String[] args) {
        // 공장 한 줄만 바꾸면 모든 UI가 일관되게 변경됨
        GUIFactory factory = new WinFactory();    // ← MacFactory()로 바꿔보기

        Button   btn = factory.createButton();
        CheckBox chk = factory.createCheckBox();

        btn.click();
        chk.check();
    }
}
