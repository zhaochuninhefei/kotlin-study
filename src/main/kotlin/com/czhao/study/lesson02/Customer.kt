package com.czhao.study.lesson02

/**
 * Customer 创建 DTO（POJO/POCO）
 *
 * @property name
 * @property email
 * @constructor Create empty Customer
 */
data class Customer(val name: String, val sex: String, val email: String) {
    var age: Int = 0
}
