package com.weather.domain.database

import android.arch.persistence.room.Room
import android.content.Context
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

private const val DATABASE_NAME = "DatabaseGateway.db"

fun initializeDatabase(context: Context): WeatherDatabase {
    copyDatabaseFileIfNotCreated(context)
    return buildDatabase(context)
}

private fun copyDatabaseFileIfNotCreated(context: Context) {
    context.getDatabasePath(DATABASE_NAME)
        ?.takeUnless { it.exists() }
        ?.let { copy(context, it) }
}


private fun copy(context: Context, databaseFile: File) {
    databaseFile.parentFile.mkdirs()
    context.assets.open(DATABASE_NAME)
        .use { copyByteArray(databaseFile, it) }
}

private fun copyByteArray(databaseFile: File, assetsInputStream: InputStream) {
    FileOutputStream(databaseFile)
        .use { it.write(byteArray(assetsInputStream)) }
}

private fun byteArray(assetsFileInputStream: InputStream) =
    ByteArray(assetsFileInputStream.available())
        .also { assetsFileInputStream.read(it) }


private fun buildDatabase(context: Context) =
    Room.databaseBuilder(context, WeatherDatabase::class.java, DATABASE_NAME).build()