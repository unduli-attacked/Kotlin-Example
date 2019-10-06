package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.VictorSP
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunit.DefaultNativeUnitModel
import org.ghrobotics.lib.mathematics.units.nativeunit.NativeUnit
import org.ghrobotics.lib.motors.ctre.FalconSRX

object DriveSubsystem : FalconSubsystem() {

    val leftMotor: VictorSP = VictorSP(0).apply {
        this.inverted = false
    }
//    val leftFollower: VictorSP = VictorSP(2)

    val rightMotor: VictorSP = VictorSP(1).apply {
        this.inverted = true
    }
//    val rightFollower: VictorSP = VictorSP(4)

}