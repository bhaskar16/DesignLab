<html>

<head>
  <title>Update Fields</title>
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

	<script>
			function validateForm() {
				var form = document.getElementById("frm");
				var name = form.elements["name"].value;
				var pass = form.elements["pass"].value;
				var contact = form.elements["contact"].value;
				var address = form.elements["address"].value;
				if(!name.match(/^[a-zA-Z]+(\s?[a-zA-Z])*$/)) {
					alert("Invalid Name");
					form.elements["name"].focus();
					return false;
				} else if(!pass.match(/^[a-zA-Z0-9]{6,15}$/)) {
					alert("Invalid Password");
					form.elements["pass"].focus();
					return false;
				} else if(contact!='' && !contact.match(/^[9,8,7]([0-9]{9})$/)) {
					alert("Invalid Contact Number");
					form.elements["contact"].focus();
					return false;
				} else { 
					if(address == '') {
						form.elements["address"].value = "N/A";
					} if(contact == '') {
						form.elements["contact"].value = "N/A";
					} return true;
				}
			}
</script>

<script src="js/jquery-1.11.2.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/npm.js"></script>
</head>
<body>


<script>
$.material.init();
</script>

          <div class="well page" id="navbar">
          

            <div class="navbar navbar-warning">
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
                    <li class="active"><a href="StudentDashboard.jsp">Back</a></li>
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
			 <!-- Forms
================================================== -->
 <%@ page import="com.Cerebro.Controller.*" %>
 
  <div class="bs-docs-section">
    <div class="row">
      <div class="col-md-12">
        <div class="page-header">
          <h1 id="forms">Update Fields </h1>
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-6">
        <div class="well bs-component">
          <form id="frm" onsubmit="return validateForm()" class="form-horizontal" name ="UpdateStudent" action="ProfileHandler" method="post">
            <fieldset>
              <legend>Student</legend><input type="hidden" name ="type" value="updateStudent">
			  <div class="form-group">
                <label for="inputName" class="col-md-2 control-label">Name</label>

                <div class="col-md-10">
                  <input type="text" class="form-control" id="name" name="name" placeholder="Name" value = "<%=session.getAttribute("Name") %>">
                </div>
              </div>
              <!--<div class="form-group">
                <label for="inputEmail" class="col-md-2 control-label">Email</label>

                <div class="col-md-10">
                  <input type="email" class="form-control" id="email" name ="email" placeholder="Email">
                </div>
              </div>-->
              <div class="form-group">
                <label for="inputPassword" class="col-md-2 control-label">Password</label>

                <div class="col-md-10">
                  <input type="password" class="form-control" id="password" name="pass" placeholder="Password" value = "<%=session.getAttribute("pass") %>">
                </div>
              </div>
			   <div class="form-group">
                <label for="textArea" class="col-md-2 control-label">Address</label>
                <div class="col-md-10">
                  <textarea class="form-control" rows="3" id="textArea" name ="address" placeholder="Address"><%=session.getAttribute("Address") %></textarea>
                  <span class="help-block">Enter your address</span>
                </div>
              </div>
			  <div class="form-group">
                <label for="inputPhone" class="col-md-2 control-label">Contact Number</label>

                <div class="col-md-10">
                  <input type="text" class="form-control" name="contact" id="contact" placeholder="Mob. Number" value = "<%=session.getAttribute("Contact") %>">
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-10 col-md-offset-2">
                  <button type="button" onclick="window.location.href='StudentDashboard.jsp'" class="btn btn-warning">Cancel</button>
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </div>
            </fieldset>
          </form>
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