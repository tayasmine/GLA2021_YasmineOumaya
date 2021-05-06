function putServerData(url, data, success){

    $.ajax({
		type: 'PUT',	
        url: url, 
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}


function callDone(result){
	
		
}
		

var newFlight;

$(document).ready(function() {
	
	
	$("#addPilotButton").click(function() {
		
		console.log("create Pilot");
    let userID = JSON.parse(localStorage.getItem('userID'));

  
    const formData = new FormData();
    

		newPilot = {
			pilotid : $("#pilotid").val(),
			pilotName : $("#pilotName").val(),
            description : $("#description").val(),
			pilotMail : $("#pilotMail").val(),
			password : $("#password").val(),
      		phonenumber : $("#phonenumber").val(),
      		birthdate : $("#birthdate").val(),
            flighthours : $("#flighthours").val(),
			
			
      
		};
    
		putServerData("ws/Pilot/addPilot",JSON.stringify(newPilot),callDone);
		
		
	});
});