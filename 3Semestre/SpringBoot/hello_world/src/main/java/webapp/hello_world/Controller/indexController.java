package webapp.hello_world.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView abrirIndex() {
        ModelAndView mv = new ModelAndView("index");

        String mensagem = "Olá, seja bem-vinda(o)!";
        mv.addObject("msg", mensagem);

        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView buscarIndex(@RequestParam("nome") String nome,
            @RequestParam("email") String email,
            @RequestParam("telefone") String telefone,
            @RequestParam("endereco") String endereco) {
        ModelAndView mv = new ModelAndView("index");

        // Criar uma breve história usando os elementos do formulário
        String historia = "Era uma vez, em uma rua tranquila chamada " + endereco.split(",")[0] + ", ";
        historia += "vivia uma pessoa chamada " + nome + ". ";
        historia += "Um belo dia, " + nome + " recebeu um email muito importante em seu endereço de email " + email
                + ". ";
        historia += "Ele ficou tão emocionado que ligou imediatamente para seus amigos e familiares no telefone "
                + telefone + " para compartilhar a notícia.";

        // Adicionar a história ao modelo da view
        mv.addObject("historia", historia);

        return mv;
    }

}