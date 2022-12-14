package SpringBancoHTML;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Connections.conectar;
import Models.User;
import Models.Request;
import Services.RequestService;
import Services.UserService;

@Controller
public class UserController {

    conectar con = new conectar();
    UserService userService = new UserService();
    RequestService requestService = new RequestService();

    @RequestMapping("/")
    public String Welcome(Model modelo) {
        try {
            con.connectionMySql();
            return "welcome";
        } catch (Exception e) {
            System.out.println("not found");
            return "notFound";
        }
    }

    @GetMapping("/login")
    public ModelAndView Login() {
        System.out.println("Login");
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("user", new User());
        return mv;
    }

    @PostMapping("/login")
    public String Validation(User user) {
        try {

            if (user.getEmail().equals("adm@gmail.com")
                    && user.getPassword().equals("123")) {
                return "redirect:lista";
            }

            boolean login = userService.Login(user.getEmail(), user.getPassword(), con.connectionMySql());

            if (!login) {
                return "redirect:error";
            }

            return "redirect:pedido";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:error";
        }
    }

    @GetMapping("/cadastro")
    public ModelAndView SingUp() {
        System.out.println("Cadastro");
        ModelAndView mv = new ModelAndView("cadastro");
        mv.addObject("user", new User());
        return mv;
    }

    @PostMapping("/cadastro")
    public String createNewUser(User user) {
        try {
            userService.createUser(user.getName(), user.getEmail(), user.getPassword(), con.connectionMySql());
            return "redirect:requestSucesso";
        } catch (Exception e) {
            return "redirect:error";
        }
    }

    @RequestMapping("/produtos")
    public String Product(Model modelo) {
        System.out.println("Produtos");
        return "produtos";
    }

    @GetMapping("/pedido")
    public ModelAndView Request(Model modelo) {
        System.out.println("Pedido");
        ModelAndView mv = new ModelAndView("pedido");
        mv.addObject("request", new Request());
        return mv;
    }

    @PostMapping("/pedido")
    public String createRequest(Request request) {
        try {
            requestService.createRequest(
                    request.getRequest(),
                    request.getPhone(),
                    request.getAdress(),
                    request.getComplement(),
                    request.getDeliveryDate(),
                    con.connectionMySql());
            
            return "redirect:pedidoSucesso";
        } catch (Exception e) {
            System.out.println(e);
            return "redirect:error";
        }
    }

    @RequestMapping("/pedidoSucesso")
    public String RequestSucess() {
        return "pedidoSucesso";
    }

    @RequestMapping("/requestSucesso")
    public String SingUpSucess() {
        return "cadastroSucesso";
    }

    @RequestMapping("/sobre")
    public String About(Model modelo) {
        System.out.println("Sobre n??s");
        return "sobre";
    }

    @RequestMapping("/cardapio")
    public String Cardapio(Model modelo) {
        System.out.println("Card??pio");
        return "cardapio";
    }

}
