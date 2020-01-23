/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Lights;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;




import frc.robot.subsystems.Lights.Colour;
import frc.robot.OI;
//import frc.robot.commands.LightCommand;
//import frc.robot.commands.DiscoCommand;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static Lights lights;    
  public static OI oi;
  
  //maybe move to a different file
  private final I2C.Port i2cPort = I2C.Port.kOnboard;

  private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);

  private final ColorMatch colorMatcher = new ColorMatch();

  private final Color blueTarget = ColorMatch.makeColor(0.2, 0.5, 0.35);
  private final Color greenTarget = ColorMatch.makeColor(0.2, 0.6, 0.2);
  private final Color yellowTarget = ColorMatch.makeColor(0.4, 0.5, 0.1);
  private final Color redTarget = ColorMatch.makeColor(0.6, 0.3, 0.1);

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    lights = new Lights();
    oi = new OI();

    colorMatcher.addColorMatch(blueTarget);
    colorMatcher.addColorMatch(greenTarget);
    colorMatcher.addColorMatch(yellowTarget);
    colorMatcher.addColorMatch(redTarget);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    Color detectedColor = colorSensor.getColor();
    String colorString;
    ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);
    if (match.confidence * 100 > 95){
      if(match.color == blueTarget){
        colorString = "blue";
        Robot.lights.setBoth(Colour.BLUE);
      }else if(match.color == greenTarget){
        colorString = "green";
        Robot.lights.setBoth(Colour.GREEN);
      }else if(match.color == yellowTarget){
        colorString = "yellow";
        Robot.lights.setBoth(Colour.YELLOW);
      }else if(match.color == redTarget){
        colorString = "red";
        Robot.lights.setBoth(Colour.RED);
      }
    } else {
      colorString = "unknown";
      Robot.lights.setBoth(Colour.PURPLE);
    }
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    
  }
}
