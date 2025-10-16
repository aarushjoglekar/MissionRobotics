package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class Buttons {
    private static final Joystick joystick = new Joystick(0);

    private static int Z = 1;
    private static int X = 2;
    private static int C = 3;
    private static int V = 4;
    private static int LEFT_BUMPER = 5;
    private static int RIGHT_BUMPER = 6;
    private static int FORWARD_BACK_W_S = 1;
    private static int LEFT_RIGHT_A_D = 0;

    public static JoystickButton keyboardZButton = new JoystickButton(joystick, Z);
    public static JoystickButton keyboardXButton = new JoystickButton(joystick, X);
    public static JoystickButton keyboardCButton = new JoystickButton(joystick, C);
    public static JoystickButton keybordVButton = new JoystickButton(joystick, V);
    public static JoystickButton joystickLeftBumperButton = new JoystickButton(joystick, LEFT_BUMPER);
    public static JoystickButton joystickRightBumperButton = new JoystickButton(joystick, RIGHT_BUMPER);

    public static double getLeftStickY() {
        return -joystick.getRawAxis(FORWARD_BACK_W_S);
    }
    
    public static double getRightStickX() {
        return -joystick.getRawAxis(LEFT_RIGHT_A_D);
    }
}