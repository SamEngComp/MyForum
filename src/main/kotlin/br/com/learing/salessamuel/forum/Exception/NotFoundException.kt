package br.com.learing.salessamuel.forum.Exception

import java.lang.RuntimeException

class NotFoundException(message: String): RuntimeException(message) { }