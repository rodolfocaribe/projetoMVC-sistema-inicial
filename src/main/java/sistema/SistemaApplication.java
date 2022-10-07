package sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import sistema.model.Contato;

import java.util.List;

@SpringBootApplication
public class SistemaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SistemaApplication.class, args);
    }

    @Autowired
    JdbcTemplate db;

    @Override
    public void run(String... args) throws Exception {;
        //inicializando o banco h2 através de arquivo .sql
//        db.update("INSERT INTO contatos(nome,telefone,endereco) VALUES (?,?,?)", "Edson Angoti Júnior", "123",
//                "Rua 1");
//        db.update("INSERT INTO contatos(nome,telefone,endereco) VALUES (?,?,?)", "José Joaquim", "123",
//                "Rua 2");
//        db.update("INSERT INTO contatos(nome,telefone,endereco) VALUES (?,?,?)", "Maria Carolina", "123",
//                "Rua 3");
    }

}
