// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.teleop;
import frc.robot.subsystems.BallTransfer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;


public class BallTransferStraight extends InstantCommand {
  private BallTransfer m_BallTransfer = BallTransfer.getInstance();
  
  public BallTransferStraight() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_BallTransfer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // m_BallTransfer.Extend();
    m_BallTransfer.setPercentControl(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
//  @Override
//  public void execute() {}

  // Called once the command ends or is interrupted.
//  @Override
//  public void end(boolean interrupted) {}

  // Returns true when the command should end.
//  @Override
//  public boolean isFinished() {
//    return false;
//  }
}
