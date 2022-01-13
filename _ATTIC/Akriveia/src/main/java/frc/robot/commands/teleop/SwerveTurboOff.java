package frc.robot.commands.teleop;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.constants.DrivetrainConstants;
import frc.robot.subsystems.Drivetrain;

public class SwerveTurboOff extends InstantCommand {
  private Drivetrain m_Drivetrain = Drivetrain.getInstance();


  public SwerveTurboOff() {
    addRequirements(m_Drivetrain);
  }

  @Override
  public void initialize() {
    m_Drivetrain.setTurbo(false);
  }

}
