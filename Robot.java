// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;


public class Robot extends TimedRobot {
   // Mechanical
   Joystick controller;
   Joystick controller2;
   DriveTrain driveTrain;
   Intake intake;

   // Programming
   NetworkTableInstance table = NetworkTableInstance.getDefault();
   AHRS ahrs;
   double rotateToAngle;
   double currentAngle;
   //Auto useAuto;

   // Auto
   SendableChooser<String> autoChooser = new SendableChooser<>();
   String selectedAutonomous;
   Timer timer;
   

  @Override
  public void robotInit() {

    // Mechanical
    controller = new Joystick(0);
    controller2 = new Joystick(1);
    driveTrain = new DriveTrain(0, 1, 2, 3, 4, 5, controller);
    intake = new Intake(6, controller2);
    

    // Programming
    ahrs = new AHRS(SPI.Port.kMXP);
    //useAuto = new Autonomous();

    autoChooser.addOption("Dump & Escape DR", "Dump & Escape DR");
    autoChooser.setDefaultOption("Do Nothing", "Do Nothing");

    SmartDashboard.putData(autoChooser);
  }


  @Override
  public void disabledPeriodic() {

    

  }

  @Override
  public void robotPeriodic() {


  }

  @Override
  public void autonomousInit() {
    selectedAutonomous = autoChooser.getSelected();
    timer.start();
  }

  @Override
  public void autonomousPeriodic() {
    switch(selectedAutonomous){
      case ("Dump & Escape DR"):
        break;
    }
  }


  @Override
  public void teleopPeriodic() {
    System.out.println("teleop loop");
    //driveTrain.TalonDrive();
    intake.intakeControl();
    driveTrain.TalonDriveNoLimiter();

    /*
    if(controller.getRawAxis(2) > .5) {
      driveTrain.TalonDriveNoLimiter();

    } else {
      driveTrain.TalonDrive();
    }
    */
  }

  
  @Override
  public void testPeriodic() {

  }
  
}
