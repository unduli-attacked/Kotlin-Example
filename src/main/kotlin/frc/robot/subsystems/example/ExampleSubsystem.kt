package frc.robot.subsystems.example

import frc.robot.Constants
import org.ghrobotics.lib.commands.FalconSubsystem
import org.ghrobotics.lib.mathematics.units.nativeunits.DefaultNativeUnitModel
import org.ghrobotics.lib.motors.ctre.FalconSRX
import org.ghrobotics.lib.subsystems.EmergencyHandleable
import kotlin.properties.Delegates

/**
 * A simple example subsystem. It extends both [FalconSubsystem] and [EmergencyHandleable]
 * This means that the robot can put it into emergency mode to disable for example closed
 * loop outputs. FalconSubsystem also has methods for resetting the subsystem on the transitions
 * between different times of the match
 */
object ExampleSubsystem : FalconSubsystem(), EmergencyHandleable {

    // declare your member variables here
    // They'll be instantiated when this subsystem is first called
    private val motor = FalconSRX(Constants.DriveConstants.motorID, DefaultNativeUnitModel)

    /**
     * In this example, whenever a user calls, for example, motorOutput = 1, the setter will be called
     * In java, the set(value) is like calling a setMotorOutput(value) method. Whenever a user sets the
     * motorOutput, the motor is set to the new value and the "backing field" (member variable, like the
     * motorOutput variable in java hidden behind a getter/setter) is set to the new value. Both get()
     * and set() can be overridden like this, and a backing property need not exist.
     */
    var motorOutput: Double = 0.0
        set(value) {
            motor.setDutyCycle(value)
            field = value
        }

    /**
     * In this example, whenever the output is set to a number different than it used to be,
     * the supplied function in the {} is run. In this case, we set the motor to the new value
     */
    var output by Delegates.observable(0.0) {
        _, _, newValue -> motor.setDutyCycle(newValue)
    }

    override fun lateInit() {
        defaultCommand = ExampleCommand(0.5)
        super.lateInit()
    }

    /**
     * Overriding and declaring functions can be done with {} blocks, or just the equals sign for a
     * single assignment.
     */
    override fun setNeutral() = motor.setNeutral()

    /**
     * When the robot goes into "Emergency" mode, this method will be called. Useful for
     * arms or elevators
     */
    override fun activateEmergency() { motor.setNeutral() }
    override fun recoverFromEmergency() { }
}