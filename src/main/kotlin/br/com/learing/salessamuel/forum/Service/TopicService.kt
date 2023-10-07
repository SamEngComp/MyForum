package br.com.learing.salessamuel.forum.Service

import br.com.learing.salessamuel.forum.DTO.Forms.TopicRegisterForm
import br.com.learing.salessamuel.forum.DTO.Views.TopicView
import br.com.learing.salessamuel.forum.Domain.Models.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(private var topics: List<Topic> = ArrayList(),
                   private val courseService: CourseService,
                   private val userService: UserService) {

    fun lis(): List<TopicView> {
        return this.topics.stream().map { t ->
            TopicView (
                id = t.id,
                title = t.title,
                message = t.message,
                status = t.status,
                creationDate = t.creationDate
            )
        }.collect(Collectors.toList())
    }

    fun searchForId(id: Long): TopicView {
        val topic = topics.stream().filter({ t -> t.id == id }).findFirst().get()
        return TopicView(
            id = topic.id,
            title = topic.title,
            message = topic.message,
            status = topic.status,
            creationDate = topic.creationDate
        )
    }

    fun register(topicRegisterForm: TopicRegisterForm) {
        val topic = Topic(
            id = topics.size.toLong() + 1,
            title = topicRegisterForm.title,
            message = topicRegisterForm.message,
            course = courseService.searchForId(topicRegisterForm.courseID),
            author = userService.searchForId(topicRegisterForm.userID)
        )
        topics = topics.plus(topic)
    }
}