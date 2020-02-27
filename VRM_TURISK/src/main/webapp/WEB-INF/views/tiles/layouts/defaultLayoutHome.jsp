<!DOCTYPE html>
<!--Welcome.jsp-->
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<html>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>VRM TURISK 1.0</title>

<!-- Plugin CSS -->
<link
	href="<c:url value="resources/freelance/vendor/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css">

<!-- Custom fonts for this template -->
<link
	href="<c:url value="resources/freelance/vendor/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet" type="text/css">

<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">

<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<link
	href="<c:url value="resources/freelance/vendor/magnific-popup/magnific-popup.css"/>"
	rel="stylesheet" type="text/css">

<link href="<c:url value="resources/freelance/css/freelancer.min.css"/>"
	rel="stylesheet" type="text/css">

<link href="<c:url value='resources/freelance/css/app.css' />"
	rel="stylesheet"></link>

<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

<link
	href="<c:url value="resources/freelance/vendor/bootstrap/css/loading-state.css"/>"
	rel="stylesheet" type="text/css">

<link
	href="<c:url value="resources/freelance/vendor/bootstrap/css/loading-state.min.css"/>"
	rel="stylesheet" type="text/css">

</head>

<body id="page-top">
	<tiles:insertAttribute name="body" />
	<script type="text/javascript"
		src="<c:url value="resources/freelance/vendor/jquery/jquery.min.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="resources/freelance/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="resources/freelance/vendor/bootstrap/js/loading-state.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="resources/freelance/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="resources/freelance/vendor/magnific-popup/jquery.magnific-popup.min.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="resources/freelance/js/jqBootstrapValidation.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="resources/freelance/js/freelancer.min.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="resources/js/to/charts/dist/Chart.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="resources/js/to/charts/dist/Chart.bundle.min.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="resources/js/to/charts/dist/utils.js"/>"></script>

	<script type="text/javascript"
		src="<c:url value="resources/js/to/charts/dist/utils.js"/>"></script>

	<script>
		$(function() {
			$(".btn").click(function() {
				$(this).button('loading').delay(1000).queue(function() {
					$(this).button('reset');
					$(this).dequeue();
				});
			});
		});
	</script>
	<!-- JS,JQ,BT.JS
	<script type="text/javascript"  src="<c:url value="/resources/jquery/jquery-3.2.1.js" />"></script>
	<script type="text/javascript"  src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    -->

</body>
</html>