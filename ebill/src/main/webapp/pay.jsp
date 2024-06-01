<%@page import ="java.sql.*" %>
<%@page import ="javax.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>approver JSP</title>
<link rel="stylesheet" type="text/css" href="mystyle.css">

    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/font-awesome.css" rel="stylesheet">
    

   
    <link href="assets/css/main.css" rel="stylesheet">
</head>



<body>

    <div id="wrapper">


       
        <div id="page-content-wrapper">

            <div class="container-fluid">

               
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Transaction
                        </h1>
                        <ol class="breadcrumb">
                          <li>Transaction</li>
                          <li class="active">History</li>
                        </ol>
                       
                        <div class="table-responsive">
                            <table class="table table-hover table-striped table-bordered table-condensed">
                                <thead>
                                    <tr>
                                        <th>Transaction No.</th>
                                        <th>User Name</th>
                                        <th>Bill Date</th>
                                        <th>Amount</th>
                                        <th>units consumed</th>
                                        <th>Final Amount Payed</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","anjali44");
    Statement fetchdata = con.createStatement();
    String sqlquery = "select * from transaction";
    ResultSet displaydata = fetchdata.executeQuery(sqlquery);
    while(displaydata.next())
    {%>
    <tr>
    <td><%=displaydata.getString(1) %></td>
    <td><%=displaydata.getString(2) %></td>
    <td><%=displaydata.getString(3) %></td>
    <td><%=displaydata.getInt(4) %></td>
    <td><%=displaydata.getInt(5) %></td>
    <td><%=displaydata.getInt(4)*displaydata.getInt(5)/100 %></td>
    </tr>
    <%
    }
}catch(Exception e)
{
	System.out.println(e);
}
%>

                                </tbody>
                            </table>
                        </div>
                       
                    </div>
                                      
                </div>
               
            </div>
            

        </div>
        
        
        


    </div>
    
    
</body>

</html>