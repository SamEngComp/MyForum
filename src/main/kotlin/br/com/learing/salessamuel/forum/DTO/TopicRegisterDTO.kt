package br.com.learing.salessamuel.forum.DTO

data class TopicRegisterDTO (
    val title: String,
    val message: String,
    val courseID: Long,
    val userID: Long
)