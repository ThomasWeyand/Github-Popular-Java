package br.com.thomas.githubpopularjava.network.exceptions

import java.lang.Exception

class UnKnownException : Exception() {

    override val message: String?
        get() = "Erro desconhecido"
}