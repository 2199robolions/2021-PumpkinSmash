package frc.robot;


import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * Add your docs here.
 */


public class Wheels {


    private DifferentialDrive drive;
    
    public Wheels() {


        /* Object */

        SpeedControllerGroup RightSCG;
        SpeedControllerGroup LeftSCG;

        Talon frontRight;
        Talon frontLeft;
        Talon backRight;
        Talon backLeft;


        /* Constructer*/

        frontRight = new Talon(3);        
        backRight  = new Talon(2);
        frontLeft  = new Talon(0);
        backLeft   = new Talon(1);

        RightSCG = new SpeedControllerGroup(frontRight, backRight);
        LeftSCG  = new SpeedControllerGroup(frontLeft, backLeft);

        drive = new DifferentialDrive(RightSCG, LeftSCG);
    }
    public void manualControl(double leftSpeed, double rightSpeed)  {
        drive.tankDrive(leftSpeed, rightSpeed);
    }

}
