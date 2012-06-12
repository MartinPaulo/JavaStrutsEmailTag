<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="versi" uri="WEB-INF/versi.tld"%>

<html>

<head>
<title>Welcome</title>
</head>

<body>
	<h2>
		<s:actionmessage />
		Hello
		<s:property value="username" />
		!
	</h2>
	<p>
		You can be reached at:
		<versi:emailAnchor value="email" default="martin.paulo@gmail.com" />
	</p>

</body>
</html>
