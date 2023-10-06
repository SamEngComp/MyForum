package br.com.learing.salessamuel.forum.Service

import br.com.learing.salessamuel.forum.Domain.Models.Course
import br.com.learing.salessamuel.forum.Domain.Models.Topic
import br.com.learing.salessamuel.forum.Domain.Models.User
import org.springframework.stereotype.Service

@Service
class TopicService {

    fun lis(): List<Topic> {
        val topic = Topic(
            id = 1,
            title = "Learing Kotlin",
            message = "Kotlin vars",
            course = Course(
                id = 1,
                name = "Kotlin Spring",
                category = "Programming"
            ),
            author = User(
                id = 1,
                name = "Samuel",
                email = "sss@email.com"
            )
        )
        return listOf(topic, topic, topic)
    }

}