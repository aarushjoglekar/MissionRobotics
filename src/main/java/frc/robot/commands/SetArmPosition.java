package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Arm.ArmPosition;

public class SetArmPosition extends InstantCommand {
    private Arm arm;
    private ArmPosition armPos;

    public SetArmPosition(ArmPosition armPos) {
        this.armPos = armPos;
        this.arm = Arm.getInstance();
        addRequirements(arm);
    }

    @Override
    public void initialize() {
        arm.setPos(armPos);
    }
}
