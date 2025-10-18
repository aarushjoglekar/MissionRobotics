package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class LineFollowing extends Command{
    ReflectiveSensor sensor = ReflectiveSensor.getInstance();
    Drivetrain drive = Drivetrain.getInstance();
    
    public boolean rightDetects() {
        return sensor.rightValue() > 0.7;
    
    }

    public boolean leftDetects() {
        return sensor.leftValue() > 0.7;
    }

    public LineFollowing() {

    }


    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        super.initialize();
    }

    @Override
    public void execute() {
        // TODO Auto-generated method stub
        super.execute();
        if (rightDetects() && leftDetects()) {
            drive.arcadeDrive(1, 0);
        } else if (rightDetects()) {
            drive.arcadeDrive(1, 1);
        } else if (leftDetects()) {
            drive.arcadeDrive(1, -1);
        }
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return (!leftDetects() && !rightDetects());
    }

    @Override
    public void end(boolean interrupted) {
        // TODO Auto-generated method stub
        super.end(interrupted);
    }

}