// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
/**
 * <b> Go Down Class </b>
 * <p>
 * Creates the command that pushes the intake down by extending the pistons.
 * @author Caleb Walters
 */
public class IntakeDown extends CommandBase {
  private final Intake m_Intake = Intake.getInstance();
  /**
   * Add commands from Intake subsystem.
   * @author Caleb Walters
   */
  public IntakeDown() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Intake.Extend();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
