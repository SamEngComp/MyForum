package br.com.learing.salessamuel.forum.DTO.Forms

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicRegisterForm (
    @field:NotEmpty
    @field:Size(min = 5, max = 10)
    val title: String,

    @field:NotEmpty
    val message: String,

    @field:NotNull
    val courseID: Long,

    @field:NotNull
    val userID: Long
)