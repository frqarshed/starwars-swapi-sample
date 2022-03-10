package com.sample.data.core.extension

import com.sample.data.core.Constants.DATE_PATTERN_DEFAULT_LOCAL
import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String = DATE_PATTERN_DEFAULT_LOCAL, local: Locale = Locale.US): String =
    SimpleDateFormat(pattern, local).format(this)