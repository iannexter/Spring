package br.com.iansistemas.kotlin.Backend_Kotlin.databases.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant
import java.util.UUID


@Entity
@Table(
    name = "cupoms",

    //o que isso vai gerar
    //
    // “Cria uma regra chamada uk_cupons_code que
    // garante que os valores da coluna code não se repitam.”
    // CREATE TABLE cupoms (
    //    code VARCHAR(255),
    //    ...
    //    CONSTRAINT uk_cupons_code UNIQUE (code)
    //);
    //INSERT INTO cupoms (code) VALUES ('PROMO10'); -- OK
    //INSERT INTO cupoms (code) VALUES ('PROMO10'); -- ERRO

    uniqueConstraints = [

        UniqueConstraint(name = "uk_cupons_code",
            columnNames = ["code"]),

        UniqueConstraint(name = "uk_cupons_owner",
            columnNames = ["owner"])

    ]



)
class CupomEntity (


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    @Column(nullable = false)
    var code: String,

    @Column(nullable = false)
    var owner: String,

    @Column(nullable = false)
    var clicks: Int,

    @CreationTimestamp
    var createdAt: Instant = Instant.now()

)



//package br.com.iansistemas.kotlin.Backend_Kotlin.databases.entities;
//
//import jakarta.persistence.*;
//import org.hibernate.annotations.CreationTimestamp;
//import java.time.Instant;
//import java.util.UUID;
//
//@Entity
//@Table(
//        name = "cupoms",
//        uniqueConstraints = {
//                @UniqueConstraint(name = "uk_cupons_code", columnNames = "code"),
//                @UniqueConstraint(name = "uk_cupons_owner", columnNames = "owner")
//        }
//)
//public class CupomEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private UUID id;
//
//    @Column(nullable = false)
//    private String code;
//
//    @Column(nullable = false)
//    private String owner;
//
//    @Column(nullable = false)
//    private int clicks;
//
//    @CreationTimestamp
//    private Instant createdAt;
//
//    // Getters e Setters
//    public UUID getId() { return id; }
//    public void setId(UUID id) { this.id = id; }
//
//    public String getCode() { return code; }
//    public void setCode(String code) { this.code = code; }
//
//    public String getOwner() { return owner; }
//    public void setOwner(String owner) { this.owner = owner; }
//
//    public int getClicks() { return clicks; }
//    public void setClicks(int clicks) { this.clicks = clicks; }
//
//    public Instant getCreatedAt() { return createdAt; }
//    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
//}