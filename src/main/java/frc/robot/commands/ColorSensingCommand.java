/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*
package frc.robot.commands;

//import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.And;

//import java.util.Random;

//import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import frc.robot.RobotMap;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import frc.robot.subsystems.Lights.Colour;


public class ColorSensingCommand extends Command {
  public ColorSensingCommand() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.lights);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
 
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    
    final I2C.Port i2cPort = I2C.Port.kOnboard;

    final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
 
    final ColorMatch colorMatcher = new ColorMatch();
 
    final Color blueTarget = ColorMatch.makeColor(0.2, 0.5, 0.35);
    final Color greenTarget = ColorMatch.makeColor(0.2, 0.6, 0.2);
    final Color yellowTarget = ColorMatch.makeColor(0.4, 0.5, 0.1);
    final Color redTarget = ColorMatch.makeColor(0.6, 0.3, 0.1);

    colorMatcher.addColorMatch(blueTarget);
    colorMatcher.addColorMatch(greenTarget);
    colorMatcher.addColorMatch(yellowTarget);
    colorMatcher.addColorMatch(redTarget);
 
        final Color detectedColor = colorSensor.getColor();
        String colorString;

        final ColorMatchResult match = colorMatcher.matchClosestColor(detectedColor);
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
     
    } 

  }
 
    
    
  

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
} */