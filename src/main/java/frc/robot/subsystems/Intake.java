package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Intake extends Subsystem {
    
    // Includes all relevant motors, sensors, etc. in subsystem

    private DoubleSolenoid grabber;
    private TalonSRX pivot;
    private TalonSRX leftArm;
    private TalonSRX rightArm;
    private DigitalInput upperSwitch;
    private DigitalInput lowerSwitch;
    private AnalogInput ultrasonic;

    public Intake() {
        // Names subsystem
        super("Intake");
        // You'll initialize everything above here again. The contructor for all of them is Class(int port), except
        // double solonoids, which are DoubleSolenoid(int forwardPort, int reversePort).
        this.grabber = new DoubleSolenoid(RobotMap.intakeForward, RobotMap.intakeReverse);
        this.pivot = new TalonSRX(RobotMap.intakePivot);
        this.leftArm = new TalonSRX(RobotMap.intakeLeftArm);
        this.rightArm = new TalonSRX(RobotMap.intakeRightArm);
        this.upperSwitch = new DigitalInput(RobotMap.intakeUpperSwitch);
        this.lowerSwitch = new DigitalInput(RobotMap.intakeLowerSwitch);
        this.ultrasonic = new AnalogInput(RobotMap.intakeUltrasonic);

        leftArm.setInverted(true);
    }

    // This method is always empty!
    @Override
    protected void initDefaultCommand() {}

    /*
    The methods you'll need to make here are:
    - setArmsSpeed(double speed) -> sets both leftArm and rightArm to speed
    - setPivotSpeed(double speed) -> sets pivot to speed; make sure does not go where it cannot go, outside of upper & lower beam breaks
    - grab() -> sets grabber to forward
    - release() -> sets grabber to reverse
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

    public void setArmsSpeed(double speed) {
        leftArm.set(ControlMode.PercentOutput, speed);
        rightArm.set(ControlMode.PercentOutput, speed);
    }

    public void setPivotSpeed(double speed) {
        pivot.set(ControlMode.PercentOutput, speed);
    }

    public void grab() {
        grabber.set(DoubleSolenoid.Value.kForward);
    }

    public void release() {
        grabber.set(DoubleSolenoid.Value.kReverse);
    }

    public boolean getUpperSwitchValue() {
        return !upperSwitch.get();
    }

    public boolean getLowerSwitchValue() {
        return !lowerSwitch.get();
    }

    public double getUltrasonicDistance() {
        return ultrasonic.getAverageVoltage();
    }

}
