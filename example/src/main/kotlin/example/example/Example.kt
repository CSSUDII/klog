package example.example

import jline.console.ConsoleReader
import org.cssudii.klog.KLog

class Example {
    private val logger: KLog = KLog()
    private val properties = HashMap<String, String>()

    private var reader = ConsoleReader()

    private fun setProperties() {
        properties["version"] = "1.0-SNAPSHOT"
    }

    private fun getProperty(key: String): String? {
        return properties[key]
    }

    fun test() {
        setProperties()

        // Print debug logs
        // you can set this to only be true if
        // you are in development mode
        // for example
        // if (isInDevMode) exampleLogger.debugPrint = true
        // if set to false all debug messages will not be printed
        logger.debugPrint = true

        // Start example app
        logger
            .debug("**System Debug Info**")
            .debug("OS Name: " + System.getProperty("os.name"))
            .debug("OS Version: " + System.getProperty("os.version"))
            .debug("OS Arch: " + System.getProperty("os.arch"))
            .printNl()
            .debug("**Logger Debug Info**")
            .debug("KLog Version: " + KLog.getProperty("core.version"))
            .printNl()
            .debug("**Project Debug Info**")
            .debug("Version: " + getProperty("version"))

        logger.info("Starting org.cssudii.example.Example App.....")

        reader.prompt = "example> "

        var line: String

        while (reader.readLine().also { line = it } != null) {
            logger.debug("running command: $line")
        }
    }
}

fun main(args: Array<String>) {
    Example().test()
}