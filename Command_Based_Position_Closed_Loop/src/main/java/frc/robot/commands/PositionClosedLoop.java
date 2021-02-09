// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Controller;
import frc.robot.subsystems.AngledShooter;

public class PositionClosedLoop extends CommandBase {
  /** Creates a new PositionClosedLoop. */
  public PositionClosedLoop() {
    // Use addRequirements() here to declare subsystem dependencies.
  }
  private AngledShooter m_AngleShooter = new AngledShooter();
  private Controller m_Controller = Controller.getInstance();

  double targetPositonRotations;
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
     targetPositonRotations = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     targetPositonRotations = m_Controller.moveAngleShooter() * 341.333;
      m_AngleShooter._talon.set(ControlMode.Position, targetPositonRotations);
  isFinished();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
