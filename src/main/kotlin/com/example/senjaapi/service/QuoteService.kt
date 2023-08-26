package com.example.senjaapi.service

import com.example.senjaapi.model.CreateQuoteRequest
import com.example.senjaapi.model.ListQuoteRequest
import com.example.senjaapi.model.QuoteResponse
import com.example.senjaapi.model.UpdateQuoteRequest

interface QuoteService {

    fun create(createQuoteRequest: CreateQuoteRequest): QuoteResponse

    fun get(id: String): QuoteResponse

    fun update(id: String, updateQuoteRequest: UpdateQuoteRequest): QuoteResponse

    fun delete(id: String)

    fun list(listQuoteRequest: ListQuoteRequest): List<QuoteResponse>

}