package com.datechnologies.androidtest.login

import com.beust.klaxon.Klaxon

data class LoginNodeResponse(val code: String, val message: String)

class JsonParser() {

        fun code(json_in: String): String? {
            val result = Klaxon()
                .parse<LoginNodeResponse>(json_in)
            return result?.code
        }

        fun message(json_in: String): String? {
            val result = Klaxon()
                .parse<LoginNodeResponse>(json_in)
            return result?.message
        }


}
