package org.cssudii.klog.loggers

import org.cssudii.klog.KLog
import org.cssudii.klog.color.Color

class ErrorLogger: DefaultLogger() {
    override fun log(klog: KLog, input: String) {
        log(input, "ERROR", Color.RED_BOLD)
    }
}