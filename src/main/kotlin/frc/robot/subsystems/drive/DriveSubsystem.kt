package frc.robot.subsystems.drive

import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.mathematics.units.nativeunit.NativeUnit
import org.ghrobotics.lib.motors.ctre.FalconSRX

object DriveSubsystem : FalconSubsystem() {

    val leftMotor: FalconSRX<NativeUnit> = FalconSRX(id = 1, model = DefaultNativeUnitModel)
}