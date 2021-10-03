<%@ page language="java" session="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Processing System</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
      rel="stylesheet"
/>
<link rel="stylesheet" href="css/styles.css"/>
</head>

<body>
	<%@ include file="header.html"%>
    <div class="align-center">
        <div>
        <!-- Employee Login Button -->

            <a href="employeeLogin.jsp">
            	<button class="button button-txt">
            		<svg width="37" height="37" viewBox="0 0 37 37" fill="none" xmlns="http://www.w3.org/2000/svg">
		                <path d="M18.5 1C8.83475 1 1 8.83475 1 18.5C1 28.1652 8.83475 36 18.5 36C28.1652 36 36 28.1652 36 18.5C36 8.83475 28.1652 1 18.5 1Z" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
		                <path d="M4.97461 29.6055C4.97461 29.6055 8.87536 24.625 18.5004 24.625C28.1254 24.625 32.0279 29.6055 32.0279 29.6055" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
		                <path d="M18.5 18.5C19.8924 18.5 21.2277 17.9469 22.2123 16.9623C23.1969 15.9777 23.75 14.6424 23.75 13.25C23.75 11.8576 23.1969 10.5223 22.2123 9.53769C21.2277 8.55312 19.8924 8 18.5 8C17.1076 8 15.7723 8.55312 14.7877 9.53769C13.8031 10.5223 13.25 11.8576 13.25 13.25C13.25 14.6424 13.8031 15.9777 14.7877 16.9623C15.7723 17.9469 17.1076 18.5 18.5 18.5V18.5Z" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
                    </svg>
               Employee Login</button>
            </a>
        
        </div>
        <br>
        <br>
        <div>
        <!-- Custommer Login -->
	<a href="customerlogin.jsp">
        <button class="button button-txt">
            <svg width="37" height="37" viewBox="0 0 37 37" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M18.5 1C8.83475 1 1 8.83475 1 18.5C1 28.1652 8.83475 36 18.5 36C28.1652 36 36 28.1652 36 18.5C36 8.83475 28.1652 1 18.5 1Z" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
                <path d="M4.97461 29.6055C4.97461 29.6055 8.87536 24.625 18.5004 24.625C28.1254 24.625 32.0279 29.6055 32.0279 29.6055" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
                <path d="M18.5 18.5C19.8924 18.5 21.2277 17.9469 22.2123 16.9623C23.1969 15.9777 23.75 14.6424 23.75 13.25C23.75 11.8576 23.1969 10.5223 22.2123 9.53769C21.2277 8.55312 19.8924 8 18.5 8C17.1076 8 15.7723 8.55312 14.7877 9.53769C13.8031 10.5223 13.25 11.8576 13.25 13.25C13.25 14.6424 13.8031 15.9777 14.7877 16.9623C15.7723 17.9469 17.1076 18.5 18.5 18.5V18.5Z" stroke="white" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
                </svg>
            Customer Login</button>
     </a>
        </div>
    </div>
</body>
</html>
