package frc.robot.subsystems.drive

import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.mathematics.units.nativeunit.NativeUnit
import org.ghrobotics.lib.motors.ctre.FalconSRX


object DriveSubsystem : FalconSubsystem(){

    val leftMotor: FalconSRX<NativeUnit> = FalconSRX(1, DefaultNativeUnitModel).apply { /* this: FalconSRX<NativeUnit> */
        this.outputInverted = false // TODO Replace me with what you found works for the leftMotor
    }

    val leftFollower: FalconSRX<NativeUnit> = FalconSRX(2, DefaultNativeUnitModel).apply { /* this: FalconSRX<NativeUnit> */
        this.outputInverted = false // TODO Replace me with what you found works for the leftFollower
        this.follow(leftMotor)
    }

    val rightMotor: FalconSRX<NativeUnit> = FalconSRX(3, DefaultNativeUnitModel).apply { /* this: FalconSRX<NativeUnit> */
        this.outputInverted = false // TODO Replace me with what you found works for the rightMotor
    }

    val rightFollower: FalconSRX<NativeUnit> = FalconSRX(4, DefaultNativeUnitModel).apply { /* this: FalconSRX<NativeUnit> */
        this.outputInverted = false // TODO Replace me with what you found works for the rightFollower
        this.follow(rightMotor)
    }

    override fun lateInit() {
        defaultCommand = DriveCommand()
    }

}