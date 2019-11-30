package auto;


import com.fasterxml.jackson.databind.JsonMappingException;
import dao.DAOJSON;
import dao.DuplikaltAuto;
import dao.KocsiNemTalalhato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import webprog.model.Allapot;
import webprog.model.Kivitel;
import webprog.model.Kocsi;

import javax.jws.WebParam;
import java.io.IOException;

@Controller
public class AutoController{

    @Autowired
    DAOJSON dao;

    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message","Szia");
        return mav;

    }

    @RequestMapping(value = "/cica")
    public String cica(){
        System.out.println("EEEEEEEEE");
        return "proba";
    }

    @RequestMapping(value = "/autok")
    public ModelAndView listAutos() throws IOException {
        ModelAndView mav  = new ModelAndView("cars");
        mav.addObject("cars",dao.readAllKocsi());
        return mav;
    }

    @RequestMapping(value = "/addKocsi", method = RequestMethod.GET)
    public ModelAndView addAutoForm(){
        ModelAndView mav = new ModelAndView("kocsiForm", "command",new Kocsi());
        mav.addObject("kivitelTipusok", Kivitel.values());
        mav.addObject("allapotTipusok", Allapot.values());
        return mav;
    }

    @RequestMapping(value = "/addKocsi", method = RequestMethod.POST)
    public ModelAndView addAuto(@ModelAttribute Kocsi kocsi) throws IOException {
        System.out.println(kocsi);
        try {
            dao.addKocsi(kocsi);
        } catch (DuplikaltAuto duplikaltAuto) {
            ModelAndView mav = new ModelAndView("kocsiForm",
                    "command",kocsi);
            mav.addObject("kivitelTipusok", Kivitel.values());
            mav.addObject("allapotTipusok", Allapot.values());
            mav.addObject("message",
                    "A rendszam mar foglalt:"+kocsi.getRendszam());
            return mav;
        }
        ModelAndView mav = new ModelAndView("redirect:auto/"+kocsi.getRendszam());
        return mav;
    }

    @RequestMapping(value = "/auto/{rendszam}")
    public ModelAndView getAutoByRendszam(@PathVariable String rendszam) throws IOException, KocsiNemTalalhato {
        ModelAndView mav = new ModelAndView("carDetails");
        mav.addObject("auto", dao.readKocsiByRendszam(rendszam));
        return mav;
    }

    @ExceptionHandler(KocsiNemTalalhato.class)
    public ModelAndView errorkocsinemtalalhato(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "A kert Kocsi nem talalhato");
        return mav;
    }


}