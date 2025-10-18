// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  public enum ArmPosition {
    UP(110),
    DOWN(0);

    private int angle;

    private ArmPosition(int angle) {
      this.angle = angle;
    }

    private int getAngle() {
      return this.angle;
    }
  }

  private static Arm mInstance = new Arm();

  public static Arm getInstance() {
    return mInstance;
  }

  private final XRPServo motor;

  /** Creates a new Arm. */
  private Arm() {
    motor = new XRPServo(4);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run (about 50 times/second)
  }

  /**
   * Set the current angle of the arm (0 - 180 degrees).
   *
   * @param angleDeg Desired arm angle in degrees
   */
  public void setPos(ArmPosition armPos) {
    motor.setAngle(armPos.getAngle());
  }
}


