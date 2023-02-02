package qixi.wordwriter

class WordwriterData(delimiter: String = " ") : Writer {

    override var startIndex: Int = 0
    override var endIndex: Int = 0
    internal val splitter = StringSplitter("", delimiter)

    override fun reset(text: String) {
        splitter.resetText(text)
        startIndex = 0
        endIndex = 0
    }

    override fun hasNext(): Boolean {
        return splitter.hasNext()
    }

    override fun next() {
        splitter.next()
        startIndex = endIndex
        endIndex = splitter.getCurrentPosition()
    }

}