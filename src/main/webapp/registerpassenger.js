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
	
	
	$("#addPassengerButton").click(function() {
		
		console.log("create Passenger");
    let userID = JSON.parse(localStorage.getItem('userID'));

  
    const formData = new FormData();
    

		newPassenger = {
			passengerid : $("#passengerid").val(),
			passengerName : $("#passengerName").val(),
			passengerMail : $("#passengerMail").val(),
			password : $("#password").val(),
      		phonenumber : $("#phonenumber").val(),
      		birthdate : $("#birthdate").val(),
			
      
		};
    
		putServerData("ws/Passenger/addPassenger",JSON.stringify(newPassenger),callDone);
		
		
	});
});