// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */
  private WPI_TalonFX leftFalcon1, leftFalcon2, rightFalcon1, rightFalcon2;

  private PigeonIMU gyro;

  //drive
  public final DifferentialDrive m_drive;

  private Drivemode drivemode;
  public enum Drivemode{
    TANK, CHEEZY, ARCADE;
  }


  public DrivetrainSubsystem() {
    leftFalcon1 = new WPI_TalonFX(DriveConstants.LEFT_FALCON_1);
    leftFalcon2 = new WPI_TalonFX(DriveConstants.LEFT_FALCON_2);
    rightFalcon1 = new WPI_TalonFX(DriveConstants.RIGHT_FALCON_1);
    rightFalcon2 = new WPI_TalonFX(DriveConstants.RIGHT_FALCON_2);
    leftFalcon2.follow(leftFalcon1);
    leftFalcon2.setInverted(InvertType.FollowMaster);
    rightFalcon2.follow(rightFalcon1);
    rightFalcon2.setInverted(InvertType.FollowMaster);

    m_drive = new DifferentialDrive(leftFalcon1, rightFalcon1);
    m_drive.setDeadband(0.05);
    gyro = new PigeonIMU(DriveConstants.GYRO_ID);
    driveMode = Drivemode.CHEEZY;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void tankDrive(double leftpower, double rightpower) {
    m_drive.tankDrive(leftpower,rightpower);
  }
  public void cheezyDrive(double straight, double turn){
    m_drive.curvatureDrive(straight -turn, false);
  }

  public void arcadeDrive(double straight, double turn){
    m_drive.arcadeDrive(straight, -turn);
  }

  public void stopDrive() {
    leftFalcon1.set(ControlMode.PercentOutput, 0);
    rightFalcon1.set(ControlMode.PercentOutput, 0);
  }
  
  public void resetEncoders() {
    leftFalcon1.setSelectedSensorPosition(0);
    rightFalcon1.setSelectedSensorPosition(0);
  }
}