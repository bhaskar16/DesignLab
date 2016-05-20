<html>
<!-- authors : Bhaskar Ghosh Dastidar, Abhirup Mukherjee -->
  <%@ page import="com.Cerebro.Controller.*" %>
  
<head>
  <title>Registered Tutor Profile</title>
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


<script>
$.material.init();
</script>

          <div class="well page" id="navbar">
          

            <div class="navbar navbar-inverse">
              <div class="container-fluid">
                <div class="navbar-header">
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="AgencyDashboard.jsp">Tutors and Students</a>
                </div>
                <div class="navbar-collapse collapse navbar-responsive-collapse">
                  <ul class="nav navbar-nav">
                    <li class="active"><a href="AgencyDashboard.jsp">Home</a></li>
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
			<style>
			.verticalLine {
    border-left: thick solid #ff0000;
}
			</style>
			
			<div class="container">

   

 <% 
	String a = request.getParameter("ID");
	session.setAttribute("TID", session.getAttribute("TID"+a));
session.setAttribute("TEmail", session.getAttribute("TEmail"+a));	
 %>
  
    <div class="row">
	
      <div class="col-md-3">
	  <h3> <% out.print(session.getAttribute("TName"+a)); %> </h3>
	  <p>
	  Agent Registered Tutor
	  </p>
	  <p>
	  <% 
	  session.setAttribute("UserType","Tutor");
	  out.print(session.getAttribute("TDescription"+a)); %>
	  </p>
	  <hr>
	  <a href="UpdateAgentTutor.jsp?ID=<%= a%>" class="btn btn-raised btn-primary">Update Profile</a>
    <form action ="NegotiationHandler" method="post">
		<input type="hidden" name="type" value="showAllContracts">
		<button type="submit" class="btn btn-raised btn-success" >Negotiations&nbsp;</a>
	</form>  
	<form action="ProfileHandler" method="post">
		<input type="hidden" name="type" value ="studentlist">
		<button type="submit" class="btn btn-raised btn-warning">Manage Student <br> Records</a></button>
	</form>
	<form action="ProfileHandler" method="post">
		<input type="hidden" name="type" value ="listAchievements">
		<input type="hidden" name="id" value ="<%=session.getAttribute("TID").toString() %>">
		<button type="submit" class="btn btn-raised btn-success">Add Achievements</button>
	</form>
    </div>
	   
	   
		
	  
        
      <div class="col-md-9">
	  <div class="well">
	
	  
	    <div class="bs-docs-section">

    <div class="row">
      <div class="col-md-12">
        <div class="page-header">
          <h1 id="tables">Details</h1>
        </div>

        <div class="bs-component">
          <table class="table table-striped table-hover ">
            <thead>
            <tr>
              <th>#</th>
              <th>Property</th>
              <th>Value</th>
              
            </tr>
            </thead>
            <tbody>
            <tr>
              <td>1</td>
              <td>Name</td>
              <td><% out.print(session.getAttribute("TName"+a)); %></td>
              
            </tr>
            <tr>
              <td>2</td>
              <td>Gender</td>
              <td><% out.print(session.getAttribute("TGender"+a)); %></td>
             
            </tr>
            <tr class="info">
              <td>3</td>
              <td>Date of birth</td>
              <td><% out.print(session.getAttribute("Tdob"+a)); %></td>
              
            </tr>
            <tr class="success">
              <td>4</td>
              <td>Email</td>
              <td><% out.print(session.getAttribute("TEmail"+a)); %></td>
              
            </tr>
            <tr class="danger">
              <td>5</td>
              <td>Contact</td>
              <td><% out.print(session.getAttribute("TContact"+a)); %></td>
             
            </tr>
            <tr class="danger">
              <td>6</td>
              <td>Discipline</td>
              <td><% out.print(session.getAttribute("TDis"+a)); %></td>
             
            </tr>
            <tr class="danger">
              <td>7</td>
              <td>SubDiscipline</td>
              <td><% out.print(session.getAttribute("TSubDis"+a)); %></td>
             
			 <%
			 
				String dslot = "", ds = (String) session.getAttribute("TDS"+a);int dscnt = 0;
				String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
				for(int i=0;i<7;i++) {
					char c = ds.charAt(i);
					if(c == '1') {
						if(dscnt > 0) {
							dslot += ", " + days[i];
						} else {
							dslot += days[i];
						} dscnt++;
					}
				}
			 
			 %>
			 
			 
            </tr>
            <tr class="danger">
              <td>8</td>
              <td>Day Slot</td>
              <td><% out.print(dslot); %></td>
             
            </tr>
            <tr class="danger">
              <td>9</td>
              <td>Time Slot</td>
              <td><% out.print(session.getAttribute("TTS"+a)); %></td>
             
            </tr>
            <tr class="danger">
              <td>10</td>
              <td>Experience</td>
              <td><% out.print(session.getAttribute("TExp"+a)); %></td>
             
            </tr>
            <tr class="danger">
              <td>11</td>
              <td>Remuneration</td>
              <td><% out.print(session.getAttribute("TRem"+a)); %></td>
             
            </tr>
            <tr class="danger">
              <td>12</td>
              <td>Location</td>
              <td><% out.print(session.getAttribute("Tlocation"+a)); %></td>
             
            </tr>
            <tr class="danger">
              <td>13</td>
              <td>Batch Size</td>
              <td><% out.print(session.getAttribute("TBS"+a)); %></td>
             
            </tr>
            <tr class="danger">
              <td>15</td>
              <td>Address</td>
              <td><% out.print(session.getAttribute("TAddress"+a)); %></td>
             
            </tr>
			
            </tbody>
          </table>
        </div><!-- /example -->
      </div>
    </div>
  </div>
       </div>
	   </div>
   
  </div>
  </div>

           

<!-- Open source code -->
<script>
  window.page = window.location.hash || "#about";

  $(document).ready(function () {
    if (window.page != "#about") {
      $(".menu").find("li[data-target=" + window.page + "]").trigger("click");
    }
  });

  $(window).on("resize", function () {
    $("html, body").height($(window).height());
    $(".main, .menu").height($(window).height() - $(".header-panel").outerHeight());
    $(".pages").height($(window).height());
  }).trigger("resize");

  $(".menu li").click(function () {
    // Menu
    if (!$(this).data("target")) return;
    if ($(this).is(".active")) return;
    $(".menu li").not($(this)).removeClass("active");
    $(".page").not(page).removeClass("active").hide();
    window.page = $(this).data("target");
    var page = $(window.page);
    window.location.hash = window.page;
    $(this).addClass("active");


    page.show();

    var totop = setInterval(function () {
      $(".pages").animate({scrollTop: 0}, 0);
    }, 1);

    setTimeout(function () {
      page.addClass("active");
      setTimeout(function () {
        clearInterval(totop);
      }, 1000);
    }, 100);
  });

  function cleanSource(html) {
    var lines = html.split(/\n/);

    lines.shift();
    lines.splice(-1, 1);

    var indentSize = lines[0].length - lines[0].trim().length,
        re = new RegExp(" {" + indentSize + "}");

    lines = lines.map(function (line) {
      if (line.match(re)) {
        line = line.substring(indentSize);
      }

      return line;
    });

    lines = lines.join("\n");

    return lines;
  }

  $("#opensource").click(function () {
    $.get(window.location.href, function (data) {
      var html = $(data).find(window.page).html();
      html = cleanSource(html);
      $("#source-modal pre").text(html);
      $("#source-modal").modal();
    });
  });
</script>

<!-- Twitter Bootstrap -->
<script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!-- Material Design for Bootstrap -->
<script src="dist/js/material.js"></script>
<script src="dist/js/ripples.min.js"></script>
<script>
  $.material.init();
</script>


<!-- Sliders -->
<script src="//cdnjs.cloudflare.com/ajax/libs/noUiSlider/6.2.0/jquery.nouislider.min.js"></script>
<script>
  $(function () {
    $.material.init();
    $(".shor").noUiSlider({
      start: 40,
      connect: "lower",
      range: {
        min: 0,
        max: 100
      }
    });

    $(".svert").noUiSlider({
      orientation: "vertical",
      start: 40,
      connect: "lower",
      range: {
        min: 0,
        max: 100
      }
    });
  });
</script>

<!-- Dropdown.js -->
<script src="https://cdn.rawgit.com/FezVrasta/dropdown.js/master/jquery.dropdown.js"></script>
<script>
  $("#dropdown-menu select").dropdown();
</script>