// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.HoodConstants;
import frc.robot.subsystems.Hood;

public class HoodPIDTuner extends CommandBase {
  Hood m_Hood= Hood.getInstance();
  public HoodPIDTuner() {
    addRequirements(m_Hood);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Hood.pctCtrl_set(0);
    m_Hood.setPosToHold();
    m_Hood.pctCtrl_lowerHoodPosition();
    Timer.delay(0.5);
    // m_Hood.pctCtrl_set(0);
    m_Hood.posCtrl();
    SmartDashboard.putNumber("TEST kP", HoodConstants.PIDF[0]);
    SmartDashboard.putNumber("TEST kI", HoodConstants.PIDF[1]);
    SmartDashboard.putNumber("TEST kD", HoodConstants.PIDF[2]);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double newP = SmartDashboard.getNumber("TEST kP", HoodConstants.PIDF[0]);
    double newI = SmartDashboard.getNumber("TEST kI", HoodConstants.PIDF[1]);
    double newD = SmartDashboard.getNumber("TEST kD", HoodConstants.PIDF[2]);

    m_Hood.setPID(newP, newI, newD);
    // m_Hood.posCtrl();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
