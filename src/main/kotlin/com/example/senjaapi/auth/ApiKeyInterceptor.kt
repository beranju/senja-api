package com.example.senjaapi.auth

import com.example.senjaapi.error.UnauthorizedException
import com.example.senjaapi.repository.ApiKeyRepository
import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository) : WebRequestInterceptor {
    override fun preHandle(request: WebRequest) {
        // ** cek apakah header request mengandung api key
        val apikey = request.getHeader("X-Api-Key") ?: throw UnauthorizedException()
        // ** cek apakah apikey ada dan validation
        if (!apiKeyRepository.existsById(apikey)) throw UnauthorizedException()

        // valid
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {}

    override fun afterCompletion(request: WebRequest, ex: Exception?) {}
}