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


//package br.com.iansistemas.kotlin.Backend_Kotlin.services;
//
//import br.com.iansistemas.kotlin.Backend_Kotlin.databases.entities.CupomEntity;
//import br.com.iansistemas.kotlin.Backend_Kotlin.databases.repositories.CupomRepository;
//import br.com.iansistemas.kotlin.Backend_Kotlin.dtos.CupomDto;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CupomService {
//
//    private final CupomRepository repository;
//    private final String domain = "https://iansistemas.com.br";
//
//    public CupomService(CupomRepository repository) {
//        this.repository = repository;
//    }
//
//    public String click(String code) {
//        CupomEntity entity = repository.findByCode(code);
//        if (entity != null) {
//            entity.setClicks(entity.getClicks() + 1);
//            repository.save(entity);
//            return domain + "/" + entity.getId();
//        }
//        return domain;
//    }
//
//    public CupomDto fetch(String code) {
//        CupomEntity entity = repository.findByCode(code);
//        if (entity != null) {
//            return new CupomDto(
//                    entity.getId(),
//                    entity.getCode(),
//                    entity.getOwner(),
//                    entity.getClicks()
//            );
//        }
//        return null;
//    }
//
//    public CupomDto register(String code, String owner) {
//        CupomEntity entity = new CupomEntity();
//        entity.setCode(code.trim());
//        entity.setOwner(owner.trim());
//        entity.setClicks(0);
//
//        CupomEntity savedEntity = repository.save(entity);
//
//        return new CupomDto(
//                savedEntity.getId(),
//                savedEntity.getCode(),
//                savedEntity.getOwner(),
//                savedEntity.getClicks()
//        );
//    }
//}