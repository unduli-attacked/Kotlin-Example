package frc.robot.subsystems.drive.drive

import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.mathematics.units.nativeunit.NativeUnit
import org.ghrobotics.lib.motors.ctre.FalconSRX

object IntakeSubsystem : FalconSubsystem() {

val intakeMotor: FalconSRX<NativeUnit> = FalconSRX(id = 0, model = DefaultNativeUnitModel)
}