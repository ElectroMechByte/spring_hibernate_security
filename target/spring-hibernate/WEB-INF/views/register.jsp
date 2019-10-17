<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Here</title>
<link rel="icon" type="image/x-icon"
	href="<c:url value="/resources/images/favicon1.png"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/register.css"/>">

</head>
<body>
<%@ include file="navbar.jsp"%>
	<div class="container" style="margin-top: 20px">

		<h1 class="well">Register Here !</h1>
		<div class="col-lg-12 well">
			<div class="row">

				<!--  RegisterServlet  form -->
				 
				 <c:url value="/customer/register" var="saveUrl"></c:url>
				<form:form id="regForm" modelAttribute="data" action="${saveUrl}" method="post">
				
					<br>
					<div class="col-sm-12">
						<div class="row">
							<div>
								<center>User Details</center>
							</div>
							<div class="col-sm-6 form-group ">
								<form:label path="firstname">FirstName:</form:label>
								<form:input path="firstname" class="form-control" id="firstname" required="true" />
							</div>
							<div class="col-sm-6 form-group">
								<form:label path="lastname">LastName:</form:label>
								<form:input path="lastname" class="form-control" id="lastname" required="true" />
							</div>
							
							 
							
						</div>
						  <div class="row">
							<div class="col-sm-6 form-group">
								<form:label path="users.emailId">Email Id</form:label>
								<form:input type="text" placeholder="Enter Email ID.."
									class="form-control" path="users.emailId"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<form:label path="customerPhone">Phone Number</form:label>
								<form:input type="text" placeholder="Enter Phone Number.."
									class="form-control" path="customerPhone"></form:input>
							</div>
						</div>  
						<hr>
					 	<div>
							<center>Shipping Address</center>
						</div>
						<div class="form-group">
							<form:label path="shippingAddress.address">Address</form:label>
							<form:textarea type="text" placeholder="Enter Shipping Address.."
								class="form-control" path="shippingAddress.address"></form:textarea>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<form:label path="shippingAddress.city">City</form:label>
								<form:input type="text" placeholder="Enter Current City.."
									class="form-control" path="shippingAddress.city"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<form:label path="shippingAddress.state">State</form:label>
								<form:input type="text" placeholder="Enter your State.."
									class="form-control" path="shippingAddress.state"></form:input>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<form:label path="shippingAddress.country">Country</form:label>
								<form:input type="text" placeholder="Enter your country.."
									class="form-control" path="shippingAddress.country"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<form:label path="shippingAddress.zipcode">Zipcode</form:label>
								<form:input type="text" placeholder="Enter zipcode.."
									class="form-control" path="shippingAddress.zipcode"></form:input>
							</div>
						</div>
						<hr>
					<div>
							<center>Billing Address</center>
						</div>
						<div class="form-group">
							<form:label path="billingAddress.address">Address</form:label>
							<form:textarea type="text" placeholder="Enter Billing Address.."
								class="form-control" path="billingAddress.address"></form:textarea>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<form:label path="billingAddress.city">City</form:label>
								<form:input type="text" placeholder="Enter your City.."
									class="form-control" path="billingAddress.city"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<form:label path="billingAddress.state">State</form:label>
								<form:input type="text" placeholder="Enter your state.."
									class="form-control" path="billingAddress.state"></form:input>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<form:label path="billingAddress.country">Country</form:label>
								<form:input type="text" placeholder="Enter your City.."
									class="form-control" path="billingAddress.country"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<form:label path="billingAddress.zipcode">Zipcode</form:label>
								<form:input type="text" placeholder="Enter Zipcode.."
									class="form-control" path="billingAddress.zipcode"></form:input>
							</div>
						</div>
					  	<div class="row">
							<div class="col-sm-6 form-group">
								<form:label path="users.password">Password</form:label>
								<form:input type="password" placeholder="********"
									class="form-control" path="users.password" id="pass"></form:input>
							</div>
							<div class="col-sm-6 form-group">
								<label>Confirm Password</label> <input type="password"
									placeholder="********" class="form-control" id="confirmpass" />
							</div>
						</div>  
						<div class="form-actions">
							<button type="submit" class="btn btn-lg btn-info"
								onclick="return Validate()">Submit</button>
						</div>
					</div>

				 

				</form:form>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>

	<!-- Validating Password -->
	<script type="text/javascript">
		function Validate() {
			var password = document.getElementById("pass").value;
			var confirmpass = document.getElementById("confirmpass").value;
			if (password != confirmpass) {
				alert("Password does Not Match.");
				return false;
			}
			return true;
		}
	</script>
</body>
 
</html>