package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Buttons {
    private static final Joystick joystick = new Joystick(0);

    private static int A = 1;
    private static int B = 2;
    private static int X = 3;
    private static int Y = 4;
    private static int LEFT_BUMPER = 5;
    private static int RIGHT_BUMPER = 6;
    private static int LEFT_STICK_Y = 1;
    private static int RIGHT_STICK_X = 0; // 2 for joystick, 0 for keyboard

    public static JoystickButton joystickAButton = new JoystickButton(joystick, A);
    public static JoystickButton joystickBButton = new JoystickButton(joystick, B);
    public static JoystickButton joystickXButton = new JoystickButton(joystick, X);
    public static JoystickButton joystickYButton = new JoystickButton(joystick, Y);
    public static JoystickButton joystickLeftBumperButton = new JoystickButton(joystick, LEFT_BUMPER);
    public static JoystickButton joystickRightBumperButton = new JoystickButton(joystick, RIGHT_BUMPER);

    public static double getLeftStickY() {
        return -joystick.getRawAxis(LEFT_STICK_Y);
    }
    
    public static double getRightStickX() {
        return -joystick.getRawAxis(RIGHT_STICK_X);
    }
}