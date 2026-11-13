public class Main {
    public static void main(String... args){
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();
        Tarefa t1 = new Tarefa(1l,"java","estudar java");
        Tarefa t2 = new Tarefa(2l,"sql","estudar sql");
        Tarefa t3 = new Tarefa(3l,"Spring","estudar Spring");

        gerenciador.adicionarTarefa(t1);
        gerenciador.adicionarTarefa(t2);
        gerenciador.adicionarTarefa(t3);

        gerenciador.listarTarefas();

        t1.concluir();

        gerenciador.buscarTarefaPorId(1l);
        gerenciador.buscarTarefaPorId(4l);

        t1.isConcluida();
        t2.isConcluida();

        System.out.println("Tarefa 2 concluída? " + t2.isConcluida());


    }
}
