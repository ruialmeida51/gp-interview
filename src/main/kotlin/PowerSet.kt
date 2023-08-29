/**
 * Note for the reviewers: this can be done with recursion, and I've tried to implement it with success, not without
 * assistance from dear Google to do so, however, as I recognize I am not the most proficient user of recursive
 * functions.
 * In turn, I chose an iterative approach of my own doing. I'm certain this is not efficient at all, roughly looking
 * it can go as high as O(n^3) taking a look into the drop implementation. I'm sure this can be improved and iterated
 * upon, but I'm not seeing a better solution currently besides recursion which, as said previously, my brain has a
 * hard time implementing on its own 🧪
 */
fun findUniqueSubsetsFor(set: Set<Int>): Set<Set<Int>> {
    // Leverage the Set data structure to avoid duplicate items.
    val uniqueSubsets = mutableSetOf<Set<Int>>()

    if (set.isEmpty()) return setOf(emptySet())

    // The set on its own is a unique subset.
    uniqueSubsets.add(set)

    var droppedCount = 0

    set.dropWhile { droppedNumber ->
        // Add the dropped number itself.
        uniqueSubsets.add(setOf(droppedNumber))

        // Drop the first number and add the remaining numbers to the unique subsets.
        // [1,2,3,4] -> add([2,3,4]) -> add([3,4]) -> add([4]) -> add([])
        val droppedSet = set.drop(++droppedCount).also {
            uniqueSubsets.add(it.toSet())
        }

        // Match the dropped number with each individual number of the remaining numbers in the dropped set.
        // [1] [2,3,4] -> listOf(1, 2); listOf(1,3); listOf(1,4) -> listOf(2,3); listOf(2,4) -> listOf(3,4)
        //
        // AND while (index + 1) is smaller than the size of the (droppedSet - 1), we can also add each number.
        // [1] [2,3,4] -> listOf(1, [2,3]); listOf(1, [2])
        // [2] [3,4] -> Do nothing.
        // This logic might be confusing at first, but it's a small optimization. The logic mentioned above
        // already takes this scenario into account, so no need to waste CPU cycles here.
        droppedSet.forEachIndexed { currentIndex, currentNumber ->
            uniqueSubsets.add(setOf(droppedNumber) + currentNumber)

            val dropLastIndex = currentIndex + 1

            if (dropLastIndex < droppedSet.lastIndex) {
                (uniqueSubsets.add(setOf(droppedNumber) + droppedSet.dropLast(dropLastIndex)))
            }
        }

        // Iterate until you reach the end of the list.
        droppedCount <= set.size
    }

    return uniqueSubsets
}
