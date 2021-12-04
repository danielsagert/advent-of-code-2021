object FileReader {
    fun content(filePath: String) = this::class.java.getResource(filePath)?.readText().orEmpty()
}