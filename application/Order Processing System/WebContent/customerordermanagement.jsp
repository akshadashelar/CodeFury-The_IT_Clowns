<%@ page language="java" import="java.util.List,com.orderprocessing.controller.OrderController, com.orderprocessing.entity.Order, com.orderprocessing.util.OrderStatus" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Order Management</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link href="css/styles.css" rel="stylesheet" />
</head>

	<body id="body-pd">
	<%@ include file="header.html"%>
    <div class="container">
    <div class="orders">Orders</div>
  <br>
  <div class="listnames">List Of Quotes</div>
  <br>
           
    
                <table rules="rows" class ="table2">
			   <thead>
			   <tr>
			       <th>Order Id</th>
			       <th>Date</th>
			       <th>Order Value</th>
			       <th>Shipping Cost</th>
			       <th>Invoice</th>
			   </tr>
			   </thead>
                    
                   <!--  -----------------fetching quotes--------------------------- -->
                   
                  <%  List<Order> displayQuotes = (List<Order>)request.getAttribute("customerQuotes");
                   	for(Order q:displayQuotes){
                   		
                   %>
                   	
    
                    <tbody>
                        <tr>
                            <td ><%=q.getOrderId() %></td>
                            <td><%=q.getOrderDate() %></td>
                            <td><%=q.getOrderValue() %></td>  
                            <td><%=q.getShippingCost() %></td>    
                            <td><button class="approve">Approve</button></td> 
                                         
                            
                        </tr>
                        
                        <%} %>
        <!--   ----------------------end of fetching orders data------------------------- -->
    
                    </tbody> 
                    
      				</table>
                
 <br>
                
<div class="listnames">List Of Orders</div>
<br>
          		
          		<table rules="rows"class="table2">
				   <thead>
				   <tr >
				       <th>Order Id</th>
				       <th>Date</th>
				       <th>Order Value</th>
				       <th>Shipping Cost</th>
				       <th>Status</th>
				       <th>Invoice</th>
				   </tr>
				   </thead>
          
                   <!--  -----------------fetching orders--------------------------- -->
                   
                   <%  List<Order> displayOrders = (List<Order>)request.getAttribute("customerOrders");
                   	for(Order o:displayOrders){
                   		
                   %>
                   
                   <tbody>
                        <tr>
                            <td ><%=o.getOrderId() %></td>
                            <td><%=o.getOrderDate() %></td>
                            <td><%=o.getOrderValue() %></td>
                            <td><%=o.getShippingCost() %></td>  
                            <td><%=o.getStatus() %></td>   
                             <% if(o.getStatus()== OrderStatus.Approved){%>
                            	<td>
                            		<form action="InvoiceController" method="POST" id="inv<%=o.getOrderId() %>">
                            			<input type="hidden" id="operation" name="operation" value="custInvoice">
                            			<input type="hidden" id="orderId" name="orderId" value="<%=o.getOrderId() %>">
                            		</form>
                            		<button class="approved" form="inv<%=o.getOrderId() %>" value="submit">Show Invoice</button>
                            	</td>
                           <% }%>
                                         
                            
                        </tr>
                        
                        <%} %>
        <!--   ----------------------end of fetching data------------------------- -->
    
                    </tbody> 
          
                
 </div>             

</body>
</html>