package controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Regiao;
import servico.ClienteServico;
import servico.RegiaoServico;
import servico.ServicoException;
import servico.ServicoFactory;

@WebServlet("/cliente/clienteServlet")
public class clienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERIR_OU_ALTERAR = "/cliente/clienteCrud.jsp";
	private static String CONFIRMACAO = "/cliente/clienteConfirmacao.jsp";
	private static String LISTAR = "/cliente/regiao.jsp";
	private static String ERRO = "/publico/erro.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClienteServico clienteServico = ServicoFactory.criarClienteServico();

		String forward = "";
		String cmd = request.getParameter("cmd");
		if (cmd == null || cmd.equalsIgnoreCase("")) {
			cmd = "";
		}
		if ("novo".equalsIgnoreCase(cmd)) {
			try {
				Cliente cli = new Cliente();
				request.setAttribute("cli", cli);
				forward = INSERIR_OU_ALTERAR;
			} catch (RuntimeException e) {
				request.setAttribute("erro", "Erro de execução: " + e.getMessage());
				forward = ERRO;
			}
		}
		RequestDispatcher rd1 = request.getRequestDispatcher(forward);
		rd1.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClienteServico clienteServico = ServicoFactory.criarClienteServico();
		String forward = "";
		try {
			Cliente cli = instanciar(request);
			clienteServico.inserirCliente(cli);
			request.setAttribute("cli", cli);
			forward = CONFIRMACAO;
		} catch (ServicoException e) {
			request.setAttribute("erro", e.getMessage());
			forward = ERRO;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	private Cliente instanciar(HttpServletRequest req) {
		String aux;
		Cliente x = new Cliente();
		aux = req.getParameter("codCliente");
		if (aux != null && !aux.isEmpty())
			x.setCodCliente(Integer.parseInt(aux));
		aux = req.getParameter("nome");
		x.setNome(aux);
		aux = req.getParameter("tel");
		x.setTelefone(aux);

		return x;
	}

}