package webapp.crud_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.crud_escola.Model.Administrador;
import webapp.crud_escola.Repository.AdministradorRepository;
import webapp.crud_escola.Repository.VerificaCadastroAdmRepository;




@Controller
public class AdministradorController {
//atributos
boolean acessoInternoAdm = false;

    @Autowired
    private AdministradorRepository ar;

    @Autowired
    private VerificaCadastroAdmRepository vcar;
    
//métodos  
    @PostMapping("cadastrar-adm")
    public ModelAndView cadastroAdmBD(Administrador adm) {

        boolean verificaCpf = vcar.existsById(adm.getCpf()) ;

        ModelAndView mv = new ModelAndView("adm/login-adm");

        if(verificaCpf==true){
            ar.save(adm);
            String mensagem = "Cadastro Realizado com sucesso";
            System.out.println(mensagem);
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "verde");
        }else{
            String mensagem = "Cadastro Não Realizado";
            System.out.println(mensagem);
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "vermelho");
        }
         
        return mv;
    }

    @PostMapping("acesso-adm")
    public ModelAndView acessoAdmLogin(@RequestParam String cpf,
                                       @RequestParam String senha,
                                       RedirectAttributes attributes) {
        ModelAndView mv =  new ModelAndView("redirect:/interna-adm");//página interna de acesso
        
        boolean acessoCPF = cpf.equals(ar.findByCpf(cpf).getCpf());
        boolean acessoSenha = senha.equals(ar.findByCpf(cpf).getSenha());
        
        if(acessoCPF && acessoSenha){
            String mensagem = "Login Realizado com sucesso";
            System.out.println(mensagem);
            acessoInternoAdm = true;
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "verde");
        }else{
            String mensagem = "Login Não Efetuado";
            System.out.println(mensagem);
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "vermelho");
            mv.setViewName("redirect:/login-adm");
        }
        return mv;
    }

    
    // @GetMapping("/interna-adm")
    // public ModelAndView acessoPageInternaAdm(RedirectAttributes attributes) {
    //     ModelAndView mv =  new ModelAndView("interna/interna-adm");
    //     if (acessoInternoAdm) {
    //         System.out.println("Acesso Permitido");
    //     } else{
    //         String mensagem = "Acesso não Permitido - faça Login";
    //         System.out.println(mensagem);
    //         mv.setViewName("redirect:/login-adm");
    //         mv.addObject("msg", mensagem);
    //         mv.addObject("classe", "vermelho"); 
    //     }

    //     return mv;
    // }

    @GetMapping("/interna-adm")
    public String acessoPageInternaAdm() {
        String acesso = "";
        ModelAndView mv = new ModelAndView();
        if (acessoInternoAdm) {
            System.out.println("Acesso Permitido");
            acesso = "/interna-adm";

        } else{
            String mensagem = "Acesso não Permitido - faça Login";
            System.out.println(mensagem);
            acesso = "/login-adm";
            mv.addObject("msg", mensagem);
            mv.addObject("classe", "vermelho"); 
        }

        return acesso;
    }
    
    
    
}
