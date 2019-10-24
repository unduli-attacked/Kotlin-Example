package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.VictorSP
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.mathematics.units.nativeunit.NativeUnit
import org.ghrobotics.lib.motors.ctre.FalconSRX

object DriveSubsystem : FalconSubsystem() {

    val leftMotor: FalconSRX<NativeUnit> = FalconSRX(0, DefaultNativeUnitModel).apply {
        this.outputInverted = false
    }
    val leftFollower: FalconSRX<NativeUnit> = FalconSRX(2, DefaultNativeUnitModel).apply{
        this.outputInverted = false;
        this.follow(leftMotor);
    }

    val rightMotor: FalconSRX<NativeUnit> = FalconSRX(1, DefaultNativeUnitModel).apply {
        this.outputInverted = true
    }
    val rightFollower: FalconSRX<NativeUnit> = FalconSRX(3, DefaultNativeUnitModel).apply{
        this.outputInverted = true;
        this.follow(rightMotor)
    }

    val intakeMotor: FalconSRX<NativeUnit> = FalconSRX(5, DefaultNativeUnitModel).apply{
        this.outputInverted = false;
    }
//    val rightFollower: VictorSP = VictorSP(4)

    override fun lateInit() {
        defaultCommand = DriveCommand()
    }
}