package frc.robot.commands.teleop;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.DrivetrainConstants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Drivetrain.coordType;
import frc.robot.subsystems.Drivetrain.driveMode;

public class SwerveDrive extends CommandBase {
  private Drivetrain m_Drivetrain = Drivetrain.getInstance();
  private DoubleSupplier forwardCommand;
  private DoubleSupplier strafeCommand;
  private DoubleSupplier spinCommand;

  private BooleanSupplier isFieldCentric;
  private BooleanSupplier isRobotCentric;
  private BooleanSupplier isBackRobotCentric;

  public SwerveDrive( DoubleSupplier forwardCommand, DoubleSupplier strafeCommand, DoubleSupplier spinCommand,
                      BooleanSupplier isFieldCentric, BooleanSupplier isRobotCentric, BooleanSupplier isBackRobotCentric) {
    this.forwardCommand = forwardCommand;
    this.strafeCommand = strafeCommand;
    this.spinCommand = spinCommand;
    this.isFieldCentric = isFieldCentric;
    this.isRobotCentric = isRobotCentric;
    this.isBackRobotCentric = isBackRobotCentric;
    addRequirements(m_Drivetrain);
  }

  @Override
  public void initialize() {
    m_Drivetrain.setDriveMode(driveMode.DRIVE);
    m_Drivetrain.setSpinLock(false);
  }

  @Override
  public void execute() {

    if(isFieldCentric.getAsBoolean()) {
      m_Drivetrain.setCoordType(coordType.FIELD_CENTRIC);
      m_Drivetrain.setFieldCentricOffset();
    }
    if(isRobotCentric.getAsBoolean()) {
      m_Drivetrain.setCoordType(coordType.ROBOT_CENTRIC);
    }
    if(isBackRobotCentric.getAsBoolean()) {
      m_Drivetrain.setCoordType(coordType.BACK_ROBOT_CENTRIC);
    }
    m_Drivetrain.drive(forwardCommand.getAsDouble() * DrivetrainConstants.MAX_WHEEL_SPEED_FEET_PER_SECOND, strafeCommand.getAsDouble() * DrivetrainConstants.MAX_WHEEL_SPEED_FEET_PER_SECOND, spinCommand.getAsDouble()*10);
  }

  @Override
  public boolean isFinished() { return false; }

  @Override
  public void end(boolean interrupted) {  }
}