package Ch16.C02구조패턴;

/* ----------------------------------------------------------
   3. 프록시 패턴 (Proxy)
   ----------------------------------------------------------
   설명 : 실제 객체 대신 "대리인"을 두어 접근을 제어하는 패턴
   비유 : 비서가 사장 일정 관리 (직접 만나기 전에 거름)
   용도 : - 지연 로딩 (큰 이미지/파일 늦게 불러오기)
          - 접근 제어 (권한 체크 후 통과)
          - 로깅, 캐싱
   ---------------------------------------------------------- */

interface Image {
    void show();
}

// 실제 객체 (생성 비용이 큼 - 로딩이 오래 걸린다고 가정)
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("[디스크에서 " + fileName + " 로딩...]");
    }

    public void show() {
        System.out.println(fileName + " 화면에 표시");
    }
}

// 프록시: 실제 필요할 때까지 RealImage 생성을 미룸
class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;   // 처음엔 null

    public ProxyImage(String fileName) {
        this.fileName = fileName;
        // 여기서 로딩하지 않음 (가벼움)
    }

    public void show() {
        if (realImage == null) {
            realImage = new RealImage(fileName);   // 처음 호출될 때만 로딩
        }
        realImage.show();
    }
}

public class C03프록시패턴 {
    public static void main(String[] args) {
        Image img = new ProxyImage("photo.jpg");

        System.out.println(">> ProxyImage 생성됨 (아직 로딩 X)");
        System.out.println(">> 첫 번째 show() 호출:");
        img.show();   // 이때 로딩 발생

        System.out.println(">> 두 번째 show() 호출:");
        img.show();   // 이미 로딩됨 → 재로딩 없음
    }
}
