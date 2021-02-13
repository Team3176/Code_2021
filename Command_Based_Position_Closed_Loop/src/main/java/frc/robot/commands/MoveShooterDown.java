// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

// import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Controller;
import frc.robot.subsystems.AngledShooter;

public class MoveShooterDown extends CommandBase {
  private AngledShooter m_AngleShooter = AngledShooter.getInstance();
  private Controller m_Controller = Controller.getInstance();
  double targetPositonRotations;

  public MoveShooterDown() {
    addRequirements(m_AngleShooter);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
     if(m_AngleShooter.shooterAngle == 0.0){
       isFinished();
     }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    

    
    if(m_AngleShooter.shooterAngle>=57){
    m_AngleShooter.setRotation(m_AngleShooter._talon.getSelectedSensorPosition() - 57);
    m_AngleShooter.shooterAngle = m_AngleShooter.shooterAngle -57;
    }

    else{
      m_AngleShooter.setRotation((m_AngleShooter._talon.getSelectedSensorPosition() - (57-m_AngleShooter.shooterAngle)));
      System.out.println(m_AngleShooter.shooterAngle);
      m_AngleShooter.shooterAngle = 0.0;
    }
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
  protected void interrupted(){

  }
}
