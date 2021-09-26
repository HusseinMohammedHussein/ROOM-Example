package com.husseinmohammed.applyroom.utils

import java.math.BigInteger
import java.security.MessageDigest

// Created by Your name on 9/26/2021.
object Encryption {
    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}