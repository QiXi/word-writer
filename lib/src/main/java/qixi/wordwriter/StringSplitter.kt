package qixi.wordwriter

interface Splitter : Iterable<String> {
    fun resetText(string: String)
}

class StringSplitter(var text: String, val delimiter: String = " ") : Splitter, Iterator<String> {
    private var position = 0
    private var length = 0

    fun getCurrentPosition(): Int = position

    override fun resetText(string: String) {
        text = string
        position = 0
        length = string.length
    }

    override fun iterator(): Iterator<String> {
        return this
    }

    override fun hasNext(): Boolean {
        return position < length
    }

    override fun next(): String {
        var end = text.indexOf(delimiter, position)
        end = if (end == -1) length else end + delimiter.length
        val nextString = text.substring(position, end)
        position = end
        return nextString
    }

}