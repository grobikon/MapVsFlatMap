package ru.grobikon.streamdemo

import java.util.stream.Collectors
import java.util.stream.Stream

/**
 * Вернет список клиентов
 */
fun getAll(): List<Customer> {
    return Stream.of(
        Customer(101, "john", "john@gmail.com", listOf("397937955", "21654725")),
        Customer(102, "smith", "smith@gmail.com", listOf("89563865", "2487238947")),
        Customer(103, "peter", "peter@gmail.com", listOf("38946328654", "3286487236")),
        Customer(104, "kely", "kely@gmail.com", listOf("389246829364", "948609467"))
    ).collect(Collectors.toList())
}