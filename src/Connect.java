import com.j4ev3.core.Sensor;

public class Connect {
//    private static Brick brick;


    public Connect() {
        //   brick = new Brick(new BluetoothComm("0016535DF4C3"));

    }

    public static void main(String[] args) {
        Connect c = new Connect();
        GlobalKeyListenerExample globalKeyListenerExample = new GlobalKeyListenerExample();
        //brick.getMotor().turnAtPower((byte) (Motor.PORT_A), 50);
//        wait(1000);
//        brick.getMotor().stopMotor(Motor.PORT_A, false);

        //while (true) {
//            AWTEventListener listener = new AWTEventListener() {
//                @Overridei
//                public void eventDispatched(AWTEvent event) {
//                    try {
//                        KeyEvent evt = (KeyEvent) event;
//                        if (evt.getID() == KeyEvent.KEY_PRESSED && evt.getKeyCode() == KeyEvent.VK_F) {
//                            brick.getMotor().turnAtPower((byte) (Motor.PORT_A), 50);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            };
//
//            Toolkit.getDefaultToolkit().addAWTEventListener(listener, AWTEvent.KEY_EVENT_MASK);

            globalKeyListenerExample.work();
        System.out.println("range :"+ Sensor.ULTRASONIC_CM);

       // }


    }


    public static void wait(int t) {
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
