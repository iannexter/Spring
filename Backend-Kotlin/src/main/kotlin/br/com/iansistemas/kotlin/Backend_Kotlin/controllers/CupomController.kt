package br.com.iansistemas.kotlin.Backend_Kotlin.controllers

import br.com.iansistemas.kotlin.Backend_Kotlin.dtos.CupomDto
import br.com.iansistemas.kotlin.Backend_Kotlin.dtos.CupomRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

//
//data class Test(
//
//    val id: String
//
//);

@RestController
class CupomController {


//    @GetMapping("/")
//    fun test(): Test {
//
//        return Test(id = "Hello world");
//    }


    @PostMapping("/register")
    fun post(@RequestBody cupom: CupomRequest): CupomDto {

        return CupomDto(id = "123",
            code = cupom.code,
            owner = cupom.owner,
            clicks = 12)
    }

}