import com.j4ev3.core.Brick;
import com.j4ev3.core.Motor;
import com.j4ev3.core.Sensor;
import com.j4ev3.desktop.BluetoothComm;


public class RobotArm {
    private static Brick brick;


    public RobotArm() {
        // ev3 menüden mac adresi alinip asagiya yazildi
        brick = new Brick(new BluetoothComm("0016535DF4C3"));

    }

    public static void main(String[] args) {
        RobotArm r=new RobotArm();
        for (int i = 0; i < 1 ; i++) {
//            brick.getMotor().stepAtSpeed(Motor.PORT_A, 0, 20, 0, 0, true);
//            r.waitt(1000);
//          brick.getMotor().stepAtSpeed(Motor.PORT_A, 0, 0, 0, -20, true);
//           r.waitt(1000);
//            brick.getMotor().turnAtPower( (Motor.PORT_C), 30);
//            r.waitt(500);
//            brick.getMotor().stopMotor(Motor.PORT_C,true);
//            r.waitt(1000);
//            brick.getMotor().turnAtPower( (Motor.PORT_D), -30);
//            r.waitt(500);
//            brick.getMotor().stopMotor(Motor.PORT_D,true);
//            r.waitt(1000);
            System.out.println("Sensor.PORT_3: "+brick.getSensor().getDeviceModeName(Sensor.PORT_3,1,20));
            System.out.println("Sensor.PORT_3 getValueRaw: "+brick.getSensor().getValueSI(Sensor.PORT_3,3,0));
            System.out.println("Sensor.PORT_4: "+brick.getSensor().getDeviceName(Sensor.PORT_4,20)+" **");

            System.out.println("Sensor.PORT_3: "+brick.getSensor().getValueSI(Sensor.PORT_3,1,3)+" **");
           System.out.println("Sensor.PORT_4: "+brick.getSensor().getValueSI(Sensor.PORT_4,1,2)+" **");
brick.getSensor().clearAll();
        }
    }
    public void waitt(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
