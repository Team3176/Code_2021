
package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrain.driveMode;

public class SwerveDefense extends CommandBase {
  private Drivetrain m_Drivetrain = Drivetrain.getInstance();

  public SwerveDefense() {
    addRequirements(m_Drivetrain);
  }

  @Override
  public void initialize() {
    m_Drivetrain.setDriveMode(driveMode.DEFENSE);
  }

  @Override
  public void execute() {
    m_Drivetrain.drive(0.0, 0.0, 0.0);
  }

  @Override
  public boolean isFinished() { return false; }

  @Override
  public void end(boolean interrupted) {  }
}