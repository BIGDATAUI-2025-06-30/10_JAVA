package Ch16.C02구조패턴;

/* ----------------------------------------------------------
   1. 어댑터 패턴 (Adapter)
   ----------------------------------------------------------
   설명 : 호환되지 않는 인터페이스를 변환해서 연결하는 패턴
   비유 : 220V 콘센트에 110V 플러그를 꽂기 위한 변환 어댑터
   용도 : 외부 라이브러리 통합, 레거시 코드 재사용
          (수정할 수 없는 클래스를 새 인터페이스에 맞춰 사용)
   ---------------------------------------------------------- */

// 우리집 콘센트(220V만 받음)
interface Socket220V {
    void plug220();
}

// 외국에서 가져온 110V 기기 (수정 불가)
class Device110V {
    public void plug110() {
        System.out.println("110V로 작동합니다");
    }
}

// 어댑터: 110V 기기를 220V 콘센트에 끼울 수 있게 변환
class VoltageAdapter implements Socket220V {
    private Device110V device;

    public VoltageAdapter(Device110V device) {
        this.device = device;
    }

    @Override
    public void plug220() {
        System.out.print("[어댑터 변환] ");
        device.plug110();   // 220V 요청을 110V 호출로 변환
    }
}

public class C01어댑터패턴 {
    public static void main(String[] args) {
        Device110V foreignDevice = new Device110V();
        Socket220V socket = new VoltageAdapter(foreignDevice);

        socket.plug220();   // 220V 콘센트에 끼우는 것처럼 호출
    }
}
