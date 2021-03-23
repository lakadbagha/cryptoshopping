/**
 * 
 */

$(document).ready(function() {
	$(".delBtn").click(function(e){
		e.preventDefault();
		var href = $(this).attr("href");
		$("#delThisCart").attr("href",href);
		$("#deleteCart").modal();
	});
	$("#delThisCart").click(function(e){
		e.preventDefault();
		var href = $(this).attr("href");
		$.get(href, function(response){
			console.log(response);
			if(response=="success"){
				window.location = "/showCart";
			}
		})
	})
	$(".editBtn").click(function(e) {
		e.preventDefault();
		var href = $(this).attr("href");
		$.get(href, function(response, status) {
			$(".my-model-form #productURL").val(response.productURL);
			$(".my-model-form #quantity").val(response.quantity);
			$(".my-model-form #cartId").val(response.cartId);
			$(".my-model-form #price").val(response.price);
		})
		$(".my-model-form #editModal").modal();
		$("#showError").hide();
	});
	$("#updateMyCart").submit(function(e) {
		e.preventDefault();
		var cartId = $(".my-model-form #cartId").val();
		var productURL = $(".my-model-form #productURL").val();
		var price = $(".my-model-form #price").val();
		var quantity = $(".my-model-form #quantity").val();
		if (cartId == "" || cartId == undefined) {
			$("#showError").show();
			$("#showError").text("Please Don't try to be oversmart.");
			return false;
		} else if (productURL == "" || productURL == undefined) {
			$("#showError").show();
			$("#showError").text("Please Don't try to be oversmart.");
			return false;
		} else if (price == "" || price == undefined) {
			$(".my-model-form #price").focus();
			$("#showError").show();
			$("#showError").text("Please write price.");
			return false;
		} else if (quantity == "" || quantity == undefined) {
			$(".my-model-form #quantity").focus();
			$("#showError").show();
			$("#showError").text("Please write quantity.");
			return false;
		} else {
			$.post("/user/updateCart", {
				productURL : productURL,
				price : price,
				cartId : cartId,
				quantity : quantity
			}, function(response) {
				if (response == "success") {
					window.location = "/showCart";
				} else {
					$("#showError").show();
					$("#showError").text(response);
				}
			})
		}
	});
	
	var sum = 0;
	$('.itemCart').each(function() {
		sum += Number($(this).text());
	});
	$("#netTotal").text(sum);
	var btc = $("#bitcoinValue").text();
	document.getElementById("grandTotal").innerHTML = (sum / btc).toFixed(7);
});