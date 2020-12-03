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
    public class ClienteController {
    
        @Autowired
        ClienteRepository clienteRepository;

        
        
        @GetMapping(value="/cadastroC")
        public ModelAndView getListarCliente() {
           
            List<Cliente>lista = clienteRepository.findAll();
    
            ModelAndView modelAndView=new ModelAndView("cadastroC");
            modelAndView.addObject("lista", lista);
            return modelAndView;
        }
        
        @GetMapping(value="/mostrar/{id}")
        public ModelAndView getMostrar(@PathVariable Long id) {
         
           Cliente cliente = clienteRepository.findById(id).get();
            
            ModelAndView modelAndView = new ModelAndView("mostrar");
            modelAndView.addObject("cliente", cliente);
                   return modelAndView;
        }
    
        
        @GetMapping(value="/cadastrarC")
        public ModelAndView getCadastrarCliente() {
          
           Cliente cliente = new Cliente();
            
            ModelAndView modelAndView = new ModelAndView("cadastrarC");
            modelAndView.addObject("cliente", cliente);
           
            return modelAndView;
        }
    
        @PostMapping(value="/cadastrarC")
        public ModelAndView postCadastrar(Cliente cliente){
            
            clienteRepository.save(cliente);
            
            ModelAndView modelAndView = new ModelAndView("mostrar");
            modelAndView.addObject("cliente", cliente);
            return modelAndView;
        }   
    
       
        @GetMapping(value="/apagar/{id}")
        public ModelAndView getApagar(@PathVariable Long id) {
           
            clienteRepository.deleteById(id);
            
            List<Cliente>lista = clienteRepository.findAll();
            ModelAndView modelAndView = new ModelAndView("cadastroC");
            modelAndView.addObject("lista", lista);
            return modelAndView;
        }
    
        
        @GetMapping(value="/edit/{id}")
        public ModelAndView getEdit(@PathVariable Long id) {
            
            Cliente cliente = clienteRepository.findById(id).get();
    
           ModelAndView modelAndView = new ModelAndView("cadastrarC");
           modelAndView.addObject("cliente", cliente);
            return modelAndView;
 
            @GetMapping(value="/pesquisar") 
            public String getPesquisar() { 
                return "pesquisar";                        
            }
        
            @PostMapping(value="/pesquisar")
            public ModelAndView postPesquisar(@RequestParam String cliente) {
                List<Cliente>lista = clienteRepository.findByNomeContainingIgnoreCaseOrderByNomeAsc(cliente);
                                                                                                          
                ModelAndView modelAndView = new ModelAndView("cadastroC");
                modelAndView.addObject("lista", lista);
                return modelAndView;
        }
        
        }
    
    
    
