package SpringBancoHTML;

import conectar.conectar;
import conectarM.ConectarMongo;
import java.sql.Connection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
    
    @RequestMapping("/")
    public String Welcome(Model modelo) {
        System.out.println("Boas vindas");
        return "welcome";
    }
    
    @RequestMapping("/login")
    public String Login(Model modelo) {
        System.out.println("Login");
        return "login";
    }
    
    @RequestMapping("/cadastro")
    public String SingUp(Model modelo) {
        System.out.println("Cadastro");
        return "cadastro";
    }
    
    @RequestMapping("/produtos")
    public String Product(Model modelo) {
        System.out.println("Produtos");
        return "produtos";
    }
    
    @RequestMapping("/form")
    public String Form(Model modelo) {
        System.out.println("Form carregando");
        modelo.addAttribute("mensagem", "Boas vindas!");
        return "form";
    }

    @RequestMapping(value = "/respostaForm", method = RequestMethod.POST)
    public String RespForm(Model modelo, String Nome, String Email,
            int code, String prof, boolean trab) {
        System.out.println("Resposta do Form");
        modelo.addAttribute("mensagem1", "Nome: " + Nome + " - Email: "
                + Email);
        conectar obj = new conectar();
        Connection conexao = obj.connectionMySql();
        obj.dataBaseInsert(Nome, Email);
        obj.consulta(conexao);
        obj.closeConnectionMySql(conexao);
        
        ConectarMongo con = new ConectarMongo();
        con.insertValues(Nome, Email, code, prof, trab);
        con.getValues();     
        return "respostaForm";
    }
    
    @RequestMapping(value="/bancoconecta", method=RequestMethod.POST) 
    public String BancoCon(Model modelo, String code){
        System.out.println("Conexão de consulta com banco");
        conectar obj = new conectar();
        Connection conexao = obj.connectionMySql();
        String x;
        x = obj.dataBaseSelect(Integer.parseInt(code));
        modelo.addAttribute("mensagem2", "Olá, "+x+", como vai?");
        obj.closeConnectionMySql(conexao);
        return "bancoconecta";
    }      
    @RequestMapping("/sobre")
    public String Banco(Model modelo){
        System.out.println("Sobre nós");
        return "sobre";
    } 
    
    @RequestMapping(value="/bancoMongo", method=RequestMethod.POST)
    public String BancoMongo(Model modelo, String code){
        System.out.println("Conexão com o Mongo");
        ConectarMongo con = new ConectarMongo();
        con.getValues();
        String x = con.selectValues(Integer.parseInt(code));
        modelo.addAttribute("mensagem3", "Olá, "+x+", como você está?");
        return "bancoMongo";
    }
    @RequestMapping("/bancoM")
    public String BancoM(Model modelo){
        System.out.println("Consulta no Mongo");
        return "bancoM";
    }     
}
