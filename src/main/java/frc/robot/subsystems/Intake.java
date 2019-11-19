package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import edu.wpi.first.wpilibj.AnalogInput;
// import edu.wpi.first.wpilibj.DigitalInput;
// import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
// import frc.robot.RobotMap;

public class Intake extends Subsystem {
    
    // Includes all relevant motors, sensors, etc. in subsystem

    // private DoubleSolenoid grabber;
    // private TalonSRX pivot;
    // private TalonSRX leftArm;
    // private TalonSRX rightArm;
    // private DigitalInput upperSwitch;
    // private DigitalInput lowerSwitch;
    // private AnalogInput ultrasonic;

    public Intake() {
        // Names subsystem
        super("Intake");
        // You'll initialize everything above here again. The contructor for all of them is Class(int port), except
        // double solonoids, which are DoubleSolenoid(int forwardPort, int reversePort).

        // leftArm.setInverted(true);
    }

    // This method is always empty!
    @Override
    protected void initDefaultCommand() {}

    /*
    The methods you'll need to make here are:
    - setArmsSpeed(double speed) -> sets both leftArm and rightArm to speed
    - grab() -> sets grabber to forward
    - release() -> sets grabber to reverse
    - setPivotSpeed(double speed) -> sets pivot to speed; make sure does not go where it cannot go, outside of upper & lower beam breaks
    - getUpperSwitchValue() -> returns opposite of upperSwitch
    - getLowerSwitchValue() -> returns opposite of lowerSwitch
    - getUltrasonicDistance() -> returns the average voltage of ultrasonic

    To set the value of a
    - talon, use -> (talon).set(ControlMode.PercentOutput, double outputValue);
    - double solenoid, use -> (solenoid).set(DoubleSolenoid.Value.kForward or kReverse);

    To get the value of a
    - digital input, such as the switches, use -> (input).get();
    - analog input, such as the ultrasound, use -> (input).getAverageVoltage();
    */

}
