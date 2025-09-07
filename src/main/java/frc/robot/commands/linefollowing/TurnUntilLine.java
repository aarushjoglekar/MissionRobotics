package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class TurnUntilLine extends Command {
    private Drivetrain drivetrain;
    private ReflectiveSensor reflectiveSensor;
    private double turnSpeed;
    private double colorValue;

    public TurnUntilLine(double turnSpeed, double colorValue) {
        this.drivetrain = Drivetrain.getInstance();
        this.reflectiveSensor = ReflectiveSensor.getInstance();
        this.turnSpeed = turnSpeed;
        this.colorValue = colorValue;
        addRequirements(drivetrain, reflectiveSensor);
    }

    @Override
    public void initialize() {
        drivetrain.arcadeDrive(0, 0);
        drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(0, turnSpeed);
    }

    @Override
    public boolean isFinished() {
        return LineFollowing.leftDetects(reflectiveSensor, colorValue)
                && LineFollowing.rightDetects(reflectiveSensor, colorValue);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0);
    }
}