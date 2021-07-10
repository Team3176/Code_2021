// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import java.sql.Driver;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrain.coordType;

public class AutonRotate extends CommandBase {

  private Drivetrain m_Drivetrain = Drivetrain.getInstance();
  private double rotationSpeed;
  private double degrees;
  private double initialAngle;
  private double goal;
  private double currentAngle;

  /** Creates a new AutonRotate. */
  public AutonRotate(double rot, double degrees) {
    addRequirements(m_Drivetrain);
    rotationSpeed = rot;
    this.degrees = degrees;
  }

  @Override
  public void initialize() {
    m_Drivetrain.setCoordType(coordType.FIELD_CENTRIC);
    //initialAngle = -drivetrain.getNavxAngle_inDegrees();
    initialAngle = m_Drivetrain.getNavxAngle_inDegrees();
    //rotation = Math.copySign(rotation, degrees);
    
    //goal = initialAngle + degrees;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Drivetrain.drive(0,0,-rotationSpeed);
    //currentAngle = -drivetrain.getNavxAngle_inDegrees();
    SmartDashboard.putNumber("initialAngle", initialAngle);
    SmartDashboard.putNumber("currentAngle", currentAngle);
    SmartDashboard.putNumber("goal", goal);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  /*public boolean isFinished() {
    if ((degrees >= 0 && currentAngle >= goal) || (degrees < 0 && currentAngle <= goal)) {
      return true;
    }
    return false;
  }*/
  public boolean isFinished() {
    if(rotationSpeed > 0){
    if(m_Drivetrain.getNavxAngle_inDegrees() >= initialAngle + degrees ){
      return true;
    }
  }
  if(rotationSpeed < 0){
    if(m_Drivetrain.getNavxAngle_inDegrees() <= initialAngle + -degrees ){
      return true;
    }
  }
    return false;
  }
}
