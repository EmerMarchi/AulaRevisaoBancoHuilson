package entidades

import enumeradores.Sexo

class Cliente (
    nome : String,
    idade : Int,
    cpf : String,
    sexo : Sexo,
    endereco : String,
    telefone : Long,
    dataNasc : String,
    val email : String,
    val pedido : Array<String>
) : Pessoa(nome = nome,
    idade = idade,
    cpf = cpf,
    sexo = sexo,
    endereco = endereco,
    telefone = telefone,
    dataNasc = dataNasc)