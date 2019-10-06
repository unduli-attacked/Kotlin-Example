package frc.robot.subsystems.drive

import org.ghrobotics.lib.commands.FalconCommand

class DriveCommand : FalconCommand(DriveSubsystem) {
    override fun isFinished() = false

    override fun initialize() {
        DriveSubsystem.leftMotor.set(0.5)
//        DriveSubsystem.leftFollower.to(DriveSubsystem.leftMotor)
//        set inverted so the travel in the same direction
        DriveSubsystem.rightMotor.set(-0.5)
    }

    override fun execute() {
        super.execute()
    }

    override fun end(interrupted: Boolean) {
        DriveSubsystem.leftMotor.stopMotor()
        DriveSubsystem.rightMotor.stopMotor()
//        DriveSubsystem.leftFollower.stopMotor()
    }
}