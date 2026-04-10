package br.com.iansistemas.kotlin.Backend_Kotlin.controllers

import br.com.iansistemas.kotlin.Backend_Kotlin.dtos.CupomDto
import br.com.iansistemas.kotlin.Backend_Kotlin.dtos.CupomRequest
import br.com.iansistemas.kotlin.Backend_Kotlin.services.CupomService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
class CupomController(

    private val service: CupomService

) {


//    @GetMapping("/")
//    fun test(): Test {
//
//        return Test(id = "Hello world");
//    }


//    @PostMapping("/register")
//    fun post(@RequestBody cupom: CupomRequest): CupomDto {
//
//        return CupomDto(id = "123",
//            code = cupom.code,
//            owner = cupom.owner,
//            clicks = 12)
//    }


    @GetMapping("/click/{code}")
    fun click(@PathVariable code: String): ResponseEntity<Void> {


        val url = service.click(code)
        return ResponseEntity.status(HttpStatus.FOUND)
            .header(HttpHeaders.LOCATION, url)
            .build()
    }

    @GetMapping("/{code}")
    fun fetch(@PathVariable code: String): CupomDto? {

        return service.fetch(code)

    }



    @PostMapping("/register")
    fun post(@RequestBody cupom: CupomRequest): CupomDto {

        val dto = service.register(cupom.code, cupom.owner)


        return dto;



    }



}




//package br.com.iansistemas.kotlin.Backend_Kotlin.controllers;
//
//import br.com.iansistemas.kotlin.Backend_Kotlin.dtos.CupomDto;
//import br.com.iansistemas.kotlin.Backend_Kotlin.dtos.CupomRequest;
//import br.com.iansistemas.kotlin.Backend_Kotlin.services.CupomService;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class CupomController {
//
//    private final CupomService service;
//
//    public CupomController(CupomService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/click/{code}")
//    public ResponseEntity<Void> click(@PathVariable String code) {
//        String url = service.click(code);
//        return ResponseEntity.status(HttpStatus.FOUND)
//                .header(HttpHeaders.LOCATION, url)
//                .build();
//    }
//
//    @GetMapping("/{code}")
//    public CupomDto fetch(@PathVariable String code) {
//        return service.fetch(code);
//    }
//
//    @PostMapping("/register")
//    public CupomDto post(@RequestBody CupomRequest cupom) {
//        return service.register(cupom.getCode(), cupom.getOwner());
//    }
//}