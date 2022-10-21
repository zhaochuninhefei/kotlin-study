package com.czhao.study.lesson02

abstract class AbstractTest {
    var name = "initname"
    fun resetName(newName: String) {
        name = newName
    }
    abstract fun handleHello()
    abstract fun sleep()
}