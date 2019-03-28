package com.waether.app.features.samples

// Command Pattern

interface Command {
    fun execute()
}


class Printer : Command {
    override fun execute() {
        print("Printer Command executed")
    }
}

class Writer : Command {
    override fun execute() {
        print("Writer Command executed")
    }
}

class CommandExample() {

    fun mainWithVale(value: Int) {
        if (value == 1) {
            print("Printer Command executed")
        } else if (value == 2) {
            print("Writer Command executed")
        }
        // my own logic
    }

    fun mainWithCommand(command: Command) {
        command.execute()
        // my own logic
    }

}


fun main() {
    val command = Writer()
    val commandExample = CommandExample()
    commandExample.mainWithCommand(Printer())
}


// =================================

// Strategy Pattern

interface StrategyInterface {

    fun doSomething()

    fun doAnotherThing()

}

class Delegate : StrategyInterface {
    override fun doSomething() {
        // do something true implementation
    }

    override fun doAnotherThing() {
        // do another thing true implementation
    }
}

class A(private val delegate: Delegate = Delegate()) : StrategyInterface {
    override fun doSomething() {
        delegate.doSomething()
    }

    override fun doAnotherThing() {
        delegate.doAnotherThing()
    }
}


class B(private val delegate: Delegate = Delegate()) : StrategyInterface {
    override fun doSomething() {
        delegate.doSomething()
    }

    override fun doAnotherThing() {
        delegate.doAnotherThing()
    }
}

class C : StrategyInterface by Delegate()






