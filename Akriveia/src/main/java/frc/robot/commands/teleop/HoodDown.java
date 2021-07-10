package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.constants.HoodConstants;
import frc.robot.subsystems.Hood;

public class HoodDown extends InstantCommand {

  private Hood m_Hood = Hood.getInstance();

  public HoodDown() {
    addRequirements(m_Hood);
  }

  @Override
  public void initialize() {
    // System.out.println("HoodDown.initialize executed. ############################################################");
    /* Gets the current encoder position and see where it should go */
    
    /*
    double temp = m_Hood.getEncoderPosition();
    if(temp <= HoodConstants.pos[1] + 100) {
     m_Hood.setPosition(HoodConstants.pos[0]);
    } else if(temp <= HoodConstants.pos[2] + 100 && temp >= HoodConstants.pos[0] - 100) {
       m_Hood.setPosition(HoodConstants.pos[1]);
    } else if(temp <= HoodConstants.pos[3] + 100 && temp >= HoodConstants.pos[1] - 100) {
     m_Hood.setPosition(HoodConstants.pos[2]);
    } else if(temp <= HoodConstants.pos[4] + 100 && temp >= HoodConstants.pos[2] - 100) {
     m_Hood.setPosition(HoodConstants.pos[3]);
     */

    // m_Hood.goDownToNextHoodPosition_Tic();

    //m_Hood.pctCtrl_lowerHoodPosition();
    // m_Hood.pctCtrl_set(-0.1);
    // int lvl = m_Hood.getSetting();
    // m_Hood.changePos(lvl-1);
    // m_Hood.pctCtrl_lowerHoodPosition();
    m_Hood.moveBottom();
  }
}