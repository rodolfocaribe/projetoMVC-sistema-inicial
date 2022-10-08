package sistema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sistema.model.Aluno;
import sistema.model.Professor;

import javax.print.attribute.standard.PresentationDirection;
import javax.swing.*;


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

    @GetMapping("novoaluno")
    public String exibeForm(Model modelo2) {
        modelo2.addAttribute("aluno", new Aluno());
        return "novoaluno";
    }
    @PostMapping("novoaluno")
    public String gravaDados(Aluno aluno) {
        db.update("insert into alunos (nome, telefone, endereco) values (?,?,?)",
                aluno.getNome(), aluno.getTelefone(), aluno.getEndereco());
        return "redirect:/alunos";
    }


    @GetMapping("novoprofessor")
    public String exibeFormProfessor(Model modelo4) {
        modelo4.addAttribute("professor", new Professor());
        return "novoprofessor";
    }
    @PostMapping("novoprofessor")
    public String gravaDadosProfessor(Professor professor) {
        db.update("insert into professores (nome) values (?)",
                professor.getNome());
        return "redirect:/professores";
    }
    @GetMapping ("excluir-aluno")
    public String apagarContato(@RequestParam(value = "id", required = true) Integer cod) {
        db.update("delete from alunos where id=?", cod);
        return "redirect:/alunos";
    }

    @GetMapping ("editar-aluno")
    public String exibeFormAlteracaoAluno(@RequestParam (value = "id", required = true) Integer cod, Model model){
        Aluno aluno = db.queryForObject(
                "select * from alunos where id = ?",
                (rs, rowNum) -> {
                    Aluno edited = new Aluno();
                    edited.setId(rs.getInt("id"));
                    edited.setNome(rs.getString("nome"));
                    edited.setEndereco(rs.getString("endereco"));
                    edited.setTelefone(rs.getString("telefone"));
                    return edited;
                }, cod);
        model.addAttribute("alunoEditado", aluno );
        return "editaaluno";
    }
    @PostMapping("gravaalunoeditado")
    public String gravaAlunoEditado(Aluno aluno) {
        db.update(
                "update alunos set nome=?, telefone=?, endereco=? where id = ?",
                aluno.getNome(),
                aluno.getTelefone(),
                aluno.getEndereco(),
                aluno.getId());
        return "redirect:/alunos";
    }
}

