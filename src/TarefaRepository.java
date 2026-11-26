import java.util.ArrayList;
import java.util.List;

public class TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();

    public void salvar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public Tarefa buscarPorId(Long id) {
        for (Tarefa tarefa : tarefas) {
            if (tarefa.getId().equals(id)) {
                return tarefa;
            }
        }
        return null;
    }

    public boolean remover(Long id) {
        Tarefa tarefa = buscarPorId(id);
        return tarefa != null && tarefas.remove(tarefa);
    }

    public List<Tarefa> listar() {
        return new ArrayList<>(tarefas);
    }
}
