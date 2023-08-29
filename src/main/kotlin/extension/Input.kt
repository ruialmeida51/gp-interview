package extension

fun gpReadLine(isValid: (input: String?) -> Boolean, message: String): String {
    while(true) {
        val readLine = readlnOrNull()

        if (readLine == null || !isValid(readLine)) {
            println(message)
        } else {
            return readLine
        }
    }
}
