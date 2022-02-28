package org.cssudii.klog.loggers

import org.cssudii.klog.KLog
import org.cssudii.klog.color.Color

class WarnLogger: DefaultLogger() {
    override fun log(klog: KLog, input: String) {
        log(input, "WARN", Color.YELLOW_BOLD)
    }
}