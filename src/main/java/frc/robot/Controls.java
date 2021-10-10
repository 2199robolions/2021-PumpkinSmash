package frc.robot;

/*Imported docc */
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;


/**
 * Add your docs here.
 */
public class Controls {

    /* Objects*/
    XboxController xbox;


    /* Constructers*/
    public Controls() {
        xbox = new XboxController(0);
    }
    
    public double getRightStick() {
        return xbox.getY(GenericHID.Hand.kRight);
    }

    public double getLeftStick() {
       return xbox.getY(GenericHID.Hand.kLeft);
    }

    public double getLeftTrigger() {
        return xbox.getTriggerAxis(GenericHID.Hand.kLeft);
    }

    public double getRightTrigger() {
        return xbox.getTriggerAxis(GenericHID.Hand.kRight);
    }

    public boolean togglePlate() {
        return xbox.getBumperPressed(GenericHID.Hand.kRight);
    }

    public boolean toggleSiren() {
        return xbox.getBumper(GenericHID.Hand.kLeft);
    }

}

//End of Controls class