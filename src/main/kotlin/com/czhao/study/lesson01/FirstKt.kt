package com.czhao.study.lesson01

val PI = 3.14
var vx = 0

/**
 * Main FirstKt.kt的主函数
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

    testVariables()

    testClass()

    testStringTemplate()

    print("maxOf(1, 4) : ")
    println(maxOf(1, 4))

    testLoop()

    print("testWhen")
    println(testWhen(Any()))

    testIn(9, 10)
    testIn(10, 10)
    testIn(11, 10)

    testCollections()

    testNullAble(null, "10")
    testNullAble("2", "10")
    testNullAble("a", "10")

    testIs()
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

fun testVariables() {
    // val 用于常量定义，只能赋值一次
    val a: Int = 1
    val b = 2
    val c: Int
    c = 3

    println("a = $a, b = $b, c = $c")

    // var 用于变量定义，可重复赋值
    var x = 5
    x += 1
    println("x = $x")

    vx += 1
    println("vx = $vx; PI = $PI")
}

fun testClass() {
    val rectangle = Rectangle(10.0, 10.0)
    println(rectangle.perimeter)
}

fun testStringTemplate() {
    var a = 1
    // String模板，$x 表示某个变量的值
    val s1 = "a is $a"
    println(s1)

    a = 2
    // ${} 内部支持表达式，表达式可以是一条语句
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun testLoop() {
    val items = listOf("李白", "杜甫", "白居易")
    for (item in items) {
        println("item : $item")
    }

    for (index in items.indices) {
        println("item at $index : ${items[index]}")
    }

    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

fun testWhen(obj: Any) =
    // when 一旦匹配到一个后就不会再做后续分支的判断
    when (obj) {
        1 -> "One"
        "hello" -> "你好"
        is Long -> "类型是Long"
        !is String -> "类型不是String"
        else -> "Unknown"
    }

fun testIn(x: Int, y: Int) {
    // range 范围
    // 相当于 min <= ... <= max，即 [min, max]

    if (x in 1..y) {
        println("$x in $y.")
    } else {
        println("$x not in $y.")
    }

    val list = listOf("a", "b", "c")

    if (x !in 0..list.lastIndex) {
        println("$x is out of range")
    } else {
        println("$x is in range")
    }

    if (list.size !in list.indices) {
        println("list size is out of valid list indices range, too")
    }

    // 遍历 [1, 10]
    for (i in 1..10) {
        print("$i->")
    }
    println()

    // 遍历1到10之间的数字，间隔2
    for (i in 1..10 step 2) {
        print("$i->")
    }

    println()
    // 从9遍历到0，间隔3
    for (i in 9 downTo 0 step 3) {
        print("$i->")
    }
}

fun testCollections() {
    val itemLst = listOf(
        "李白",
        "杜甫",
        "白居易",
        "王维",
        "孟浩然",
        "王昌龄",
        "张九龄",
        "李贺",
        "李商隐",
        "杜牧",
        "刘禹锡",
        "陈子昂",
        "韩愈",
        "贾岛",
        "贺知章"
    )
    // 遍历集合
    for (item in itemLst) {
        println(item)
    }

    val itemSet = setOf(
        "李白",
        "杜甫",
        "白居易",
        "王维",
        "孟浩然",
        "王昌龄",
        "张九龄",
        "李贺",
        "李商隐",
        "杜牧",
        "刘禹锡",
        "陈子昂",
        "韩愈",
        "贾岛",
        "贺知章"
    )
    // 用 in 判断元素是否在集合中存在
    when {
        "苏东坡" in itemSet -> println("苏东坡 是唐朝诗人")
        "李商隐" in itemSet -> println("李商隐 是唐朝诗人")
        // 因为 李商隐 成功匹配，所以这里 王昌龄 的判断分支就不走了。
        "王昌龄" in itemSet -> println("王昌龄 是唐朝诗人")
    }
    // stream操作
    println("姓李的唐朝大诗人有:")
    itemLst
        // 过滤姓李的诗人
        .filter { it.startsWith("李") }
        // 按名字排序
        .sortedBy { it }
        // 转换格式
        .map { "唐朝大诗人: $it" }
        // 输出
        .forEach { println(it) }
}

/**
 * parseInt 转换整数，结果有可能是null
 *
 * 类型后面跟一个"?"表示这个变量有可能是null。
 *
 * @param str 被转换的字符串
 * @return Int?
 */
fun parseInt(str: String?): Int? {
    if (str == null) {
        return null
    }
    return str.toIntOrNull()
}

/**
 * testNullAble
 *
 * @param arg1
 * @param arg2
 */
fun testNullAble(arg1: String?, arg2: String?) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // 直接使用 `x * y` 会导致编译错误，因为它们可能为 null
    if (x != null && y != null) {
        // 在空检测后，x 与 y 会自动转换为非空值（non-nullable）
        println(x * y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

fun testIs() {
    fun getStringLength(obj: Any?): Int? {
        if (obj is String) {
            println("obj: $obj")
            // `obj` 在该条件分支内自动转换成 `String`
            return obj.length
        }
        // 在离开类型检测分支后，`obj` 仍然是 `Any` 类型
        return null
    }

    fun printLength(obj: Any?) {
        println("Getting the length of '$obj'. Result: ${getStringLength(obj) ?: "Error: The object is not a string"} ")
    }

    printLength("天行健君子以自强不息")
    printLength(1000)
    printLength(listOf(Any()))
    val strTest:String? = null
    println("strTest: $strTest")
    printLength(strTest)
}



