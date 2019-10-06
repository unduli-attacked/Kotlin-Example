package frc.robot.subsystems.drive

import org.ghrobotics.lib.commands.FalconCommand

class DriveCommand : FalconCommand(DriveSubsystem) {
    override fun isFinished() = false

    override fun initialize() {
        DriveSubsystem.rightMotor.set(0.5)
    }

    override fun end(interrupted: Boolean) {
        DriveSubsystem.rightMotor.set(0.0)
    }
}