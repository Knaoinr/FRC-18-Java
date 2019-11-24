package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Guillotine extends Subsystem {

    private DoubleSolenoid kicker;
    private TalonSRX lift;
    private DigitalInput upperSwitch;
    private DigitalInput lowerSwitch;

    public Guillotine() {
        super("Guillotine");
        // Use Intake.java as a guide if you need to, but try just trying to remember first ^-^
        this.kicker = new DoubleSolenoid(RobotMap.kickerForward, RobotMap.kickerReverse);
        this.lift = new TalonSRX(RobotMap.lift);
        this.upperSwitch = new DigitalInput(RobotMap.guillotineUpperSwitch);
        this.lowerSwitch = new DigitalInput(RobotMap.guillotineLowerSwitch);
    }

    @Override
    protected void initDefaultCommand() {}

    /*
    The methods you'll need to make here are:
    - setLiftSpeed(double speed) -> sets lift to speed; make sure does not go where it cannot go, outside of upper & lower beam breaks
    - hold() -> sets kicker to forward
    - kick() -> sets kicker to reverse
    - getUpperSwitchValue() -> returns opposite of upperSwitch
    - getLowerSwitchValue() -> returns opposite of lowerSwitch
    - getLiftPosition() -> returns lift sensor position
    - zeroLiftPosition() -> calibrates sensor by setting lift sensor position to 0

    To set the value of a
    - talon encoder, use -> (talon).setSelectedSensorPosition(int sensorPos, 0, 1);

    To get the value of a
    - talon encoder, use -> (talon).getSelectedSensorPosition(0);
    */

    public void setLiftSpeed(double speed) {
        lift.set(ControlMode.PercentOutput, speed);
    }

    public void hold() {
        kicker.set(DoubleSolenoid.Value.kForward);
    }

    public void kick() {
        kicker.set(DoubleSolenoid.Value.kReverse);
    }

    public boolean getUpperSwitchValue() {
        return !upperSwitch.get();
    }

    public boolean getLowerSwitchValue() {
        return !lowerSwitch.get();
    }

    public int getLiftPosition() {
        return lift.getSelectedSensorPosition(0);
    }

    public void zeroLiftPosition() {
        lift.setSelectedSensorPosition(0, 0, 1);
    }

}
