// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.linefollowing.LineFollowing;
import frc.robot.commands.linefollowing.TurnUntilLine;
import frc.robot.subsystems.Arm.ArmPosition;

public class AutonPath extends SequentialCommandGroup {
  //This is a sequential command group - all the commands in the addCommands block will run sequentially
  private static final double forwardSpeed = 0.8;
  private static final double turnSpeed = 0.6;
  private static final double turnForwardSpeed = 0.9;
  private static final double rotateSpeed = 0.5;
  private static final double colorValue = 0.67;

  public AutonPath() {
    addCommands(
      new SetArmPosition(ArmPosition.DOWN),
      new WaitCommand(3),
      new LineFollowing(forwardSpeed, turnForwardSpeed, rotateSpeed, colorValue),
      new TurnUntilLine(turnSpeed * -1, colorValue),
      new LineFollowing(forwardSpeed, turnForwardSpeed, rotateSpeed, colorValue),
      new TurnUntilLine(turnSpeed * -1, colorValue),
      new SetArmPosition(ArmPosition.UP),
      new WaitCommand(0.3),
      new LineFollowing(forwardSpeed, turnForwardSpeed, rotateSpeed, colorValue)
    );
  }
}
