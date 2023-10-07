package br.com.learing.salessamuel.forum.DTO.Views

import br.com.learing.salessamuel.forum.Domain.Models.TopicStatus
import java.time.LocalDateTime

data class TopicView(
    val id: Long?,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val creationDate: LocalDateTime
)