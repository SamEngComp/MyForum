package br.com.learing.salessamuel.forum.Mapper

import br.com.learing.salessamuel.forum.DTO.Forms.TopicRegisterForm
import br.com.learing.salessamuel.forum.Domain.Models.Topic
import br.com.learing.salessamuel.forum.Service.CourseService
import br.com.learing.salessamuel.forum.Service.UserService
import org.springframework.stereotype.Component

@Component
class TopicRegisterFormMapper(
    private val courseService: CourseService,
    private val userService: UserService
): Mapper<TopicRegisterForm, Topic> {
    override fun map(t: TopicRegisterForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            course = courseService.searchForId(t.courseID),
            author = userService.searchForId(t.userID)
        )
    }
}