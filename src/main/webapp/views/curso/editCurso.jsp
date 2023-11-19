<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
   <link rel="stylesheet" type="text/css" href="./assets/css/index.css"/>
 <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
<title>Trampo 360::Atualizar Aluno</title>     
    
</head>

<main>
<nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand active" href="index.html">
                <img src="./assets/img/logo.stext.png" width="60" height="50" class="d-inline-block align-top" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="./aluno">Aluno</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./">Curso</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link " href="./vaga">Vaga</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="./evento">Evento</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="./escolhe">Escolhe</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="./eval">Evento/Aluno</a>
                    </li>
                     <li class="nav-item">
                        <a class="nav-link" href="./vaal">Vaga/Aluno</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
                <header class="tag">
            <h1 class="container">Atualizar Curso</h1>
        </header>

       <div class="container py-3">
            <form action="./curso-update">
            <input type="hidden" id="id" name="id" class="form-control" value="${curso.id}" />
<!-- 	            <div class="form-group mb-3"> -->
<!-- 	                <label for="nome" class="form-label"> -->
<!-- 	                    id -->
<!-- 	                </label> -->
<%-- 	                <input type="text" id="id" name="id" class="form-control" value="${Curso.id}" readonly/> --%>
<!-- 	            </div> -->
	          <div class="form-group mb-3">
					<label for="curso" class="form-label"> Curso </label> 
					<select id="curso" name="curso" class="form-control">
						<option value="DEFAULT">Escolha um Curso</option>
						<jstl:forEach items="${listaCurso}" var="c">
							<option value="${c.id}">${c.curso}</option>
						</jstl:forEach>
					</select>
				</div>
                    <div class="form-group mb-3">
                        <label htmlFor="data_Curso" class="form-label">
                           Data do curso
                        </label>
                        <input type="text" id="data_Curso" name="data_Curso" class="form-control" placeholder=" Insira o email" value="${curso.data_Curso}" />
                    </div>
                    <button type="submit" class="btn btn-primary">
                        Enviar
                    </button>
                    <a href="./curso" class="btn btn-danger" style="margin-left: 10px">
                        Cancelar
                    </a>
                </fieldset>
            </form>
        </div>
        <br><br>
    <footer>
        <div class="footer-info">
            <div class="contact-info">

                <h5>Telefone para contato</h5>
                </p>
                <p> (11) 3858-0777 </p>
                <p> (11) 97770-3952</p>
            </div>
            <div class="end-info">
                <h5>Endereço</h5>
                <p>Rua Gaivota, 125 - Bairro Moema</p>
                <p> São Paulo - SP</p>
            </div>
            <div class="social-media text-white">
                <h5> Nossas mídias sociais</h5>
                <i class="bi bi-instagram insta fs-4" onclick="window.open('https://www.instagram.com/', '_blank')"></i>
                <i class="bi bi-facebook face fs-4" onclick="window.open('https://www.facebook.com/', '_blank')"></i>
                <i class="bi bi-twitter tw fs-4" onclick="window.open('https://www.twitter.com/', '_blank')"></i>
                <i class="bi bi-messenger mess fs-4" onclick="window.open('https://www.messenger.com/', '_blank')"></i>
                <i class="bi bi-whatsapp whats fs-4 " onclick="window.open('https://web.whatsapp.com/', '_blank')"></i>
            </div>
        </div>
        <div class="footer-text">
            <p>&copy; 2023 Trampo360°. Todos os direitos reservados.</p>
        </div>
    </footer>
    <!---fimRodapé-->
</main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>

</html>