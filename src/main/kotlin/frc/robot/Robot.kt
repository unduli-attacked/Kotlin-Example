
package frc.robot

import frc.robot.subsystems.drive.DriveSubsystem
import frc.robot.subsystems.intake.IntakeSubsystem
import org.ghrobotics.lib.wrappers.FalconTimedRobot

object Robot : FalconTimedRobot() {

    override fun robotInit() {
        // the + operator just adds the FalconSubsystem to the FalconSubsystemHandler
        +DriveSubsystem
        // it's not necessary if the thing isn't a Subsystem or FalconSubsystem
        Controls
        +IntakeSubsystem
        super.robotInit()
    }

    override fun robotPeriodic() {

        // update the buttons the driver might have pressed
        Controls.update()

        super.robotPeriodic()
    }
}

fun main() {
    Robot.start()
}