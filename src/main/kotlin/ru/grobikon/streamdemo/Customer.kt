package ru.grobikon.streamdemo

data class Customer(
    var id: Int? = null,
    var name: String? = null,
    var email: String? = null,
    var phoneNumbers: List<String>? = null
)