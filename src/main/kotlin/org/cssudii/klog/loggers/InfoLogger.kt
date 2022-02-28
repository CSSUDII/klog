package org.cssudii.klog.loggers

import org.cssudii.klog.KLog
import org.cssudii.klog.color.Color

class InfoLogger: DefaultLogger() {
    override fun log(klog: KLog, input: String) {
        log(input, "INFO", Color.GREEN_BOLD)
    }
}