package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.PowerManagementConstants;
import frc.robot.util.ElectricalData;

public class PowerManagement extends SubsystemBase {
    private PowerDistributionPanel PDP; 
    private static PowerManagement instance = new PowerManagement();

    /* We assume an update rate of 1 update per 0.02 sec; therefore, we collect 5 values in the Current History,
     * which represents a window of 0.1 sec wide (10% of a second).
     * Consider expanding to 15 values which would represent a 0.25sec wide window. */
   
    private ElectricalData HoodPM; 
    private ElectricalData DrumPM; 
   
    public PowerManagement() {
        PDP = new PowerDistributionPanel(PowerManagementConstants.PDP_CAN_ID);
        HoodPM = new ElectricalData(PowerManagementConstants.ANGLED_SHOOTER_PDP_CHANNEL, "Angled Shooter", 5);
        DrumPM = new ElectricalData(PowerManagementConstants.DRUM_PDP_CHANNEL, "Drum", 5);
    }

    public double getHoodInstantAmp() {
        return HoodPM.getInstantaneousAmp();
    }

    public double getHoodAvgAmp() {
        return HoodPM.mean();
    }

    public double getDrumInstantAmp() {
        return DrumPM.getInstantaneousAmp();
    }

    public double getDrumAvgAmp() {
        return DrumPM.mean();
    }

    @Override
    public void periodic() {
        HoodPM.addAmpData();
        DrumPM.addAmpData();
    }

    public void clearFaults() {
        PDP.clearStickyFaults();
    }

    public static PowerManagement getInstance() {
        return instance; 
    }
/**
 * PDP CHANNEL MAP
 * System / Motor / Motor Controller / Encoder? / AmpFuse / CodeName / Slot#(Channel)
 * Swerve	Falcon	TalonFX	TalonFXInternal	40A	D1	1
 * Swerve	Falcon	TalonFX	TalonFXInternal	40A	D2	14
 * Swerve	Falcon	TalonFX	TalonFXInternal	40A	D3	15
 * Swerve	Falcon	TalonFX	TalonFXInternal	40A	D4	0
 * Swerve	775Pro	TalonSRX	Y- Versa	30A	G1	5
 * Swerve	775Pro	TalonSRX	Y- Versa	40A	G2	10
 * Swerve	775Pro	TalonSRX	Y- Versa	30A	G3	11
 * Swerve	775Pro	TalonSRX	Y- Versa	30A	G4	4
 * Intake	775Pro	TalonSRX	Y- Versa	30A	IN	6
 * Shooter	Falcon	N/A	N/A	40A	Shoot	12
 * Hood 	775Pro	TalonSRX	Y- Versa	30A	Angle	8
 * Drum NEO550	SparkMAX	N/A	40A	Drum	3
 * Transfer	775Pro	TalonSRX?	N/A	30A	Trans	9
 * Limelight	N/A	N/A	N/A	5A	LL	7
 * 
 */
}
