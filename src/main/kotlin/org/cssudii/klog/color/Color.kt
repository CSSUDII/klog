@file:Suppress("unused")

package org.cssudii.klog.color

enum class Color(
    private val code: String
) {
    RESET("\u001b[0m"),
    BLACK("\u001b[0;30m"),
    RED("\u001b[0;31m"),
    GREEN("\u001b[0;32m"),
    YELLOW("\u001b[0;33m"),
    BLUE("\u001b[0;34m"),
    MAGENTA("\u001b[0;35m"),
    CYAN("\u001b[0;36m"),
    WHITE("\u001b[0;37m"),

    BLACK_BOLD("\u001b[1;30m"),
    RED_BOLD("\u001b[1;31m"),
    GREEN_BOLD("\u001b[1;32m"),
    YELLOW_BOLD("\u001b[1;33m"),
    BLUE_BOLD("\u001b[1;34m"),
    MAGENTA_BOLD("\u001b[1;35m"),
    CYAN_BOLD("\u001b[1;36m"),
    WHITE_BOLD("\u001b[1;37m"),

    BLACK_UNDERLINED("\u001b[4;30m"),
    RED_UNDERLINED("\u001b[4;31m"),
    GREEN_UNDERLINED("\u001b[4;32m"),
    YELLOW_UNDERLINED("\u001b[4;33m"),
    BLUE_UNDERLINED("\u001b[4;34m"),
    MAGENTA_UNDERLINED("\u001b[4;35m"),
    CYAN_UNDERLINED("\u001b[4;36m"),
    WHITE_UNDERLINED("\u001b[4;37m"),

    // Background
    BLACK_BACKGROUND("\u001b[40m"),  // BLACK
    RED_BACKGROUND("\u001b[41m"),  // RED
    GREEN_BACKGROUND("\u001b[42m"),  // GREEN
    YELLOW_BACKGROUND("\u001b[43m"),  // YELLOW
    BLUE_BACKGROUND("\u001b[44m"),  // BLUE
    MAGENTA_BACKGROUND("\u001b[45m"),  // MAGENTA
    CYAN_BACKGROUND("\u001b[46m"),  // CYAN
    WHITE_BACKGROUND("\u001b[47m"),  // WHITE

    BLACK_BRIGHT("\u001b[0;90m"),  // BLACK
    RED_BRIGHT("\u001b[0;91m"),  // RED
    GREEN_BRIGHT("\u001b[0;92m"),  // GREEN
    YELLOW_BRIGHT("\u001b[0;93m"),  // YELLOW
    BLUE_BRIGHT("\u001b[0;94m"),  // BLUE
    MAGENTA_BRIGHT("\u001b[0;95m"),  // MAGENTA
    CYAN_BRIGHT("\u001b[0;96m"),  // CYAN
    WHITE_BRIGHT("\u001b[0;97m"),  // WHITE

    BLACK_BOLD_BRIGHT("\u001b[1;90m"),  // BLACK
    RED_BOLD_BRIGHT("\u001b[1;91m"),  // RED
    GREEN_BOLD_BRIGHT("\u001b[1;92m"),  // GREEN
    YELLOW_BOLD_BRIGHT("\u001b[1;93m"),  // YELLOW
    BLUE_BOLD_BRIGHT("\u001b[1;94m"),  // BLUE
    MAGENTA_BOLD_BRIGHT("\u001b[1;95m"),  // MAGENTA
    CYAN_BOLD_BRIGHT("\u001b[1;96m"),  // CYAN
    WHITE_BOLD_BRIGHT("\u001b[1;97m"),  // WHITE

    BLACK_BACKGROUND_BRIGHT("\u001b[0;100m"),  // BLACK
    RED_BACKGROUND_BRIGHT("\u001b[0;101m"),  // RED
    GREEN_BACKGROUND_BRIGHT("\u001b[0;102m"),  // GREEN
    YELLOW_BACKGROUND_BRIGHT("\u001b[0;103m"),  // YELLOW
    BLUE_BACKGROUND_BRIGHT("\u001b[0;104m"),  // BLUE
    MAGENTA_BACKGROUND_BRIGHT("\u001b[0;105m"),  // MAGENTA
    CYAN_BACKGROUND_BRIGHT("\u001b[0;106m"),  // CYAN
    WHITE_BACKGROUND_BRIGHT("\u001b[0;107m");

    override fun toString(): String {
        return code
    }
}