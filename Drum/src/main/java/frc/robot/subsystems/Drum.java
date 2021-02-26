// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import javax.swing.text.Style;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SlewRateLimiter;
import frc.robot.Constants;

public class Drum extends SubsystemBase {
  /** Creates a new Drum. */

  private CANSparkMax drumMotor = new CANSparkMax(Constants.drumMotorCANID, MotorType.kBrushless);
  private CANPIDController drumPIDController;
  private CANEncoder drumEncoder;
  private SlewRateLimiter rateLimiter;
  private static Drum instance = new Drum();
  public boolean drumPctOutputMode = false;
  private boolean isRateLimitOff = false;
  private int lastSetting;
  private int direction = 1;
  private double shakeStartTime = -1;
  private double shakeIterations = 0;

  private double percentOutputSet = 0.0;     // for unused percent output control

  public Drum() {

    // Set defaults and get all Motor components and set type
    // Set PID constants

    drumMotor.restoreFactoryDefaults();
    drumPIDController = drumMotor.getPIDController();
    drumEncoder = drumMotor.getEncoder();

    drumPIDController.setReference(0.0, ControlType.kVelocity);

    rateLimiter = new SlewRateLimiter(Constants.drumKRampRate, 0);

    drumPIDController.setP(Constants.drumKP);
    drumPIDController.setI(Constants.drumKI);
    drumPIDController.setD(Constants.drumKD);
    drumPIDController.setFF(Constants.drumKF);
    drumPIDController.setIZone(Constants.drumKIZone);
    drumPIDController.setOutputRange(Constants.drumKMinOutput, Constants.drumKMaxOutput);

  }

  public void reengageRampLimit() {
    if (isRateLimitOff) {
      rateLimiter.reset(drumEncoder.getVelocity());
      isRateLimitOff = false;
    }
  }

  // hit the hyperdrive!
  public void extremeSpin() {
    reengageRampLimit();
    lastSetting = 4;
    drumPIDController.setReference(rateLimiter.calculate(Constants.drumExtreme), ControlType.kVelocity);
    System.out.println(drumEncoder.getVelocity());
    System.out.println("Extreme run");
  }

  public void highSpin() {
    reengageRampLimit();
    lastSetting = 3;
    drumPIDController.setReference(rateLimiter.calculate(Constants.drumHigh), ControlType.kVelocity);
    System.out.println(drumEncoder.getVelocity());
    System.out.println("High run");
  }

  public void mediumSpin() {
    reengageRampLimit();
    lastSetting = 2;
    drumPIDController.setReference(rateLimiter.calculate(Constants.drumMedium), ControlType.kVelocity);
    System.out.println(drumEncoder.getVelocity());
    System.out.println("Medium run");
  }

  public void lowSpin() {
    reengageRampLimit();
    lastSetting = 1;
    drumPIDController.setReference(rateLimiter.calculate(Constants.drumLow), ControlType.kVelocity);
    System.out.println(drumEncoder.getVelocity());
    System.out.println("Low run");
  }

  // used with the default command to cut power to the drum upon being enabled
  public void drumPowerOff() {
    isRateLimitOff = true;
    lastSetting = 0;
    drumMotor.set(0.0);
    drumEncoder.getVelocity();
    System.out.println("Power off run");
  }

  public boolean shakeDrum() {
    isRateLimitOff = true;
    if (shakeIterations < 10) {
      if (shakeStartTime == -1) {
        drumMotor.set(0.3 * direction);
        shakeStartTime = System.nanoTime() / 1000000;
        direction *= -1;
      }
      if ((System.nanoTime() / 1000000) - shakeStartTime >= 150) {
        drumMotor.set(0.3 * direction);
        direction *= -1;
        shakeIterations += 1;
        shakeStartTime = System.nanoTime() / 1000000;
      }
    } else {
      shakeIterations = 0;
      shakeStartTime = -1;
      direction = 1;
      return true;
    }
    return false;
  }

  public int getLastSetting() {
    return lastSetting;
  }

  public static Drum getInstance() {
    return instance;
  }

  // Periodic NOT USED for now
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  //***** EXPERIMENTAL PERCENT OUTPUT - NOT USED YET *****

  // Percent Output control, runs every loop to print the stuff
  public void percentOutputIncrement() {
    //drumMotor.set(percentOutputSet);
    drumEncoder.getVelocity();
    System.out.println("Percent output run at " + percentOutputSet);
  }

  // called once when the percent is triggered to be increased or decreased
  public void changePercentSet(boolean upDown) {
    if ((upDown == true) && (percentOutputSet < 1.0)) {
      percentOutputSet += 0.05;
    } else if ((upDown == false) && (percentOutputSet > -1.0)) {
      percentOutputSet -= 0.05;
    }
  }

  public void resetPercentSet() {
    percentOutputSet = 0.0;
  }

}
