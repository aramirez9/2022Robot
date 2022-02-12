package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain {
    WPI_TalonSRX leftLeader;
    WPI_TalonSRX rightLeader;
    WPI_TalonSRX leftFollower;
    WPI_TalonSRX rightFollower;

    Joystick controller;

    DifferentialDrive myDrive;

    double throttleValue;
    //right trigger boosts speed
    int throttleAxis = 3;

    double leftStick;
    double rightStick;

    //double leftEncoder;
    //double rightEncoder;



    

}
