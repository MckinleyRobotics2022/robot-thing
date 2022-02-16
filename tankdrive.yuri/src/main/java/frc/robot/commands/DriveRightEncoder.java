// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive;

public class DriveRightEncoder extends CommandBase {
  private final Drive drive;
  private final double speed;
  private final double distanceRight;
  /** Creates a new DriveRightEncoder. */
  public DriveRightEncoder(Drive drive, double speed, double distanceRight) {
    this.drive = drive;
    this.speed = speed;
    this.distanceRight = distanceRight;
    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drive.resetEncodersValues();
    //drive.driveRight(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.driveRightEncoder(distanceRight, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.autoDriveStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}