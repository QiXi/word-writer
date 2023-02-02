package qixi.wordwriter

interface Writer {

    var startIndex: Int
    var endIndex: Int

    fun reset(text: String)
    fun hasNext(): Boolean
    fun next()

}