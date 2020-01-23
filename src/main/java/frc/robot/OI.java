package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//import frc.robot.commands.DiscoCommand;
//import frc.robot.commands.LightCommand;;


public class OI{

    final int L_JOY = 0;

    public Joystick Joystick = new Joystick(L_JOY);
    public Button discoButton = new JoystickButton(Joystick, 7);
    
    public void init(){
        //discoButton.whenPressed(new DiscoCommand());
        //discoButton.whenReleased(new TeamLightCommand());
    }

}