<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
label {
    cursor: pointer;
}
<%@

include file ="../style/login2.css" %> 
</style>
</head>
<body role="document">
	<div id="fullscreen_bg" class="fullscreen_bg" />
	<div id="regContainer" class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">

								<label onclick="changeForm()"><font size="5px">Login</font></label>

							</div>
							<div class="col-xs-6">
								<label onclick="changeRegForm()"><font size="5px">Register</font></label>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form:form id="register-form" action="${pageContext.request.contextPath}/registration" method="post"
									role="form"  modelAttribute="registerUser">
									<div class="form-group">
										<label for="username">Username</label> 
										<form:input type="text" path="userName"
											name="username" id="username" tabindex="1"
											class="form-control" placeholder="Username" value=""/>
									</div>
									<div class="form-group">
										<label for="email">E-mail</label> 
										<form:input type="text" path="email"
											name="email" id="email" tabindex="1" class="form-control"
											placeholder="E-mail" value=""/>
									</div>
									
									<div class="form-group">
										<label for="confirm-password">Password</label> <form:input
											type="password" name="confirm-password" id="confirm-password"
											tabindex="2" class="form-control" path="password"
											placeholder="Password"/>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit"
													id="register-submit" tabindex="4"
													class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">
function changeForm()
{
	window.location = "${pageContext.request.contextPath}/login";
}
function changeRegForm()
{

	window.location = "${pageContext.request.contextPath}/registration";
}
</script>

</html>

