package br.com.learing.salessamuel.forum.Service

import br.com.learing.salessamuel.forum.DTO.TopicRegisterDTO
import br.com.learing.salessamuel.forum.Domain.Models.Course
import br.com.learing.salessamuel.forum.Domain.Models.Topic
import br.com.learing.salessamuel.forum.Domain.Models.User
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class TopicService(private var topics: List<Topic> = ArrayList(),
                   private val courseService: CourseService,
                   private val userService: UserService) {

    fun lis(): List<Topic> {
        return topics
    }

    fun searchForId(id: Long): Topic {
        return topics.stream().filter({ t -> t.id == id }).findFirst().get()
    }

    fun register(topicRegisterDTO: TopicRegisterDTO) {
        val topic = Topic(
            title = topicRegisterDTO.title,
            message = topicRegisterDTO.message,
            course = courseService.searchForId(topicRegisterDTO.courseID),
            author = userService.searchForId(topicRegisterDTO.userID)
        )
        topics = topics.plus(topic)
    }
}