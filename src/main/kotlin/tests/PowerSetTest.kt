package tests

import findUniqueSubsetsFor

/**
 * Ideally, I'd do this w/ espresso or something. But I believe this will suffice for now.
 */
object PowerSetTest {
    fun runTestSuite(): Boolean {
        return testEmptySet() &&
                testSingleItemInSet() &&
                testDuplicateItemsInSet() &&
                testNoDuplicateItemsInSet()
    }


    private fun testEmptySet(): Boolean {
        val validSubset = findUniqueSubsetsFor(emptySet()) == setOf(emptySet<Int>())
        return validSubset.also { println("🧪 Test empty set: $it") }
    }

    private fun testSingleItemInSet(): Boolean {
        val validSubset = findUniqueSubsetsFor(setOf(1)) == setOf(setOf(1), emptySet())
        return validSubset.also { println("🧪 Test single item in set: $it") }
    }

    private fun testDuplicateItemsInSet(): Boolean {
        val validSubset1 = findUniqueSubsetsFor(setOf(1, 1, 1, 1)) == setOf(setOf(1), emptySet())
        val validSubset2 = findUniqueSubsetsFor(setOf(1, 1, 2, 2)) == setOf(setOf(1, 2), setOf(1), setOf(2), emptySet())

        return (validSubset1 && validSubset2).also { println("🧪 Test single item in set: $it") }
    }

    private fun testNoDuplicateItemsInSet(): Boolean {
        val validSubset1 = findUniqueSubsetsFor(setOf(1,2,3)) == setOf(
            setOf(1),
            setOf(1, 2),
            setOf(1, 3),
            setOf(2),
            setOf(2, 3),
            setOf(3),
            setOf(1, 2, 3),
            emptySet()
        )

        val validSubset2 = findUniqueSubsetsFor(setOf(1,2,3,4)) == setOf(
            setOf(1),
            setOf(1, 2),
            setOf(1, 3),
            setOf(1, 4),
            setOf(2),
            setOf(2, 3),
            setOf(2, 4),
            setOf(3),
            setOf(3, 4),
            setOf(4),
            setOf(1, 2, 3),
            setOf(2, 3, 4),
            setOf(1, 2, 3, 4),
            emptySet()
        )

        val validSubset3 = findUniqueSubsetsFor(setOf(1,2,3,4,5)) == setOf(
            setOf(1),
            setOf(1, 2),
            setOf(1, 3),
            setOf(1, 4),
            setOf(1, 5),
            setOf(2),
            setOf(2, 3),
            setOf(2, 4),
            setOf(2, 5),
            setOf(3),
            setOf(3, 4),
            setOf(3, 5),
            setOf(4),
            setOf(4, 5),
            setOf(5),
            setOf(1, 2, 3),
            setOf(2, 3, 4),
            setOf(3, 4, 5),
            setOf(1, 2, 3, 4),
            setOf(2, 3, 4, 5),
            setOf(1, 2, 3, 4, 5),
            emptySet()
        )

        val validSubset4 = findUniqueSubsetsFor(setOf(1,2,3,4,5, 6)) == setOf(
            setOf(1),
            setOf(1, 2),
            setOf(1, 3),
            setOf(1, 4),
            setOf(1, 5),
            setOf(1, 6),
            setOf(2),
            setOf(2, 3),
            setOf(2, 4),
            setOf(2, 5),
            setOf(2, 6),
            setOf(3),
            setOf(3, 4),
            setOf(3, 5),
            setOf(3, 6),
            setOf(4),
            setOf(4, 5),
            setOf(4, 6),
            setOf(5),
            setOf(5, 6),
            setOf(6),
            setOf(1, 2, 3),
            setOf(2, 3, 4),
            setOf(3, 4, 5),
            setOf(4, 5, 6),
            setOf(1, 2, 3, 4),
            setOf(2, 3, 4, 5),
            setOf(3, 4, 5, 6),
            setOf(1, 2, 3, 4, 5),
            setOf(2, 3, 4, 5, 6),
            setOf(1, 2, 3, 4, 5, 6),
            emptySet()
        )

        return (validSubset1 && validSubset2 && validSubset3 && validSubset4).also {
            println("🧪 Test no duplicate items in set: $it")
        }
    }
}