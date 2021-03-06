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
			
			
			<div class="container">
			 <!-- Forms
================================================== -->

 <%
 String a = request.getParameter("ID"); 
 session.setAttribute("TName", session.getAttribute("TName"+a));
 session.setAttribute("TGender",session.getAttribute("TGender"+a));
 session.setAttribute("TAddress",session.getAttribute("TAddress"+a));
 session.setAttribute("TEmail",session.getAttribute("TEmail"+a));
 session.setAttribute("TDis",session.getAttribute("TDis"+a));
 session.setAttribute("TSubDis",session.getAttribute("TSubDis"+a));
 session.setAttribute("TDS",session.getAttribute("TDS"+a));
 session.setAttribute("TTS",session.getAttribute("TTS"+a));
 session.setAttribute("TExp",session.getAttribute("TExp"+a));
 session.setAttribute("TRem",session.getAttribute("TRem"+a));
 session.setAttribute("Tlocation",session.getAttribute("Tlocation"+a));
 session.setAttribute("TDescription",session.getAttribute("TDescription"+a));
 session.setAttribute("TContact",session.getAttribute("TContact"+a));
 session.setAttribute("TBS",session.getAttribute("TBS"+a));
 session.setAttribute("Tdob",session.getAttribute("Tdob"+a));

 
 
 %>


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
          <form id="frm" onsubmit="return validateForm()" class="form-horizontal" name="updateAgentTutor" action="ProfileHandler" method = "post">
            <fieldset>
              <legend>Tutors</legend>
              <input type="hidden" name="type" value="updateAgentTutor">
			  <div class="form-group">
                <label for="inputName" class="col-md-2 control-label">Name</label>

                <div class="col-md-10">
                  <input type="text" class="form-control" id="inputName" placeholder="Name" name="name" value = "<%=session.getAttribute("TName") %>">
                </div>
              </div>
              
              <div class="form-group">
                <label for="inputDOB" class="col-md-2 control-label">Date of Birth</label>

                <div class="col-md-10">
                  <input type="date" class="form-control" id="inputDob" placeholder="Date of birth" name="db" value = "<%=session.getAttribute("Tdob") %>" >
                </div>
              </div>
              <!--<div class="form-group">
                <label for="inputEmail" class="col-md-2 control-label">Email</label>

                <div class="col-md-10">
                  <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="email">
                </div>
              </div>-->
             <input type="hidden" name="pass" value=""></input>
			   <div class="form-group">
                <label for="textArea" class="col-md-2 control-label">Address</label>

                <div class="col-md-10">
                  <textarea class="form-control" rows="3" id="textArea" placeholder="Address" name="address"><%=session.getAttribute("TAddress") %></textarea>
                  <span class="help-block">Enter Tutor's address</span>
                </div>
              </div>
			  <div class="form-group">
                <label for="inputPhone" class="col-md-2 control-label">Contact Number</label>

                <div class="col-md-10">
                  <input type="text" class="form-control" id="inputPhone" placeholder="Mob. Number" name="contact" value = "<%=session.getAttribute("TContact") %>">
                </div>
              </div>
			  <div class="form-group">
                <label class="col-md-2 control-label">Location</label>

                <div class="col-md-10">
                  <!--<input type="text" class="form-control" id="inputLocation" placeholder="Location/Area" name="location">-->
				  <div class="radio radio-primary">
					  <label>
						<input onclick="locCheck()"type="radio" name="loc" value="Any Location" checked>Any Location</input>
					  </label>
					</div>
					<div class="radio radio-primary">
					  <label>
						<input onclick="locCheck()"type="radio" name="loc" value="My Location">Tutor's Location</input>
					  </label>
					</div>
					<input type="hidden" name="location" value="Any Location"></input>
					<div id="locrow" style="display:none;">
						<input class="form-control" name="locbox" type="text" placeholder="Enter Location" value = "<%=session.getAttribute("Tlocation") %>"></input>
					</div>
				</div>
              </div>
            </fieldset>
         
        </div>
      </div>
    
      <div class="col-md-5 col-md-offset-1" >
        <div class="well">
		
		<div class="form-group">
                <label for="select1" class="col-md-4 control-label">Experience in years</label>

                <div id="select1" class="col-md-8">
                  <!--<select id="select1" class="form-control" name="exp">
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>Greater than 5</option>
                  </select>-->
				  <input  class="form-control" name="exp" type="number" min="0" max="40" step="5"></input>
                </div>
        </div>
			<br><br>
			 <div class="form-group">
			 
                <label for="inputDS" class="col-md-2 control-label">Day Slot</label>

                <div id="inputDS" class="col-md-10">
                  <!--<input type="text" class="form-control" id="inputDS" placeholder="Day Slot" name="DS">-->
				  <div class="radio radio-primary">
					  <label>
						<input type="radio" onclick="dsCheck()" name="dslot" value="any" checked>Any</input>
					  </label>
					</div>
					<div class="radio radio-primary">
					  <label>
						<input onclick="dsCheck()"type="radio" name="dslot" value="spec">Specific days</input>
					  </label>
					</div>
					<input type="hidden" name="DS" value="1111111"></input>
					<div id="dayrow" style="display:none;">
						<select name="daybox" multiple>
							<option value="1">Sunday</option>
							<option value="1">Monday</option>
							<option value="1">Tuesday</option>
							<option value="1">Wednesday</option>
							<option value="1">Thursday</option>
							<option value="1">Friday</option>
							<option value="1">Saturday</option>
						</select><br/><br/><br/>
					</div>
                </div>
            </div>
              
              
              	 <div class="form-group">
                <label for="inputTS" class="col-md-2 control-label">Time Slot</label>

                <div id="inputTS" class="col-md-10">
                  <!--<input type="text" class="form-control" id="inputTS" placeholder="Time Slot" name="TS">-->
				  <div class="radio radio-primary">
					  <label>
						<input type="radio" onclick="tsCheck()" name="tslot" value="any" checked>Any</input>
					  </label>
					</div>
					<div class="radio radio-primary">
					  <label>
						<input onclick="tsCheck()"type="radio" name="tslot" value="spec">Specific Time</input>
					  </label>
					</div>
					<input type="hidden" name="TS" value="00:00-23:30"></input>
					<div id="timerow" style="display:none;">
						Start - <select name="tsr11"></select>&nbsp;&nbsp;
						&nbsp;&nbsp;End - <select name="tsr12"></select><br/><br/>
						Start - <select name="tsr21"></select>&nbsp;&nbsp;
						&nbsp;&nbsp;End - <select name="tsr22"></select><br/><br/>
						Start - <select name="tsr31"></select>&nbsp;&nbsp;
						&nbsp;&nbsp;End - <select name="tsr32"></select><br/><br/>
						Start - <select name="tsr41"></select>&nbsp;&nbsp;
						&nbsp;&nbsp;End - <select name="tsr42"></select><br/><br/>
						Start - <select name="tsr51"></select>&nbsp;&nbsp;
						&nbsp;&nbsp;End - <select name="tsr52"></select><br/>
						<br/><br/><br/>
					</div>
                </div>
              </div><br>
			 <div class="form-group">
					<label for="select2" class="col-md-2 control-label" >Discipline</label>

					<div id="select2" class="col-md-10">
					  <select class="form-control" name="disc" onchange="rePopSubDisc()">
							<option value="Academics">Academics</option>
							<option value="Technical or Vocational">Technical or Vocational</option>
							<option value="Art">Art</option>
							<option value="Singing">Singing</option>
							<option value="Instruments">Instruments</option>
							<option value="Dance">Dance</option>
							<option value="Sports">Sports</option>
							<option value="Others">Others</option>
					  <select>
					  <div id="discrow" style="display:none;">
						<input class="form-control" name="discipline" type="text" placeholder="Others please specify"></input>
					  </div>
					</div>
			 </div>
              <br><br><br><br><br><br>
            <div id="subdiscrow" class="form-group">
                <label for="select3" class="col-md-2 control-label" >Sub Discipline</label>

                <div id="select3" class="col-md-10">
                  <select class="form-control" name="subdiscipline">
					<option value="English">English</option>
					<option value="Bengali">Bengali</option>
					<option value="Hindi">Hindi</option>
					<option value="Computer">Computer</option>
					<option value="Physics">Physics</option>
					<option value="Chemistry">Chemistry</option>
					<option value="Mathematics">Mathematics</option>
					<option value="Biology">Biology</option>
				  <select>
                </div>
            </div>
			
			<br/><br/><br/><br/><br/>

         <div class="form-group">
            <label for="inputSal" class="col-md-4 control-label">Remuneration(Low)</label>
            <div id="inputSal" class="col-md-8">
              <input class="form-control" name="remunerationl" type="number" min="0" max="10000" step="100" required></input>
            </div>
          </div><br/>
          
            <div class="form-group">
            <label for="inputSal2" class="col-md-4 control-label">Remuneration(High)</label>
            <div id="inputSal2" class="col-md-8">
              <input class="form-control" name="remunerationh" type="number" min="0" max="10000" step="100" required></input>
            </div>
          </div><br/><br/><br/><br/><br><br><br>
          <div class="form-group">
                <label for="select4" class="col-md-2 control-label" >Batch Size</label>
			  <div class="col-md-10">
					  <select id="select4" class="form-control" name="bs">
						 <option>Single</option>
						 <option>Upto 5</option>
						 <option>Upto 10</option>
						 <option>Any</option>
					  </select>
			  </div>
		  </div><br><br><br><br><br>
           <div class="form-group">
            <label class="control-label" for="inputSal">Description</label>
            <input type="text" class="form-control" id="inputdesc" name="desc" value = "<%=session.getAttribute("TDescription") %>">
          </div>
		 <div class="form-group">
                <div class="col-md-10 col-md-offset-2">
                  <button type="button" onclick="window.location.href='AgencyDashboard.jsp'"class="btn btn-warning">Cancel</button>
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
         </div><br><br><br>
       
       
      </div>
    </div>  
  </div></div></form>
  
   <script>
			function validateForm() {
				var form = document.getElementById("frm");
				var name = form.elements["name"].value;
				var dob = form.elements["db"].value;
				var today = new Date(), dobObj = new Date(dob);
				var contact = form.elements["contact"].value;
				var address = form.elements["address"].value;
				var disc = form.elements["disc"].value;
				var discipline = form.elements["discipline"].value;
				var subdiscipline = form.elements["subdiscipline"].value;
				var experience = form.elements["exp"].value;
				var remuneration1 = parseInt(form.elements["remunerationl"].value);
				var remuneration2 = parseInt(form.elements["remunerationh"].value);
				var ds = form.elements["dslot"].value;
				var ts = form.elements["tslot"].value;
				var daybox = form.elements["daybox"];
				var loc = form.elements["loc"].value;
				var locbox = form.elements["locbox"].value;
				var bsize = form.elements["bs"].value;
				var description = form.elements["desc"].value;
				if(!name.match(/^[a-zA-Z]+(\s?[a-zA-Z])*$/)) {
					alert("Invalid Name");
					form.elements["name"].focus();
					return false;
				} else if(dob == '' || dobObj > today) {
					alert("Invalid Date of Birth");
					form.elements["db"].focus();
					return false;
				} else if(!contact.match(/^[9,8,7]([0-9]{9})$/)) {
					alert("Invalid Contact Number");
					form.elements["contact"].focus();
					return false;
				} else if(address == '') {
					alert("Address cannot be empty");
					form.elements["address"].focus();
					return false;
				} else if(disc == "Others" && discipline == '') {
					alert("Discipline cannot be empty");
					form.elements["discipline"].focus();
					return false;
				} else if(disc != "Others" && subdiscipline == '') {
					alert("Sub-Discipline cannot be empty");
					form.elements["subdiscipline"].focus();
					return false;
				} else if(experience == '' || experience < 0 || experience > 40) {
					alert("Invalid Experience");
					form.elements["exp"].focus();
					return false;
				} else if(remuneration1 == '' || remuneration1 < 0 || remuneration1 > 10000 || remuneration1 > remuneration2) {
					alert("Invalid Remuneration");
					form.elements["remunerationl"].focus();
					return false;
				} else if(remuneration2 == '' || remuneration2 < 0 || remuneration2 > 10000) {
					alert("Invalid Remuneration");
					form.elements["remunerationh"].focus();
					return false;
				}else if (loc == "My Location" && locbox == '') {
					alert("Location cannot be Empty");
					form.elements["locbox"].focus();
					return false;
				} else if(bsize != 'Single' && bsize != 'Upto 5' && bsize != 'Upto 10' && bsize != 'Any') {
					alert("Invalid Batch Size");
					form.elements["bs"].focus();
					return false;
				} else if(description == '') {
					alert("Description cannot be empty");
					form.elements["desc"].focus();
					return false;
				} else { 
					if(disc != "Others") {
						form.elements["discipline"].value = disc;
					} if(ds == "spec") {
						var i;var finalDS = "";
						for(i = 0;i < daybox.length;i++) {
							if(daybox[i].selected == true) {
								finalDS += daybox[i].value;
							} else {
								finalDS += "0";
							} if(finalDS == "0000000") {
								alert("No Day Slots specified");
								form.elements["daybox"].focus();
								return false;
							}
						} form.elements["DS"].value = finalDS;
					} else {
						form.elements["DS"].value = "1111111";
					} if(ts == "spec"){
						var time_slot = getSpecTS();
						if(time_slot == "") {
							alert("Invalid Time Slots");
							form.elements["tsr11"].focus();
							return false;
						} else {form.elements["TS"].value = time_slot;}
					} else {
						form.elements["TS"].value = "00:00-23:30";
					} if(loc == "My Location") {
						form.elements["location"].value = locbox;
					} else {
						form.elements["location"].value = "Any Location";
					} if(address == '') {
						form.elements["address"].value = "N/A";
					} if(contact == '') {
						form.elements["contact"].value = "N/A";
					} return true;
				}
			} function dsCheck() {
				var form = document.getElementById("frm");
				var ds = form.elements["dslot"].value;
				if(ds == 'any') {
					document.getElementById("dayrow").style = "display:none;";
				} else {
					document.getElementById("dayrow").style = "display:;";
				}
			} function tsCheck() {
				var form = document.getElementById("frm");
				var ts = form.elements["tslot"].value;
				var finalTS = form.elements["TS"];
				if(ts == 'any') {
					document.getElementById("timerow").style = "display:none;";
					finalTS.value = "00:00-23:30";
				} else {
					finalTS.value = "";var selects = ["tsr11","tsr12","tsr21","tsr22",
					"tsr31","tsr32","tsr41","tsr42","tsr51","tsr52"];
					for(var i=0;i<selects.length;i++) timeLoad(selects[i]);
					document.getElementById("timerow").style = "display:;";
				}
			} function getSpecTS() {
				var form = document.getElementById("frm");var finalTS = "";
				var selects = ["tsr11","tsr12","tsr21","tsr22",
					"tsr31","tsr32","tsr41","tsr42","tsr51","tsr52"];
				for(var i=0;i<10;i+=2) {
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
				} return finalTS;
			} function timeLoad(sel) {
				var ip = document.getElementById("frm").elements[sel];
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
			} function locCheck() {
				var form = document.getElementById("frm");
				var ds = form.elements["loc"].value;
				if(ds == 'My Location') {
					document.getElementById("locrow").style = "display:;";
				} else {
					document.getElementById("locrow").style = "display:none;";
				}
			} function rePopSubDisc() {
				var form = document.getElementById("frm");
				var disc = form.elements["disc"].value;
				var subdisc = form.elements["subdiscipline"];
				var discrow = document.getElementById("discrow");
				var subdiscrow = document.getElementById("subdiscrow");
				if(disc == "Academics") {
					subdisc.options.length = 0;discrow.style = "display:none;";subdiscrow.style = "display:;";
					subdisc.options[subdisc.options.length] = new Option('English', 'English');
					subdisc.options[subdisc.options.length] = new Option('Bengali', 'Bengali');
					subdisc.options[subdisc.options.length] = new Option('Hindi', 'Hindi');
					subdisc.options[subdisc.options.length] = new Option('Computer', 'Computer');
					subdisc.options[subdisc.options.length] = new Option('Physics', 'Physics');
					subdisc.options[subdisc.options.length] = new Option('Chemistry', 'Chemistry');
					subdisc.options[subdisc.options.length] = new Option('Mathematics', 'Mathematics');
					subdisc.options[subdisc.options.length] = new Option('Biology', 'Biology');
				} else if(disc == "Technical or Vocational") {
					subdisc.options.length = 0;discrow.style = "display:none;";subdiscrow.style = "display:;";
					subdisc.options[subdisc.options.length] = new Option('Technical', 'Technical');
					subdisc.options[subdisc.options.length] = new Option('Vocational', 'Vocational');
				} else if(disc == "Art") {
					subdisc.options.length = 0;discrow.style = "display:none;";subdiscrow.style = "display:;";
					subdisc.options[subdisc.options.length] = new Option('Drawing', 'Drawing');
					subdisc.options[subdisc.options.length] = new Option('Oil Painting', 'Oil Painting');
					subdisc.options[subdisc.options.length] = new Option('Origami', 'Origami');
					subdisc.options[subdisc.options.length] = new Option('Craft', 'Craft');
				} else if(disc == "Singing") {
					subdisc.options.length = 0;discrow.style = "display:none;";subdiscrow.style = "display:;";
					subdisc.options[subdisc.options.length] = new Option('Eastern Classical', 'Eastern Classical');
					subdisc.options[subdisc.options.length] = new Option('Western', 'Western');
				} else if(disc == "Dance") {
					subdisc.options.length = 0;discrow.style = "display:none;";subdiscrow.style = "display:;";
					subdisc.options[subdisc.options.length] = new Option('Classical', 'Classical');
					subdisc.options[subdisc.options.length] = new Option('Western', 'Western');
				} else if(disc == "Instruments") {
					subdisc.options.length = 0;discrow.style = "display:none;";subdiscrow.style = "display:;";
					subdisc.options[subdisc.options.length] = new Option('Piano', 'Piano');
					subdisc.options[subdisc.options.length] = new Option('Guitar', 'Guitar');
					subdisc.options[subdisc.options.length] = new Option('Percussion', 'Percussion');
				} else if(disc == "Sports") {
					subdisc.options.length = 0;discrow.style = "display:none;";subdiscrow.style = "display:;";
					subdisc.options[subdisc.options.length] = new Option('Football', 'Football');
					subdisc.options[subdisc.options.length] = new Option('Cricket', 'Cricket');
					subdisc.options[subdisc.options.length] = new Option('Hockey', 'Hockey');
					subdisc.options[subdisc.options.length] = new Option('Basketball', 'Basketball');
					subdisc.options[subdisc.options.length] = new Option('Lawn Tennis', 'Lawn Tennis');
					subdisc.options[subdisc.options.length] = new Option('Table Tennis', 'Table Tennis');
				} else if(disc == "Others") {
					subdisc.options.length = 0;discrow.style = "display:;";
					subdisc.value = '';subdiscrow.style = "display:none;";
				} else {}
			}
		</script>

           

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