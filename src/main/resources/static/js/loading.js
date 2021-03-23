/**
 * 
 */
document.onreadystatechange = function() {
	var state = document.readyState
	if (state == 'interactive') {
		$('#contents').hide();
	} else if (state == 'complete') {
		setTimeout(function() {
			document.getElementById('interactive');
			$('#load').hide();
			$('#contents').show();
		}, 1000);
	}
}