package sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import sistema.repository.Contatos;

import java.util.List;

@SpringBootApplication
public class SistemaApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SistemaApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone,endereco) VALUES (?,?,?)", "Edson Angoti Júnior", "123", "Rua 1");
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone,endereco) VALUES (?,?,?)", "José Joaquim", "123", "Rua 2");
        jdbcTemplate.update("INSERT INTO contatos(nome,telefone,endereco) VALUES (?,?,?)", "Maria Carolina", "123", "Rua 3");
        List<Contatos> contatos = jdbcTemplate.query("SELECT id, nome, telefone FROM contatos", (rs, rowNum) -> {
            return new Contatos(rs.getInt("id"), rs.getString("nome"), rs.getString("telefone"), rs.getString("endereco"));
        });

    }


}
