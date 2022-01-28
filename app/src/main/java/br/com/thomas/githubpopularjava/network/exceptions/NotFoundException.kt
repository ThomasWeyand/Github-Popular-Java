package br.com.thomas.githubpopularjava.network.exceptions

import java.io.IOException

class NotFoundException : IOException() {

    override val message: String?
        get() = "Não encontrado"
}