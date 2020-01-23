/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

//import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.And;

//import java.util.Random;

import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.subsystems.Lights.Colour;


public class LightCommand extends Command {
  public LightCommand() {
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
    DriverStation.Alliance color;
    color = DriverStation.getInstance().getAlliance();
    if(Robot.oi.discoButton.get()){
      
      final double seconds = 0.5;
      Robot.lights.setBoth(Colour.RED);
      Timer.delay(seconds);
      Robot.lights.setBoth(Colour.YELLOW);
      Timer.delay(seconds);
      Robot.lights.setBoth(Colour.PURPLE);
      Timer.delay(seconds);
      Robot.lights.setBoth(Colour.WHITE);
      Timer.delay(seconds);
      Robot.lights.setBoth(Colour.GREEN);
      Timer.delay(seconds);
    }
    else if(color == DriverStation.Alliance.Blue){
      Robot.lights.setBoth(Colour.BLUE);

    }
    else if(color == DriverStation.Alliance.Red){
      Robot.lights.setBoth(Colour.RED);
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
}