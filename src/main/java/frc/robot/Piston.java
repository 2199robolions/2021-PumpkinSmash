package frc.robot;

/**
 * Add your docs here.
 */
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The actual class
 */
public class Piston {
    //Solinoid creation
    private Solenoid       siren;
    private DoubleSolenoid pumkinRemoval;

    //State trackers
    private SirenState sirenOnOff     = null;
    private PlateState pistonPosition = null;

    private static enum PlateState {
        RETRACT,
        DEPLOY;
    }

    private static enum SirenState {
        ENABLED,
        DISABLED;
    }
    
    /* Constructer*/
    public Piston() {
        //Creates the piston(s)
        siren         = new Solenoid( 2 );
        pumkinRemoval = new DoubleSolenoid( 0 , 1 );

        //Sets the pistons
        siren.set(false);
        pumkinRemoval.set(DoubleSolenoid.Value.kReverse);

        //Sets the state machines
        sirenOnOff     = SirenState.DISABLED;
        pistonPosition = PlateState.RETRACT;
    }

    /**
     * Deploys and retracts the cleaning plate
     * @param togglePlate
     */
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

    /**
     * Starts and stops the siren
     * @param toggleSiren
     */
    public void sirenToggle(boolean toggleSiren) {
        if (toggleSiren == true) {
            if (sirenOnOff == SirenState.ENABLED) {
                sirenOnOff = SirenState.DISABLED;
                System.out.println("Disabled");
            }
            else if (sirenOnOff == SirenState.DISABLED) {
                sirenOnOff = SirenState.ENABLED;
                System.out.println("Enabled");
            }
        }

        if (sirenOnOff == SirenState.ENABLED) {
            siren.set(true);
        }
        else if (sirenOnOff == SirenState.DISABLED) {
            siren.set(false);
        }
    }

}

//End of Piston class