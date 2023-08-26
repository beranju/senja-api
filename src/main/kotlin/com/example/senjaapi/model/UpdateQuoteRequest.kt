package com.example.senjaapi.model

import jakarta.validation.constraints.NotBlank

data class UpdateQuoteRequest(
    @field:NotBlank
    val text: String?,
    @field:NotBlank
    val author: String?
)
