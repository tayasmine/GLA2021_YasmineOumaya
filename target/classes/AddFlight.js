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
	
	
	$("#addFlightButton").click(function() {
		
		console.log("create flight");
    let userID = JSON.parse(localStorage.getItem('userID'));

  
    const formData = new FormData();
    

		newFlight = {
			id : $("#id").val(),
			departure : $("#departure").val(),
			direction : $("#direction").val(),
			date : $("#date").val(),
      		time : $("#time").val(),
      duration : $("#duration").val(),
			price : $("#price").val(),
			flighttype :  $("#flighttype").val(),
      appointment : $("#appointment").val(),
      availableseats : $("#availableseats").val(),
      description : $("#description").val(),
      pilotid: $("#pilotid").val(),
      aircrafttype: $("#aircrafttype").val(),
      
		};
    
		putServerData("ws/Flight/addFlight",JSON.stringify(newFlight),callDone);
		
		
	});
});




