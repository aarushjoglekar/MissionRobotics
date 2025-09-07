package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class LineFollowing extends Command {
  private Drivetrain drivetrain;
  private ReflectiveSensor reflectiveSensor;
  private double forwardSpeed;
  private double turnForwardSpeed;
  private double rotateSpeed;
  private double colorValue;

  private boolean hasFinishedLineFollow;
  private Timer timer;

  public static boolean leftDetects(ReflectiveSensor sensor, double colorValue) {
    return sensor.leftValue() > colorValue;
  }

  public static boolean rightDetects(ReflectiveSensor sensor, double colorValue) {
    return sensor.rightValue() > colorValue;
  }

  public LineFollowing(double forwardSpeed, double turnForwardSpeed, double rotateSpeed, double colorValue) {
    this.drivetrain = Drivetrain.getInstance();
    this.reflectiveSensor = ReflectiveSensor.getInstance();
    this.forwardSpeed = forwardSpeed;
    this.turnForwardSpeed = turnForwardSpeed;
    this.rotateSpeed = rotateSpeed;
    this.colorValue = colorValue;
    this.timer = new Timer();
    addRequirements(drivetrain, reflectiveSensor);
  }

  @Override
  public void initialize() {
    drivetrain.arcadeDrive(0, 0);
    drivetrain.resetEncoders();
    timer.reset();
    timer.start();
    this.hasFinishedLineFollow = false;
  }

  @Override
  public void execute() {
    if (!hasFinishedLineFollow) {
      // move forward if both sensors detect less light than the color value
      if (leftDetects(reflectiveSensor, colorValue) && rightDetects(reflectiveSensor, colorValue)) {
        drivetrain.arcadeDrive(forwardSpeed, 0);
      } else if (leftDetects(reflectiveSensor, colorValue)) {
        // If swerved too far right and only left sensor detects the tape, move forward
        // and rotate left
        drivetrain.arcadeDrive(turnForwardSpeed, rotateSpeed);
      } else if (rightDetects(reflectiveSensor, colorValue)) {
        drivetrain.arcadeDrive(turnForwardSpeed, -1 * rotateSpeed);
      }
    } else {
      if (timer.hasElapsed(0)) {
        timer.start();
      }
      drivetrain.arcadeDrive(forwardSpeed * 0.7, 0);
    }
  }

  @Override
  public boolean isFinished() {
    // If both sensors do not detect tape, the line following is finished
    if (!hasFinishedLineFollow) {
      hasFinishedLineFollow = !leftDetects(reflectiveSensor, colorValue) && !rightDetects(reflectiveSensor, colorValue);
      return false;
    } else {
      return timer.hasElapsed(0.2);
    }
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
    timer.stop();
  }
}