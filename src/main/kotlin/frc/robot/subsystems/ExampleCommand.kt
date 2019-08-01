package frc.robot.subsystems

import edu.wpi.first.wpilibj.experimental.command.Command
import org.ghrobotics.lib.commands.FalconCommand

/**
 * This example command takes one argument, [output], and reserves the
 * use of [ExampleSubsystem]. See the documentation of this's base class,
 * [Command], by command (mac) or ctrl (windows) + clicking on orange names
 * like [Command].
 */
class ExampleCommand(val output: Double) : FalconCommand(ExampleSubsystem) {

    override fun execute() { ExampleSubsystem.motorOutput = output }

    override fun end(interrupted: Boolean) { ExampleSubsystem.motorOutput = 0.0 }

    override fun isFinished(): Boolean = false
}