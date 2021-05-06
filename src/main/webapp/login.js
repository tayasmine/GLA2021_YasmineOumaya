function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function postServerData(url, data, success){
    $.ajax({
		type: 'POST',	
        url: url,
		data: data,
		contentType : 'application/json',
        dataType: "json"
    }).done(success);
}

function callDone(result){
	if(result!=null){
		localStorage.setItem('userID', JSON.stringify(result.userID));
		console.log("user id: "+ result.userID);
		localStorage.setItem('isApilot', JSON.stringify(result.isApilot));

		if(localStorage.getItem("confirmAsked")){
			document.location.href = "pilotConfirm.html?bookingId=1";
		}
		else{
			document.location.href = "home.html";
		}
		if(localStorage.getItem("last_Page")=="ViewFlight.html"){
			document.location.href = "ViewFlight.html";
		}

	}
	else{
		alert("Something wrong happened during the connection \n Your Email or Password is incorrect");

		document.location.href = "Log-in.html";
	}
}


$(function(){

	$("#LOGIN").click(function(){				

	var user = {
		email : $("#email").val(),
		pwd : $("#Password").val()
		}
		
	if($("#email").val() == ""){
			console.log("email is null");
			return false;
		}
		
	if($("#Password").val() == ""){
			console.log("password is null");
			return false;
		}
	
		alert(user.email + user.pwd);
		
	postServerData("ws/passenger/login",JSON.stringify(user),callDone);
	
	});

});