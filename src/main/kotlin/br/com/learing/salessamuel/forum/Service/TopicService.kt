package br.com.learing.salessamuel.forum.Service

import br.com.learing.salessamuel.forum.DTO.Forms.TopicRegisterForm
import br.com.learing.salessamuel.forum.DTO.Forms.TopicEditForm
import br.com.learing.salessamuel.forum.DTO.Views.TopicView
import br.com.learing.salessamuel.forum.Domain.Models.Topic
import br.com.learing.salessamuel.forum.Mapper.TopicRegisterFormMapper
import br.com.learing.salessamuel.forum.Mapper.TopicViewMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(private var topics: List<Topic> = ArrayList(),
                   private val topicViewMapper: TopicViewMapper,
                   private val topicRegisterFormMapper: TopicRegisterFormMapper) {

    fun lis(): List<TopicView> {
        return this.topics.stream().map {
            t -> topicViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun searchForId(id: Long): TopicView {
        val topic = searchTopicForId(id)
        return topicViewMapper.map(topic)
    }

    fun register(topicRegisterForm: TopicRegisterForm) {
        val topic = topicRegisterFormMapper.map(topicRegisterForm)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
    }

    fun edit(topicEditForm: TopicEditForm) {
        val topic = searchTopicForId(topicEditForm.id)
        topics = topics.minus(topic).plus(Topic(
            id = topic.id,
            title = topicEditForm.title,
            message = topicEditForm.message,
            creationDate = topic.creationDate,
            course = topic.course,
            author = topic.author,
            status = topic.status,
            answers = topic.answers
        ))
    }

    fun delete(id: Long) {
        val topic = searchTopicForId(id)
        topics = topics.minus(topic)
    }

    private fun searchTopicForId(id: Long): Topic {
        return topics.stream().filter({ t -> t.id == id }).findFirst().get()
    }
}