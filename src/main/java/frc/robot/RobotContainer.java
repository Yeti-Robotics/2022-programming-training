// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
// import frc.robot.commands.TimeDriveCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

/** 
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

    Joystick leftJoystick, rightJoystick;
    DrivetrainSubsystem drivetrainSubsystem;
    JoystickButton leftButton1, leftButton2;

  public RobotContainer() {
    
    leftJoystick = new Joystick(0);
    rightJoystick = new Joystick(1);
    drivetrainSubsystem = new DrivetrainSubsystem();
    leftButton1 = new JoystickButton(leftJoystick, 1);
    leftButton2 = new JoystickButton(leftJoystick, 2);

    drivetrainSubsystem.setDefaultCommand(new RunCommand(() -> drivetrainSubsystem.drive(-leftJoystick.getY(), -rightJoystick.getY()), drivetrainSubsystem));
    configureButtonBindings();
  }

  private void configureButtonBindings() {
      
  }
}
