package entidades

import enumeradores.Sexo
import enumeradores.Cargo
import enumeradores.Funcao
import enumeradores.Setor
import java.math.BigDecimal

class Instalador (
    nome : String,
    idade : Int,
    cpf : String,
    sexo : Sexo,
    endereco : String,
    telefone : Long,
    dataNasc : String,
    val cargo : Cargo,
    val tempoExperiencia : Double,
    val salario : BigDecimal,
    val setor : Setor,
    val funcao: Funcao,
    val equipamento: List<String>
)
    : Pessoa(
    nome = nome,
    idade = idade,
    cpf = cpf,
    sexo = sexo,
    endereco = endereco,
    telefone = telefone,
    dataNasc = dataNasc
) {
    //Comportamentos do Instalador
    fun instalarCaixaDaAgua(): Boolean {
        return this.funcao == Funcao.OPERADOR
    }

    fun instalacaoCompleta(): String {
        return if (this.funcao == Funcao.OPERADOR) {
            "Instalação concluída"
        } else {
            "Instalação mal sucedida"
        }
    }

    //O Polimorfismo nada mais é do que fazer uma SOBREESCRITA do
    //método que está na superclasse
    override fun receberConta(conta: Conta, aPagar : BigDecimal){
        conta.saldo = conta.saldo.subtract(aPagar)
    }
}