function test(){
    var html =$("#from").val()+" hello"+$("#from").val();
    $("#result").append(html);
}


function put_form_data(){
	var data='{ "From...":"'+$("#from").val()+
	'","To..":"'+$("#to").val()+
	'","date":'+$("#date").val()
	' } ';
	$("#result").append(data);
	return data;
}


$(function(){
	/*$("#GO").click(function(){
		test();
	});*/
	$("#GO").click(function(){
		var data = JSON.parse(put_form_data());
		putServerData("/Flight",data);
	});
});