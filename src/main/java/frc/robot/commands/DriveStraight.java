package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.subsystems.Subsystems;

public class DriveStraight extends Command {

    // private double ticks;
    // private boolean forward;
    // private double speed;

    public DriveStraight(double inches, double Speed, boolean Forward, double Timeout) {
        super("DriveStraight");
        // requires(Subsystems.driveBase);
        // Set the class variables here like you would for your own constructor!
        // Keep in mind that the number of inches should be positive.
        setTimeout(Timeout);
    }

    @Override
    public void initialize() {
        // Zero the encoder position, gyro, and any other instruments
    }

    @Override
    public void execute() {
        // This will calculate the motor values needed to continue driving straight!
        // double correction = Subsystems.driveBase.getGyroAngle();
        // correction *= 0.075;
        // correction += 1.0;
        // if (forward) {
        //     Subsystems.driveBase.setMotors(-speed, -speed * correction);
        // } else {
        //     Subsystems.driveBase.setMotors(speed * correction, speed);
        // }
    }

    @Override
    public boolean isFinished() {
        // If the robot has reached the length needed OR time has run out (with isTimedOut()), return false
        return isTimedOut(); //placeholder for u
    }

    @Override
    public void interrupted() {
        // Stop the motors
    }

    @Override
    public void end() {
        // Stop the motors
    }

    // Remember this?
    public double convertToTicks(double inches) {
        return (4096 / (6 * 3.1415926) * inches);
    }

}
