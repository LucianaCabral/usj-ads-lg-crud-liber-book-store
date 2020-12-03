package br.edu.usj.ads.lgii.liber;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LivroController {

    @Autowired
    LivroRepository livroRepository;
    
    @GetMapping(value="/cadastro")
    public ModelAndView getListar() {
        
        List<Livro>lista = livroRepository.findAll();

        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    
    @GetMapping(value="/exibir/{id}")
    public ModelAndView getExibirPorId(@PathVariable Long id) {
        
        Livro livro = livroRepository.findById(id).get();
        
        ModelAndView modelAndView = new ModelAndView("exibir");
        modelAndView.addObject("livro", livro);
               return modelAndView;
    }

    
    @GetMapping(value="/cadastrar")
    public ModelAndView getCadastrar() {
       
        Livro livro = new Livro();
        
        ModelAndView modelAndView = new ModelAndView("cadastrar");
        modelAndView.addObject("livro", livro);
        
        return modelAndView;
    }

    @PostMapping(value="/cadastrar")
    public ModelAndView postCadastrar(Livro livro){
        
        livroRepository.save(livro);
        
        ModelAndView modelAndView = new ModelAndView("exibir");
        modelAndView.addObject("livro", livro);
        return modelAndView;
    }   

    
    @GetMapping(value="/deletar/{id}")
    public ModelAndView getDeletar(@PathVariable Long id) {
        livroRepository.deleteById(id);
        
        List<Livro>lista = livroRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }

    
    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        
        Livro livro = livroRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("cadastrar");//cadastrar
        modelAndView.addObject("livro", livro);
        return modelAndView;
    }

   
    @GetMapping(value="/pesquisar") 
    public String getPesquisar() { 
        return "pesquisar";                        
    }

    @PostMapping(value="/pesquisar")
    public ModelAndView postPesquisar(@RequestParam String livro) {
        List<Livro>lista = livroRepository.findByAutorContainingIgnoreCaseOrderByAutorAsc(livro);
                                                                                                  
        ModelAndView modelAndView = new ModelAndView("pesquisar");
       
        modelAndView.addObject("lista", lista);
        return modelAndView;
    }
}

