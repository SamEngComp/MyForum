package br.com.learing.salessamuel.forum.Service

import br.com.learing.salessamuel.forum.Domain.Models.Course
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService(private var courses: List<Course>) {

    init {
        val course = Course (
            id = 1,
            name = "Kotlin",
            category = "Programming"
        )

        courses = Arrays.asList(course)
    }

    fun searchForId(id: Long): Course {
        return courses.stream().filter({ t -> t.id == id }).findFirst().get()
    }
}
