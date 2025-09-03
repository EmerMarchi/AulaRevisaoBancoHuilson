package ui

fun menu(){
    do {
        println("1 - Cadastrar Caixa D'Água")
        println("2 - Editar Caixa D'Água")
        println("3 - Listar Caixas D'Água")
        println("4 - Excluir Caixa D'Água")
        println("0 - Sair")

        val opcao = readln().toInt()

        when (opcao) {
            0 -> println("Adeus amigo!")
            1 -> println("Cadastrando caixa...")
            2 -> println("Editando caixa...")
            3 -> println("Listar caixas...")
            4 -> println("Ecluindo caixa...")
            else -> println("Opção inválida!")
        }
    }while (opcao != 0)

}