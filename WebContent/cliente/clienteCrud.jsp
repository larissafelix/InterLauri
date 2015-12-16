<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Teste CRUD</title>
</head>
<body>
<h1>CADASTRO DE CLIENTE</h1>
<h2>Entre com os dados do cliente</h2>
 <form method="post" action="<%=request.getContextPath()%>clienteServlet" name="formReg">
  <br />

 Nome : <input type="text" name="nome" value="${cli.nome}" /> <br />
 Telefone : <input type="text" name="tel" value="${cli.telefone}" /> <br />
 <input type="submit" value="Enviar" />
 </form>
</body>
</html>