<%@ page language="java" import="java.util.List, java.util.Map, com.orderprocessing.entity.Invoice,com.orderprocessing.entity.Product,com.orderprocessing.entity.Customer, com.orderprocessing.controller.CustomerController, com.orderprocessing.entity.Order" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Invoice</title>
<link href="main.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="header.html"%>
<% Invoice invoice = (Invoice) request.getAttribute("invoice");
Customer customer = (Customer)request.getAttribute("customer");
Order order = (Order)request.getAttribute("order");
Map<Product, Integer> products = (Map<Product, Integer>)request.getAttribute("products");
System.out.println(products);
%>


	<div class="page-content container">
        <div class="page-header text-blue-d2">
            <h1 class="page-title text-secondary-d1">
                Invoice
                <small class="page-info">
                    <i class="fa fa-angle-double-right text-80"></i>
                    ID: <%= invoice.getInvoiceId() %>
                </small>
            </h1>
    
        </div>
    
        <div class="container px-0">
            <div class="row mt-4">
                <div class="col-12 col-lg-10 offset-lg-1">
                    <div class="row">
                        <div class="col-12">
                            <div class="text-center text-150">
                                <i class="fa fa-book fa-2x text-success-m2 mr-1"></i>
                                <span class="text-default-d3">INVOICE</span>
                            </div>
                        </div>
                    </div>
                    <!-- .row -->
    
                    <hr class="row brc-default-l1 mx-n1 mb-4" />
    
                    <div class="row">
                        <div class="col-sm-6">
                            <div>
                                <span class="text-sm text-grey-m2 align-middle">To:</span>
                                <span class="text-600 text-110 text-blue align-middle">Muskan</span>
                            </div>
                            <div class="text-grey-m2">
                                <div class="my-1">
                                    <%= customer.getCustomerAddress() %>
                                </div>
                                <div class="my-1">
                                    <%=customer.getCustomerCity() %>
                                </div>
                                <div class="my-1"><i class="fa fa-phone fa-flip-horizontal text-secondary"></i> <b class="text-600"><%= customer.getCustomerPhone() %></b></div>
                            </div>
                        </div>
                        <!-- /.col -->
    
                        <div class="text-95 col-sm-6 align-self-start d-sm-flex justify-content-end">
                            <hr class="d-sm-none" />
                            <div class="text-grey-m2">
                                <div class="mt-1 mb-2 text-secondary-m1 text-600 text-125">
                                    Invoice
                                </div>
    
                                <div class="my-2">
                                    <i class="fa fa-circle text-blue-m2 text-xs mr-1"></i> 
                                    <span class="text-600 text-90">ID: <%=invoice.getInvoiceId() %></span> 
                                </div>
    
                                <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1">

                                    </i> <span class="text-600 text-90">Order Date:</span> <%= order.getOrderDate() %>

                                </div>
    
                                <div class="my-2"><i class="fa fa-circle text-blue-m2 text-xs mr-1">

                                    </i> <span class="text-600 text-90">Status:</span> 
                                    <span class="badge badge-danger badge-pill px-25"><%=invoice.getStatus() %></span>
                                </div>
                            </div>
                        </div>
                        <!-- /.col -->
                    </div>
    
                    <div class="mt-4">
                        <div class="row text-600 bgc-default-tp1 py-25">
                            <div class="d-none d-sm-block col-1">#</div>
                            <div class="col-9 col-sm-4">Description</div>
                            <div class="d-none d-sm-block col-4 col-sm-1">Qty</div>
                            <div class="d-none d-sm-block col-sm-2">Unit Price</div>
                            <div class="d-none d-sm-block col-sm-2">GST Amt</div>
                            <div class="col-2">Amount</div>
                        </div>
    <% for(Map.Entry<Product, Integer> entry: products.entrySet()) {
    	Product p = entry.getKey();
    	System.out.println(p);
    	int qty = entry.getValue();
     %>
                        <div class="text-95 text-secondary-d3">
                            <div class="row mb-2 mb-sm-0 py-25">
                                <div class="d-none d-sm-block col-1">1</div>
                                <div class="col-9 col-sm-4"><%= p.getProductName()  %></div>
                                <div class="d-none d-sm-block col-1"><%= qty  %></div>
                                <div class="d-none d-sm-block col-2 text-95"><%= p.getProductPrice()  %></div>
                                <div class="col-2 text-secondary-d2"><%= p.getProductPrice()  %></div>
                                <div class="col-2 text-secondary-d2"><%= invoice.getTotalGST()  %></div>
                            </div>
    <%} %>
                            <!-- <div class="row mb-2 mb-sm-0 py-25 bgc-default-l4">
                                <div class="d-none d-sm-block col-1">2</div>
                                <div class="col-9 col-sm-4">T.V.</div>
                                <div class="d-none d-sm-block col-1">1</div>
                                <div class="d-none d-sm-block col-2 text-95">Rs 15</div>
                                <div class="col-2 text-secondary-d2">Rs 15</div>
                                <div class="col-2 text-secondary-d2">Rs 20</div>
                            </div>
    
                            <div class="row mb-2 mb-sm-0 py-25">
                                <div class="d-none d-sm-block col-1">3</div>
                                <div class="col-9 col-sm-4">Bed</div>
                                <div class="d-none d-sm-block col-1">--</div>
                                <div class="d-none d-sm-block col-2 text-95">Rs 1,000</div>
                                <div class="col-2 text-secondary-d2">Rs 1,000</div>
                                <div class="col-2 text-secondary-d2">Rs 20</div>
                            </div>
    
                            <div class="row mb-2 mb-sm-0 py-25 bgc-default-l4">
                                <div class="d-none d-sm-block col-1">4</div>
                                <div class="col-9 col-sm-4">Curtains</div>
                                <div class="d-none d-sm-block col-1">1</div>
                                <div class="d-none d-sm-block col-2 text-95">Rs 500</div>
                                <div class="col-2 text-secondary-d2">Rs 500</div>
                                <div class="col-2 text-secondary-d2">Rs 20</div>
                            </div> -->
                        </div>
                       
    
                        <div class="row border-b-2 brc-default-l2"></div>
    
                        <!-- or use a table instead -->
                        <!--
                <div class="table-responsive">
                    <table class="table table-striped table-borderless border-0 border-b-2 brc-default-l1">
                        <thead class="bg-none bgc-default-tp1">
                            <tr class="text-white">
                                <th class="opacity-2">#</th>
                                <th>Description</th>
                                <th>Qty</th>
                                <th>Unit Price</th>
                                <th width="140">Amount</th>
                            </tr>
                        </thead>
    
                        <tbody class="text-95 text-secondary-d3">
                            <tr></tr>
                            <tr>
                                <td>1</td>
                                <td>Domain registration</td>
                                <td>2</td>
                                <td class="text-95">$10</td>
                                <td class="text-secondary-d2">$20</td>
                            </tr> 
                        </tbody>
                    </table>
                </div>
                -->
    
                        <div class="row mt-3 justify-content-end">
    
                            <div class="col-12 col-sm-5 text-grey text-90 order-first order-sm-last">
                                <div class="row my-2">
                                    <div class="col-7 text-right">
                                        GST Type
                                    </div>
                                    <div class="col-5">
                                        <span class="text-120 text-secondary-d1"><%invoice.getTypeOfGST(); %></span>
                                    </div>
                                </div>
    
    
                                <div class="row my-2 align-items-center bgc-primary-l3 p-2">
                                    <div class="col-7 text-right">
                                        Total Amount
                                    </div>
                                    <div class="col-5">
                                        <span class="text-150 text-success-d3 opacity-2"><%invoice.getTotalInvoiceValue(); %></span>
                                    </div>
                                </div>
                            </div>
                        </div>
    
                        <hr />
    
                        <!-- <div>
                            <span class="text-secondary-d1 text-105">Thank you for your business</span>
                            <a href="#" class="btn btn-info btn-bold px-4 float-right mt-3 mt-lg-0">Pay Now</a>
                        </div> -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    

</body>
</html>