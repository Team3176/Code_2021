package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drum;


/**
 * Shakes the Drum briefly and stops the Intake.
 */
public class IntakeHarvestReset extends InstantCommand {
  Drum m_Drum = Drum.getInstance();
 

  public IntakeHarvestReset() {
    addRequirements(m_Drum);

  }

  @Override
  public void initialize() {
    // System.out.println("IntakeHarvestReset.initialize executed. ############################################################");
    m_Drum.shakeDrum();
    // mIntake.retractIntake();
    // System.out.println("SPRING");
  }
}
