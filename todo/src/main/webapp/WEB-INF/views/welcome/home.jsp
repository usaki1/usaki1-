<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<div id="wrapper">
		<h1>Hello world!</h1>
		<p>The time on the server is ${serverTime}.</p>
	</div>

	<form:form method="get"
		action="${pageContext.request.contextPath}/ajaxTransactionTokenCheck">
		<input type="submit" id="first" name="first" value="first" />
	</form:form>
</body>
</html>
