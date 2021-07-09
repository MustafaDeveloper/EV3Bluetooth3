import com.j4ev3.core.Brick;
import com.j4ev3.core.Motor;
import com.j4ev3.core.Sensor;
import com.j4ev3.desktop.BluetoothComm;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class GlobalKeyListenerExample implements NativeKeyListener {
    private static Brick brick = new Brick(new BluetoothComm("0016535DF4C3"));
    int stepRight=60;
    int stepLeft=-60;


    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException nativeHookException) {
                nativeHookException.printStackTrace();
            }
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_UP) {
            brick.getMotor().turnAtPower((byte) (Motor.PORT_C), -100);
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_DOWN) {
            brick.getMotor().turnAtPower((byte) (Motor.PORT_C), 100);
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_UP) {
            brick.getMotor().turnAtPower((byte) (Motor.PORT_D), -100);
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_DOWN) {
            brick.getMotor().turnAtPower((byte) (Motor.PORT_D), 100);
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_LEFT) {
                brick.getMotor().stepAtSpeed(Motor.PORT_A, stepRight,0 , 0, 20, true);
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_RIGHT) {
                brick.getMotor().stepAtSpeed(Motor.PORT_A, stepLeft, 20, 0, 0, true);
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

        if (e.getKeyCode() == NativeKeyEvent.VC_UP) {
            brick.getMotor().stopMotor(Motor.PORT_C, false);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_DOWN) {
            brick.getMotor().stopMotor(Motor.PORT_C, false);
        }

        if (e.getKeyCode() == NativeKeyEvent.VC_UP) {
            brick.getMotor().stopMotor(Motor.PORT_D, false);
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_DOWN) {
            brick.getMotor().stopMotor(Motor.PORT_D, false);
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }

//    public static void main(String[] args) {
//        try {
//            GlobalScreen.registerNativeHook();
//        }
//        catch (NativeHookException ex) {
//            System.err.println("There was a problem registering the native hook.");
//            System.err.println(ex.getMessage());
//
//            System.exit(1);
//        }
//
//        GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample());
//    }

    public static void work() {
        try {
            GlobalScreen.registerNativeHook();

        } catch (NativeHookException ex) {
            //System.err.println("There was a problem registering the native hook.");
           // System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListenerExample());

    }
}