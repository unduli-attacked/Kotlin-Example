package frc.robot.subsystems.drive

import frc.robot.Controls
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.wrappers.hid.FalconXboxBuilder
import org.ghrobotics.lib.wrappers.hid.FalconXboxController
import org.ghrobotics.lib.wrappers.hid.button
import org.ghrobotics.lib.wrappers.hid.kStart

class DriveCommand : FalconCommand(DriveSubsystem) {
    override fun isFinished() = false

    override fun initialize() {

        DriveSubsystem.leftMotor.set(0.5)


    }

    override fun end(interrupted: Boolean) {
    }
}