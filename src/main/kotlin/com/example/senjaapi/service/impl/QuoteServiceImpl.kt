package com.example.senjaapi.service.impl

import com.example.senjaapi.entity.Quote
import com.example.senjaapi.error.NotFoundException
import com.example.senjaapi.model.CreateQuoteRequest
import com.example.senjaapi.model.ListQuoteRequest
import com.example.senjaapi.model.QuoteResponse
import com.example.senjaapi.model.UpdateQuoteRequest
import com.example.senjaapi.repository.QuoteRepository
import com.example.senjaapi.service.QuoteService
import com.example.senjaapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class QuoteServiceImpl(val quoteRepository: QuoteRepository, val validationUtil: ValidationUtil) : QuoteService {
    override fun create(createQuoteRequest: CreateQuoteRequest): QuoteResponse {
        // ** validate before execute the data
        validationUtil.validate(createQuoteRequest)

        val quote = Quote(
            id = createQuoteRequest.id!!,
            text = createQuoteRequest.text!!,
            author = createQuoteRequest.author!!
        )
        quoteRepository.save(quote)

        return convertQuoteToQuoteResponse(quote)
    }

    override fun get(id: String): QuoteResponse {
        val quote = quoteRepository.findByIdOrNull(id) ?: throw NotFoundException()
        return convertQuoteToQuoteResponse(quote)
    }

    override fun update(id: String, updateQuoteRequest: UpdateQuoteRequest): QuoteResponse {
        val quote = quoteRepository.findByIdOrNull(id) ?: throw NotFoundException()
        validationUtil.validate(updateQuoteRequest)
        quote.apply {
            text = updateQuoteRequest.text!!
            author = updateQuoteRequest.author!!
        }
        quoteRepository.save(quote)
        return convertQuoteToQuoteResponse(quote)
    }

    override fun delete(id: String) {
        val quote = quoteRepository.findByIdOrNull(id) ?: throw NotFoundException()
        quoteRepository.delete(quote)
    }

    override fun list(listQuoteRequest: ListQuoteRequest): List<QuoteResponse> {
        val page = quoteRepository.findAll(PageRequest.of(listQuoteRequest.page, listQuoteRequest.size))
        val quotes: List<Quote> = page.get().collect(Collectors.toList())
        return quotes.map { convertQuoteToQuoteResponse(it) }
    }

    private fun convertQuoteToQuoteResponse(quote: Quote): QuoteResponse =
        QuoteResponse(
            id = quote.id,
            text = quote.text,
            author = quote.author
        )
}