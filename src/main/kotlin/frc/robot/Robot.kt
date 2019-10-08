
package frc.robot

import frc.robot.subsystems.drive.drive.DriveSubsystem
import org.ghrobotics.lib.wrappers.FalconTimedRobot

object Robot : FalconTimedRobot() {

    override fun robotInit() {
        // the + operator just adds the FalconSubsystem to the FalconSubsystemHandler
        +DriveSubsystem
        // it's not necessary if the thing isn't a Subsystem or FalconSubsystem
        Controls

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