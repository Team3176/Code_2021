// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.AngledShooterConstants;
import frc.robot.subsystems.AngledShooter;

public class AngledShooterPIDTuner extends CommandBase {
  AngledShooter subsystem = AngledShooter.getInstance();
  public AngledShooterPIDTuner() {
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber("TEST kP", AngledShooterConstants.PIDF[0]);
    SmartDashboard.putNumber("TEST kI", AngledShooterConstants.PIDF[1]);
    SmartDashboard.putNumber("TEST kD", AngledShooterConstants.PIDF[2]);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double newP = SmartDashboard.getNumber("TEST kP", AngledShooterConstants.PIDF[0]);
    double newI = SmartDashboard.getNumber("TEST kI", AngledShooterConstants.PIDF[1]);
    double newD = SmartDashboard.getNumber("TEST kD", AngledShooterConstants.PIDF[2]);

    subsystem.setPID(newP, newI, newD);
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
