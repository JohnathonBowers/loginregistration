<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container col-lg-10 d-flex flex-row">
		<div class="container col-lg-6 me-4">
			<div class="row mt-4">
				<h1 class="text-primary">Register</h1>
			</div>
			<div class="row mt-4">
				<form:form action="/register" method="POST" modelAttribute="newUser">
					<div class="row mb-4">
						<form:label path="username" class="col-sm-3 col-form-label">Username:</form:label>
						<div class="col-sm-9">
							<form:input type="text" path="username" class="form-control"></form:input>
						</div>
						<div class="row">
							<form:errors class="my-2 text-danger" path="username"></form:errors>
						</div>
					</div>
					<div class="row my-4">
						<form:label path="email" class="col-sm-3 col-form-label">Email:</form:label>
						<div class="col-sm-9">
							<form:input type="text" path="email" class="form-control"></form:input>
						</div>
						<div class="row">
							<form:errors class="my-2 text-danger" path="email"></form:errors>
						</div>
					</div>
					<div class="row my-2">
						<form:label path="password" class="col-sm-3 col-form-label">Password:</form:label>
						<div class="col-sm-9">
							<form:input type="password" path="password" class="form-control"></form:input>
						</div>
						<div class="row">
							<form:errors class="my-2 text-danger" path="password"></form:errors>
						</div>
					</div>
					<div class="row my-4">
						<form:label path="confirmPassword" class="col-sm-3 col-form-label">Confirm Password:</form:label>
						<div class="col-sm-9">
							<form:input type="password" path="confirmPassword" class="form-control"></form:input>
						</div>
						<div class="row">
							<form:errors class="my-2 text-danger" path="confirmPassword"></form:errors>
						</div>
					</div>
					<div class="row mt-4 justify-content-end">
						<input type="submit" class="btn btn-primary col-sm-2 me-3" value="Submit" />
					</div>
				</form:form>
			</div>
		</div>
		<div class="container col-lg-6 ms-4">
			<div class="row mt-4">
				<h1 class="text-primary">Login</h1>
			</div>
			<div class="row mt-4">
				<form:form action="/login" method="POST" modelAttribute="newLogin">
					<div class="row mb-4">
						<form:label path="email" class="col-sm-3 col-form-label">Email:</form:label>
						<div class="col-sm-9">
							<form:input type="text" path="email" class="form-control"></form:input>
						</div>
						<div class="row">
							<form:errors class="my-2 text-danger" path="email"></form:errors>
						</div>
					</div>
					<div class="row my-4">
						<form:label path="password" class="col-sm-3 col-form-label">Password:</form:label>
						<div class="col-sm-9">
							<form:input type="password" path="password" class="form-control"></form:input>
						</div>
						<div class="row">
							<form:errors class="my-2 text-danger" path="password"></form:errors>
						</div>
					</div>
					<div class="row mt-2 justify-content-end">
						<input type="submit" class="btn btn-primary col-sm-2 me-3" value="Submit" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>