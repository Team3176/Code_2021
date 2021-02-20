package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;

public class FlywheelStop extends CommandBase {
  private Flywheel m_Flywheel = Flywheel.getInstance();
  
  public FlywheelStop() {
    addRequirements(m_Flywheel);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {    
    m_Flywheel.spinFlywheel(0);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}