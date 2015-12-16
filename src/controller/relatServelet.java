package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Regiao;
import servico.RegiaoServico;
import servico.ServicoException;
import servico.ServicoFactory;

@WebServlet("relatServelet")
public class relatServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String LISTAR = "/cliente/pedido.jsp";
	private static String ERRO = "/publico/erro.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Object> parametros = new HashMap<String, Object>();

		String nomeRelat = request.getParameter("nomeRelat");
		//parametros.put(ini, fim);
		
		String arquivoJasper = getServletContext().getRealPath("/Web-INF/relatorios/"+nomeRelat+".jasper");
	//	byte[] bytes = RelatorioUtil.criarRelatorio(arquivoJasper, parametros);
	}
}