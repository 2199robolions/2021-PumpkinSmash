/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /* Objects */
  private Controls controls;
  private Wheels wheels;
  private Piston piston;
  //private Arm arm;

  public Robot(){
    //Instance creation
    controls = new Controls();
    wheels   = new Wheels();
    piston   = new Piston();
    //arm = new Arm();
  }
  

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    //
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    //
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    //
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    double  leftPower;
    double  rightPower;
    boolean removalToggle;
    boolean sirenToggle;
    //double upArmPower; 
    //double downArmPower;

    leftPower     = controls.getLeftStick();
    rightPower    = controls.getRightStick();
    removalToggle = controls.togglePlate();
    sirenToggle   = controls.toggleSiren();
    //upArmPower   = controller.getRightTrigger();
    //downArmPower = controller.getLeftTrigger();

    wheels.manualControl( leftPower , rightPower );
    piston.deployRetract( removalToggle );
    piston.sirenToggle  ( sirenToggle );
    //arm.manualArmControl(downArmPower , upArmPower);
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

//End of Robot class