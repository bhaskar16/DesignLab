//@author: Bhaskar Ghosh Dastidar 
//dastidar.bhaskar@gmail.com
var giftcard;
var email;
var Name;
var message;
var occasion;
var formValues;
function setgc(gctype)
{	
	switch(gctype){
		case 1: {giftcard = 500;break;}
		case 2: {giftcard = 1000;break;}
		case 3: {giftcard = 2000;break;}
		default: {giftcard = 500;break;}
		
	}
	
}

function formvalidation() // Control function of all validation
{
	formValues = document.getElementById("GCForm");
	email = formValues.elements[0].value;
	Name = formValues.elements[1].value;
	occasion = formValues.elements[2].value;
	message = formValues.elements[3].value;
	var a = validatenull(formValues);
	var b = validateemail(email);
	var c = validateName(Name);	
	var d = validatemessage(message);
	if (a == 1 && b == 1 && c==1 && d == 1) // If all validations succeed.
	postToGoogleForm();

}
function validatenull(x) // To check whether all values are present or not
{
	var i;
	for (i = 0; i < x.length; i++) {
	if(x.elements[i].value == "")
	{alert("Please provide this information");
	x.elements[i].focus();
	return 0;}
	return 1;
   
	}
}
function validatemessage(message){ // TO validate whether the personalised message is within 250 characters
	if(message.length>250)
		return 0;
	return 1;
}
function validateemail(email) // To validate the email id
{  
 if (!(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/).test(email))  
  {  
    alert("Please enter a valid email address!");
	document.forms["GCForm"]["email"].focus();
	return 0;
  }
return 1;  
}
function validateName(Name) // To validate the Name of the sender
{
	var numericpresent = Name.match(/\d+/g);
	if (numericpresent != null) {
    alert('Please enter a valid Name');
	document.forms["GCForm"]["senderName"].focus();
	return 0;
}
		return 1;
}


function postToGoogleForm(){ // Final Ajax call to the google form
		
       
            $.ajax({
                url: "https://docs.google.com/forms/d/1DLvXtyrc6CW6iWczg6QP4cqw88eIjXkYQzLXenWQwtY/formResponse",
                data: {"entry_1995217607" : email, "entry_1778891461" : Name, "entry_549218214": occasion,  "entry_2089197617": message},
                type: "POST",
                dataType: "xml",
                statusCode: {
                    0: function (){
 
                        alert("Success! You've booked a StayGlad Gift card worth Rupees. "+giftcard);
                        //Success message
                    },
                    200: function (){
                         alert("Done 200");
                        //Success Message
                    }
                }
            });
        
    }
