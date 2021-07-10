package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drum;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Transfer;

public class ShootReset extends InstantCommand {
  Drum m_Drum = Drum.getInstance();
  Flywheel m_Flywheel = Flywheel.getInstance();
  Transfer m_Transfer = Transfer.getInstance();
  
  public ShootReset() {
    addRequirements(m_Drum);
    addRequirements(m_Flywheel);
    addRequirements(m_Transfer);
  }

  @Override
  public void initialize() {
    // System.out.println("ShootReset.initialize executed. ############################################################");
    m_Drum.pidVelCtrl_set(0);
    m_Flywheel.spinVelocityOutputPercent(0);
    m_Transfer.setPercentControl(0);
    m_Transfer.Retract();
  }
}