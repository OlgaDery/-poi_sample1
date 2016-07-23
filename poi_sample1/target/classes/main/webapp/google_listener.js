var selected = {}; //{filter_key:[poi_id]}

$('#scroll_form input').off().on('change', function(){
	var filter_key = $(this).attr("name");
	var poi_id = $(this).attr("value");

	//check if selected dict has such key, if not crate empty list as value for this key
	if (selected[filter_key] == undefined ){
		selected[filter_key] = [];
	}
	
	// if value is in the list 
	if (selected[filter_key].indexOf(poi_id) > -1){		
		// get index of the value in the list
		var i = selected[filter_key].indexOf(poi_id);
		// delete value from the list
		selected[filter_key].splice(i,1);
	}
	// if value not in the list
	else{
		// add value to the list
		selected[filter_key].push(poi_id);
	}
	// show the dict in input where id='111'
	$("#111").val(JSON.stringify(selected));

	
	var posting = $.post("/poi_app/map/ajax", selected, "application/json");
	posting.done( function(result) {
		var flJson = JSON.stringify(eval(result));//firstLine);
		//alert(typeof(flJson)+": "+eval(flJson));
		  setMapView(flJson);
	  });
	  posting.fail(function() {
		    alert( "error" );
		  });
});