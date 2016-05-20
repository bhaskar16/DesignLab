<html>

<head>
  <title>Open Contracts</title>
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
<body onload="loadTime()">


<script>
$.material.init();
</script>

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
			<style>
			.verticalLine {
    border-left: thick solid #ff0000;
}
			</style>
			
			<div class="container">
			 <!-- Forms
================================================== -->
   <%@ page import="com.Cerebro.Controller.*" %>
   
    

    <div class="row">
	
      <div class="col-md-3">
	  <h3>  </h3>
	  <p>
	
	  </p>
	  <h1>
	All Open Contracts
	  </h1>
	  <hr>
	
	

       </div>
	   
	   
		
	   <% 			String utype= session.getAttribute("UserType").toString();
            		
            		if(utype.equals("student"))
            		{%>
            		<div class="well">
		<div class="bs-docs-section">
		<center><h3>You cannot update Contract Info. Please go back</h3></center>
		</div>
		</div>
            	 <% 		
            		}
            		else {
	   				String a = request.getParameter("ID");
            		int k = Integer.parseInt(a);
            		session.setAttribute("CID", session.getAttribute("OCID"+k));
            		session.setAttribute("TID", session.getAttribute("OTID"+k));
            		session.setAttribute("SID", session.getAttribute("OSID"+k));
            		session.setAttribute("Status", session.getAttribute("OStatus"+k));
            		
            		%> 
        
      <div class="col-md-9">
      
	  <div class="well">
		<div class="bs-docs-section">
		<center><h3>Terms of negotiation</h3></center>
		
		<hr>
		<center>
             <form action="NegotiationHandler" method ="post" id = "form1" onsubmit="return validateForm()">
             <input type="hidden" name="type" value="updateContract" id= "hiddentype">
             <div class="form-group has-success">
            <label class="control-label" for="inputSuccess">Remuneration</label>
            <!--<input type="text" name ="Rem" class="form-control" id="inputSuccess" value="  out.print(session.getAttribute("ORemuneration"+k)); %>">-->
			<input class="form-control" name="Rem" type="number" min="0" max="10000" step="100"></input>
          </div>
          
          <div class="form-group has-success">
            <label class="control-label" for="inputSuccess">Day Slots</label>
            <!--<input type="text" name="DS" class="form-control" id="inputSuccess" value="  out.print(session.getAttribute("ODays"+k)); %>">-->
			  <input type="hidden" name="DS" value="1111111"></input> 
			<select class="form-control" name="daybox" multiple>
				<option value="1">Sunday</option>
				<option value="1">Monday</option>
				<option value="1">Tuesday</option>
				<option value="1">Wednesday</option>
				<option value="1">Thursday</option>
				<option value="1">Friday</option>
				<option value="1">Saturday</option>
			</select><br/><br/><br/>
		  </div>
          
          <div class="form-group has-success">
            <label class="control-label" for="inputSuccess">Time Slots</label>
            <!--<input type="text" name="TS" class="form-control" id="inputSuccess" value=" out.print(session.getAttribute("OTime"+k)); %>">-->
			<input type="hidden" name="TS" value="00:00-23:30">
			Start - <select name="tsr11"></select>&nbsp;&nbsp;
			&nbsp;&nbsp;End - <select name="tsr12"></select><br/><br/>
		  </div>
          
          <div class="form-group has-success">
            <label class="control-label" for="inputSuccess">Location</label>
            <input type="text" name="Loc" class="form-control" id="inputSuccess">
          </div>
          
          <div class="form-group has-success">
            <label class="control-label" for="inputSuccess">Batch</label>
            <!--<input type="text" name="Batch" class="form-control" id="inputSuccess" value=" out.print(session.getAttribute("OBatch"+k)); %>">-->
			<select class="form-control" name="Batch">
				<option>Single</option>
				<option>Upto 5</option>
				<option>Upto 10</option>
				<option>Any</option>
			</select>
          </div>
          
           			 <button type="submit" class="btn btn-primary" >Update Contracts</button> <% } %>
           		 <!--   <button type="button" class="btn btn-warning" onclick="submitForm(1)">Cancel</button>
                  <button type="button" class="btn btn-primary" onclick="submitForm(2)">Close Deal</button>-->
             </form>
            </center>
		<script>
			function validateForm() {
				
				var form = document.getElementById('form1');
				var rem = form.elements["Rem"];
				var loc = form.elements["Loc"];
				var ds = form.elements["DS"];
				var ts = form.elements["TS"];
				var dslot = form.elements["daybox"];
				if(rem.value == '') {
					alert("Remuneration cannot be Empty");
					rem.focus();return false;
				} else if(loc.value == ''){
					alert("Location cannot be empty.");
					loc.focus();return false;
				} else {
					
					var i;
					var finalDS = "";
					for(i = 0;i < dslot.length;i++) {
						if(dslot[i].selected == true) {
							finalDS += dslot[i].value;
						} else {
							finalDS += "0";
						}
						if(finalDS == "0000000") {
							alert("No Day Slots specified");
							dslot.focus();
							return false;
						}
					}
					
					ds.value = finalDS;
					
					var time_slot = getSpecTS();
					if(time_slot == "") {
						alert("Invalid Time Slots");
						form.elements["tsr11"].focus();
						return false;
					} else {ts.value = time_slot;}
				}
			}
			 function loadTime(){
				timeLoad("tsr11");timeLoad("tsr12");
			} function getSpecTS() {
				var form = document.getElementById("form1");var finalTS = "";
				var selects = ["tsr11","tsr12"];
				for(var i=0;i<2;i+=2) {
					var t1 = (form.elements[selects[i]].value).toString();
					var t2 = (form.elements[selects[i+1]].value).toString();
					var t1val = parseInt(t1.substring(0,2) + t1.substring(3,5));
					var t2val = parseInt(t2.substring(0,2) + t2.substring(3,5));
					if(t1val < t2val) {
						if(finalTS == "") finalTS = t1 + "-" + t2;
						else finalTS += "," + t1 + "-" + t2;
					} else if(t1val > t2val) {
						console.log("Came Here")
						finalTS = "";break;
					} else {}
				}
				alert(finalTS);
				return finalTS;
			} function timeLoad(sel) {
				var ip = document.getElementById("form1").elements[sel];
				if(ip.options.length == 0) {
					var values = ["00:00","00:30","01:00","01:30","02:00","02:30","03:00","03:30",
						"04:00","04:30","05:00","05:30","06:00","06:30","07:00","07:30","08:00",
						"08:30","09:00","09:30","10:00","10:30","11:00","11:30","12:00","12:30",
						"13:00","13:30","14:00","14:30","15:00","15:30","16:00","16:30","17:00",
						"17:30","18:00","18:30","19:00","19:30","20:00","20:30","21:00","21:30",
						"22:00","22:30","23:00","23:30"];
					var keys = ["00:00 AM","00:30 AM","01:00 AM","01:30 AM","02:00 AM","02:30 AM",
					"03:00 AM","03:30 AM","04:00 AM","04:30 AM","05:00 AM","05:30 AM","06:00 AM",
					"06:30 AM","07:00 AM","07:30 AM","08:00 AM","08:30 AM","09:00 AM","09:30 AM",
					"10:00 AM","10:30 AM","11:00 AM","11:30 AM","12:00 PM","12:30 PM","01:00 PM",
					"01:30 PM","02:00 PM","02:30 PM","03:00 PM","03:30 PM","04:00 PM","04:30 PM",
					"05:00 PM","05:30 PM","06:00 PM","06:30 PM","07:00 PM","07:30 PM","08:00 PM",
					"08:30 PM","09:00 PM","09:30 PM","10:00 PM","10:30 PM","11:00 PM","11:30 PM"];
					for(var i=0;i<48;i++) {
						ip.options[i] = new Option(keys[i], values[i]);
					}
				}
			}
			
		</script>
				
				
    </div>
	</div>
	<br>
	
  </div>
  
  <hr>
  
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