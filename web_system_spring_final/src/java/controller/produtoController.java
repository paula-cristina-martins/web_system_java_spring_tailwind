package controller;

import entidade.produto;
import java.util.List;
import modelo.produtoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/produto")
public class produtoController {

    @RequestMapping("/inicio")
    public String produto() {
        System.out.println("OK - Produtos .....!!!");
        return "produto";
    }

    @PostMapping("/formulario")
    public String formularioProduto(Model model, produto produto, @RequestParam("acao") String submit) {
        if ("cadastrar".equals(submit)) {
            cadastrarProduto(model, produto);
        } else if ("consultar".equals(submit)) {
            listarProdutos(model, produto);
        } else if ("alterar".equals(submit)) {
            alterarProduto(model, produto);
        } else if ("consultar_produto".equals(submit)) {
            consultarProduto(model, produto);
        } else if ("excluir".equals(submit)) {
            excluirProduto(model, produto);
        }

        model.addAttribute(produto);
        return "produto";
    }

    public String cadastrarProduto(Model model, produto produto) {
        try {
            produto prod = new produto();
            produtoDAO prodDAO = new produtoDAO();

            prod.setLote(produto.getLote());
            prod.setNome(produto.getNome());
            prod.setDescricao(produto.getDescricao());
            prod.setFornecedor(produto.getFornecedor());
            prod.setQuantidade(produto.getQuantidade());
            prod.setValorCompra(produto.getValorCompra());
            prod.setValorVenda(produto.getValorVenda());

            String mensagem = prodDAO.cadastrarProduto(prod);

            if (mensagem != null && mensagem.startsWith("Erro")) {
                model.addAttribute("errorMessage", mensagem);
            } else {
                model.addAttribute("successMessage", mensagem);
            }
        } catch (Exception x) {
            model.addAttribute("errorMessage", "Mensagem de erro:" + x.getMessage());
        }

        model.addAttribute(produto);
        return "produto";
    }

    public String listarProdutos(Model model, produto produto) {
        try {
            produtoDAO prodDAO = new produtoDAO();
            List<produto> produtos = prodDAO.listarProdutos();

            if (produtos != null && !produtos.isEmpty()) {
                model.addAttribute("produtos", produtos);
            } else {
                model.addAttribute("errorMessage", "Nenhum produto encontrado.");
            }
        } catch (Exception x) {
            model.addAttribute("errorMessage", "Mensagem de erro:" + x.getMessage());
        }

        model.addAttribute(produto);
        return "produto";
    }

    public String consultarProduto(Model model, produto produto) {
        try {
            String lote = produto.getLote();

            produtoDAO prodDAO = new produtoDAO();
            produto prod = prodDAO.consultarProduto(lote);
            System.out.println(prod);
            if (prod != null) {
                prod.setLote(produto.getLote());
                prod.setNome(produto.getNome());
                prod.setDescricao(produto.getDescricao());
                prod.setFornecedor(produto.getFornecedor());
                prod.setQuantidade(produto.getQuantidade());
                prod.setValorCompra(produto.getValorCompra());
                prod.setValorVenda(produto.getValorVenda());
            } else {
                model.addAttribute("errorMessage", "Produto não encontrado.");
            }
        } catch (Exception x) {
            model.addAttribute("errorMessage", "Mensagem de erro:" + x.getMessage());
        }

        model.addAttribute(produto);
        return "produto";
    }

    public String alterarProduto(Model model, produto produto) {
        try {
            produto prod = new produto();
            prod.setLote(produto.getLote());
            prod.setNome(produto.getNome());
            prod.setDescricao(produto.getDescricao());
            prod.setFornecedor(produto.getFornecedor());
            prod.setQuantidade(produto.getQuantidade());
            prod.setValorCompra(produto.getValorCompra());
            prod.setValorVenda(produto.getValorVenda());

            produtoDAO prodDAO = new produtoDAO();
            String mensagem = prodDAO.alterarProduto(prod);

            if (mensagem != null && mensagem.startsWith("Erro")) {
                model.addAttribute("errorMessage", mensagem);
            } else {
                model.addAttribute("successMessage", mensagem);
            }
        } catch (Exception x) {
            model.addAttribute("errorMessage", "Mensagem de erro:" + x.getMessage());
        }

        model.addAttribute(produto);
        return "produto";
    }

    public String excluirProduto(Model model, produto produto) {
        try {
            String lote = produto.getLote();

            produtoDAO prodDAO = new produtoDAO();
            String mensagem = prodDAO.excluirProduto(lote);

            if (mensagem != null && mensagem.startsWith("Erro")) {
                model.addAttribute("errorMessage", mensagem);
            } else {
                model.addAttribute("successMessage", mensagem);
            }
        } catch (Exception x) {
            model.addAttribute("errorMessage", "Mensagem de erro:" + x.getMessage());
        }

        model.addAttribute(produto);
        return "produto";
    }

}
