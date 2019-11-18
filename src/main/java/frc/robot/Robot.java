package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.commands.autonomous.*;
import frc.robot.subsystems.Subsystems;
import frc.robot.userinterface.UserInterface;

public class Robot extends TimedRobot {

    // Your variables here will represent any cameras, pixies, and autonomous/teleop commands that you plan to use.

    // This is the constructor!
    public Robot() {
        super(0.06);
    }

    // Called when robot turned on
    public void robotInit() {

        /*
        Here is where you should initialize everything, rather than the constructor.
        Once you've made variables for this class above, do that here!

        Besides that, you'll want to do a few things to set up your robot:
        - Once you've made subsystems:
            1. Start the compressor
            2. Set any initial positions (here, set guillotine to lowest position)
            3. We have fancy LEDs, so use the command Subsystems.arduino.sendCommand("0001111");
        - Once you've made the user interface & commands for them:
            1. Connect buttons with commands, e.g. (insert button).whenPressed(new IntakeGrab());
            Note that this only used for commands that should be executed on a button press.
            Here's what the buttons should do in total:

            "intake arms close: A
            intake arms open: B
            kicker retracts: X
            kicker kicks out: Y
            entire programmed sequence: START
            Right trigger: intake wheels
            Left trigger: outake wheels
            Left joystick: rotation
            Right joystick: forwards and backwards
            Ensure that guillotine is completely down before beginning"

            Which of these buttons should you set up here?
        */

    }

    public void disabledInit() {
        Subsystems.arduino.sendCommand("0001111");
    }

    public void autonomousInit() {
        Scheduler.getInstance().removeAll();
        Subsystems.arduino.sendCommand("0005551");
        String gameData = DriverStation.getInstance().getGameSpecificMessage();
        if (UserInterface.launchpad.getMultiSwitchLeft()) {
            autonomous = new LeftAutonomous(gameData, UserInterface.launchpad.getSwitch1());
        } else if (UserInterface.launchpad.getMultiSwitchInactive()) {
            autonomous = new CenterAutonomous(gameData.charAt(0));
        } else if (UserInterface.launchpad.getMultiSwitchRight()) {
            autonomous = new RightAutonomous(gameData, UserInterface.launchpad.getSwitch1());
        }
        //autonomous.start();
        rotations.start();
    }

    public void teleopInit() {
        if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
            Subsystems.arduino.sendCommand("0003331");
        } else {
            Subsystems.arduino.sendCommand("0002221");
        }
        Scheduler.getInstance().removeAll();
    }

    public void disabledPeriodic() {
        printDataToSmartDashboard();
    }
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        printDataToSmartDashboard();
    }

    public void teleopPeriodic() {
        Subsystems.guillotine.setLiftSpeed(0.0d);
        if (UserInterface.operatorController.getLeftJoystickY() < -.1d) {
            Subsystems.intake.release(); // if controller left joystick goes up, arms release
            Subsystems.guillotine.setLiftSpeed(1.0d);
        } else if (UserInterface.operatorController.getLeftJoystickY() > .1d) {
            Subsystems.guillotine.setLiftSpeed(-0.4d);
            if (Subsystems.guillotine.getLowerSwitchValue()) {
                Subsystems.guillotine.kick(); // when going down with the left joystick, if all the way down, kick cube
            }
        }
        Subsystems.intake.setArmsSpeed(0.0d);
        if (UserInterface.operatorController.getLeftTrigger() > 0.1d) {
            Subsystems.intake.setArmsSpeed(-0.9d);
        } else if (UserInterface.operatorController.getRightTrigger() > 0.1d) {
            Subsystems.intake.setArmsSpeed(0.5d);
        }
        Subsystems.intake.setPivotSpeed(0.0d);
        if (UserInterface.operatorController.getRightJoystickY() < -0.1d) {
            Subsystems.guillotine.kick(); // kicker open if intake pivot goes up
            Subsystems.intake.setPivotSpeed(0.6);
        } else if (UserInterface.operatorController.getRightJoystickY() > 0.1d) {
            Subsystems.intake.setPivotSpeed(-0.2);
        }
        Scheduler.getInstance().run();
        printDataToSmartDashboard();
    }

    private void printDataToSmartDashboard() {
        SmartDashboard.putNumber("Ultrasonic", Subsystems.intake.getUltrasonicDistance());
        SmartDashboard.putBoolean("Lift Upper Switch", Subsystems.guillotine.getUpperSwitchValue());
        SmartDashboard.putBoolean("Lift Lower Switch", Subsystems.guillotine.getLowerSwitchValue());
        SmartDashboard.putBoolean("Intake Upper Switch", Subsystems.intake.getUpperSwitchValue());
        SmartDashboard.putBoolean("Intake Lower Switch", Subsystems.intake.getLowerSwitchValue());
        SmartDashboard.putNumber("Guillotine Position", Subsystems.guillotine.getLiftPosition());
        SmartDashboard.putNumber("Left Encoder", Subsystems.driveBase.getLeftPosition());
        SmartDashboard.putNumber("Right Encoder", Subsystems.driveBase.getRightPosition());
        SmartDashboard.putNumber("Left Arm Current", Subsystems.intake.getLeftArmCurrent());
        SmartDashboard.putNumber("Right Arm Current", Subsystems.intake.getRightArmCurrent());
        SmartDashboard.putNumber("Xbox POV", UserInterface.operatorController.getPOVAngle());
        SmartDashboard.putNumber("Gyro Angle", Subsystems.driveBase.getGyroAngle());

    }
}