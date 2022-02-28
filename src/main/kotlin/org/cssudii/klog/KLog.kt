package org.cssudii.klog

import org.cssudii.klog.color.Color
import org.cssudii.klog.loggers.DebugLogger
import org.cssudii.klog.loggers.ErrorLogger
import org.cssudii.klog.loggers.InfoLogger
import org.cssudii.klog.loggers.WarnLogger

class KLog() {
    private val loggers = HashMap<String, Logger>()
    open var color: Color = Color.RESET

    private val kLogVersion = "1.0-SNAPSHOT"

    init {
        instance = this
    }

    var debugPrint = false
    var timestamp = true

    init {
        // Add default loggers
        loggers["info"] = InfoLogger()
        loggers["warn"] = WarnLogger()
        loggers["debug"] = DebugLogger()
        loggers["error"] = ErrorLogger()

        setProperty("core.version", kLogVersion)
    }

    fun getLoggerById(loggerID: String): Logger? {
        return loggers[loggerID]
    }

    fun info(input: String): KLog {
        getLoggerById("info")
            ?.log(this, input)
        return this
    }

    fun warn(input: String): KLog {
        getLoggerById("warn")
            ?.log(this, input)
        return this
    }

    fun debug(input: String): KLog {
        getLoggerById("debug")
            ?.log(this, input)
        return this
    }

    fun error(input: String): KLog {
        getLoggerById("error")
            ?.log(this, input)
        return this
    }

    fun printNl(times: Int = 1): KLog {
        repeat(times) {
            println("")
        }
        return this
    }

    companion object {
        lateinit var instance: KLog
            private set

        private val properties = HashMap<String, String>()

        fun getProperty(key: String): String? {
            return properties[key]
        }

        fun setProperty(key: String, value: String) {
            properties[key] = value
        }
    }
}