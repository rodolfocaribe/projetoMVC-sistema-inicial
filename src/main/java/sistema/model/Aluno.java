package sistema.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Aluno {
    private int id;
    private String nome, telefone, endereco;

    public Aluno(int id, String nome, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
