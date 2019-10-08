package frc.robot.subsystems.intake

import edu.wpi.first.wpilibj.GenericHID
import frc.robot.Controls
import frc.robot.subsystems.drive.DriveSubsystem.leftMotor
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.utils.withDeadband
import org.ghrobotics.lib.wrappers.hid.getX
import org.ghrobotics.lib.wrappers.hid.getY

class IntakeCommand : FalconCommand(IntakeSubsystem) {
    override fun isFinished() = false

    override fun initialize() {
        //something with speed?
        IntakeSubsystem.intakeMotor.setDutyCycle(1.0)
    }

    override fun end(interrupted: Boolean) {
        IntakeSubsystem.intakeMotor.setNeutral()
    }

    companion object {
        private const val kDeadband = 0.08
        val intakeSource by lazy { Controls.driverFalconXbox.getRawAxis(2).withDeadband(kDeadband) }
    }
}