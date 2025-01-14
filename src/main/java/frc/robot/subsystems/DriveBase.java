package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
// import frc.robot.commands.TankDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends Subsystem {

    private WPI_TalonSRX leftMasterMotor;
    private WPI_TalonSRX rightMasterMotor;

    private WPI_VictorSPX leftFollower1;
    private WPI_VictorSPX leftFollower2;
    private WPI_VictorSPX rightFollower1;
    private WPI_VictorSPX rightFollower2;

    private ADXRS450_Gyro gyro;

    SpeedControllerGroup leftSide;
    SpeedControllerGroup rightSide;

    public DifferentialDrive splitDrive;
    public DifferentialDrive arcadeDrive;
    public DifferentialDrive cheesyDrive;

    public DriveBase() {
        super("DriveBase");
        this.leftMasterMotor = new WPI_TalonSRX(RobotMap.leftMasterMotor);
        this.rightMasterMotor = new WPI_TalonSRX(RobotMap.rightMasterMotor);

        this.leftFollower1 = new WPI_VictorSPX(RobotMap.leftFollower1);
        this.leftFollower2 = new WPI_VictorSPX(RobotMap.leftFollower2);
        this.rightFollower1 = new WPI_VictorSPX(RobotMap.rightFollower1);
        this.rightFollower2 = new WPI_VictorSPX(RobotMap.rightFollower2);

        this.gyro = new ADXRS450_Gyro();

        this.leftSide = new SpeedControllerGroup(leftMasterMotor, leftFollower1, leftFollower2);
        this.rightSide = new SpeedControllerGroup(rightMasterMotor, rightFollower1, rightFollower2);

        this.splitDrive = new DifferentialDrive(leftSide, rightSide); 
        this.arcadeDrive = new DifferentialDrive(leftSide, rightSide);
        this.cheesyDrive = new DifferentialDrive(leftSide, rightSide);
        
        leftMasterMotor.setInverted(true);
        leftFollower1.setInverted(true);
        leftFollower2.setInverted(true);
    }

    // Notice that, in this case, you'll have a default command that controls the drive base.
    @Override
    public void initDefaultCommand() { /* this.setDefaultCommand(new TankDrive()); */ }

    public void setMotors(double left, double right) {
        // leftMasterMotor.set(ControlMode.PercentOutput, left * 0.5);
        // rightMasterMotor.set(ControlMode.PercentOutput, right * 0.5);
        leftSide.set(left*0.3);//see percent output above, think it's just be a master-follower thing?
        rightSide.set(right*0.3);
    }

    public int getLeftPosition() {
        return leftMasterMotor.getSelectedSensorPosition(0);
    }

    public int getRightPosition() {
        return rightMasterMotor.getSelectedSensorPosition(0);
    }

    public int getLeftVelocity() {
        return leftMasterMotor.getSelectedSensorVelocity(0);
    }

    public int getRightVelocity() {
        return rightMasterMotor.getSelectedSensorVelocity(0);
    }

    public double getGyroAngle() {
        return gyro.getAngle();
    }

    public void zeroEncoderPosition() {
        leftMasterMotor.setSelectedSensorPosition(0, 0, 10);
        rightMasterMotor.setSelectedSensorPosition(0, 0, 10);
    }

    public void zeroGyroAngle() { gyro.reset(); }
}
