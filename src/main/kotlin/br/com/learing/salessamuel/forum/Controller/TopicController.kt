package br.com.learing.salessamuel.forum.Controller

import br.com.learing.salessamuel.forum.DTO.Forms.TopicEditForm
import br.com.learing.salessamuel.forum.DTO.Forms.TopicRegisterForm
import br.com.learing.salessamuel.forum.DTO.Views.TopicView
import br.com.learing.salessamuel.forum.Domain.Models.Topic
import br.com.learing.salessamuel.forum.Service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topic")
class TopicController(private val topicService: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return topicService.lis()
    }

    @GetMapping("/{id}")
    fun searchForId(@PathVariable id: Long): TopicView {
        return topicService.searchForId(id)
    }

    @PostMapping
    fun register(@RequestBody @Valid topicRegisterForm: TopicRegisterForm) {
        topicService.register(topicRegisterForm)
    }

    @PutMapping
    fun edit(@RequestBody @Valid topicEditForm: TopicEditForm) {
        topicService.edit(topicEditForm)
    }
}