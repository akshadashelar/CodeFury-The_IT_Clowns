<!DOCTYPE  html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>import products</title>
    <link rel="stylesheet" href="css/styles.css">
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
      <%@ include file="header.html"%> 
	 <form action="ProductController" method="POST" enctype="multipart/form-data">
	 	<div class="drag-area">
			<div class="icon"><button><i class="fas fa-cloud-upload-alt"></i></button></div>
			<header id="uploadline">Upload File to Import Products</header>
			<span></span>
			<input type="hidden" id="operation" name="operation" value="importproduct">
			<input type="file" name="products">
			<input id ="upload" type="submit" value="Submit">
		</div>
	</form>
	<br><br>
	<%
	try {
		int count = (int)request.getAttribute("successCount");
	%>
	<p>Number of Products added: <%= count %></p>
	<%} catch(Exception e) {} %>
	<script src="importproducts.js"></script>

</body>
</html>