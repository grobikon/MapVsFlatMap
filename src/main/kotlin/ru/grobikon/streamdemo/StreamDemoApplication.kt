package ru.grobikon.streamdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.stream.Collectors

@SpringBootApplication
class StreamDemoApplication

fun main(args: Array<String>) {
    runApplication<StreamDemoApplication>(*args)

    val customers = getAll()

    //List<Customer> convert => List<String>   -> Data Transformation
    //mapping: customer -> customer.email
    //customer -> customer.email -> сопоставление oneToOne
    val emails = customers.stream()
        .map { customer -> customer.email }
        .collect(Collectors.toList())
    println(emails)

    //Получаем номера телефонов клиентов, т.к у 1 клиента может быть список телефонов map нам вернет список списков телефонов.
    //Нас это не устраивает мы хотим получить 1 список телефонов.
    //customer -> customer.phoneNumbers -> сопоставление oneToMany
    val phoneNumbersMap: List<List<String>?> = customers.stream()
        .map { customer -> customer.phoneNumbers }
        .collect(Collectors.toList())

    println(phoneNumbersMap)


    //List<Customer> convert => List<String>   -> Data Transformation
    //mapping: customer -> phone Numbers
    //customer -> customer.phoneNumbers -> сопоставление oneToMany
    val phoneNumbersFlatMap: List<String> = customers.stream()
        .flatMap { customer -> customer.phoneNumbers?.stream() }    //преобразует несколько списков в 1 список
        .collect(Collectors.toList())

    println(phoneNumbersFlatMap)
}
