<%@page import="dominio.Pedido"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Gerar relatorio de Pedidos</h2>
EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
EntityManager em = emf.createEntityManager();
<h2>Entre com a data inicial e final</h2>
 <form method="post" action="<%=request.getContextPath()%>/cliente/regiaoServlet" name="formReg">
  <br />

 Data inicial : <input type="text" name="ini" /> <br />
 Data final : <input type="text" name="fim"/> <br />
 <input type="submit" value="Gerar relatorio por periodo" action="<%=request.getContextPath()%>relatServelet?cmd=novo"/>
 </form>
</body>
</html>