import java.util.ArrayList;
/*
Adicionar as três tarefas.



Listar todas.



Buscar uma tarefa existente.



Buscar um ID inexistente.



Concluir uma tarefa encontrada e verificar seu novo estad

*/

public class GerenciadorTarefas {
    private ArrayList <Tarefa> tarefas = new ArrayList<>(); //ArrayList<Tarefa>: coleção que aceita objetos da classe Tarefa.
    //private: impede outras classes de modificar diretamente a lista.
    //new ArrayList<>(): cria a lista vazia.
    //cada instância de GerenciadorTarefas terá sua própria coleção.
    public void adicionarTarefa(Tarefa tarefa){
        tarefas.add(tarefa);

        //Esse método recebe um objeto Tarefa e o adiciona à lista.
        //Por enquanto, é simples. Posteriormente, precisaremos impedir tarefas nulas e IDs duplicados. 
    }
    public void listarTarefas(){
        for(Tarefa tarefa : tarefas){
            System.out.println(
                "ID: " + tarefa.getId()
                + " | Título: " + tarefa.getTitulo()
                + " | Concluída: " + tarefa.isConcluida()
            );
        }
        /* 
        Esse formato é chamado de enhanced for, ou for-each.
        Ele percorre os objetos da coleção sem precisar manipular índices manualmente.
        O método listar() tem complexidade O(n), pois percorre todos os elementos.
        Uma observação de arquitetura: imprimir diretamente é suficiente para nosso exercício inicial, mas futuramente o gerenciador retornará dados e a camada de apresentação ficará responsável pela impressão.
        */
    }

    public Tarefa buscarTarefaPorId(Long id){
        for(Tarefa tarefa : tarefas){
            if(tarefa.getId().equals(id)){
                System.out.println("Tarefa encontrada: " + tarefa.getTitulo());
                return tarefa;

                /* 
                tarefa.getId().equals(id): verifica se o ID atual corresponde ao procurado.
                public Tarefa: o método promete devolver um objeto do tipo Tarefa, ou null.
                return tarefa: devolve o objeto encontrado e encerra o método.
                return null: indica que nenhum objeto foi encontrado.
                */
            }
        }
        System.out.println("Tarefa não encontrada.");
        return null;
    }






    
}
