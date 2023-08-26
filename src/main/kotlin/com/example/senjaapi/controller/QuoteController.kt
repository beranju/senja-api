package com.example.senjaapi.controller

import com.example.senjaapi.model.*
import com.example.senjaapi.service.QuoteService
import org.springframework.web.bind.annotation.*

@RestController
class QuoteController(val quoteService: QuoteService) {

    @PostMapping(
        value = ["/api/quotes"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createQuote(@RequestBody body: CreateQuoteRequest): WebResponse<QuoteResponse> {
        val quoteResponse = quoteService.create(body)
        return WebResponse(
            code = 200,
            status = "Ok",
            data = quoteResponse
        )
    }

    @GetMapping(
        value = ["api/quotes/{idQuote}"],
        produces = ["application/json"],
    )
    fun getQuote(@PathVariable("idQuote") id: String): WebResponse<QuoteResponse> {
        val quoteResponse = quoteService.get(id)
        return WebResponse(
            code = 200,
            status = "Ok",
            data = quoteResponse
        )
    }

    @PutMapping(
        value = ["api/quotes/{idQuote}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateQuote(
        @PathVariable("idQuote") id: String,
        @RequestBody updateQuoteRequest: UpdateQuoteRequest
    ): WebResponse<QuoteResponse> {
        val quoteResponse = quoteService.update(id, updateQuoteRequest)
        return WebResponse(
            code = 200,
            status = "Ok",
            data = quoteResponse
        )
    }

    @DeleteMapping(
        value = ["api/quotes/{idQuote}"],
        produces = ["application/json"]
    )
    fun deleteQuote(@PathVariable("idQuote") id: String): WebResponse<String> {
        quoteService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["api/quotes"],
        produces = ["application/json"]
    )
    fun listQuotes(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "10") size: Int
    ): WebResponse<List<QuoteResponse>> {
        val request = ListQuoteRequest(page, size)
        val response = quoteService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

}