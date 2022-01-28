package br.com.thomas.githubpopularjava.network.exceptions

import java.io.IOException

class UnAuthorizedException : IOException() {

    override val message: String?
        get() = "Não foi autorizado"
}