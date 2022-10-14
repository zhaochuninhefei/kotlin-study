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
}

/**
 * Sum1
 *
 * @param a
 * @param b
 * @return
 */
fun sum1(a: Int, b: Int): Int {
    return a + b
}


/**
 * Sum2
 *
 * @param a
 * @param b
 */
fun sum2(a: Int, b: Int) = a + b



