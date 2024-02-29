package webapp.hello_world.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/** @author Rolfi Luz - Senai * */
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
    public ModelAndView nomeIndex(@RequestParam("nome") String nome) {
        ModelAndView mv = new ModelAndView("index");

        String mensagem = "Insira seus dados!";
        mv.addObject("msg", mensagem);
        mv.addObject("nome", nome);

        return mv;
    }

    public ModelAndView idadeIndex(@RequestParam("idade") String idade) {
        ModelAndView mv = new ModelAndView("index");

        String mensagem = "Insira seus dados!";
        mv.addObject("msg", mensagem);
        mv.addObject("idade", idade);

        return mv;
    }

    public ModelAndView sexoIndex(@RequestParam("sexo") String sexo) {
        ModelAndView mv = new ModelAndView("index");

        String mensagem = "Insira seus dados!";
        mv.addObject("msg", mensagem);
        mv.addObject("sexo", sexo);

        return mv;
    }
}
