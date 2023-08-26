package com.example.senjaapi.model

import jakarta.validation.constraints.NotBlank

/**
 * tambahkan annotation validation seletelah membuat custom validation util
 *
 * @NotBlank untuk string
 * @NotNull untuk number
 * @Min untuk memberikan nilai minimun pada number
 */
data class CreateQuoteRequest(
    @field:NotBlank
    val id: String?,
    @field:NotBlank
    val text: String?,
    @field:NotBlank
    val author: String?
)
