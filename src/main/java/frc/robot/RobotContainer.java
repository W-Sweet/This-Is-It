// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
//import frc.robot.commands.DriveToDistance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutonomousOne;
import frc.robot.commands.AutonomousTwo;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveTrain m_DriveTrain = new DriveTrain();
  private final DriveWithJoystick driving = new DriveWithJoystick(m_DriveTrain);
  private final AutonomousOne Auto1Sec;
  private final AutonomousTwo Auto2;
  private final DriveForwardTimed driveForwardTimed;
  public static XboxController driverJoystick;
  SendableChooser<Command> chooser = new SendableChooser<>();
 // private final DriveToDistance driveToDistance;


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driving.addRequirements(m_DriveTrain);
    driverJoystick = new XboxController(Constants.JoystickButton);
    m_DriveTrain.setDefaultCommand(driving);
    driveForwardTimed = new DriveForwardTimed(m_DriveTrain);
    Auto1Sec = new AutonomousOne(m_DriveTrain);
    Auto2 = new AutonomousTwo(m_DriveTrain);

    
    SmartDashboard.putData("Auto", chooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return chooser.getSelected();
  }
}