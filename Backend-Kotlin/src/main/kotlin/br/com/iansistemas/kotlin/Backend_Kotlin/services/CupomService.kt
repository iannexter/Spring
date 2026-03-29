package br.com.iansistemas.kotlin.Backend_Kotlin.services

import br.com.iansistemas.kotlin.Backend_Kotlin.databases.entities.CupomEntity
import br.com.iansistemas.kotlin.Backend_Kotlin.databases.repositories.CupomRepository
import br.com.iansistemas.kotlin.Backend_Kotlin.dtos.CupomDto
import org.springframework.stereotype.Service


@Service
class CupomService(

    //injecao de dependencia
    private val repository: CupomRepository

) {

    private val domain = "https://iansistemas.com.br"

    fun click(code: String): String {

        val entity = repository.findByCode(code)

        return entity?.let{

            entity.clicks += 1

            repository.save(entity)
            "$domain/${entity.id}"
        } ?: domain

    }




    //buscar
    fun fetch(code: String): CupomDto?{

        val entity = repository.findByCode(code)

        return entity?.let{

            return CupomDto(

                id = it.id!!,
                code = it.code,
                owner = it.owner,
                clicks = it.clicks


            )

        }


    }

    fun register(code: String, owner: String): CupomDto{

        val entity = CupomEntity(


            //funcao trim -> corta espaços
            code = code.trim(),
            owner = owner.trim(),
            clicks = 0

        )
        //entidade salva
        val savedEntity = repository.save(entity);

        return CupomDto(

            id = savedEntity.id!!,
            code = savedEntity.code,
            owner = savedEntity.owner,
            clicks = savedEntity.clicks


        )


    }

}