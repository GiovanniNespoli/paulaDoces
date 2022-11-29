package SpringBancoHTML;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdmController {
    @RequestMapping("/alterar")
    public String Update(Model modelo) {
        System.out.println("Alterar");
        return "alterar";
    }
    
    @RequestMapping("/lista")
    public String List(Model modelo) {
        System.out.println("Lista");
        return "lista";
    }
}
