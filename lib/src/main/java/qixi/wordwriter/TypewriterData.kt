package qixi.wordwriter

class TypewriterData : Writer {

    override var startIndex: Int = 0
    override var endIndex: Int = 0
    private var length = 0

    override fun reset(text: String) {
        startIndex = 0
        endIndex = 0
        length = text.length
    }

    override fun hasNext(): Boolean {
        return (startIndex < length)
    }

    override fun next() {
        startIndex = endIndex
        endIndex++
        if (endIndex >= length) {
            endIndex = length
        }
    }

}