/**
 * 
 */

$(document)
		.ready(
				function() {
					$("#cancel").click(function(event) {
						$("#productURLId").prop('disabled', false);
						$("#addCartPanel").hide();
						$("#price").val("");
						$("#quantity").val("");
						$("#productURLId").val("");
						$("#productURLId").focus();
					});
					$("#userAddCartForm1").submit(
							function(event) {
								var url = document
										.getElementById('productURLId').value;
								if (url == '' || url == null) {
									alert('Please Write proper URL');
									return false;
								} else {
									$("#successMessage").hide();
									$("#productURLId").prop('disabled', true);
									$("#addCartPanel").fadeIn(1000);
									$("#price").focus();
								}
							});
					$("#addCartPanel").hide();
					$("#successMessage").hide();
					$("#price")
							.keyup(
									function() {
										var price = document
												.getElementById("price").value;
										var quantity = document
												.getElementById("quantity").value;
										var btc = document
												.getElementById("bitcoinValue").innerHTML;
										if ($.isNumeric(price)
												&& $.isNumeric(quantity)) {
											document
													.getElementById("totalPrice").innerHTML = (price
													* quantity / btc)
													.toFixed(7)
													+ " btc";
										}
									});
					$("#quantity")
							.keyup(
									function() {
										var price = document
												.getElementById("price").value;
										var quantity = document
												.getElementById("quantity").value;
										var btc = document
												.getElementById("bitcoinValue").innerHTML;
										if ($.isNumeric(price)
												&& $.isNumeric(quantity)) {
											document
													.getElementById("totalPrice").innerHTML = (price
													* quantity / btc)
													.toFixed(7)
													+ " btc";
										}
									});
					$("#userAddCartForm2").submit(
							function(event) {
								event.preventDefault();
								var url = $('productURLId').val();
								var price = $("price").val();
								var quantity = $("quantity").val();
								if (price == '' || price == null) {
									alert('Please Enter price.');
									return false;
								} else if (quantity == '' || quantity == null) {
									alert('Please Enter quantity.');
									return false;
								} else {
									$("#load").show();
									$.post("/user/addCart", {
										productURL : url,
										price : price,
										quantity : quantity
									}, function(responseJSON) {
										if (responseJSON === 'success') {
											$("#load").hide();
											$("#successMessage").show();
											var value = parseInt($("#cartInfo")
													.text(), 10) + 1;
											$("#cartInfo").text(value);
										} else {
											alert(responseJSON);
										}
									});
								}
								;
							});

				});