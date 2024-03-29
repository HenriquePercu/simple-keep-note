package com.example.keep.repository

import io.agroal.api.AgroalDataSource
import jakarta.inject.Singleton
import org.ktorm.database.Database
import org.ktorm.logging.ConsoleLogger
import org.ktorm.logging.LogLevel
import org.ktorm.logging.detectLoggerImplementation

class DatabaseConfig(
    private val dataSource: AgroalDataSource
) {

    @Singleton
    fun init(): Database {
        return Database.connect(
            dataSource = dataSource,
            logger = ConsoleLogger(threshold = LogLevel.DEBUG)
        )

    }

}