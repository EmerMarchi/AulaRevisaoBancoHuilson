package crud

import entidades.CaixaDAgua
import enumeradores.Cor
import enumeradores.Formato
import enumeradores.Marca
import enumeradores.Material
import java.sql.Connection

fun criarTabelaCaixa(){
    val conectar = EntidadeJDBC(
        url = "jdbc:postgresql://localhost:5432/postgres",
        usuario = "postgres",
        senha = "postgres"
    )

    val sql = "CREATE TABLE IF NOT EXISTS CaixaDAgua " +
            " (" +
            " id serial NOT NULL PRIMARY KEY, " +
            " capacidade float, " +
            " material varchar(255), " +
            " formato varchar(255), " +
            " cano float, " +
            " cor varchar(255), " +
            " peso float, " +
            " marca varchar(255), " +
            " altura float, " +
            " profundidade float, " +
            " largura float, " +
            " preco varchar(255)" +
            ")"

    val banco = conectar.conectarComBanco()
    val enviarParaBnaco = banco!!.createStatement().execute(sql)

    println(enviarParaBnaco)

    banco.close()//encerra a conexão com o banco
}


fun cadastrarCaixa(){

    val opcao = readln().toInt()

    println("Capacidade da caixa em litros:")
    val litros = readln().toInt()

    println("Escolha o material da caixa:")
    println("1 - Plástico")
    println("2 - PVC")
    println("3 - Polietileno")
    println("4 - Metal")
    println("5 - Concreto")
    var material : Material
    when(opcao){
        1-> material = Material.PLASTICO
        2-> material = Material.PVC
        3-> material = Material.POLIETILENO
        4-> material = Material.METAL
        5-> material = Material.CONCRETO
        else -> material = Material.PLASTICO
    }

    println("Qual o formato da caixa")
    println("1 - Circular")
    println("2 - Quadricular")
    println("3 - Retangular")
    var formato : Formato
    when(opcao){
        1-> formato = Formato.CIRCULAR
        2-> formato = Formato.QUADRICULAR
        3-> formato = Formato.RETANGULAR
        else -> formato = Formato.QUADRICULAR
    }

    println("Qual  o diâmetro do cano da caixa:")
    val diametro = readln().toInt()

    println("Qual a cor da caixa:")
    println("1 - Azul")
    println("2 - Rosa")
    println("3 - Vermelho")
    println("4 - Verde")
    println("5 - Laranja")
    var cor : Cor
    when(opcao){
        1-> cor = Cor.AZUL
        2-> cor = Cor.ROSA
        3-> cor = Cor.VERMELHO
        4-> cor = Cor.VERDE
        5-> cor = Cor.LARANJA
        else -> cor = Cor.AZUL
    }

    println("Qual o peso da caixa:")
    val quilo = readln().toDouble()

    println("Qual a marca da caixa:")
    println("1 - FortLev")
    println("2 - Tigre")
    println("3 - AcquaLimp")
    println("4 - Amanco")
    var marca : Marca
    when(opcao){
        1-> marca = Marca.FORTLEV
        2-> marca = Marca.TIGRE
        3-> marca = Marca.ACQUALIMP
        4-> marca = Marca.AMANCO
        else -> marca = Marca.TIGRE
    }

    println("Qual a altura da caixa:")
    val alt = readln().toDouble()

    println("Qual a profundidade da caixa:")
    val prof = readln().toDouble()

    println("Qual a largura da caixa:")
    val larg = readln().toDouble()


    println("Qual o preço da caixa:")
    val reais = readln().toBigDecimal()

    CaixaDAgua(
        capacidade = litros,
        material = material,
        formato = formato,
        cano = diametro,
        cor = cor,
        peso = quilo,
        marca = marca,
        altura = alt,
        profundidade = prof,
        largura = larg,
        preco = reais
    )
}

fun editarCaixa(){

}

fun listarCaixas(){

}

fun excluirCaixa(){

}