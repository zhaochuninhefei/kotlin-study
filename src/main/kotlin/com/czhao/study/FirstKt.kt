package com.czhao.study

/**
 * Main
 *
 * @param args
 */
fun main(args: Array<String>) {
    println("Hello, kotlin!")
    println("args:" + args.contentToString())

    print("sum(1, 4) : ")
    println(sum1(1, 4))

    print("sum2(1, 4) : ")
    println(sum2(1, 4))

    print("printSum(1, 4) : ")
    printSum(1, 4)

    print("printSum2(1, 4) : ")
    printSum2(1, 4)
}

/**
 * Sum1 显式声明返回类型的函数
 *
 * @param a
 * @param b
 * @return
 */
fun sum1(a: Int, b: Int): Int {
    return a + b
}


/**
 * Sum2 没有函数体，直接用表达式赋值的函数。
 * 其返回类型能够从表达式推断出来，可以不显式声明。(但显式声明也可以。)
 *
 * @param a
 * @param b
 */
fun sum2(a: Int, b: Int) = a + b

/**
 * Print sum 没有返回值的函数，可以显式声明返回类型为Unit，也可以不声明。
 *
 * @param a
 * @param b
 */
fun printSum(a: Int, b: Int) {
    print("sum of $a and $b is ${a + b}\n")
}

/**
 * Print sum2 没有返回值的函数，也可以用表达式赋值。
 *
 * @param a
 * @param b
 */
fun printSum2(a: Int, b: Int) = print("sum of $a and $b is ${a + b}\n")

