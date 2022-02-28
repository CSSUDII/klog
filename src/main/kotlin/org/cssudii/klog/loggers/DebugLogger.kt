package org.cssudii.klog.loggers

import org.cssudii.klog.KLog
import org.cssudii.klog.color.Color

class DebugLogger: DefaultLogger() {
    override fun log(klog: KLog, input: String) {
        if (!klog.debugPrint) return
        log(input, "DEBUG", Color.CYAN_BOLD)
    }
}