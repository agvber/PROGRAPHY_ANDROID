package com.agvber.common.coroutine

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class Dispatcher(val dispatcher: AppDispatchers)

enum class AppDispatchers {
    Default,
    IO,
}