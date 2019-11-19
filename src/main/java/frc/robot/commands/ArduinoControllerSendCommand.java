package frc.robot.commands;

// import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.subsystems.Subsystems;

public class ArduinoControllerSendCommand extends Command {

    /*
    Here's a simpler example of a command!
    
    Commands have six parts:
    1. Constructor - super(String name), requires whichever subsystem
    2. initialize() - sets timeout if not done in constructor, zeroes instruments
    3. execute() - contains things to be done
    4. isFinished() - returns whether the command should end or not
    5. interrupted() - executed when the command is manually stopped
    6. end() - called when isFinished() returns true

    Try and see what they do here and in other classes, then try making some of your own!

    */

    public ArduinoControllerSendCommand() {
        super("ArduinoControllerSendCommand");
    }

    @Override
    public void initialize() {
        // if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
        //     Subsystems.arduino.sendCommand("0005356");
        // } else {
        //     Subsystems.arduino.sendCommand("0005256");
        // }
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void interrupted() {

    }

    @Override
    public void end() {

    }



}
