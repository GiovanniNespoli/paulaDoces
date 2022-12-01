package SpringBancoHTML;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Connections.conectar;

import java.util.ArrayList;
import java.util.List;

import Models.Request;
import Services.RequestService;

@Controller
public class AdmController {

    conectar con = new conectar();
    RequestService request = new RequestService();
    List<Request> requests = new ArrayList<>();

    @RequestMapping("/alterar")
    public ModelAndView Update(Model modelo) {
        requests = request.index(con.connectionMySql());
        ModelAndView mv = new ModelAndView("alterar");
        mv.addObject("request", requests);
        return mv;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateRequest(@RequestParam String id) {
        request.update(con.connectionMySql(), Integer.parseInt(id));
        return "redirect:alterar";
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.POST)
    public String deleteRequest(@RequestParam String id) {
        request.delete(con.connectionMySql(), Integer.parseInt(id));
        return "redirect:alterar";
    }

    @RequestMapping("/lista")
    public ModelAndView List(Model modelo) {
        requests = request.index(con.connectionMySql());
        ModelAndView mv = new ModelAndView("lista");
        mv.addObject("request", requests);
        return mv;
    }

    @RequestMapping("/realizados")
    public ModelAndView requestAlreadyDid(Model modelo) {
        requests = request.listDoneRequests(con.connectionMySql());
        ModelAndView mv = new ModelAndView("realizados");
        mv.addObject("request", requests);
        return mv;
    }
}
