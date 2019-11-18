package frc.robot;

// import edu.wpi.cscore.UsbCamera;
// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.cameraserver.CameraServer;
// import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.command.CommandGroup;
// import edu.wpi.first.wpilibj.command.Scheduler;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.commands.*;
// import frc.robot.commands.autonomous.*;
// import frc.robot.subsystems.Subsystems;
// import frc.robot.userinterface.UserInterface;

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
            3. We have fancy LEDs, so use the command -> Subsystems.arduino.sendCommand("0001111");
        - Once you've made the user interface & commands for them:
            1. Connect buttons with commands, e.g. -> (insert button).whenPressed(new IntakeGrab());
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

    /*
    Now, you'll have 6 methods: combinations of disabled/autonomous/teleop and init/periodic.
    Follow these guidelines for each:
    - All inits remove all commands in the scheduler
    - If we have LEDs (and we do here!) change color in all inits
    - Auto and teleop periodics run commands in the scheduler
    - All periodics print data to SmartDashboard (see bottom of file)
    - Disabled stops robot function to some extent
    - Auto init includes auto commands
    - Teleop periodic includes motor speed control
    */

    public void disabledInit() {
        // Subsystems.arduino.sendCommand("0001111");
    }

    public void autonomousInit() {
        // Scheduler.getInstance().removeAll();
        // Subsystems.arduino.sendCommand("0005551");
        // Start any autonomous command group with -> (insert name).start();
    }

    public void teleopInit() {
        // Scheduler.getInstance().removeAll();
        // You can use the following code to decide if the team's color is red or blue! ->
        // if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
        //     Subsystems.arduino.sendCommand("0003331");
        // } else {
        //     Subsystems.arduino.sendCommand("0002221");
        // }
    }

    public void disabledPeriodic() {
        // ...
    }
    
    public void autonomousPeriodic() {
        // Scheduler.getInstance().run();
    }

    public void teleopPeriodic() {
        // Scheduler.getInstance().run();
        /*
        Here you'll manage all the robot movements that aren't already covered in the button code in
        robotInit() or contained in the drive base. Once you've made your subsystems and user interface,
        find out which parts need to be moved!
        */
    }

    /*
    Here, you'll want to write a private void method that prints the values of variables to the Smart Dashboard.
    To do this, the general command is -> SmartDashboard.putNumber("Name", Something.getValue());
    However, there are also commands like putBoolean rather than putNumber that you can use.
    */

}