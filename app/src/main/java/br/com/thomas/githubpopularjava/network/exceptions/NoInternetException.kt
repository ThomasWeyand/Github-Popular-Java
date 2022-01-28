package br.com.thomas.githubpopularjava.network.exceptions

import java.io.IOException

class NoInternetException : IOException() {

    override val message: String?
        get() = "Sem conexão a internet"
}