package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.VictorSP
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.mathematics.units.nativeunit.NativeUnit
import org.ghrobotics.lib.motors.ctre.FalconSRX

object DriveSubsystem : FalconSubsystem() {

    val leftMotor: FalconSRX<NativeUnit> = FalconSRX(id = 1, model = DefaultNativeUnitModel)
    val leftFollower: FalconSRX<NativeUnit> = FalconSRX(id = 2, model = DefaultNativeUnitModel).apply {
        follow(leftMotor)
    }
    val rightMotor: FalconSRX<NativeUnit> = FalconSRX(id = 3, model = DefaultNativeUnitModel).apply {
    this.outputInverted = true
    }
    val rightFollower: FalconSRX<NativeUnit> = FalconSRX(id = 4, model = DefaultNativeUnitModel).apply {
        this.outputInverted = true
        follow(rightMotor)
    }
    override fun lateInit() {
        defaultCommand = DriveCommand()
    }
}