package entidades

import java.math.BigDecimal

class Servico (
    val preco : BigDecimal,
    val tempo : Double,
    val condicao : String,
    val instalador : Instalador
)