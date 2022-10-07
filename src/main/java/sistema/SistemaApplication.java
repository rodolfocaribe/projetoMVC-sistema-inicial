package sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import sistema.model.Aluno;
import sistema.model.Professor;

@SpringBootApplication
public class SistemaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SistemaApplication.class, args);
    }

    @Autowired
    JdbcTemplate db;

    @Override
    public void run(String... args) throws Exception {
        db.update("INSERT INTO alunos(nome,telefone,endereco) VALUES (?,?,?)", "Rodolfo de Tal", "123",
                "Rua 1");
        db.update("INSERT INTO alunos(nome,telefone,endereco) VALUES (?,?,?)", "Juliana Fulana", "123",
                "Rua 2");
        db.update("INSERT INTO alunos(nome,telefone,endereco) VALUES (?,?,?)", "João Botão", "123",
                "Rua 3");
        db.update("INSERT INTO professores(nome) VALUES (?)", "Professor Pardal");
        db.update("INSERT INTO professores(nome) VALUES (?)", "Professor Girafales");
        db.update("INSERT INTO professores(nome) VALUES (?)", "Professora Florinda");
    }

}
