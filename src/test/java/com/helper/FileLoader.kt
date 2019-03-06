package com.helper

import org.springframework.util.ResourceUtils
import java.io.IOException
import java.nio.file.Files

object FileLoader {
    @Throws(IOException::class)
    fun read(filePath: String): String {
        val file = ResourceUtils.getFile(filePath)
        return String(Files.readAllBytes(file.toPath()))
    }
}
