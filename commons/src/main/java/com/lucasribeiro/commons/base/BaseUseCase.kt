package com.lucasribeiro.commons.base

interface BaseUseCase<T, R> {
    fun execute(param: T): R
}