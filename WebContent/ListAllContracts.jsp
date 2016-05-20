<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- authors : Bhaskar Ghosh Dastidar, Abhirup Mukherjee -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Contracts</title>

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

 <div class="well page" id="navbar">
          

            <div class="navbar navbar-default">
              <div class="container-fluid">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="<%= session.getAttribute("Homepage").toString()%>">Tutors and Students</a>
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
  <h2>Contract List</h2>
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">Active</a></li>
    <li><a data-toggle="tab" href="#menu1">Pending</a></li>
    <li><a data-toggle="tab" href="#menu2">Final</a></li>
    
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      <h3>All Active Contracts</h3>
      <hr>
      <% 
      String s = session.getAttribute("Olength").toString();
    	int k = Integer.parseInt(s);if(k <= 0) {
			out.println("<h3>You have no Active Contracts.</h3>");
		}
    	int i =0;
    	while(i<k){ 
    		session.setAttribute("ID", i);
      %>
      <div class="well">
		<div class="bs-docs-section">
		
    <strong> <p> <%  out.print("Tutor Name: " + session.getAttribute("OTNAME"+i)); %></p></strong>
	<strong> <p> <%  out.print("Student Name: " + session.getAttribute("OSNAME"+i)); %></p></strong>
     <strong> <p> <%  out.print("Location: " + session.getAttribute("OLocation"+i)); %></p></strong>
      <strong> <p> <%  out.print("Remuneration: " + session.getAttribute("ORemuneration"+i)); %></p></strong>
      
	  <%  
	  
		String dslot = "", ds = (String) session.getAttribute("ODays"+i);int dscnt = 0;
				String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
				for(int j=0;j<7;j++) {
					char ch = ds.charAt(j);
					if(ch == '1') {
						if(dscnt > 0) {
							dslot += ", " + days[j];
						} else {
							dslot += days[j];
						} dscnt++;
					}
				}
	  
	  %>
       <strong> <p> <%  out.print("Days: " + dslot); %></p></strong>
        <strong> <p> <%  out.print("Time: " + session.getAttribute("OTime"+i)); %></p></strong>
         <strong> <p> <%  out.print("Batch Size: " + session.getAttribute("OBatch"+i)); %></p></strong>
         <a href="OpenContracts.jsp?ID=<%= i%>" class="btn btn-raised btn-primary pull-right">Update Contract</a>
        <!-- <a href="Messaging.jsp?ID=<%= i%>" class="btn btn-raised btn-primary pull-right">Messaging</a> --> 
        <form action="NegotiationHandler" method="post"><input type="hidden" name="type" value="showMessages"><input type="hidden" name="Ctype" value="O"><input type="hidden" name="count" value ="<%= i%>"><button type="submit" class="btn  btn-primary pull-right">Messaging</button></form>
          <a href="CloseDeal.jsp?ID=<%= i%>" button type="button" class="btn btn-warning" >Propose Clousure</a>
        <a href="CancelDeal.jsp?ID=<%= i%>" button type="button" class="btn btn-warning" >Cancel</a>
           
         </div></div>
     <%
	i++;
	
    	}
	
	%>
	<hr>
    </div>
    <div id="menu1" class="tab-pane fade">
      <h3>Pending Contracts</h3>
       <% 
      String as = session.getAttribute("Plength").toString();
    	k = Integer.parseInt(as);if(k <= 0) {
			out.println("<h3>You have no Pending Contracts.</h3>");
		}
    	i =0;
    	while(i<k){ 
    		session.setAttribute("PID", i);
      %>
      <div class="well">
		<div class="bs-docs-section">
    <strong> <p> <%  out.print("Tutor Name: " + session.getAttribute("PTNAME"+i)); %></p></strong>
	<strong> <p> <%  out.print("Student Name: " + session.getAttribute("PSNAME"+i)); %></p></strong>
     <strong> <p> <%  out.print("Location: " + session.getAttribute("PLocation"+i)); %></p></strong>
      <strong> <p> <%  out.print("Remuneration: " + session.getAttribute("PRemuneration"+i)); %></p></strong>
	  <%  
	  
		String dslot = "", ds = (String) session.getAttribute("PDays"+i);int dscnt = 0;
				String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
				for(int j=0;j<7;j++) {
					char ch = ds.charAt(j);
					if(ch == '1') {
						if(dscnt > 0) {
							dslot += ", " + days[j];
						} else {
							dslot += days[j];
						} dscnt++;
					}
				}
	  
	  %>
       <strong> <p> <%  out.print("Days: " + dslot); %></p></strong>
        <strong> <p> <%  out.print("Time: " + session.getAttribute("PTime"+i)); %></p></strong>
         <strong> <p> <%  out.print("Batch Size: " + session.getAttribute("PBatch"+i)); %></p></strong>
        <a href="AcceptDeal.jsp?ID=<%= i%>" class="btn btn-raised btn-primary pull-right">Accept Deal</a>
          <a href="RejectDeal.jsp?ID=<%= i%>" class="btn btn-warning" >Reject Deal</a>
        <form action="NegotiationHandler" method="post"><input type="hidden" name="type" value="showMessages"><input type="hidden" name="Ctype" value="P"><input type="hidden" name="count" value ="<%= i%>"><button type="submit" class="btn btn-raised  btn-primary pull-right">Messaging</button></form>
         </div>
         </div>
     <%
	i++;
	
    	}
	
	%>
    </div>
    <div id="menu2" class="tab-pane fade">
      <h3>Final Contracts</h3>
      <% 
      as = session.getAttribute("Flength").toString();
    	k = Integer.parseInt(as);if(k <= 0) {
			out.println("<h3>You have no Final Contracts.</h3>");
		}
    	i =0;
    	while(i<k){ 
      %>
      <div class="well">
		<div class="bs-docs-section">
    <strong> <p> <%  out.print("Tutor Name: " + session.getAttribute("FTNAME"+i)); %></p></strong>
	<strong> <p> <%  out.print("Student Name: " + session.getAttribute("FSNAME"+i)); %></p></strong>
     <strong> <p> <%  out.print("Location: " + session.getAttribute("FLocation"+i)); %></p></strong>
      <strong> <p> <%  out.print("Remuneration: " + session.getAttribute("FRemuneration"+i)); %></p></strong>
	  <%  
	  
		String dslot = "", ds = (String) session.getAttribute("FDays"+i);int dscnt = 0;
				String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
				for(int j=0;j<7;j++) {
					char ch = ds.charAt(j);
					if(ch == '1') {
						if(dscnt > 0) {
							dslot += ", " + days[j];
						} else {
							dslot += days[j];
						} dscnt++;
					}
				}
	  
	  %>
       <strong> <p> <%  out.print("Days: " + dslot); %></p></strong>
        <strong> <p> <%  out.print("Time: " + session.getAttribute("FTime"+i)); %></p></strong>
         <strong> <p> <%  out.print("Batch Size: " + session.getAttribute("FBatch"+i)); %></p></strong>
          
         </div></div>
     <%
	i++;
	
    	}
	
	%>
    </div>
    
  </div>
</div>

</body>
</html>