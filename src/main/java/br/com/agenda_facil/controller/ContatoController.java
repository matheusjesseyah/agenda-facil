package br.com.agenda_facil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.agenda_facil.model.Contato;
import br.com.agenda_facil.repository.ContatoRepository;
import jakarta.validation.Valid;




@Controller
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoRepository contatoRepository;

    public ContatoController(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    // LISTAR CONTATOS
    @GetMapping
    public String listar(Model model) {

        model.addAttribute("contatos", contatoRepository.findAll());

        model.addAttribute("total", contatoRepository.count());

        return "contatos";
    }

    // ABRIR FORMULÁRIO
    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute("contato", new Contato());

        model.addAttribute("titulo", "Novo contato");

        return "formulario";
    }

    // SALVAR CONTATO
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("contato") Contato contato, BindingResult resultado, Model model) {

        if (resultado.hasErrors()){
            model.addAttribute("titulo", contato.getId() == null ? "Novo contato" : "Editar contato");
            return "formulario";

        }
        contatoRepository.save(contato);

        return "redirect:/contatos";
    }

    // EXCLUIR CONTATO
    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        contatoRepository.deleteById(id);

        return "redirect:/contatos";
    }

    // EDITAR CONTATO
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {

        Contato contato = contatoRepository.findById(id).orElseThrow();

        model.addAttribute("contato", contato);

        return "formulario";
    }
}
    
    
    
