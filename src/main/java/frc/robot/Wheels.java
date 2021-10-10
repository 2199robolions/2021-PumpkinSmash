package frc.robot;

/**
 * Add your docs here.
 */
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class Wheels {

    /* Object */
    private SpeedControllerGroup RightSCG;
    private SpeedControllerGroup LeftSCG;
    private DifferentialDrive drive;

    //Motor Declarations
    private Talon frontRight;
    private Talon frontLeft;
    private Talon backRight;
    private Talon backLeft;
    
    /* Constructer*/
    public Wheels() {
        frontRight = new Talon(3);        
        backRight  = new Talon(2);
        frontLeft  = new Talon(0);
        backLeft   = new Talon(1);

        RightSCG = new SpeedControllerGroup(frontRight, backRight);
        LeftSCG  = new SpeedControllerGroup(frontLeft, backLeft);

        drive = new DifferentialDrive(RightSCG, LeftSCG);
    }

    /**
     * Drives the robot in a tank like manner
     * @param leftSpeed
     * @param rightSpeed
     */
    public void manualControl(double leftSpeed, double rightSpeed)  {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

}
