package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.GenericHID
import frc.robot.Controls
import frc.robot.subsystems.drive.DriveSubsystem.leftMotor
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.utils.withDeadband
import org.ghrobotics.lib.wrappers.hid.getX
import org.ghrobotics.lib.wrappers.hid.getY

class DriveCommand : FalconCommand(DriveSubsystem) {
    override fun isFinished() = false

    override fun execute() {
        val forward = -speedSource()
        val turn = -rotationSource()

        val left = forward + turn
        val right = forward - turn

        DriveSubsystem.leftMotor.setDutyCycle(left)
        DriveSubsystem.rightMotor.setDutyCycle(right)
    }

    override fun end(interrupted: Boolean) {
        DriveSubsystem.leftMotor.setNeutral()
        DriveSubsystem.rightMotor.setNeutral()
    }
    companion object {
        private const val kDeadband = 0.08
        val speedSource by lazy { Controls.driverFalconXbox.getY(GenericHID.Hand.kLeft).withDeadband(kDeadband) }
        private val rotationSource by lazy { Controls.driverFalconXbox.getX(GenericHID.Hand.kRight)}
    }
}