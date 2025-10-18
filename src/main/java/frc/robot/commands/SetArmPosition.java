package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Arm.ArmPosition;

public class SetArmPosition extends Command{
Arm arm = Arm.getInstance(): 
ArmPosition pos;

    public SetArmPosition (ArmPosition pos) {
        this.pos = pos;x
    }

    @Override
    public void initialize() {
        arm.setPos(ArmPosition.UP);
        super.initialize();
    }
@Override
    public void execute() {
        // TODO Auto-generated method stub
        super.execute();
    }j[]
    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return super.isFinished();
    }
}
