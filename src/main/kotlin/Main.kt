fun main() {
    // Запрос количества строк и столбцов
    print("Введите количество строк: ")
    val rows = readLine()!!.toInt()
    print("Введите количество столбцов: ")
    val columns = readLine()!!.toInt()

    // Создание двумерного массива
    val array = Array(rows) { IntArray(columns) }

    // Заполнение массива трехзначными числами
    println("Введите $rows строки по $columns трехзначных чисел:")
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            array[i][j] = readLine()!!.toInt()
        }
    }

    // Подсчет количества различных цифр
    val digits = mutableSetOf<Int>()
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            val number = array[i][j]
            digits.addAll(getDigits(number))
        }
    }

    // Вывод двумерного массива и количество различных цифр
    println("Двумерный массив:")
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            print("${array[i][j]}\t")
        }
        println()
    }
    println("В массиве использовано ${digits.size} различных цифр")
}

fun getDigits(number: Int): Set<Int> {
    val digits = mutableSetOf<Int>()
    var n = number
    while (n != 0) {
        val digit = n % 10
        digits.add(digit)
        n /= 10
    }
    return digits
}
