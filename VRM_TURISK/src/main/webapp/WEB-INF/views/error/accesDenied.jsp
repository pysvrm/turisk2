<!--Welcome.jsp-->
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<center>
	<p>
		<font size="6" color="#F8FBEF"> <strong>${user}</strong>, No
			estas autorizado para visualizar esta pagina. <a
			href="<c:url value="/logout" />">Salir</a> <img class="img-fluid"
			src="resources/freelance/img/portfolio/block_02.png" alt="">
		</font>
	</p>
</center>