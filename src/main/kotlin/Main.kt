import extension.gpReadLine
import tests.PowerSetTest

/**
 * Given a set (i.e., no duplicate) of integer numbers, e.g. [1, 3, 2, 4], write a function
 * that returns all unique subsets of the given set.
 * - Set A is a subset of a set B if all elements of A are also elements of B.
 * - It is possible for A and B to be equal.
 * - It is possible for A and B to be empty.
 * - By definition, order of elements in a set is not important, e.g., [1, 2] and [2, 1] are
 * considered the same set. The output of the function should contain all unique
 * subsets of the input set, in any order the candidate chooses.
 * Please include the test cases you used for your solution.
 */

fun main() {
    println("-- GymPass Exercise 🚀 --")
    println("📝 Please input a set of numbers separated by comma. E.g: 1,2,3,4")

    val set = gpReadLine(
        isValid = ::isUserSetInputValid,
        message = "💥 Format invalid. Please enter a set of numbers separated by comma. E.g: 1,2,3,4"
    )
        .split(",")
        .mapNotNull { it.toIntOrNull() }
        .toSet()

    println("🪄 These are all the unique subsets that we found: ")
    println(findUniqueSubsetsFor(set).joinToString())

    println("\n🧪 Executing tests...")
    if (PowerSetTest.runTestSuite()) {
        println("🧪 Test suite ran successfully.")
    } else {
        println("💥 Test suite failed.")
    }
}


private fun isUserSetInputValid(input: String?): Boolean = input.orEmpty().matches("^[0-9,]*$".toRegex())



