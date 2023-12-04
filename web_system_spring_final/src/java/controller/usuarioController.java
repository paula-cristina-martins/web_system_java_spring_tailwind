package controller;

import entidade.usuario;
import java.util.List;
import modelo.usuarioDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class usuarioController {

    @RequestMapping("/inicio")
    public String usuario() {
        System.out.println("OK - Usuarios .....!!!");
        return "usuario";
    }

    @PostMapping("/formulario")
    public String formularioUsuario(Model model, usuario usuario, @RequestParam("acao") String submit) {
        if ("cadastrar".equals(submit)) {
            cadastrarUsuario(model, usuario);
        } else if ("consultar".equals(submit)) {
            listarUsuarios(model, usuario);
        } else if ("alterar".equals(submit)) {
            alterarUsuario(model, usuario);
        } else if ("consultar_usuario".equals(submit)) {
            consultarUsuario(model, usuario);
        } else if ("excluir".equals(submit)) {
            excluirUsuario(model, usuario);
        }

        model.addAttribute(usuario);
        return "usuario";
    }

    public String cadastrarUsuario(Model model, usuario usuario) {
        try {
            usuario user = new usuario();
            usuarioDAO userDAO = new usuarioDAO();

            user.setCpf(usuario.getCpf());
            user.setNome(usuario.getNome());
            user.setCep(usuario.getCep());
            user.setLogradouro(usuario.getLogradouro());
            user.setNumero(usuario.getNumero());
            user.setBairro(usuario.getBairro());
            user.setComplemento(usuario.getComplemento());
            user.setCidade(usuario.getCidade());
            user.setUf(usuario.getUf());
            user.setObservacao(usuario.getObservacao());
            user.setEmail(usuario.getEmail());
            user.setSenha(usuario.getSenha());

            String mensagem = userDAO.cadastrarUsuario(user);

            if (mensagem != null && mensagem.startsWith("Erro")) {
                model.addAttribute("errorMessage", mensagem);
            } else {
                model.addAttribute("successMessage", mensagem);
            }
        } catch (Exception x) {
            model.addAttribute("errorMessage", "Mensagem de erro:" + x.getMessage());
        }

        model.addAttribute(usuario);
        return "usuario";
    }

    public String listarUsuarios(Model model, usuario usuario) {
        try {
            usuarioDAO userDAO = new usuarioDAO();
            List<usuario> usuarios = userDAO.listarUsuarios();

            if (usuarios != null && !usuarios.isEmpty()) {
                model.addAttribute("usuarios", usuarios);
            } else {
                model.addAttribute("errorMessage", "Nenhum usuário encontrado.");
            }
        } catch (Exception x) {
            model.addAttribute("errorMessage", "Mensagem de erro:" + x.getMessage());
        }

        model.addAttribute(usuario);
        return "usuario";
    }

    public String consultarUsuario(Model model, usuario usuario) {
        try {
            String cpf = usuario.getCpf();

            usuarioDAO userDAO = new usuarioDAO();
            usuario user = userDAO.consultarUsuario(cpf);

            if (user != null) {
                user.setCpf(usuario.getCpf());
                user.setNome(usuario.getNome());
                user.setCep(usuario.getCep());
                user.setLogradouro(usuario.getLogradouro());
                user.setNumero(usuario.getNumero());
                user.setBairro(usuario.getBairro());
                user.setComplemento(usuario.getComplemento());
                user.setCidade(usuario.getCidade());
                user.setUf(usuario.getUf());
                user.setObservacao(usuario.getObservacao());
                user.setEmail(usuario.getEmail());
                user.setSenha(usuario.getSenha());
            } else {
                model.addAttribute("errorMessage", "Usuário não encontrado.");
            }
        } catch (Exception x) {
            model.addAttribute("errorMessage", "Mensagem de erro:" + x.getMessage());
        }

        model.addAttribute(usuario);
        return "usuario";
    }

    public String alterarUsuario(Model model, usuario usuario) {
        try {
            usuario user = new usuario();
            user.setCpf(usuario.getCpf());
            user.setNome(usuario.getNome());
            user.setCep(usuario.getCep());
            user.setLogradouro(usuario.getLogradouro());
            user.setNumero(usuario.getNumero());
            user.setBairro(usuario.getBairro());
            user.setComplemento(usuario.getComplemento());
            user.setCidade(usuario.getCidade());
            user.setUf(usuario.getUf());
            user.setObservacao(usuario.getObservacao());
            user.setEmail(usuario.getEmail());
            user.setSenha(usuario.getSenha());

            usuarioDAO userDAO = new usuarioDAO();
            String mensagem = userDAO.alterarUsuario(user);

            if (mensagem != null && mensagem.startsWith("Erro")) {
                model.addAttribute("errorMessage", mensagem);
            } else {
                model.addAttribute("successMessage", mensagem);
            }
        } catch (Exception x) {
            model.addAttribute("errorMessage", "Mensagem de erro:" + x.getMessage());
        }

        model.addAttribute(usuario);
        return "usuario";
    }

    public String excluirUsuario(Model model, usuario usuario) {
        try {
            String cpf = usuario.getCpf();

            usuarioDAO userDAO = new usuarioDAO();
            String mensagem = userDAO.excluirUsuario(cpf);

            if (mensagem != null && mensagem.startsWith("Erro")) {
                model.addAttribute("errorMessage", mensagem);
            } else {
                model.addAttribute("successMessage", mensagem);
            }
        } catch (Exception x) {
            model.addAttribute("errorMessage", "Mensagem de erro:" + x.getMessage());
        }

        model.addAttribute(usuario);
        return "usuario";
    }

}
