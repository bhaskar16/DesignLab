<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reviews</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <!-- Mobile support -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Material Design fonts -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  
   <link href="css/bootstrap.css" rel="stylesheet">
   <link href="css/animate.css" rel="stylesheet">
   <link href="css/response.css" rel="stylesheet">



  <!-- Bootstrap Material Design -->
  <link href="dist/css/bootstrap-material-design.css" rel="stylesheet">
  <link href="dist/css/ripples.min.css" rel="stylesheet">


  <!-- Page style -->
  <link href="index.css" rel="stylesheet">



<link href="css/table.css" rel="stylesheet" type="text/css"/>
    <!-- IF using Sass (run gulp sass first), then uncomment below and remove the CSS includes above
    <link href="css/ionic.app.css" rel="stylesheet">
    -->


<script src="js/jquery-1.11.2.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/npm.js"></script>
</head>
<body>
 <%@ page import="com.Cerebro.Controller.*" %>
<br>

<div class="well page" id="navbar">
          

            <div class="navbar navbar-default">
              <div class="container-fluid">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="StudentDashboard.jsp">Tutors and Students</a>
                </div>
                <div class="navbar-collapse collapse navbar-responsive-collapse">
                  <ul class="nav navbar-nav">
                    <li class="active"><a href="" onclick="window.history.back()">Back</a></li>
				  </ul>
                    <!--<li><a href="javascript:void(0)">Link</a></li>
                    <li class="dropdown">
                      <a href="http://fezvrasta.github.io/bootstrap-material-design/bootstrap-elements.html" data-target="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown
                        <b class="caret"></b></a>
                      <ul class="dropdown-menu">
                        <li><a href="javascript:void(0)">Action</a></li>
                        <li><a href="javascript:void(0)">Another action</a></li>
                        <li><a href="javascript:void(0)">Something else here</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Dropdown header</li>
                        <li><a href="javascript:void(0)">Separated link</a></li>
                        <li><a href="javascript:void(0)">One more separated link</a></li>
                      </ul>
                    </li>
                  </ul>
                  <form class="navbar-form navbar-left">
                    <div class="form-group">
                      <input type="text" class="form-control col-sm-12" placeholder="Search Tutors/students">
                    </div>
                  </form>
                  <ul class="nav navbar-nav navbar-right">
                    <li><a href="javascript:void(0)">Link</a></li>
                    <li class="dropdown">
                      <a href="http://fezvrasta.github.io/bootstrap-material-design/bootstrap-elements.html" data-target="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown
                        <b class="caret"></b></a>
                      <ul class="dropdown-menu">
                        <li><a href="javascript:void(0)">Action</a></li>
                        <li><a href="javascript:void(0)">Another action</a></li>
                        <li><a href="javascript:void(0)">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="javascript:void(0)">Separated link</a></li>
                      </ul>
                    </li>
                  </ul>-->
                </div>
              </div>
            </div>

			</div>


<div class="container">
<div class="row">
    <div class="col-lg-3"></div>

    <div class="col-lg-6">
         <div class="well">
		<div class="bs-docs-section">
            <center><h1>Reviews for </h1><h3><%  out.print(session.getAttribute("TEmail")); %></h3></center>
            <hr>
           <pre>Overall Rating :<%  out.print(session.getAttribute("Rating")); %> </pre>
        

        <div class="card-body">
         <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">All Reviews</a></li>
    <li><a data-toggle="tab" href="#menu1">Verified Reviews</a></li>
    </ul>
     <div class="tab-content">
     <div id="menu1" class="tab-pane fade">
        <% 
      String s = session.getAttribute("Count").toString();
    	int k = Integer.parseInt(s);
		if(k <= 0) {
			out.println("<h3>No Reviews Available.</h3>");
		}
    	int i =0;
    	while(i<k){
      %>
            <h3><%  out.print(session.getAttribute("SName"+i)); %></h3>
            <p><%  out.print(session.getAttribute("Body"+i)); %></p>
            <hr>
            <%
	i++;
	
    	}
	
	%>
	</div>
       
        <hr>
       
    <div id="home" class="tab-pane fade in active">
        <% 
      s = session.getAttribute("UCount").toString();
    	k = Integer.parseInt(s);
		if(k <= 0) {
			out.println("<h3>No Reviews Available.</h3>");
		}
    	i =0;
    	while(i<k){
      %>
            <h3><%  out.print(session.getAttribute("USName"+i)); %></h3>
            <p><%  out.print(session.getAttribute("UBody"+i)); %></p>
            <hr>
            <%
	i++;
	
    	}
	
	%>
        </div>
        </div>
        </div>
		
		 
      

    </div>

</div>
    </div>

    <div class="col-lg-3"></div>
</div>

</div>
</body>
</html>