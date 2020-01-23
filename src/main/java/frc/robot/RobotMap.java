/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;

//import edu.wpi.first.wpilibj.

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  private static final int LEFT_PB_RELAY = 0;
	private static final int LEFT_GR_RELAY = 1;
	private static final int RIGHT_PB_RELAY = 2;
  private static final int RIGHT_GR_RELAY = 3;
  

  public static DigitalInput Switch = new DigitalInput(0);

  public static Relay leftLED_PB = new Relay(LEFT_PB_RELAY, Relay.Direction.kBoth);
	public static Relay leftLED_GB = new Relay(LEFT_GR_RELAY, Relay.Direction.kBoth);
	public static Relay rightLED_PB = new Relay(RIGHT_PB_RELAY, Relay.Direction.kBoth);
	public static Relay rightLED_GR = new Relay(RIGHT_GR_RELAY, Relay.Direction.kBoth);
}
