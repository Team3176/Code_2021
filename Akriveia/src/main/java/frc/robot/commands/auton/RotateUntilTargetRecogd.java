// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import java.sql.Driver;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auton.AutonRotate;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrain.coordType;
import frc.robot.VisionClient;


/**
 * AutoAlign: A simplistic command class to retrieve the x-angle (tx) formed
 * by the LL crosshairs, the lens, and the recognized target.  It (tx) is then
 * used to call AutoRotate(tx) to rotate the bot until the angle is within the range 
 * formed by upperTxLimit and lowerTxLimit
 */
public class RotateUntilTargetRecogd extends CommandBase{

  private Drivetrain m_Drivetrain = Drivetrain.getInstance();
  private VisionClient m_VisionClient = VisionClient.getInstance();
  private boolean tv;

  /** Creates a new AutonAlign. */
  public RotateUntilTargetRecogd() {
    addRequirements(m_Drivetrain);
  }

  @Override
  public void initialize() {
    m_Drivetrain.setCoordType(coordType.ROBOT_CENTRIC);
    m_VisionClient.turnLEDsOn();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.tv =  m_VisionClient.getTv();
    //new AutonRotate(.1, tx);
    m_Drivetrain.drive(0, 0, .5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      m_Drivetrain.drive(0,0,0);
      m_VisionClient.turnLEDsOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return tv;
  }
}
