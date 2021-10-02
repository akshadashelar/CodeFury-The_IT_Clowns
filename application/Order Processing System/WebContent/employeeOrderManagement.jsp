<%@ page language="java" import="java.util.List,com.orderprocessing.controller.OrderController, com.orderprocessing.entity.Order, com.orderprocessing.util.OrderStatus" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Order Management</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link href="css/styles.css" rel="stylesheet" />
</head>

	<body id="body-pd">
	<%@ include file="header.html"%>
    <div class="container">
    <div class="orders">Orders</div><br>

           <div class="listnames">List Of Orders</div>
           
    
                <table rules="rows"class="table2">             
                    <thead>
                        <tr>
                            <th>Customer Id</th>
                            <th>Date</th>
                            <th>Customer Name</th>
                            <th>Customer City</th>						
                            <th>Order Value</th>						
                            <th>Status</th>
                            <!-- <th>Invoice Status</th> -->
                        </tr>
                    </thead>
                    
                   <!--  -----------------fetching orders--------------------------- -->
                   
                  <%  List<Order> displayOrders = (List<Order>)request.getAttribute("allOrders");
                   	for(Order o:displayOrders){
                   		
                   %>
                   	
    
                    <tbody>
                        <tr>
                            <td ><%=o.getOrderId() %></td>
                            <td><%=o.getOrderDate() %></td>
                            <td>Gojo Satora</td>
                            <td><%=o.getCustomerShippingAddress() %></td>  
                            <td><%=o.getOrderValue() %></td> 
                            <td><%=o.getStatus() %></td>   
                             <% if(o.getStatus()== OrderStatus.Approved || o.getStatus()==OrderStatus.Completed){%>
                            	<td>
                            		<form action="InvoiceController" method="post">
                            			<input type="text" name="operation" value="custInvoice" hidden>
                            			<input type="text" name="orderId" value="<%=o.getOrderId() %>" hidden>
                            			<button class="approved" type="submit">Invoice</button>
                            		</form>
                            	</td>
                           <% }%>
                                         
                            
                        </tr>
                        
                        <%} %>
        <!--   ----------------------end of fetching data------------------------- -->
    
                    </tbody> 
                    
                </table>
                <div class="button-align">
                <a href="http://localhost:8080/Order_Processing_System/newquote.jsp">
                <button class="button-order button-txt-order button-align"> 
                                     
                    Create New Quote</button></a>
                <a href="http://localhost:8080/Order_Processing_System/importproducts.jsp">
                <button class="button-order button-txt-order button-align"> 
                            
                    Import New Products</button></a>
                </div>
            </div>             

</body>
</html>