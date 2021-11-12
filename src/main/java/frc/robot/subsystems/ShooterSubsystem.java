// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  private WPI_TalonFX rightFlywheel;
  private WPI_TalonFX leftFlywheel;
  public double setPoint;
  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    rightFlywheel = new WPI_TalonFX(ShooterConstants.RIGHT_FLYWHEEL);
    leftFlywheel = new WPI_TalonFX(ShooterConstants.LEFT_FLYWHEEL);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
