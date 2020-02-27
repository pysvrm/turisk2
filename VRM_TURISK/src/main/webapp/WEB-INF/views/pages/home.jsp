<!--Welcome.jsp-->
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<c:url var="home" value="/" scope="request" />
<script>
	var ctx = "${pageContext.request.contextPath}"
	var xmlhttp = new XMLHttpRequest();

	function modal() {
		$('.modal').modal('show');
		setTimeout(function() {
			$('.modal').modal('hide');
		});
	}

	function doAjaxPostJHE() {
		var mensaje = confirm("\u00bf Desea reiniciar procesos JHE \77");

		if (mensaje) {
			doAjaxPostJHE0();
		}
	}

	function doAjaxPostJHE0() {
		$('.modal').modal('show');
		$.ajax({
			type : "POST",
			url : ctx + "/reiniciaJHE",
			success : function(response) {
				$('.modal').modal('hide');
			}
		});
	}

	function doAjaxPostTAD() {
		var mensaje = confirm("\u00bf Desea reiniciar procesos TAD \77");

		if (mensaje) {
			doAjaxPostTAD0();
		}
	}

	function doAjaxPostTAD0() {
		$('.modal').modal('show');
		$.ajax({
			type : "POST",
			url : ctx + "/reiniciaTADS",
			success : function(response) {
				$('.modal').modal('hide');
			}
		});
	}

	function doAjaxPostArmadoTren() {
		var mensaje = confirm("\u00bf Desea reiniciar procesos proceso Armando de tren \77");

		if (mensaje) {
			doAjaxPostArmadoTren0();
		}
	}

	function doAjaxPostArmadoTren0() {
		$('.modal').modal('show');
		$.ajax({
			type : "POST",
			url : ctx + "/armadoTren",
			success : function(response) {
				$('.modal').modal('hide');
			}
		});
	}

	function doAjaxPostVerificaErrores() {
		$('.modal').modal('show');
		$.ajax({
			type : "POST",
			url : ctx + "/verificaErrores",
			success : function(response) {
				$('.modal').modal('hide');
			}
		});
	}

	function doAjaxPostArmadoTren() {
		var mensaje = confirm("\u00bf Desea reiniciar procesos proceso Armando de tren \77");

		if (mensaje) {
			doAjaxPostArmadoTren0();
		}
	}

	function doAjaxPostReiniciaCEO() {
		$('#exampleModal2').modal('show');
		$.ajax({
			type : "POST",
			url : ctx + "/reiniciaCeo",
			success : function(response) {
				$('#exampleModal2').modal('hide');
			}
		});
	}

	function doAjaxPostCartel0() {
		$('#exampleModal2').modal('show');
		$.ajax({
			type : "POST",
			url : ctx + "/cartel0",
			success : function(response) {
				$('#exampleModal2').modal('hide');
			}
		});
	}

	function doAjaxPostEliminaEquipo() {
		$("#exampleModal").modal('hide');
		var vInicial = $('#inpt-inicial').val();
		var vNumero = $('#inpt-numero').val();
		$('input[name="inicial"]').val(vInicial);
		$('input[name="numero"]').val(vNumero);
		$('#inicial').val(vInicial);
		$('#numero').val(vNumero);
		$.ajax({
			type : "POST",
			url : ctx + "/eliminaEquipo",
			data : {
				inicial : vInicial,
				numero : vNumero
			},
			success : function(response) {
				$("#exampleModal").modal('hide');
			}
		});
	}
	
	function doAjaxPostEliminaEquipos() {
		$("#exampleModal").modal('hide');
		var vlista = $('#inpt-unidades').val();
		$('input[name="unidades"]').val(vlista);
		$('#unidades').val(vlista);
		$.ajax({
			type : "POST",
			url : ctx + "/eliminaEquipos",
			data : {
				listaEquipos : vlista,
			},
			success : function(response) {
				$("#exampleModalEquipos").modal('hide');
			}
		});
	}



	function doAjaxPostEliminaTrenDuplicado() {
		$("#exampleModalTrenD").modal('hide');
		var vTren = $('#inpt-tren').val();
		var vDia = $('#inpt-dia').val();
		var vEstacion = $('#inpt-estacion').val();
		$('input[name="tren"]').val(vTren);
		$('input[name="fecTren"]').val(vDia);
		$('input[name="estacion"]').val(vEstacion);
		$('#tren').val(vTren);
		$('#fecTren').val(vDia);
		$('#estacion').val(vEstacion);
		$.ajax({
			type : "POST",
			url : ctx + "/eliminaTrenDuplicado",
			data : {
				tren : vTren,
				fecTren : vDia,
				estacion : vEstacion
			},
			success : function(response) {
				$("#exampleModalTrenD").modal('hide');
			}
		});
	}

	function doAjaxPostSTSJHE() {

		$('.modal').modal('show');
		$.ajax({
			type : "GET",
			url : ctx + "/obtenerStatusJhe",
			success : function(response) {
				$('.modal').modal('hide');
				$("#subViewDiv").load(location.href + " #subViewDiv >*", "");
			}
		});

	}

	function doAjaxPostSTSTAD() {
		$('.modal').modal('show');
		$.ajax({
			type : "GET",
			url : ctx + "/obtenerStatusTad",
			success : function(response) {
				$('.modal').modal('hide');
				$("#subViewDivTad").load(location.href + " #subViewDivTad >*",
						"");
			}
		});

	}
</script>

<style>
.load-spinner .modal-dialog {
	display: table;
	position: relative;
	margin: 0 auto;
	top: calc(33% - 24px);
}

.load-spinner .modal-dialog .modal-content {
	background-color: #FFFAFA;
	border: solid;
	border-color: #20B2AA;
}

.table-dark {
	font-size: 8px;
}
</style>

<nav
	class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase"
	id="mainNav">
	<div class="container">
		<a class="navbar-brand js-scroll-trigger" href="#page-top">Start
			MedicalSuport</a>
		<button
			class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded"
			type="button" data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			Menu <i class="fa fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
					href="#portfolio">Botiquin</a></li>
				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
					href="#about">Acerca de</a></li>
				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
					href="#contact">Contacto</a></li>
				<li class="nav-item mx-0 mx-lg-1"><a
					class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger"
					href="<c:url value="/logout" />">Salir</a></li>
				<li class="nav-item mx-0 mx-lg-1"><sec:authorize
						access="hasRole('ROLE_ADMIN')">
						<br>
						<a class="font-weight-light mb-0" style="color: white;">Bienvenido
							Administrador</a>
					</sec:authorize> <sec:authorize access="hasRole('ROLE_USER')">
						<br>
						<a class="font-weight-light mb-0" style="color: white;">Bienvenido
							MCC</a>
					</sec:authorize></li>

			</ul>
		</div>
	</div>
</nav>

<!-- Header -->
<header class="masthead bg-primary text-white text-center">
	<div class="container">
		<img class="img-fluid mb-5 d-block mx-auto"
			src="resources/freelance/img/profile.png" alt="">
		<h1 class="text-uppercase mb-0">SICOP Medical Support</h1>
		<hr class="star-light">
		<h2 class="font-weight-light mb-0">Web Developer - Graphic Artist
			- User Experience Designer</h2>
	</div>
</header>

<!-- Portfolio Grid Section -->
<section class="portfolio" id="portfolio">
	<div class="container">
		<h2 class="text-center text-uppercase text-secondary mb-0">Botiquin</h2>
		<hr class="star-dark mb-5">
		<div class="row">
			<div class="col-md-6 col-lg-4">
				<a class="portfolio-item d-block mx-auto" href="#portfolio-modal-1">
					<div
						class="portfolio-item-caption d-flex position-absolute h-100 w-100">
						<div
							class="portfolio-item-caption-content my-auto w-100 text-center text-white">
							<i class="fa fa-search-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid"
					src="resources/freelance/img/portfolio/cabin.png" alt="">
				</a>
			</div>
			<div class="col-md-6 col-lg-4">
				<a class="portfolio-item d-block mx-auto" href="#portfolio-modal-2">
					<div
						class="portfolio-item-caption d-flex position-absolute h-100 w-100">
						<div
							class="portfolio-item-caption-content my-auto w-100 text-center text-white">
							<i class="fa fa-search-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid"
					src="resources/freelance/img/portfolio/cake.png" alt="">
				</a>
			</div>
			<div class="col-md-6 col-lg-4">
				<a class="portfolio-item d-block mx-auto" href="#portfolio-modal-3">
					<div
						class="portfolio-item-caption d-flex position-absolute h-100 w-100">
						<div
							class="portfolio-item-caption-content my-auto w-100 text-center text-white">
							<i class="fa fa-search-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid"
					src="resources/freelance/img/portfolio/circus.png" alt="">
				</a>
			</div>
			<div class="col-md-6 col-lg-4">
				<a class="portfolio-item d-block mx-auto" href="#portfolio-modal-4">
					<div
						class="portfolio-item-caption d-flex position-absolute h-100 w-100">
						<div
							class="portfolio-item-caption-content my-auto w-100 text-center text-white">
							<i class="fa fa-search-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid"
					src="resources/freelance/img/portfolio/game.png" alt="">
				</a>
			</div>
			<div class="col-md-6 col-lg-4">
				<a class="portfolio-item d-block mx-auto" href="#portfolio-modal-5">
					<div
						class="portfolio-item-caption d-flex position-absolute h-100 w-100">
						<div
							class="portfolio-item-caption-content my-auto w-100 text-center text-white">
							<i class="fa fa-search-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid"
					src="resources/freelance/img/portfolio/safe.png" alt="">
				</a>
			</div>
			<div class="col-md-6 col-lg-4">
				<a class="portfolio-item d-block mx-auto" href="#portfolio-modal-6">
					<div
						class="portfolio-item-caption d-flex position-absolute h-100 w-100">
						<div
							class="portfolio-item-caption-content my-auto w-100 text-center text-white">
							<i class="fa fa-search-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid"
					src="resources/freelance/img/portfolio/submarine.png" alt="">
				</a>
			</div>
		</div>
	</div>
</section>

<!-- About Section -->
<section class="bg-primary text-white mb-0" id="about">
	<div class="container">
		<h2 class="text-center text-uppercase text-white">About</h2>
		<hr class="star-light mb-5">
		<div class="row">
			<div class="col-lg-4 ml-auto">
				<p class="lead">Freelancer is a free bootstrap theme created by
					Start Bootstrap. The download includes the complete source files
					including HTML, CSS, and JavaScript as well as optional LESS
					stylesheets for easy customization.</p>
			</div>
			<div class="col-lg-4 mr-auto">
				<p class="lead">Whether you're a student looking to showcase
					your work, a professional looking to attract clients, or a graphic
					artist looking to share your projects, this template is the perfect
					starting point!</p>
			</div>
		</div>
		<div class="text-center mt-4">
			<a class="btn btn-xl btn-outline-light" href="#"> <i
				class="fa fa-download mr-2"></i> Download Now!
			</a>
		</div>
	</div>
</section>

<!-- Contact Section -->
<section id="contact">
	<div class="container">
		<h2 class="text-center text-uppercase text-secondary mb-0">Contact
			Me</h2>
		<hr class="star-dark mb-5">
		<div class="row">
			<div class="col-lg-8 mx-auto">
				<!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
				<!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
				<form name="sentMessage" id="contactForm" novalidate="novalidate">
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Name</label> <input class="form-control" id="name"
								type="text" placeholder="Name" required="required"
								data-validation-required-message="Please enter your name.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Email Address</label> <input class="form-control"
								id="email" type="email" placeholder="Email Address"
								required="required"
								data-validation-required-message="Please enter your email address.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Phone Number</label> <input class="form-control"
								id="phone" type="tel" placeholder="Phone Number"
								required="required"
								data-validation-required-message="Please enter your phone number.">
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="control-group">
						<div
							class="form-group floating-label-form-group controls mb-0 pb-2">
							<label>Message</label>
							<textarea class="form-control" id="message" rows="5"
								placeholder="Message" required="required"
								data-validation-required-message="Please enter a message."></textarea>
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<br>
					<div id="success"></div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-xl"
							id="sendMessageButton">Send</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>

<!-- Footer -->
<footer class="footer text-center">
	<div class="container">
		<div class="row">
			<div class="col-md-4 mb-5 mb-lg-0">
				<h4 class="text-uppercase mb-4">Location</h4>
				<p class="lead mb-0">
					2215 John Daniel Drive <br>Clark, MO 65243
				</p>
			</div>
			<div class="col-md-4 mb-5 mb-lg-0">
				<h4 class="text-uppercase mb-4">Around the Web</h4>
				<ul class="list-inline mb-0">
					<li class="list-inline-item"><a
						class="btn btn-outline-light btn-social text-center rounded-circle"
						href="#"> <i class="fa fa-fw fa-facebook"></i>
					</a></li>
					<li class="list-inline-item"><a
						class="btn btn-outline-light btn-social text-center rounded-circle"
						href="#"> <i class="fa fa-fw fa-google-plus"></i>
					</a></li>
					<li class="list-inline-item"><a
						class="btn btn-outline-light btn-social text-center rounded-circle"
						href="#"> <i class="fa fa-fw fa-twitter"></i>
					</a></li>
					<li class="list-inline-item"><a
						class="btn btn-outline-light btn-social text-center rounded-circle"
						href="#"> <i class="fa fa-fw fa-linkedin"></i>
					</a></li>
					<li class="list-inline-item"><a
						class="btn btn-outline-light btn-social text-center rounded-circle"
						href="#"> <i class="fa fa-fw fa-dribbble"></i>
					</a></li>
				</ul>
			</div>
			<div class="col-md-4">
				<h4 class="text-uppercase mb-4">About Freelancer</h4>
				<p class="lead mb-0">
					Freelance is a free to use, open source Bootstrap theme created by
					<a href="http://startbootstrap.com">Start Bootstrap</a>.
				</p>
			</div>
		</div>
	</div>
</footer>

<div class="copyright py-4 text-center text-white">
	<div class="container">
		<small>Copyright &copy; Your Website 2018</small>
	</div>
</div>

<!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
<div class="scroll-to-top d-lg-none position-fixed ">
	<a class="js-scroll-trigger d-block text-center text-white rounded"
		href="#page-top"> <i class="fa fa-chevron-up"></i>
	</a>
</div>

<!-- Portfolio Modal 1.1 -->
<div class="portfolio-modal mfp-hide" id="portfolio-modal-1">
	<div class="portfolio-modal-dialog bg-white">
		<a class="close-button d-none d-md-block portfolio-modal-dismiss"
			href="#"> <i class="fa fa-3x fa-times"></i>
		</a>
		<div class="container text-center">
			<div class="row">
				<form class="form-horizontal">
					<div class="col-lg-8 mx-auto">
						<h2 class="text-secondary text-uppercase mb-0">Reiniciar
							Procesos</h2>
						<hr class="star-dark mb-5">
						<img class="img-fluid mb-5"
							src="resources/freelance/img/portfolio/cabin.png" alt=""> 	
						<sec:authorize access="hasRole('ROLE_ADMIN')">	
						<input
							id="button-restart-AT" type="button" value="ARMANDO DE TREN!"
							onclick="doAjaxPostArmadoTren();" class="btn btn-success" />
						 <br>
						 <br> 
						 <input id="button-restart-VE"
							type="button" value="VERIFICACION DE ERRORES!"
							onclick="doAjaxPostVerificaErrores();" class="btn btn-success" />
							
						</br>
						</br>
							
						<input
							id="button-restart-CEO" type="button"
							value="REINICIA PROCESO CEO!" onclick="doAjaxPostReiniciaCEO();"
							class="btn btn-success" /></br> <br> 
							
						</sec:authorize>
							
						<br> <input id="button-restart-C0"
							type="button" value="CARTEL 0!" onclick="doAjaxPostCartel0();"
							class="btn btn-success" /></br> <br> 
							
						
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModal">Eliminar Equipo</button>
						<br> <br> 
						
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModalEquipos">Eliminar Equipos</button>
						<br> <br>
						
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#exampleModalTrenD">Eliminar Tren Duplicado</button>
						<br> <br> 
						<a
							class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss"
							href="#"> <i class="fa fa-close"></i> Salir Reinicia procesos
						</a>


						<div id="subViewDiv"></div>
						<p class="mb-5">Seccion para el manejo de JHE, reinicio de
							servicios.</p>





						<div id="exampleModal4">
							<div id="exampleModal2" class="modal fade load-spinner"
								data-backdrop="static" data-keyboard="false" tabindex="-1">
								<div id="exampleModal3" class="modal-dialog modal-sm">
									<div class="modal-content" style="width: 150px; height: 100px">
										<span class="fa fa-spinner fa-spin fa-3x"></span>
										<h1 style="font-size: 100%;">Loading ...</h1>
									</div>
								</div>
							</div>
						</div>




						<input type="hidden" id="inicial" name="inicial" value="" /> <input
							type="hidden" id="numero" name="numero" value="" />

						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Eliminar
											Equipo</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<table>
											<tr>
												<td>Inicial......<input type="text" id="inpt-inicial"
													name="inicial">
												</td>

											</tr>
											<tr>
												<td>Numero.<input type="text" id="inpt-numero"
													name="numero">
												</td>
											</tr>
										</table>
									</div>
									<div class="modal-footer">
										<input id="button-restart-EQ" type="button" value="Eliminar"
											onclick="doAjaxPostEliminaEquipo();" class="btn btn-primary" />
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Cancelar</button>
									</div>
								</div>
							</div>
						</div>
						





						<div class="modal fade" id="exampleModalEquipos" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Eliminar
											Equipos</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										Lista Equipos<br>
										<textarea id="inpt-unidades" name="unidades" cols="50" rows="10" >InicialNumero,InicialNumero...</textarea>
									</div>
									<div class="modal-footer">
										<input id="button-restart-EQ" type="button" value="Eliminar"
											onclick="doAjaxPostEliminaEquipos();" class="btn btn-primary" />
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Cancelar</button>
									</div>
								</div>
							</div>
						</div>
						
						
						
						<!-- Modal -->
						<div class="modal fade" id="exampleModalTrenD" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Eliminar
											Tren DuplicaDO</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<table>
											<tr>
												<td>Tren......<input type="text" id="inpt-tren"
													name="tren">
												</td>

											</tr>
											<tr>
												<td>Fecha Tren...<input type="text" id="inpt-dia"
													name="fecTren">
												</td>
											</tr>
											
											<tr>
												<td>Estacion(CIR7)<input type="text" id="inpt-estacion"
													name="estacion">
												</td>
											</tr>
											
										</table>
									</div>
									<div class="modal-footer">
										<input id="button-restart-EQ" type="button" value="Eliminar"
											onclick="doAjaxPostEliminaTrenDuplicado();" class="btn btn-primary" />
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Cancelar</button>
									</div>
								</div>
							</div>
						</div>


					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Portfolio Modal 2 -->
<div class="portfolio-modal mfp-hide" id="portfolio-modal-2">
	<div class="portfolio-modal-dialog bg-white">
		<a class="close-button d-none d-md-block portfolio-modal-dismiss"
			href="#"> <i class="fa fa-3x fa-times"></i>
		</a>
		<div class="container text-center">
			<div class="row">
				<c:url var="reiniciaJHE" value="/reiniciaJHE" />
				<form class="form-horizontal">
					<div class="col-lg-8 mx-auto">
						<h2 class="text-secondary text-uppercase mb-0">Reiniciar
							todos los JHE Procesos</h2>
						<hr class="star-dark mb-5">
						<img class="img-fluid mb-5"
							src="resources/freelance/img/portfolio/cake.png" alt="">
					<sec:authorize access="hasRole('ROLE_ADMIN')">	
						 <input
							id="button-restart-jhe" type="button" value="RESTART ALL JHE!"
							onclick="doAjaxPostJHE();" class="btn btn-danger" /> <br> <br>
						<br> 
						
					</sec:authorize>
					
					<input id="button-status-jhe" type="button"
							value="STATUS JHE!" onclick="doAjaxPostSTSJHE();"
							class="btn btn btn-info" /> <br> <br> <br>		
						<a
							class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss"
							href="#"> <i class="fa fa-close"></i> Salir Reinicia procesos
						</a>

						<div id="subViewDiv">
							<H1>PROCESOS</H1>
							<H1 class="text-primary">JHE ACTIVOS 75 ::${total75}</H1>
							<table class="table table-dark">
								<thead>
									<tr>

										<th scope="col">Server</th>
										<th scope="col">Proceso</th>
										<th scope="col">PID</th>
										<th scope="col">CPU</th>
										<th scope="col">MEM</th>
										<th scope="col">TIME</th>

									</tr>
								</thead>
								<tbody>

									<c:forEach items="${listaProcesoDetallado75}" var="estatusJHE"
										varStatus="tagStatus">
										<tr>
											<td>${estatusJHE.server}</td>
											<td>${estatusJHE.tmiProces}</td>
											<td>${estatusJHE.pid}</td>
											<td>${estatusJHE.cpu}</td>
											<td>${estatusJHE.mem}</td>
											<td>${estatusJHE.time}</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>

							<H1 class="text-primary">JHE ACTIVOS 76 ::${total76}</H1>
							<table class="table table-dark">
								<thead>
									<tr>

										<th scope="col">Server</th>
										<th scope="col">Proceso</th>
										<th scope="col">PID</th>
										<th scope="col">CPU</th>
										<th scope="col">MEM</th>
										<th scope="col">TIME</th>

									</tr>
								</thead>
								<tbody>


									<c:forEach items="${listaProcesoDetallado76}" var="estatusJHE"
										varStatus="tagStatus">
										<tr>

											<td>${estatusJHE.server}</td>
											<td>${estatusJHE.tmiProces}</td>
											<td>${estatusJHE.pid}</td>
											<td>${estatusJHE.cpu}</td>
											<td>${estatusJHE.mem}</td>
											<td>${estatusJHE.time}</td>

										</tr>
									</c:forEach>

								</tbody>
							</table>


							<H1 class="text-primary">JHE ACTIVOS 78 ::${total78}</H1>
							<table class="table table-dark">
								<thead>
									<tr>

										<th scope="col">Server</th>
										<th scope="col">Proceso</th>
										<th scope="col">PID</th>
										<th scope="col">CPU</th>
										<th scope="col">MEM</th>
										<th scope="col">TIME</th>

									</tr>
								</thead>
								<tbody>


									<c:forEach items="${listaProcesoDetallado78}" var="estatusJHE"
										varStatus="tagStatus">
										<tr>

											<td>${estatusJHE.server}</td>
											<td>${estatusJHE.tmiProces}</td>
											<td>${estatusJHE.pid}</td>
											<td>${estatusJHE.cpu}</td>
											<td>${estatusJHE.mem}</td>
											<td>${estatusJHE.time}</td>

										</tr>
									</c:forEach>

								</tbody>
							</table>

							<H1 class="text-primary">JHE ACTIVOS 79 ::${total79}</H1>
							<table class="table table-dark">
								<thead>
									<tr>

										<th scope="col">Server</th>
										<th scope="col">Proceso</th>
										<th scope="col">PID</th>
										<th scope="col">CPU</th>
										<th scope="col">MEM</th>
										<th scope="col">TIME</th>

									</tr>
								</thead>
								<tbody>


									<c:forEach items="${listaProcesoDetallado79}" var="estatusJHE"
										varStatus="tagStatus">
										<tr>

											<td>${estatusJHE.server}</td>
											<td>${estatusJHE.tmiProces}</td>
											<td>${estatusJHE.pid}</td>
											<td>${estatusJHE.cpu}</td>
											<td>${estatusJHE.mem}</td>
											<td>${estatusJHE.time}</td>

										</tr>
									</c:forEach>

								</tbody>
							</table>


						</div>
						<p class="mb-5">Seccion para el manejo de JHE, reinicio de
							servicios.</p>

						<div class="modal fade load-spinner" data-backdrop="static"
							data-keyboard="false" tabindex="-1">
							<div class="modal-dialog modal-sm">
								<div class="modal-content" style="width: 150px; height: 100px">
									<span class="fa fa-spinner fa-spin fa-3x"></span>
									<h1 style="font-size: 100%;">Loading ...</h1>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Portfolio Modal 3 -->
<div class="portfolio-modal mfp-hide" id="portfolio-modal-3">
	<div class="portfolio-modal-dialog bg-white">
		<a class="close-button d-none d-md-block portfolio-modal-dismiss"
			href="#"> <i class="fa fa-3x fa-times"></i>
		</a>
		<div class="container text-center">
			<div class="row">
				<form class="form-horizontal">
					<div class="col-lg-8 mx-auto">
						<h2 class="text-secondary text-uppercase mb-0">Reiniciar TADS</h2>
						<hr class="star-dark mb-5">
						<img class="img-fluid mb-5"
							src="resources/freelance/img/portfolio/circus.png" alt="">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<input id="button-restart-tad" type="button" value="RESTART TADS!"
							onclick="doAjaxPostTAD();" class="btn btn-danger" /> <br> <br>
						
						</sec:authorize>
						
						<input id="button-status-tad" type="button" value="STATUS TADS!"
							onclick="doAjaxPostSTSTAD();" class="btn btn btn-info" /><br>
						<br> 
						
						<a class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss"
							href="#"> <i class="fa fa-close"></i> Salir Reinicia TADS
						</a>


						<div id="subViewDivTad">
							<H1>PROCESOS</H1>
							<H1 class="text-primary">JHE ACTIVOS 6.80 ::${total680}</H1>
							<table class="table table-dark">
								<thead>
									<tr>

										<th scope="col">Server</th>
										<th scope="col">Proceso</th>
										<th scope="col">PID</th>
										<th scope="col">MEM</th>
										<th scope="col">TIME</th>

									</tr>
								</thead>
								<tbody>

									<c:forEach items="${listaProcesoDetallado680}" var="estatusTAD"
										varStatus="tagStatus">
										<tr>
											<td>${estatusTAD.server}</td>
											<td>${estatusTAD.tadProces}</td>
											<td>${estatusTAD.pid}</td>
											<td>${estatusTAD.mem}</td>
											<td>${estatusTAD.time}</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>

							<H1 class="text-primary">JHE ACTIVOS 12.80 ::${total1280}</H1>
							<table class="table table-dark">
								<thead>
									<tr>

										<th scope="col">Server</th>
										<th scope="col">Proceso</th>
										<th scope="col">PID</th>
										<th scope="col">MEM</th>
										<th scope="col">TIME</th>

									</tr>
								</thead>
								<tbody>

									<c:forEach items="${listaProcesoDetallado1280}"
										var="estatusTAD" varStatus="tagStatus">
										<tr>
											<td>${estatusTAD.server}</td>
											<td>${estatusTAD.tadProces}</td>
											<td>${estatusTAD.pid}</td>
											<td>${estatusTAD.mem}</td>
											<td>${estatusTAD.time}</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<div class="modal fade load-spinner" data-backdrop="static"
							data-keyboard="false" tabindex="-1">
							<div class="modal-dialog modal-sm">
								<div class="modal-content" style="width: 150px; height: 100px">
									<span class="fa fa-spinner fa-spin fa-3x"></span>
									<h1 style="font-size: 100%;">Loading ...</h1>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Portfolio Modal 4 -->
<div class="portfolio-modal mfp-hide" id="portfolio-modal-4">
	<div class="portfolio-modal-dialog bg-white">
		<a class="close-button d-none d-md-block portfolio-modal-dismiss"
			href="#"> <i class="fa fa-3x fa-times"></i>
		</a>
		<div class="container text-center">
			<div class="row">
				<form class="form-horizontal">
					<div class="col-lg-8 mx-auto">
						<h2 class="text-secondary text-uppercase mb-0">Reiniciar TADS</h2>
						<hr class="star-dark mb-5">
						<img class="img-fluid mb-5"
							src="resources/freelance/img/portfolio/circus.png" alt="">

						<!-- <input id="button-restart-TA" type="button" value="!RESTART ALL!"
							onclick="doAjaxPostReiniciaTodo();" class="btn btn-danger" />


						<button type="button" class="btn btn-primary btn-lg"
							data-toggle="modal" data-target="#miModal">Abrir modal</button> -->
						<div id="subViewDiv"></div>
						<p class="mb-5">Seccion para el manejo de TADS, reinicio de
							servicios.</p>
						<a
							class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss"
							href="#"> <i class="fa fa-close"></i> Salir Reinicia TADS
						</a>
						<div class="modal fade load-spinner" data-backdrop="static"
							data-keyboard="false" tabindex="-1">
							<div class="modal-dialog modal-sm">
								<div class="modal-content" style="width: 150px; height: 100px">
									<span class="fa fa-spinner fa-spin fa-3x"></span>
									<h1 style="font-size: 100%;">Loading ...</h1>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- Portfolio Modal 5 -->
<div class="portfolio-modal mfp-hide" id="portfolio-modal-5">
	<div class="portfolio-modal-dialog bg-white">
		<a class="close-button d-none d-md-block portfolio-modal-dismiss"
			href="#"> <i class="fa fa-3x fa-times"></i>
		</a>
		<div class="container text-center">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
					<hr class="star-dark mb-5">
					<img class="img-fluid mb-5"
						src="resources/freelance/img/portfolio/safe.png" alt="">
					<p class="mb-5">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias
						magnam, recusandae quos quis inventore quisquam velit asperiores,
						vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
					<a
						class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss"
						href="#"> <i class="fa fa-close"></i> Close Project
					</a>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Portfolio Modal 6 -->
<div class="portfolio-modal mfp-hide" id="portfolio-modal-6">
	<div class="portfolio-modal-dialog bg-white">
		<a class="close-button d-none d-md-block portfolio-modal-dismiss"
			href="#"> <i class="fa fa-3x fa-times"></i>
		</a>
		<div class="container text-center">
			<div class="row">
				<div class="col-lg-8 mx-auto">
					<h2 class="text-secondary text-uppercase mb-0">Project Name</h2>
					<hr class="star-dark mb-5">
					<img class="img-fluid mb-5"
						src="resources/freelance/img/portfolio/submarine.png" alt="">
					<p class="mb-5">Lorem ipsum dolor sit amet, consectetur
						adipisicing elit. Mollitia neque assumenda ipsam nihil, molestias
						magnam, recusandae quos quis inventore quisquam velit asperiores,
						vitae? Reprehenderit soluta, eos quod consequuntur itaque. Nam.</p>
					<a
						class="btn btn-primary btn-lg rounded-pill portfolio-modal-dismiss"
						href="#"> <i class="fa fa-close"></i> Close Project
					</a>
				</div>
			</div>
		</div>
	</div>
</div>