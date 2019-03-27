package com.waether.app.features.samples


interface OriginalBehavior {
    fun originalBehavior()
}


interface ExtraBehavior {
    fun optionalBehavior()
}


class Foo : OriginalBehavior {
    override fun originalBehavior() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


class Boo : OriginalBehavior, ExtraBehavior {
    override fun originalBehavior() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun optionalBehavior() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


class MyClass<T>(
    private val behavior: T
) where
T : OriginalBehavior,
T : ExtraBehavior {

    init {
        behavior.originalBehavior()
        behavior.optionalBehavior()
    }

}