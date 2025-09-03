package crud

import java.lang.classfile.instruction.StackInstruction
import java.sql.Connection
import java.sql.DriverManager

class EntidadeJDBC(
    val url : String,
    val usuario : String,
    val senha : String
) {
    fun conectarComBanco() : Connection?{
        //Quando precisa fazer algo que possa falhar
        try {                           //Cada banco tem o seu driver
            val coneccao : Connection = DriverManager.getConnection(
                //Quando a Classe instanciar os atributos
                this.url, this.usuario, this.senha
            )
            println("Conectou!")
            return coneccao
        } catch (erro : Exception){
            println(erro.printStackTrace())
        }
        return null
    }
}