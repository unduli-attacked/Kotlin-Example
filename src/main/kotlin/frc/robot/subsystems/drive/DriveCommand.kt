package frc.robot.subsystems.drive

import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.VictorSP
import frc.robot.Controls
import org.ghrobotics.lib.commands.FalconCommand
import org.ghrobotics.lib.utils.withDeadband
import org.ghrobotics.lib.wrappers.hid.getX
import org.ghrobotics.lib.wrappers.hid.getY



class DriveCommand : FalconCommand(DriveSubsystem){

    override fun isFinished() = false

    override fun initialize() {
        DriveSubsystem.leftMotor.setNeutral()
        DriveSubsystem.rightMotor.setNeutral()
    }

    override fun execute() {
        //negative because Xbox is negative Y when pushed forward
        val forward = -speedSource()  // same as -1 * speedSource.invoke()
        val turn = -rotationSource()

        val wantedLeftOutput = forward + turn
        val wantedRightOutput = forward - turn

        DriveSubsystem.leftMotor.setDutyCycle(wantedLeftOutput)
        DriveSubsystem.rightMotor.setDutyCycle(wantedRightOutput)





    }
    override fun end (interrupted: Boolean){
        DriveSubsystem.leftMotor.setNeutral()
        DriveSubsystem.rightMotor.setNeutral()

    }

    companion object {
        private const val kDeadband = 0.08
        val speedSource by lazy {Controls.driverFalconXbox.getY(GenericHID.Hand.kLeft).withDeadband(kDeadband) }
        val rotationSource by lazy{Controls.driverFalconXbox.getX(GenericHID.Hand.kRight).withDeadband(kDeadband) }
    }


}
