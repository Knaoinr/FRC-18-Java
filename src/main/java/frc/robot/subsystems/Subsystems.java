package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;

public class Subsystems {

    /*
    This class contains all the subsystems of the robot.
    The subsystems here are the arduino (ArduinoController), compressor, drive base, guillotine, and intake.
    Make public static final instances of each subsystem! You'll be able to access these anywhere.
    */

    public static final ArduinoController arduino = new ArduinoController();
    public static final Compressor compressor = new Compressor();
    public static final DriveBase driveBase = new DriveBase();
    public static final Guillotine guillotine = new Guillotine();
    public static final Intake intake = new Intake();

}
