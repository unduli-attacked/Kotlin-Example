package frc.robot

import frc.robot.subsystems.ExampleCommand
import org.ghrobotics.lib.wrappers.hid.* // ktlint-disable no-wildcard-imports

object Controls {

    var isClimbing = false
        private set

    // This is the xbox controller on port 0 of the driverstation
    val driverFalconXbox = xboxController(0) {
        registerEmergencyMode()

        // basically, this means that when [isClimbing] is false, you are allowed to do the following buttons
        state({ !isClimbing }) {
            // bind buttons here. For example,
            // button(kA).change(MyCommand)

            // This command will run while you hold B
            button(kB).change(ExampleCommand(0.5))

            // This command will start when you press X and run forever, until it's canceled, ends, or Y is pressed.
            button(kX).changeOn(ExampleCommand(0.4).interruptOn { genericHID.getRawButton(kY.value) })
        }
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