// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.AutonPath;
import frc.robot.commands.SetArmPosition;
import frc.robot.commands.linefollowing.LineFollowing;
import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;


public class RobotContainer {
  private final Drivetrain drivetrain = Drivetrain.getInstance();


  public RobotContainer() {
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    // Default command is arcade drive. This will run unless another command
    // is scheduled over it.
    drivetrain.setDefaultCommand(getDriverCommand());
    Buttons.keyboardZButtons.onTrue(new SetArmPosition(ArmPosition.UP));
    Buttons.keyboardXButton.onTrue(new SetArmPosition.DOWN));
    Buttons.keyboardCButton.onTrue(new LineFollowing()); 
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new AutonPath();
  }

  /**
   * Use this to pass the teleop command to the main {@link Robot} class.
   *
   * @return the command to run in teleop
   */
  public Command getDriverCommand() {
    return new ArcadeDrive(
        drivetrain, () -> Buttons.getLeftStickY(), () -> Buttons.getRightStickX());
  }
}
