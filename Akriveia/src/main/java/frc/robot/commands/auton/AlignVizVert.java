// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import java.sql.Driver;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.auton.AutonRotate;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drum;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Drivetrain.coordType;
import frc.robot.VisionClient;
import frc.robot.constants.ShootingLookupTables;


/**
 * AutoAlign: A simplistic command class to retrieve the x-angle (tx) formed
 * by the LL crosshairs, the lens, and the recognized target.  It (tx) is then
 * used to call AutoRotate(tx) to rotate the bot until the angle is within the range 
 * formed by upperTxLimit and lowerTxLimit
 */
public class AlignVizVert extends CommandBase {

  private Hood m_Hood = Hood.getInstance();
  private Drum m_Drum = Drum.getInstance();
  private Flywheel m_Flywheel = Flywheel.getInstance();
  private VisionClient m_Visionclient = VisionClient.getInstance();
  double upperDeadbandLimitForVisionclient, lowerDeadbandLimitForVisionclient;
  double distanceToTargetHorz, distanceToTargetVert;
  private double flywheelRPM, HoodPos, DrumVel;
  private boolean iAmDone = false;
  private double ty = 0;

  /** Creates a new AutonAlign. */
  public AlignVizVert() {

    //SUBSYSTEM REQUIREMENTS
    addRequirements(m_Hood);
    addRequirements(m_Drum);
    addRequirements(m_Flywheel);

    //CLASS VARIABLES
    double flywheelRPM, drumVel, HoodPos;
  }

  @Override
  public void initialize() {
    m_Visionclient.turnLEDsOn();
    this.upperDeadbandLimitForVisionclient = 2;
    this.lowerDeadbandLimitForVisionclient = -2;
    iAmDone = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Get Horizontal Distance and Vertical Distances to target from VisionClient
    this.distanceToTargetHorz = m_Visionclient.getDeltaX();
    this.distanceToTargetVert = m_Visionclient.getDeltaY();

    // Convert Horz & Vert distances to indices that can be used with firingLookupTable
    // The Double values are rounded to the nearest Int value.
    int horzIdx = (int) Math.round(this.distanceToTargetHorz);
    int vertIdx = (int) Math.round(this.distanceToTargetVert);

    // Lookup the corresponding values in the ShootingLookupTables at array position [horzIdx, vertIdx]
    this.flywheelRPM = ShootingLookupTables.RPM[horzIdx][vertIdx];
    this.HoodPos = ShootingLookupTables.HOODPOS_for2PosHood[horzIdx][vertIdx];
    this.DrumVel = ShootingLookupTables.DRUMVEL[horzIdx][vertIdx];

    // Set DRUM, FLYWHEEL, & HOOD to appropriate positions
    //m_Hood.
    //m_Flywheel.spinVelocityOutputPercent(8);
    //m_Drum.pidVelCtrl_setRpmLevel(1);




    





    //new AutonRotate(.1, tx);
    SmartDashboard.putNumber("AutonAlign.ty", ty);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      m_Visionclient.turnLEDsOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
      return true;
  }
}
