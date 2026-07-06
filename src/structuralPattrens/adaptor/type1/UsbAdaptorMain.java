package structuralPattrens.adaptor.type1;


/**
 * 기존 프로그램(UsbB)은 그대로 두고, UsbC 장치를 연결하고 싶다.
 *
 *
 * ✔ Adapter(어댑터) 패턴이란?
 * 서로 호환되지 않는 인터페이스를 연결하여 기존 코드를 수정하지 않고 함께 사용할 수 있도록 하는 구조 패턴(Structural Pattern)이다.
 *
 *
 * ✔ 출현 배경
 * 프로그램이 커지면서 다음과 같은 문제가 생겼다.
 * 이미 사용 중인 기존 시스템(Legacy System)이 있음
 * 새로 개발하는 시스템은 다른 인터페이스를 사용함
 * 기존 코드를 수정하기 어렵거나 수정하면 영향 범위가 큼
 * 서로 인터페이스가 달라 직접 사용할 수 없음
 *
 *
 * ✔ 구조 특징
 * Target (원하는 형태)
 * Adaptee (기존 시스템)
 * Adapter (변환기)
 *
 * Target → UsbB
 * Adaptee → UsbC
 * Adapter → UsbAdaptor
 * Client → UsbAdaptorMain
 */
public class UsbAdaptorMain {
    static void main() {
        UsbC usbC = new UsbC() {
            @Override
            public void usbC() {
                System.out.println("C타입 변환 중");
            }
        };

        UsbB usbB = new UsbAdaptor(usbC);
        usbB.usbB();

    }
}
