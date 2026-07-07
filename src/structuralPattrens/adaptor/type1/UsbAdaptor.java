package structuralPattrens.adaptor.type1;

// [어댑터 패턴 - Adapter(변환기) 역할]
// Target(UsbB)을 구현하면서 내부에 Adaptee(UsbC)를 참조(합성)한다.
// 클라이언트의 usbB() 호출을 Adaptee의 usbC() 호출로 변환(위임)하여
// 서로 호환되지 않던 두 인터페이스를 연결한다.
public class UsbAdaptor implements UsbB {

    // 변환 대상인 기존 시스템(Adaptee)
    private UsbC usbC;

    public UsbAdaptor(UsbC usbC) {
        this.usbC = usbC;
    }

    @Override
    public void usbB() {
        usbC.usbC();  // Target 호출을 Adaptee 호출로 변환
    }
}
