
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);    
}

function postServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    })..done(function( msg ) {
    alert( "Data Saved: " + msg );
  });  
  function putServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    })..done(function( msg ) {
    alert( "Data Saved: " + msg );
  });    
}
function callDone(result){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)
	});

	$("#result").append(html);
}

$(function(){
	$("#aircraft").click(function(){
		getServerData("ws/example/Aircraft",callDone);
	});
	
	$("#Pilot").click(function(){
		getServerData("ws/example/Pilot",callDone);
	});
	
	$("#Flight").click(function(){
		getServerData("ws/example/Flight",callDone);
	});
	
	$("#Passenger").click(function(){
		getServerData("ws/example/Passenger",callDone);
	});
	
});