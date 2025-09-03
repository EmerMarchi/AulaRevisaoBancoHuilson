package entidades

import enumeradores.Cor
import enumeradores.Formato
import enumeradores.Marca
import enumeradores.Material
import java.math.BigDecimal

class CaixaDAgua ( //Os 2 parenteses Construtor da Classe
    val capacidade : Int,
    val material : Material,
    val formato : Formato,
    val cano : Int,
    val cor : Cor,
    val peso : Double,
    val marca : Marca,
    val altura : Double,
    val profundidade : Double,
    val largura : Double,
    val preco : BigDecimal? = BigDecimal.ZERO
    //val dimenssao : Array<Double>, //Altura, Largura e Profundidade
)//Aqui vai todos os atributos da classe