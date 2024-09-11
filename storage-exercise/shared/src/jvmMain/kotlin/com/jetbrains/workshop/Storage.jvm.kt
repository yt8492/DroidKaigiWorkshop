package com.jetbrains.workshop

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import kotlin.io.path.Path

actual fun persistString(key: String, value: String) {
    val jsonFile = getOrCreateStorageJsonFile()
    val json = jsonFile.bufferedReader().use {
        it.readLines()
            .joinToString("")
    }
    val map = Json.decodeFromString<Map<String, String>>(json)
    val newMap = map.plus(key to value)
    jsonFile.bufferedWriter().use {
        it.write(Json.encodeToString(newMap))
    }
}

private fun getOrCreateStorageJsonFile(): File {
    val appDir = getOrCreateAppDir()
    val storageFile = File(appDir, "storage.json")
    if (!storageFile.exists()) {
        storageFile.createNewFile()
        storageFile.bufferedWriter().use {
            it.write("{}")
        }
    }
    return storageFile
}

private fun getOrCreateAppDir(): File {
    val path = Path(System.getProperty("user.home"), ".storage-exercise")
    val appDir = path.toFile()
    if (!appDir.exists()) {
        appDir.mkdir()
    }
    return appDir
}

actual fun restoreString(key: String): String? {
    val jsonFile = getOrCreateStorageJsonFile()
    val json = jsonFile.bufferedReader().use {
        it.readLines()
            .joinToString("")
    }
    val map = Json.decodeFromString<Map<String, String>>(json)
    return map[key]
}
