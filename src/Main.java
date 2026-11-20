import java.util.Scanner;
public class Main {
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        Boolean executando = true;

        while(executando){
            System.out.println("\n===== TASKFLOW =====");

            System.out.println("1 - Adicionar tarefa");

            System.out.println("2 - Listar tarefas");

            System.out.println("3 - Buscar tarefa por ID");

            System.out.println("4 - Atualizar tarefa");

            System.out.println("5 - Concluir tarefa");

            System.out.println("6 - Excluir tarefa");

            System.out.println("0 - Sair\n");

            System.out.print("Escolha uma opção: ");

            try{
                int opcao = Integer.parseInt(sc.nextLine());

            switch(opcao){
                case 1:
                    System.out.print("Digite o ID da tarefa: ");

                    Long id = Long.parseLong(sc.nextLine());

                    System.out.print("Digite o título da tarefa: ");

                    String titulo = sc.nextLine();

                    System.out.print("Digite a descrição da tarefa: ");

                    String descricao = sc.nextLine();

                    Tarefa tarefa = new Tarefa(id,titulo,descricao);

                    gerenciador.adicionarTarefa(tarefa);

                    System.out.println("Tarefa cadastrada com sucesso");
                    break;
                case 2:
                    gerenciador.listarTarefas();

                    break;
                case 3:
                    System.out.print("Digite o ID da tarefa: ");
                    Long idBusca = Long.parseLong(sc.nextLine());

                    gerenciador.buscarTarefaPorId(idBusca);

                    break;
                case 4:
                    System.out.print("Digite o ID da tarefa: ");
                    Long idAtual = Long.parseLong(sc.nextLine());

                    System.out.print("Digite o novo título da tarefa: ");
                    String novoTitulo = sc.nextLine();

                    System.out.print("Digite a nova descrição da tarefa: ");
                    String novaDescricao = sc.nextLine();

                    gerenciador.atualizarTarefa(idAtual, novoTitulo, novaDescricao);

                    System.out.println("Tarefa atualizada");
                    break;
                case 5:
                    System.out.print("Digite o ID da tarefa: ");
                    Long idParaConluirTarefa = Long.parseLong(sc.nextLine());

                    Tarefa tarefaParaConcluir = gerenciador.buscarTarefaPorId(idParaConluirTarefa);

                    if(tarefaParaConcluir != null){
                        tarefaParaConcluir.concluir();
                        System.out.println("Tarefa concluída");
                    }else{   
                        System.out.println("Tarefa não encontrada");
                    }
                    break;
                case 6:
                    System.out.print("Digite o ID da tarefa: ");
                    Long idParaExcluirTarefa = Long.parseLong(sc.nextLine());
                    
                    if( gerenciador.removerTarefa(idParaExcluirTarefa )== true){
                        System.out.println("Tarefa excluida");
                    }else{
                        System.out.println("Tarefa não encontrada");
                    }

                    break;
                case 0:
                    System.out.println("Saiu do menu");
                    executando = false;
                    break;
                default:
                    System.out.println("opção inválida");
                    break;                            
                
            }

        }catch (NumberFormatException e){
            System.out.println("Digite um valor válido. ");
            
        }catch (IllegalArgumentException e){
            System.out.println("\nErro: " + e.getMessage());
        }  
            
        }

        sc.close();

    }
}
