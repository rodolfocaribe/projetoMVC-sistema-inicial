package sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sistema.model.Contato;
import org.springframework.web.bind.annotation.PostMapping;
import sistema.model.Professor;

@Controller
public class HomeController {

    @Autowired
    JdbcTemplate db;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/contatos")
    public String contatos(Model model) {
        List<Contato> listaDeContatos = db.query(
                "select * from contatos",
                (res, rowNum) -> {
                    Contato contato = new Contato(
                            res.getInt("id"),
                            res.getString("nome"),
                            res.getString("telefone"),
                            res.getString("endereco"));
                    return contato;
                });
        model.addAttribute("contatos", listaDeContatos);
        return "contato";
    }
    @GetMapping("/professores")
    public String professores(Model model) {
        List<Professor> listaDeProfessores = db.query(
                "select * from professores",
                (res, rowNum) -> {
                    Professor professor = new Professor(
                            res.getInt("id"),
                            res.getString("nome"));
                    return professor;
                });
        model.addAttribute("professores", listaDeProfessores
        );
        return "professores";
    }

    @GetMapping("novo")
    public String exibeForm(Model model) {
        model.addAttribute("contato", new Contato());
        return "formulario";
    }
    @GetMapping("novoprofessor")
    public String exibeFormProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "formularioprofessor";
    }

    @PostMapping("novo")
    public String gravaDados(Contato contato) {
        System.out.println("-----------------------");
        System.out.println(contato.getNome());
        System.out.println(contato.getEndereco());
        System.out.println(contato.getTelefone());

        db.update("insert into contatos(endereco, telefone, nome) values (?, ?, ?)",
                contato.getEndereco(), contato.getTelefone(), contato.getNome());
        return "home";
    }
    //metodo post professor
    @PostMapping("novoprofessor")
    public String gravaDados(Professor professor) {
        System.out.println("-----------------------");
        System.out.println(professor.getId());
        System.out.println(professor.getNome());

        db.update("insert into professores (nome) values (?)",
                professor.getNome());
        return "home";
    }

}
