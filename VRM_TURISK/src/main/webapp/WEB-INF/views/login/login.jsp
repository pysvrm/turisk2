<!--login.jsp-->
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<div id="mainWrapper">
	<div class="login-container">
		<div class="login-card">
			<div class="login-form">
				<c:url var="loginUrl" value="/home" />
				<form action="${loginUrl}" method="post" class="form-horizontal">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid username and password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>You have been logged out successfully.</p>
						</div>
					</c:if>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="username"><i
							class="fa fa-user"></i></label> <input type="text" class="form-control"
							id="username" name="ssoId" placeholder="Enter Username" required>
					</div>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="password"><i
							class="fa fa-lock"></i></label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Enter Password" required>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <br>
					<div class="form-actions">
						<input type="submit" class="btn btn-block btn-primary btn-default" value="Log in"> 
						<input type="submit" class="btn btn-block btn-primaryG btn-default" value="Gmail">
					</div>
				</form>
				<br>
				
				<c:url var="loginUrlFacebook" value="/signin/facebook" />
				<form action="${loginUrlFacebook}" method="post" class="form-horizontal">
					<input type="submit" class="btn btn-block btn-primaryF btn-default" value="Facebook">
				</form>
			</div>
		</div>
	</div>
</div>