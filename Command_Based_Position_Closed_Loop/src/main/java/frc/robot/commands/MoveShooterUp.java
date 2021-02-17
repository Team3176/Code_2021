// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.AngledShooter;

public class MoveShooterUp extends CommandBase {
  private AngledShooter m_AngledShooter = AngledShooter.getInstance();
  double targetPositonRotations;

  public MoveShooterUp() {
    addRequirements(m_AngledShooter);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
     if(m_AngledShooter.getShooterAngle() >= 341){
       isFinished();
     }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    if(m_AngledShooter.getShooterAngle() <= 284){
    m_AngledShooter.setPosition(m_AngledShooter.getEncoderPosition() + 57);
    m_AngledShooter.setShooterAngle(m_AngledShooter.getShooterAngle() + 57);
    }

    else{
      m_AngledShooter.setPosition(m_AngledShooter.getEncoderPosition() + (341 - m_AngledShooter.getShooterAngle()));
      m_AngledShooter.setShooterAngle(341);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
