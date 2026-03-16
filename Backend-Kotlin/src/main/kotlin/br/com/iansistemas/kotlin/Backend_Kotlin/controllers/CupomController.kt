package br.com.iansistemas.kotlin.Backend_Kotlin.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


data class Test(

    val id: String

);

@RestController
class CupomController {


    @GetMapping("/")
    fun test(): Test {

        return Test(id = "Hello world");
    }

}