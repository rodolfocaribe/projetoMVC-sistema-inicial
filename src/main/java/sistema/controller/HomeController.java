package sistema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sistema.model.Aluno;
import sistema.model.Professor;


@Controller
public class HomeController {

    @Autowired
    JdbcTemplate db;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/alunos")
    public String aluno(Model model) {
        List<Aluno> listaDeAlunos = db.query(
                "select * from alunos",
                (res, rowNum) -> {
                    Aluno aluno = new Aluno(
                            res.getInt("id"),
                            res.getString("nome"),
                            res.getString("telefone"),
                            res.getString("endereco"));
                    return aluno;
                });
        model.addAttribute("alunos", listaDeAlunos);
        return "aluno";
    }

    @GetMapping("/professores")
    public String professores(Model modelo) {
        List<Professor> listaDeProfessores = db.query(
                "select * from professores",
                (res, rowNum) -> {
                    Professor professor = new Professor(
                            res.getInt("id"),
                            res.getString("nome"));
                    return professor;
                });

        modelo.addAttribute("professores", listaDeProfessores);
        return "professor";
    }

}


