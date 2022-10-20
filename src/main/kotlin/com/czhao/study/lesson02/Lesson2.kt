package com.czhao.study.lesson02

fun main() {
    testCustomer()
    testDefaultParam()
    testMap()
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

fun foo(a: Int = 1, b:String = "") {
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