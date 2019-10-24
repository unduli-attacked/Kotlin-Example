package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.VictorSP
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.mathematics.units.nativeunit.NativeUnit
import org.ghrobotics.lib.motors.ctre.FalconSRX

object IntakeSubsystem : FalconSubsystem() {

    val intakeMotor: FalconSRX<NativeUnit> = FalconSRX(5, DefaultNativeUnitModel).apply{
        this.outputInverted = false;
    }

    override fun lateInit() {
        defaultCommand = DriveCommand()
    }
}