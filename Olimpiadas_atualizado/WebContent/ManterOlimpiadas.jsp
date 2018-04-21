<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visualizar Olimpiadas</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
        <!-- Barra superior com os menus de navegação -->
<c:import url ="Menu.jsp" />
        <!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="page-header">Visualizar Olimpiadas #${ano.ano}  </h3>
            
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Ano</strong>
                    </p>
                    <p>
                        ${olimpiadas.ano} 
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Tipo</strong>
                    </p>
                    <p>
                        ${olimpiadas.tipo}
                    </p>
                </div>
            </div>
            <hr />
            
        
        <div class="container">
  <h2>Olimpiadas</h2>
          
  <table class="table">
    <thead>
      <tr>
      <th>Pais</th>
        <th>Modalidade</th>
        <th>Ouro</th>
        <th>Prata</th>
        <th>Bronze</th>
      </tr>
    </thead>
    <tbody>
      <tr>
         <td>${pais.nome}</td>
        <td>${modalidades.nome}</td>
        <td>${modalidades.ouro}</td>
        <td>${modalidades.prata}</td>
         <td>${modalidades.bronze}</td>
      </tr>
     
    </tbody>
  </table>
</div>
<div id="actions" class="row">
                <div class="col-md-12">
                    <a href="index.jsp" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>