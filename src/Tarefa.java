public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida = false;

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
    public boolean isConcluida(){
        return concluida;
    }

    public void concluir(){
        this.concluida = true;
    }

}
