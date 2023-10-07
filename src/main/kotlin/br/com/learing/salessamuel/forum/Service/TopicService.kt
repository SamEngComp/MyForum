package br.com.learing.salessamuel.forum.Service

import br.com.learing.salessamuel.forum.Domain.Models.Course
import br.com.learing.salessamuel.forum.Domain.Models.Topic
import br.com.learing.salessamuel.forum.Domain.Models.User
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class TopicService(private var topics: List<Topic>) {

    init {
        val topic1 = Topic(
            id = 1,
            title = "Learing Kotlin 1",
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
        val topic2 = Topic(
            id = 2,
            title = "Learing Kotlin 2",
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
        val topic3 = Topic(
            id = 3,
            title = "Learing Kotlin 3",
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
        topics = Arrays.asList(topic1, topic2, topic3)
    }

    fun lis(): List<Topic> {
        return topics
    }

    fun searchForId(id: Long): Topic {
        return topics.stream().filter({ t -> t.id == id }).findFirst().get()
    }

}