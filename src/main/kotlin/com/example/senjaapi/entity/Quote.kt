package com.example.senjaapi.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "quotes")
data class Quote(
    @Id
    val id: String,
    @Column(name = "text")
    var text: String,
    @Column(name = "author")
    var author: String
)
