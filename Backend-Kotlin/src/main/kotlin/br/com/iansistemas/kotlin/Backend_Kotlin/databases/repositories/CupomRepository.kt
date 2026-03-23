package br.com.iansistemas.kotlin.Backend_Kotlin.databases.repositories

import br.com.iansistemas.kotlin.Backend_Kotlin.databases.entities.CupomEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CupomRepository: JpaRepository<CupomEntity, UUID> {

    fun findByCode(code: String): CupomEntity?

}