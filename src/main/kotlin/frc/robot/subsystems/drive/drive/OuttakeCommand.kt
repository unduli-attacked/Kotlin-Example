//package frc.robot.subsystems.drive.drive
//
//
//import edu.wpi.first.wpilibj.GenericHID
//import frc.robot.Controls
//import org.ghrobotics.lib.commands.FalconCommand
//import org.ghrobotics.lib.utils.withDeadband
//import org.ghrobotics.lib.wrappers.hid.getX
//import org.ghrobotics.lib.wrappers.hid.getY
//
//
//class OuttakeCommand : FalconCommand(IntakeSubsystem) {
//    override fun isFinished() = false
//
//    override fun initialize() {
//        IntakeSubsystem.intakeMotor.setDutyCycle(1.0)
//    }
//    override fun end(interrupted: Boolean) {
//        IntakeSubsystem.intakeMotor.setNeutral()
//    }
//    companion object {
//        private const val kDeadband = 0.05
//        private val rotationSource by lazy { Controls.driverFalconXbox.getX(GenericHID.Hand.kRight) }
//
//    }
//}