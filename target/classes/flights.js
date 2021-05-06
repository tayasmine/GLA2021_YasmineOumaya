function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);    
}


function postServerData(url, success){
	$.ajax({
		url: url,
		type: 'POST',
		dataType: "json",
	 }).done(success);
}

function callDone(result){
	var templateExample = _.template($('#templateExample').html());
	result.forEach(f => {
	
	var html = templateExample({
		"attribute":JSON.stringify(f)
	});

	$("#result").append(html);});
}

$(function(){
	$("#SHOW").click(function(){
		getServerData("ws/Flight/All",callDone);
	});
});


$(function(){
	$("#BOOK").click(function(){
		postServerData("ws/Flight//bookFlight?flightid=12345?passengerid=Julien");
	});
});