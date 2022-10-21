package com.czhao.study.lesson02

import java.io.File
import java.lang.IllegalStateException


fun main() {
    testCustomer()
    testDefaultParam()
    testMap()
    testRange()
    testLazy()
    testSingleton()
    testFunExtend()
    testAbstract()
    testIfNullNotNull()
    testWhen()
    testTry()
    testIf(2)
}

fun testCustomer() {
    println()
    println("--- testCustomer ---")
    val customer = Customer("zhangsan", "男", "zhangsan@gitee.com")
    println("customer: $customer , age: ${customer.age}")
    customer.age = 20
    println("customer: $customer , age: ${customer.age}")
    val cus1 = customer.copy(name = "lisi", email = "lisi@gitee.com")
    println("cus1: $cus1 , age: ${cus1.age}")
}

fun testDefaultParam() {
    println()
    println("--- testDefaultParam ---")
    foo()
    foo(2)
    foo(b = "b")
    foo(b = "testb", a = 9)
    foo(10, "bbb")
}

fun foo(a: Int = 1, b: String = "") {
    println("a is $a")
    println("b is $b")
}

fun testMap() {
    println()
    println("--- testMap ---")
    val map = mapOf("李白" to 1, "白居易" to 3, "杜甫" to 2)
    val v1 = map["李白"]
    println("李白: $v1")
    for ((name, order) in map) {
        println("$name -> $order")
    }

    val map2 = mutableMapOf("李白" to 1, "杜甫" to 2, "白居易" to 3)
    var v2 = map2["李白"]
    println("李白: $v2")
    map2["李白"] = 100
    v2 = map2["李白"]
    println("李白: $v2")
}

fun testRange() {
    println()
    println("--- testRange ---")

    println("闭区间: [1, 10]")
    for (i in 1..10) {
        print("$i >")
    }
    println()

    println("半开区间: [1, 10)")
    for (i in 1 until 10) {
        print("$i >")
    }
    println()

    println("闭区间: [1, 10], 步长: 2")
    for (i in 2..10 step 2) {
        print("$i >")
    }
    println()

    println("闭区间: [10, 1]")
    for (i in 10 downTo 1) {
        print("$i >")
    }
    println()

    println("闭区间: [-5, 5]")
    (-5..5).forEach {
        print("$it >")
    }
    println()
}

val p: String by lazy {
    "test" + 100
}

fun testLazy() {
    println()
    println("--- testLazy ---")
    println(p)
}

fun String.myToString(): String {
    return "扩展函数 String.myToString : ${toString()}"
}

fun testFunExtend() {
    println()
    println("--- testFunExtend ---")
    val line = "死去元知万事空"
    println(line.myToString())
}

fun testSingleton() {
    println()
    println("--- testSingleton ---")
    val singleton = SingletonTest
    println("singleton: $singleton, name: ${singleton.name}")
}

fun testAbstract() {
    println()
    println("--- testAbstract ---")
    val who = object : AbstractTest() {
        override fun handleHello() {
            println("Hello, $name")
        }

        override fun sleep() {
            println("$name is sleeping...")
        }
    }
    who.handleHello()
    who.resetName("zhangsan")
    who.sleep()
}

fun testIfNullNotNull() {
    println()
    println("--- testIfNullNotNull ---")

    val files = File("./").listFiles()
    val filesNothing = File("./emptydir").listFiles()

    // if-not-null 缩写
    println("files in curdir : ${files?.size}")

    // if-not-null-else 缩写
    println("files in ./emptydir : ${filesNothing?.size ?: "empty"}")
    val filesSize = files?.size ?: run {
        0
    }
    println("filesSize in ./emptydir : $filesSize")

    // if null 执行一个语句
    files ?: throw IllegalStateException("files is null!")
    filesNothing ?: println("filesNothing is null!")

    // 在可能会空的集合中取第一元素
    println("第一个文件全路径: ${filesNothing?.firstOrNull()?.absoluteFile?.absolutePath}")

    // if not null 执行代码
    filesNothing?.let {
        println("filesNothing is not null!")
    }

    val mapped = filesNothing?.let { it.size + 100 } ?: 100
    println("mapped is $mapped")
}

fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }
}

fun testWhen() {
    println()
    println("--- testIfNullNotNull ---")
    val transformColor = transform("Blue")
    println("color show: $transformColor")
}

fun testTry() {
    println()
    println("--- testTry ---")
    val secondsOneDay = try {
        24 * 60 * 60
    } catch (e: ArithmeticException) {
        throw IllegalStateException(e)
    }
    println("一天有 $secondsOneDay 秒")
}

fun testIf(x: Int) {
    println()
    println("--- testTry ---")
    val y = if (x == 1) {
        "one"
    } else if (x == 2) {
        "two"
    } else {
        "other"
    }
    println("y is $y")
}
