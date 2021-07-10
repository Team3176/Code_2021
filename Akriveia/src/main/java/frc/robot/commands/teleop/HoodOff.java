package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Hood;

public class HoodOff extends InstantCommand {
  Hood m_Hood = Hood.getInstance();

  public HoodOff() {
    addRequirements(m_Hood);
  }

  @Override
  public void initialize() {
    // System.out.println("&&&&&&&&&&&&&&&&&&_ANGLED_SHOOTER_0FF_&&&&&&&&&&&&&&&&&&");
    // mHood.pctCtrl_set(0.0);
    m_Hood.pctCtrl_stopHoodMotor();
  }
}
