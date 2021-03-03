package frc.robot.commands;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
/**
 * <b> Down And Roll Class </b>
 * <p>
 * Creates the command that both pushes the intake down via extending 
 * the pistons and spins the wheels via the motor.
 * @author Caleb Walters
 */
public class DownAndRoll extends CommandBase {
  private final Intake m_Intake = Intake.getInstance();
  /**
   * Add commands from Intake subsystem.
   * @author Caleb Walters
   */
  public DownAndRoll() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_Intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Intake.Extend();
    m_Intake.setPercentControl(Constants.INTAKE_PERCENT);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Intake.Extend();
    m_Intake.setPercentControl(Constants.INTAKE_PERCENT);
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