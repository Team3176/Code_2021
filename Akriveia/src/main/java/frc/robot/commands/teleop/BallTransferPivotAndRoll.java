package frc.robot.commands.teleop;

import frc.robot.subsystems.Transfer;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.constants.BallTransferConstants;

public class BallTransferPivotAndRoll extends InstantCommand {
  
  private Transfer m_BallTransfer = Transfer.getInstance();
  
  public BallTransferPivotAndRoll() {
    addRequirements(m_BallTransfer);
  }

  @Override
  public void initialize() {
    // System.out.println("BallTransferPivotAndRoll.initialize executed.##########################");
    m_BallTransfer.Retract();
    m_BallTransfer.setPercentControl(0);
  }
}