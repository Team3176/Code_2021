// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrain.coordType;

public class AutonDrive extends CommandBase {
  /** Creates a new AutonDrive. */

  Timer timer = new Timer();
  private Drivetrain drivetrain = Drivetrain.getInstance();

  public AutonDrive() {
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }
 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    timer.start();
    drivetrain.setCoordType(coordType.ROBOT_CENTRIC);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.drive(.25,0,0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(timer.get() > 2){
      return true;
    }
    return false;
  }
}
