package frc.robot.subsystems.intake

import edu.wpi.first.wpilibj.GenericHID
import frc.robot.Controls
import frc.robot.subsystems.drive.DriveSubsystem
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.utils.withDeadband
import org.ghrobotics.lib.wrappers.hid.getX
import org.ghrobotics.lib.wrappers.hid.getY

class OutakeCommand : FalconCommand(IntakeSubsystem) {
   override fun isFinished() = false

    override fun end(interrupted: Boolean){
        IntakeSubsystem.intakeMotor.setNeutral()
    }
    companion object {
        private const val kDeadband = 0.08
        private val rotationSource by lazy { Controls.driverFalconXbox.getX(GenericHID.Hand.kRight) }
    }
}