package sistema.repository;


import lombok.Data;

@Data
public class Contatos {
    int id;
    String nome, telefone, endereco;
    public Contatos(int id, String nome, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
