package frc.robot.commands.auton;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CrossInitLine extends CommandBase {
    private Drivetrain m_Drivetrain = Drivetrain.getInstance();

    public CrossInitLine() {
        addRequirements(m_Drivetrain);
    }

    @Override
    public void execute() {
        /*
        if(time stuff) {
            drivetrain.drive(some parameters)
        } else if(time stuff) {
            drivetrain.drive(other parameters)
        } else if(more time stuff) {
            driavetrain.state(vision);
            drivetrain.drive(parameters) //but it will stay locked on or something
            shooter.shoot()
        }
        */
    }

    @Override
    public boolean isFinished() {
        return false; //Would normally be a timer checking things
    }

    @Override
    public void end(boolean interrupted) { 

    }
}