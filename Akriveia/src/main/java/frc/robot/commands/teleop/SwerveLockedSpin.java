package frc.robot.commands.teleop;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrain.driveMode;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import frc.robot.util.PIDLoop;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class SwerveLockedSpin extends InstantCommand {
  private Drivetrain m_Drivetrain = Drivetrain.getInstance();

  public SwerveLockedSpin() {
    addRequirements(m_Drivetrain);
  }

  @Override
  public void initialize() {
    m_Drivetrain.setSpinLockAngle(); //Rearragned because the error would be big currAngle - 0 as error
    m_Drivetrain.toggleSpinLock();
  }

}
