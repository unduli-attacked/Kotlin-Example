package frc.robot

import edu.wpi.first.wpilibj.Joystick
import frc.robot.subsystems.drive.DriveCommand
import frc.robot.subsystems.drive.IntakeCommand
import org.ghrobotics.lib.wrappers.hid.* // ktlint-disable no-wildcard-imports

object Controls {

    // This is the xbox controller on port 0 of the driverstation
    val driverFalconXbox = xboxController(0) {
        registerEmergencyMode()
        button(kB).change(DriveCommand())
        button(kA).change(IntakeCommand());
    }

    fun update() {
        driverFalconXbox.update() // this polls all the buttons and stuff
    }
}

// just a smol helper that configures emergency mode on an Xbox controller
private fun FalconXboxBuilder.registerEmergencyMode() {
    button(kBack).changeOn {
        Robot.activateEmergency()
    }
    button(kStart).changeOn {
        Robot.recoverFromEmergency()
    }
}