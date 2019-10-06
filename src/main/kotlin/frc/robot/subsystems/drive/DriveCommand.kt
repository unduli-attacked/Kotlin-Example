package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.GenericHID
import frc.robot.Controls
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.utils.withDeadband
import org.ghrobotics.lib.wrappers.hid.getX
import org.ghrobotics.lib.wrappers.hid.getY

class DriveCommand : FalconCommand(DriveSubsystem) {
    override fun isFinished() = false

    override fun initialize() {
        val forward = -speedSource()
        val turn = rotationSource()

        val wantedLeftOutput = forward + turn
        val wantedRightOutput = forward - turn

        DriveSubsystem.leftMotor.set(wantedLeftOutput)
        DriveSubsystem.rightMotor.set(wantedRightOutput)
    }

    override fun execute() {
        super.execute()
    }

    override fun end(interrupted: Boolean) {
        DriveSubsystem.leftMotor.stopMotor()
        DriveSubsystem.rightMotor.stopMotor()
    }

    companion object {
        private const val kDeadband = 0.05
        val speedSource by lazy { Controls.driverFalconXbox.getY(GenericHID.Hand.kLeft).withDeadband(kDeadband) }
        private val rotationSource by lazy { Controls.driverFalconXbox.getX(GenericHID.Hand.kRight) }
    }
}