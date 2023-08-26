package com.example.senjaapi.repository

import com.example.senjaapi.entity.Quote
import org.springframework.data.jpa.repository.JpaRepository

interface QuoteRepository: JpaRepository<Quote, String> {
}