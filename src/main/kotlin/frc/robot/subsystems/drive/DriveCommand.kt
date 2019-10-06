package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.VictorSP
import org.ghrobotics.lib.commands.FalconCommand

class DriveCommand : FalconCommand(DriveSubsystem) {
    override fun isFinished() = false

    override fun initialize() {
        DriveSubsystem.leftMotor.set(0.8)
        DriveSubsystem.rightMotor.set(0.8)
    }

    override fun end(interrupted: Boolean) {
        DriveSubsystem.leftMotor.stopMotor()
        DriveSubsystem.rightMotor.stopMotor()
    }


}