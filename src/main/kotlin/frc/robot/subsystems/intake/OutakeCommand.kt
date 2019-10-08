package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.GenericHID
import frc.robot.Controls
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.utils.withDeadband
import org.ghrobotics.lib.wrappers.hid.getX
import org.ghrobotics.lib.wrappers.hid.getY

class OutakeCommand : FalconCommand(IntakeSubsystem) {
    override fun isFinished() = false

    override fun initialize() {
        IntakeSubsystem.intakeMotor.setDutyCycle(-1.0)
    }
    override fun end(interrupted: Boolean) {
        IntakeSubsystem.intakeMotor.setNeutral()
    }
}