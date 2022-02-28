package org.cssudii.klog.loggers

import org.cssudii.klog.Logger

open abstract class DefaultLogger: Logger() {
    override fun isDefault(): Boolean {
        return true
    }
}