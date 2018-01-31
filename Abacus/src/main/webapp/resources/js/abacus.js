"use strict";
//client side validation
$(document)
.ready(
		function() {
			$('#abacusForm')
					.validate(
							{
								rules : {
									threadRow : {
										required : true,
										minlength : 79,
										maxlength : 79
									},
									valueRow : {
										required : true,
										min : 0,
										max : 999999

									}
								},
								messages : {
									threadRow : {
										required : "The thread has to be filled.",
										minlength : "The thread has to be 91 characters long.",
										maxlength : "The thread has to be 91 characters long."
									},
									valueRow : {
										required : "The value to add has to be filled.",
										min : "The value has to be minimum 0.",
										max : "The value has to be maximum 999999."
									}
								},
								errorElement : "em",
								errorPlacement : function(
										error, element) {
									// Add the `help-block` class to the error element
									error
											.addClass("help-block");

									if (element.prop("type") === "checkbox") {
										error
												.insertAfter(element
														.parent("label"));
									} else {
										error
												.insertAfter(element);
									}
								},
								highlight : function(element,
										errorClass, validClass) {
									$(element)
											.parents(
													".col-sm-5")
											.addClass(
													"has-error")
											.removeClass(
													"has-success");
								},
								unhighlight : function(element,
										errorClass, validClass) {
									$(element)
											.parents(
													".col-sm-5")
											.addClass(
													"has-success")
											.removeClass(
													"has-error");
								}

							});
		});

var ajaxRequest = new AjaxRequest('POST', '/ajax/add', ajaxSuccessfulRequest, ajaxRequestFailed, 300);

//add button clicked.
function submitButtonClicked(){
	document.getElementById("lblResult").innerHTML = "-";
	// validate form
	$("#abacusForm").validate();
	if ($("#abacusForm").valid()) {
		//make a ajax request
		ajaxRequest.makeRequest(getFormData());
	}
}

// get form data
function getFormData(){
	return {
		threadsValue : document.getElementById("threadRow").value,
		additionValue : document.getElementById("valueRow").value
	};
}

// ajax request
function AjaxRequest(httpMethod, url, successHandler, errorHandler, timeout) {

	var date = new Date();
	var offSet = date.getTimezoneOffset()
	return {
		httpMethod : httpMethod,
		url : url,
		successHandler : successHandler,
		errorHandler : errorHandler,
		timeout : timeout,
		makeRequest : function makeRequest(data) {
			$.ajax({
				type : this.httpMethod,
				contentType : "application/json; charset=utf-8;",
				url : this.url,
				beforeSend : function(request) {
					request.setRequestHeader("tz-accept", offSet);
				},
				data : JSON.stringify(data),
				timeout : this.timeout,
				success : function(response) {					
					if (typeof (successHandler) != 'undefined') {
						successHandler(response.result);
					}
				},
				error : function(error) {
					// error object
					var requestErrorObject = error.responseJSON;
					// fault object
					var responseText = requestErrorObject.errorText;
					if (typeof (errorHandler) != 'undefined') {						
						// call error handler
						errorHandler(responseText, this.httpMethod);
					}
				}
			});
		}
	}
}

//ajax error handler
function ajaxRequestFailed(error) {
	window.alert(error);
}

//ajax success handler
function ajaxSuccessfulRequest(data){
	document.getElementById("lblResult").innerHTML = data;
}