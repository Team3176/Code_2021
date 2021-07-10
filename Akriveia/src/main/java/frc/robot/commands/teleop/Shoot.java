package frc.robot.commands.teleop;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.constants.BallTransferConstants;
import frc.robot.subsystems.Drum;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Transfer;
import frc.robot.VisionClient;

/**
 * Shoots a power cell, taking control of the Flywheel, Drum, and BallTransfer
 */
public class Shoot extends InstantCommand {
  Drum m_Drum = Drum.getInstance();
  Flywheel m_Flywheel = Flywheel.getInstance();
  Transfer m_Transfer = Transfer.getInstance();
  VisionClient m_VisionClient = VisionClient.getInstance();
  // Hood mAngle = Hood.getInstance();
  // Timer time = new Timer();
  double visionAngle, visionDistanceX;
  
  public Shoot() {
    addRequirements(m_Drum);
    // if (!m_VisionClient.isAtlasOn()) {addRequirements(mFlywheel);}
    addRequirements(m_Transfer);
    addRequirements(m_Flywheel);
    // addRequirements(mAngle);
    // System.out.println("Shoot Created");
  }

  @Override
  public void initialize() {
    // System.out.println("Shoot.initialize executed. ############################################################");
    visionAngle = m_VisionClient.getTargetAngle();
    visionDistanceX = m_VisionClient.getTargetDistanceX();
    m_Drum.pidVelCtrl_setRpmLevel(1);
    // mFlywheel.spinVelocityOutputPercent(1);
    // mAngle.pctCtrl_raiseHoodPosition();
    // if (!m_VisionClient.isAtlasOn()) {mFlywheel.spinVelocityPIDF(5);}
    m_Flywheel.spinVelocityPIDF(8);
    // mTransfer.setPercentControl(BallTransferConstants.BALL_TRANSFER_PERCENT/2);
    // Timer.delay(2);
    m_Transfer.setPercentControl(BallTransferConstants.BALL_TRANSFER_PERCENT);
    // Timer.delay(5);
    // mTransfer.Extend();
    // mAngle.pctCtrl_holdHoodPosition();
  }
}