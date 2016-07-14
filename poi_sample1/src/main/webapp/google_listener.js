var selected = {}; //{filter_key:[poi_id]}
var filter_key = "";
var poi_id = null;
var poi_id_list = [];

$('#scroll_form input').off().on('change', function(){
	filter_key = $(this).attr("name");
	poi_id = $(this).attr("value");
	
	// if value is in the list 
	if (poi_id_list.indexOf(poi_id) > -1){		
		// get index of the value in the list
		var i = poi_id_list.indexOf(poi_id);
		// delete value from the list
		poi_id_list.splice(i,1);
	}
	// if value in list
	else{		
		// add value to the list
		poi_id_list.push(poi_id);
	}
	// show the dict in input where id='111'
	selected[filter_key] = poi_id_list;
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