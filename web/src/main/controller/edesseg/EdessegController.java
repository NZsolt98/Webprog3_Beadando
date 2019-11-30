package auto;


import com.fasterxml.jackson.databind.JsonMappingException;
import dao.DAOJSON;
import dao.DuplikaltEdesseg;
import dao.EdessegNemTalalhato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import webprog.model.Tipus;
import webprog.model.Mennyiseg;
import webprog.model.Edesseg;

import javax.jws.WebParam;
import java.io.IOException;

@Controller
public class EdessegController{

    @Autowired
    DAOJSON dao;

    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message","Üdvözöllek");
        return mav;

    }

    @RequestMapping(value = "/edessegek")
    public ModelAndView listEdessegek() throws IOException {
        ModelAndView mav  = new ModelAndView("edessegek");
        mav.addObject("edessegek",dao.readAllEdesseg());
        return mav;
    }

    @RequestMapping(value = "/addEdesseg", method = RequestMethod.GET)
    public ModelAndView addEdessegForm(){
        ModelAndView mav = new ModelAndView("edessegForm", "command",new Edesseg());
        mav.addObject("mennyisegTipusok", Mennyiseg.values());
        mav.addObject("tipusTipusok", Tipus.values());
        return mav;
    }

    @RequestMapping(value = "/addEdesseg", method = RequestMethod.POST)
    public ModelAndView addEdesseg(@ModelAttribute Edesseg edesseg) throws IOException {
        System.out.println(edesseg);
        try {
            dao.addEdesseg(edesseg);
        } catch (Duplikaltedesseg duplikaltedesseg) {
            ModelAndView mav = new ModelAndView("edessegForm",
                    "command",edesseg);
            mav.addObject("mennyisegTipusok", Mennyiseg.values());
            mav.addObject("tipusTipusok", Tipus.values());
            mav.addObject("message",
                    "A termekszam mar foglalt:"+edesseg.getTermekszam());
            return mav;
        }
        ModelAndView mav = new ModelAndView("redirect:auto/"+edesseg.getTermekszam());
        return mav;
    }

    @RequestMapping(value = "/edesseg/{termekszam}")
    public ModelAndView getEdessegByTermekszam(@PathVariable String termekszam) throws IOException, EdessegNemTalalhato {
        ModelAndView mav = new ModelAndView("sweetDetails");
        mav.addObject("edesseg", dao.readEdessegByTermekszam(termekszam));
        return mav;
    }

    @ExceptionHandler(EdessegNemTalalhato.class)
    public ModelAndView erroredessegnemtalalhato(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "A kert edesseg nem talalhato");
        return mav;
    }


}