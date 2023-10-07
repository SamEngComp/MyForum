package br.com.learing.salessamuel.forum.Mapper

interface Mapper<T, U> {
    fun map(t: T): U
}
