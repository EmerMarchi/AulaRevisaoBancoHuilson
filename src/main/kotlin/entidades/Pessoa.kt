package entidades

import enumeradores.Sexo
import java.math.BigDecimal

open class Pessoa (
    val nome : String,
    val cpf : String,
    val sexo : Sexo,
    val idade : Int,
    val telefone : Long,
    val endereco : String,
    val dataNasc : String
){
    open fun receberConta(conta: Conta, aRecber : BigDecimal){
        conta.saldo = conta.saldo.add(aRecber)

    }
}