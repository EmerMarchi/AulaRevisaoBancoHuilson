package crud

import entidades.CaixaDAgua
import enumeradores.Cor
import enumeradores.Formato
import enumeradores.Marca
import enumeradores.Material
import java.sql.Connection
import java.sql.ResultSet

val conectar = EntidadeJDBC(
    url = "jdbc:postgresql://localhost:5432/postgres",
    usuario = "postgres",
    senha = "postgres"
)

fun criarTabelaCaixa(){

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



    println("Capacidade da caixa em litros:")
    val litros = readln().toInt()

    println("Escolha o material da caixa:")
    println("1 - Plástico")
    println("2 - PVC")
    println("3 - Polietileno")
    println("4 - Metal")
    println("5 - Concreto")
    var material : Material

    var opcao = readln().toInt()
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
    opcao = readln().toInt()
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
    opcao = readln().toInt()
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
    opcao = readln().toInt()
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

   val c = CaixaDAgua(
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
    val banco = conectar.conectarComBanco()!!.prepareStatement(
        "INSERT INTO CaixaDAgua " +
                " (capacidade, material, formato, cano, cor, peso, marca, altura, profundidade, largura, preco) " +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
    )

        banco.setInt(1, c.capacidade)
        banco.setString(2, c.material.name)
        banco.setString(3, c.formato.name)
        banco.setInt(4, c.cano)
        banco.setString(5, c.cor.name)
        banco.setDouble(6, c.peso)
        banco.setString(7, c.marca.name)
        banco.setDouble(8, c.altura)
        banco.setDouble(9, c.profundidade)
        banco.setDouble(10, c.largura)
        banco.setString(11, c.preco.toString())

        banco.executeUpdate()

        banco.close()
}

fun editarCaixa(){

}

fun listarCaixas(){
    val banco = conectar.conectarComBanco()
    val sql = "SELECT * FROM CaixaDAgua"
    //Ápos consultar o banco usando um SQL junto da função executeQuerry a consulta, se assertiva retorna um array de respostas
    val resultados : ResultSet = banco!!.createStatement().executeQuery(sql)

    while (resultados.next()){
        println("--------------------------------------------------------------------------------")
        println("Id: ${resultados.getString("id")}")
        println("Capacidade: ${resultados.getString("capacidade")}")
        println("Material: ${resultados.getString("material")}")
        println("Formato: ${resultados.getString("formato")}")
        println("Cano: ${resultados.getString("cano")}")
        println("Cor: ${resultados.getString("cor")}")
        println("Peso: ${resultados.getString("peso")}")
        println("Marca: ${resultados.getString("marca")}")
        println("Altura: ${resultados.getString("altura")}")
        println("Profundidade: ${resultados.getString("profundidade")}")
        println("Largura: ${resultados.getString("largura")}")
        println("Preço: ${resultados.getString("preco")}")
    }
}

fun excluirCaixa(){
    println("Digite o ID que deseja excluir: ")
    val id = readln().toInt()

    val banco = conectar.conectarComBanco()
    val sqlBusca = "SELECT * FROM CaixaDAgua WHERE id = ?"
    val resultados = banco!!.prepareStatement(sqlBusca)
    resultados.setInt(1, id)
    val retorno = resultados.executeQuery()
    while (retorno.next()){
        println("--------------------------------------------------------------------------------")
        println("Id: ${retorno.getString("id")}")
        println("Capacidade: ${retorno.getString("capacidade")}")
        println("Material: ${retorno.getString("material")}")
        println("Formato: ${retorno.getString("formato")}")
        println("Cano: ${retorno.getString("cano")}")
        println("Cor: ${retorno.getString("cor")}")
        println("Peso: ${retorno.getString("peso")}")
        println("Marca: ${retorno.getString("marca")}")
        println("Altura: ${retorno.getString("altura")}")
        println("Profundidade: ${retorno.getString("profundidade")}")
        println("Largura: ${retorno.getString("largura")}")
        println("Preço: ${retorno.getString("preco")}")
    }
    println("Tem certeza que deseja excluir esse registro?")
    val resposta = readln().lowercase()
    when(resposta){
        "sim"->{
            val deletar = banco.prepareStatement("DELETE FROM CaixaDAgua WHERE id = ?")
            deletar.setInt(1, id)// Diz qual é o valor do 1°
            deletar.executeUpdate()//Manda a instrução para ser executada no banco

        } else  -> {
            println("Operação Cancelada!")
        }
    }
}