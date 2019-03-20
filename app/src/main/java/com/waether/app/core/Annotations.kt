package com.waether.app.core

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
annotation class ContentViewId(val layoutId: Int)