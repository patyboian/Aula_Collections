package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    // atributo
    private List<Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }
    public void removerTarefa(String descricao){
        // vamos usar o removeall, pois como podemos inserir valores repetidos,
        // assim ja removemos tudo com a mesma descrição
        // abaixo criamos uma lista vazia para adicionar as tarefas que vamos remover
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for(Tarefa t : tarefaList){ // aqui navegamos por todas as tarefas
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefasParaRemover.add(t);
                // com o comando acima, ele percorre toda a lista e adiciona apenas as que possuir a descrição

            }
        }
        // agora removemos todos os itens que incluimos na lista
        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas(){
        return tarefaList.size(); // retorna a quantidade de itens que tem na lista
    }

    public void obterDescricoesTarefas(){
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        ListaTarefa listaTarefa = new ListaTarefa();

        // Testando os métodos criados acima:

        System.out.println("O numéro total de elementos na lista é: "+ listaTarefa.obterNumeroTotalTarefas());


        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        listaTarefa.adicionarTarefa("Tarefa 3");
        listaTarefa.adicionarTarefa("Tarefa 3"); // incluimos o nome repetido para testar a exclusão
        System.out.println("O numéro total de elementos na lista é: "+ listaTarefa.obterNumeroTotalTarefas());

    listaTarefa.removerTarefa("Tarefa 3");
        System.out.println("O numéro total de elementos na lista é: "+ listaTarefa.obterNumeroTotalTarefas());

        // se deixar da forma como está abaixo, ele vai imprimir:
        // [list.OperacoesBasicas.Tarefa@214c265e, list.OperacoesBasicas.Tarefa@448139f0
        // Para corrigir, vamos até a classe Tarefas e criamos subescrevemos o metodo toString, assim o problema é resolvido
        listaTarefa.obterDescricoesTarefas();
    }

}
