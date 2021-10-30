// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DrivetrainSubsystem extends SubsystemBase {

    public WPI_TalonFX leftMotor1, leftMotor2, rightMotor1, rightMotor2;

    public DrivetrainSubsystem() {
        leftMotor1 = new WPI_TalonFX(1);
        leftMotor2 = new WPI_TalonFX(2);
        rightMotor1 = new WPI_TalonFX(3);
        rightMotor2 = new WPI_TalonFX(4);
        rightMotor1.setInverted(true);
        rightMotor2.setInverted(true);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftMotor1.set(leftSpeed);
        leftMotor2.set(leftSpeed);
        rightMotor1.set(rightSpeed);
        rightMotor2.set(rightSpeed);
    }
}
