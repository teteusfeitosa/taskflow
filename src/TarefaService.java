import java.util.List;
import java.util.Objects;

public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = Objects.requireNonNull(repository, "Repository obrigatório");
    }

    public void cadastrarTarefa(Tarefa tarefa) {
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa não pode ser nula");
        }
        if (repository.buscarPorId(tarefa.getId()) != null) {
            throw new IllegalArgumentException("Tarefa com o mesmo ID já existe");
        }
        repository.salvar(tarefa);
    }

    public Tarefa buscarTarefa(Long id) {
        return repository.buscarPorId(id);
    }

    public void atualizar(Long id, String titulo, String descricao) {
        Tarefa tarefa = repository.buscarPorId(id);
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
        tarefa.atualizarDadosDaTarefa(titulo, descricao);
    }

    public void concluirTarefa(Long id) {
        Tarefa tarefa = repository.buscarPorId(id);
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa não encontrada");
        }
        tarefa.concluir();
    }

    public boolean excluirTarefa(Long id) {
        return repository.remover(id);
    }

    public List<Tarefa> listarTarefas() {
        return repository.listar();
    }
}
