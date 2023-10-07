package br.com.learing.salessamuel.forum.Service

import br.com.learing.salessamuel.forum.Domain.Models.User
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class UserService(private var users: List<User>) {

    init {
        val user = User(
            id = 1,
            name = "Samuel",
            email = "ss@email.com"
        )

        users = Arrays.asList(user)
    }

    fun searchForId(id: Long): User {
        return users.stream().filter({ t -> t.id == id }).findFirst().get()
    }

}
