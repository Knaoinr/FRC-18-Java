package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
// import frc.robot.RobotMap;

public class Guillotine extends Subsystem {

    // private DoubleSolenoid kicker;
    // private TalonSRX lift;
    // private DigitalInput upperSwitch;
    // private DigitalInput lowerSwitch;

    public Guillotine() {
        super("Guillotine");
        // Use Intake.java as a guide if you need to, but try just trying to remember first ^-^
    }

    @Override
    protected void initDefaultCommand() {}

    /*
    The methods you'll need to make here are:
    - hold() -> sets kicker to forward
    - kick() -> sets kicker to reverse
    - setLiftSpeed(double speed) -> sets lift to speed; make sure does not go where it cannot go, outside of upper & lower beam breaks
    - getUpperSwitchValue() -> returns opposite of upperSwitch
    - getLowerSwitchValue() -> returns opposite of lowerSwitch
    - getLiftPosition() -> returns lift sensor position
    - zeroLiftPosition() -> calibrates sensor by setting lift sensor position to 0

    To set the value of a
    - talon encoder, use -> (talon).setSelectedSensorPosition(int sensorPos, 0, 1);

    To get the value of a
    - talon encoder, use -> (talon).getSelectedSensorPosition(0);
    */

}
