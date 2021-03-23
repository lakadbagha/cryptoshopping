/**
 * 
 */

$(document).ready(function() {
	$(".delBtn").click(function(e) {
		e.preventDefault();
		var href = $(this).attr("href");
		var remove = $(this).parent().parent().parent().parent();
		$.get(href, function(response) {
			console.log(response);
			if (response === "deleted") {
				remove.remove();
			} else {
				alert(response);
			}
		})
	});
	$(".addressBtn").click(function(e) {
		e.preventDefault();
		var href = $(this).attr("href");
		$.get(href, function(response) {
			$("#name").val(response.fullName);
			$("#address1").val(response.addressLine1);
			$("#address2").val(response.addressLine2);
			$("#city").val(response.city);
			$("select option").filter(function() {
				return $(this).text() === response.region;
			}).prop('selected', true);
			$("#country").val(response.country);
			$("#pinCode").val(response.zipCode);
			$("#landMark").val(response.landMark);
			$("#phoneNumber").val(response.phoneNumber);
			$("#orderNote").val(response.notesForOrder);
			$("#deliverNote").val(response.notesFordeliver);
			$("#orderNote").focus();
		});
	});
	$("#placeOrder").submit(function(e) {
		e.preventDefault();
		var name = $("#name").val();
		var address1 = $("#address1").val();
		var address2 = $("#address2").val();
		var city = $("#city").val();
		var state = $("#state").val();
		var country = $("#country").val();
		var zipCode = $("#pinCode").val();
		var landMark = $("#landMark").val();
		var phoneNumber = $("#phoneNumber").val();
		var deliverNote = $("#deliverNote").val();
		var orderNote = $("#orderNote").val();
		if (name == "" || name === undefined) {
			alert("Please Write Full Name");
			return false;
		} else if (address1 == "" || address1 === undefined) {
			alert("Please Write Address Line 1");
			return false;
		} else if (address2 == "" || address2 === undefined) {
			alert("Please Write Address Line 2");
			return false;
		} else if (city == "" || city === undefined) {
			alert("Please Write city");
			return false;
		} else if (state == "" || state === undefined) {
			alert("Please Write state/region");
			return false;
		} else if (country == "" || country === undefined) {
			alert("Please Write country");
			return false;
		} else if (zipCode == "" || zipCode === undefined) {
			alert("Please Write Zip Code/Postal code");
			return false;
		} else if (landMark == "" || landMark === undefined) {
			alert("Please Write Land Mark/Near By");
			return false;
		} else if (phoneNumber == "" || phoneNumber === undefined) {
			alert("Please Write Phone Number/Mobile");
			return false;
		} else {
			$.post("/user/saveAddress", {
				fullName : name,
				addressLine1 : address1,
				addressLine2 : address2,
				city : city,
				state : state,
				country : country,
				pinCode : zipCode,
				landMark : landMark,
				noteOnOrder : orderNote,
				noteOnDeliver : deliverNote,
				phoneNumber : phoneNumber
			}, function(response) {
				console.log(response);
				if (response.indexOf("success") >= 0) {
					var invoiceId = response.split(": ")[1];
					var url = "/user/userPayment/"+invoiceId;
					window.location = url;
				} else {
					alert(response);
				}
			});
		}
	});
	var sum = 0;
	$('.list-group').each(function() {
		sum += 1;
	});
	if (sum == 0) {
		$("#getAddressDetails").remove();
		$("#addressForm").attr("class", "col-sm-8 mx-auto");
	}
});