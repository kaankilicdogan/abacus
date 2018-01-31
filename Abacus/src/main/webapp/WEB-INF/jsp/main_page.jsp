<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<title>Abacus</title>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">ABACUS</h3>
		</div>
		<div class="panel-body">
			<form id="abacusForm" class="form-horizontal">
				<div class="form-group">

					<label class="col-sm-4 control-label" for="threadRow">
						Thread input</label>

					<div class="col-sm-5">
						<input type="text" class="form-control" id="threadRow"
							name="threadRow">
					</div>
				</div>
				<div class="form-group">

					<label class="col-sm-4 control-label" for="valueRow"> Value
						to add</label>

					<div class="col-sm-5">
						<input type="text" class="form-control" id="valueRow"
							name="valueRow">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-4">
						<button class="btn btn-primary" type="button"
							onclick="submitButtonClicked()">Get Result</button>
					</div>
				</div>

			</form>
		</div>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">Result</h3>
		</div>
		<div class="panel-body">
			<label class="col-sm control-label" id="lblResult" ></label>
		</div>
	</div>

	<script src="${contextPath}/resources/js/jquery-1.11.1.js"></script>
	<script src="${contextPath}/resources/js/jquery.validate.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${contextPath}/resources/js/abacus.js"></script>
</body>
</html>