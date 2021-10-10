package frc.robot;

/**
 * Add your docs here.
 */
import edu.wpi.first.wpilibj.DoubleSolenoid;


public class Piston {
    //Solinoid creation
    private DoubleSolenoid pumkinRemoval;

    //State tracker
    public PlateState pistonPosition = null;

    public static enum PlateState {
        RETRACT,
        DEPLOY;
    }
    
    /* Constructer*/
    public Piston() {
        //Creates the piston instance
        pumkinRemoval = new DoubleSolenoid(0,1);

        //Sets the piston and state machine to retract
        pumkinRemoval.set(DoubleSolenoid.Value.kReverse);
        pistonPosition = PlateState.RETRACT;
    }

    public void deployRetract(boolean togglePlate) {
        if (togglePlate == true)  {
            if (pistonPosition == PlateState.RETRACT)  {
                pistonPosition = PlateState.DEPLOY;
                pumkinRemoval.set(DoubleSolenoid.Value.kForward);
                System.out.println("Deployed");
            }
            else if (pistonPosition == PlateState.DEPLOY) {
                pistonPosition = PlateState.RETRACT;
                pumkinRemoval.set(DoubleSolenoid.Value.kReverse);
                System.out.println("Retract");
            }
        }
    }

}
