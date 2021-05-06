function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);    
}

function postServerData(url, msg, success){
    $.ajax({
        dataType: "json",
        type: 'POST',
        data: msg,
        url: url
    }).done(success );  
 }
  
 function putServerData(url, msg, success){
    $.ajax({
        dataType: "json",
        type: 'PUT',
        data: msg,
        url: url
    }).done(success );  
 }

function deleteServerData(url, success){
    $.ajax({
        dataType: "json",
		type: 'DELETE',
        url: url
    }).done(success);    
}

function callDone(result){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)
	});

	$("#result").append(html);
}

$(function(){
	$("#All").click(function(){
		getServerData("ws/Flight/All",callDone);
	});
	
	$("#Pilot").click(function(){
		getServerData("ws/Pilot/Pilot",callDone);
		
		var parmWebservice ={
			"id":$("#id").val,
		};
		postServerData(url, msg, success);
		
		deleteServerData(url, success);
	});
	
	$("#Flight").click(function(){
		getServerData("ws/Flight/Flight",callDone);
		var parmWebservice ={
			"id":$("#id").val,
		};
		postServerData(url, msg, success);
		
		deleteServerData(url, success);
	});
	
	$("#Passenger").click(function(){
		getServerData("ws/Flight/Passenger",callDone);
		var parmWebservice ={
			"id":$("#id").val,
		};
		postServerData(url, msg, success);
		
		deleteServerData(url, success);
	});
	
});