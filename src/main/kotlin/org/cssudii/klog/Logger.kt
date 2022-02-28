package org.cssudii.klog

import org.cssudii.klog.color.Color
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

open abstract class Logger {
    abstract fun log(klog: KLog, input: String)
    abstract fun isDefault(): Boolean

    val klog: KLog = KLog.instance

    fun log(input: String, prefix: String, color: Color = klog.color) {
        val toLog = color.toString() + prefix + Color.RESET + " " + input

        if (klog.timestamp) logWithTimeStamp(toLog) else println(toLog)
    }

    private fun logWithTimeStamp(input: String) {
        val timestamp = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneOffset.UTC)
            .format(Instant.now())

        println("$timestamp $input")
    }
}