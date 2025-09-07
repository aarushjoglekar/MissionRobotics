package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ReflectiveSensor extends SubsystemBase {
    private static ReflectiveSensor mInstance = new ReflectiveSensor();

    public static ReflectiveSensor getInstance() {
        return mInstance;
    }

    private XRPReflectanceSensor sensor;

    private ReflectiveSensor() {
        sensor = new XRPReflectanceSensor();
    }

    public double leftValue() {
        return sensor.getLeftReflectanceValue();
    }

    public double rightValue() {
        return sensor.getRightReflectanceValue();
    }

    @Override
    public void periodic() {
        //Add any prints here
    }
}