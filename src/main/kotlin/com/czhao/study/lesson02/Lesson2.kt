package com.czhao.study.lesson02

fun main() {
    testCustomer()
}

fun testCustomer() {
    val customer = Customer("zhangsan", "男", "zhangsan@gitee.com")
    println("customer.toString: $customer , age: ${customer.age}")
    customer.age = 20
    println("customer.toString: $customer , age: ${customer.age}")
}