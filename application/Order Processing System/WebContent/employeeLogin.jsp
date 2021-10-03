<%@ page language="java" session="false" import="java.util.List,com.orderprocessing.controller.EmployeeController" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	
	<link
	      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	      rel="stylesheet"
	/>
	
	<link rel="stylesheet" href="css/styles.css">
	
</head>

<body>
	<%@ include file="header.html"%>
	<div class="align-center">  

<div>
        <!-- User Image -->
        <svg width="82" height="82" viewBox="0 0 82 82" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M41 1C18.908 1 1 18.908 1 41C1 63.092 18.908 81 41 81C63.092 81 81 63.092 81 41C81 18.908 63.092 1 41 1Z" fill="#4385E9" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
            <path d="M10.0845 66.384C10.0845 66.384 19.0005 55 41.0005 55C63.0005 55 71.9205 66.384 71.9205 66.384" fill="#4385E9"/>
            <path d="M10.0845 66.384C10.0845 66.384 19.0005 55 41.0005 55C63.0005 55 71.9205 66.384 71.9205 66.384" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
            <path d="M41 41C44.1826 41 47.2348 39.7357 49.4853 37.4853C51.7357 35.2348 53 32.1826 53 29C53 25.8174 51.7357 22.7652 49.4853 20.5147C47.2348 18.2643 44.1826 17 41 17C37.8174 17 34.7652 18.2643 32.5147 20.5147C30.2643 22.7652 29 25.8174 29 29C29 32.1826 30.2643 35.2348 32.5147 37.4853C34.7652 39.7357 37.8174 41 41 41Z" fill="#4385E9" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
        </svg>       
</div>
    <br>
    <div class="heading-txt"> Employee Login</div>
    <br><br>
    <div>
        <!-- Form for id and password -->
        
        <form action="EmployeeController" method="POST" id="empform">
            <div>
                <input class="input" type="text" placeholder="Employee Id" name="ename" required>  
            </div>
            <br><br>
            <div>
                <input class="input" type="password" placeholder="Password" name="epswd" required>
            </div>
        </form>
    </div>
    <br>
    <div>
        <!-- Employee Login Button -->

        <button class="button-login button-txt" form="empform" value="submit"> 
                Login</button>
        </div>

</div>


	
</body>
</html>

