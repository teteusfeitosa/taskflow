public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean concluida = false;

   public Tarefa(Long id, String titulo, String descricao){
        if(id == null || id <= 0){
            throw new IllegalArgumentException("ID inválido");
        }
        if(titulo == null || titulo.isBlank()){
            throw new IllegalArgumentException("Título inválido");
        }
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
    }
    public Long getId(){
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getDescricao(){
        return descricao;
    }
    public Boolean isConcluida(){
        return concluida;
    }

    public void concluir(){
        this.concluida = true;
    }

    public void atualizarDadosDaTarefa(Long id, String novoTitulo, String novaDescricao){
        if(novoTitulo == null || novoTitulo.isBlank()){
            throw new IllegalArgumentException("Título inválido");
        }
        this.titulo = novoTitulo;
        this.descricao = novaDescricao;        
    }

}
