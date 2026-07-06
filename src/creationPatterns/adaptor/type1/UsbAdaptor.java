package creationPatterns.adaptor.type1;

public class UsbAdaptor implements UsbB {

    private UsbC usbC;

    public UsbAdaptor(UsbC usbC) {
        this.usbC = usbC;
    }

    @Override
    public void usbB() {
        usbC.usbC();
    }
}
