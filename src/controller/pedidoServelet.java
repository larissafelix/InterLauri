package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Pedido;
import servico.PedidoServico;
import servico.ServicoException;
import servico.ServicoFactory;

	@WebServlet("pedidoServelet")
	public class pedidoServelet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private static String CONFIRMACAO = "/cliente/regiaoConfirmacao.jsp";
		private static String LISTAR = "/cliente/pedido.jsp";
		private static String ERRO = "/publico/erro.jsp";

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			PedidoServico pedidoServico = ServicoFactory.criarPedidoServico();

			String forward = "";
			try {
				List<Pedido> lista = pedidoServico.buscarTodos();
					request.setAttribute("lista", lista);
					forward = LISTAR;
				} catch (RuntimeException e) {
					request.setAttribute("erro", "Erro de execução: " + e.getMessage());
					forward = ERRO;
				}
			
			RequestDispatcher rd1 = request.getRequestDispatcher(forward);
			rd1.forward(request, response);
		}
	}