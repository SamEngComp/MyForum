package br.com.learing.salessamuel.forum.DTO.Forms

data class TopicRegisterForm (
    val title: String,
    val message: String,
    val courseID: Long,
    val userID: Long
)