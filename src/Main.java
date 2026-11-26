import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        TarefaRepository repository = new TarefaRepository();
        TarefaService service = new TarefaService(repository);
        boolean executando = true;

        try (Scanner sc = new Scanner(System.in)) {
            while (executando) {
                System.out.println("\n===== TASKFLOW =====");
                System.out.println("1 - Adicionar tarefa");
                System.out.println("2 - Listar tarefas");
                System.out.println("3 - Buscar tarefa por ID");
                System.out.println("4 - Atualizar tarefa");
                System.out.println("5 - Concluir tarefa");
                System.out.println("6 - Excluir tarefa");
                System.out.println("0 - Sair\n");
                System.out.print("Escolha uma opção: ");

                if (!sc.hasNextLine()) {
                    break;
                }

                try {
                    int opcao = Integer.parseInt(sc.nextLine());
                    switch (opcao) {
                        case 1:
                            System.out.print("Digite o ID da tarefa: ");
                            Long id = Long.parseLong(sc.nextLine());
                            System.out.print("Digite o título da tarefa: ");
                            String titulo = sc.nextLine();
                            System.out.print("Digite a descrição da tarefa: ");
                            String descricao = sc.nextLine();
                            service.cadastrarTarefa(new Tarefa(id, titulo, descricao));
                            System.out.println("Tarefa cadastrada com sucesso");
                            break;
                        case 2:
                            List<Tarefa> lista = service.listarTarefas();
                            if (lista.isEmpty()) {
                                System.out.println("A lista está vazia");
                            } else {
                                for (Tarefa tarefa : lista) {
                                    exibirTarefa(tarefa);
                                }
                            }
                            break;
                        case 3:
                            System.out.print("Digite o ID da tarefa: ");
                            Long idBusca = Long.parseLong(sc.nextLine());
                            Tarefa encontrada = service.buscarTarefa(idBusca);
                            if (encontrada == null) {
                                System.out.println("Tarefa não encontrada");
                            } else {
                                exibirTarefa(encontrada);
                            }
                            break;
                        case 4:
                            System.out.print("Digite o ID da tarefa: ");
                            Long idAtual = Long.parseLong(sc.nextLine());
                            System.out.print("Digite o novo título da tarefa: ");
                            String novoTitulo = sc.nextLine();
                            System.out.print("Digite a nova descrição da tarefa: ");
                            String novaDescricao = sc.nextLine();
                            service.atualizar(idAtual, novoTitulo, novaDescricao);
                            System.out.println("Tarefa atualizada");
                            break;
                        case 5:
                            System.out.print("Digite o ID da tarefa: ");
                            Long idConclusao = Long.parseLong(sc.nextLine());
                            service.concluirTarefa(idConclusao);
                            System.out.println("Tarefa concluída");
                            break;
                        case 6:
                            System.out.print("Digite o ID da tarefa: ");
                            Long idExclusao = Long.parseLong(sc.nextLine());
                            if (service.excluirTarefa(idExclusao)) {
                                System.out.println("Tarefa excluída");
                            } else {
                                System.out.println("Tarefa não encontrada");
                            }
                            break;
                        case 0:
                            System.out.println("Saiu do menu");
                            executando = false;
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Digite um valor válido.");
                } catch (IllegalArgumentException e) {
                    System.out.println("\nErro: " + e.getMessage());
                }
            }
        }
    }

    private static void exibirTarefa(Tarefa tarefa) {
        String status = tarefa.isConcluida() ? "Concluída" : "Pendente";
        System.out.println("ID: " + tarefa.getId()
                + " | Título: " + tarefa.getTitulo()
                + " | Descrição: " + tarefa.getDescricao()
                + " | Status: " + status);
    }
}
