<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="versi" uri="WEB-INF/versi.tld"%>
<html>
<head>

<title>My Login Application</title>
</head>

<body>
	<h2>My Login Application</h2>
	<s:actionerror />
	<versi:emailAnchor id="2" clazz="test" title="Jolly nice person" style="background-color:yellow;" value="email"
		default="martin.paulo@gmail.com" writeWithJavaScript="true" />
	<s:form action="login.action" method="post" namespace="/">
		<s:textfield name="username" key="label.username" size="20" />
		<s:password name="password" key="label.password" size="20" />
		<s:submit method="execute" key="label.login" align="center" />
	</s:form>
	<hr />
</body>
</html>
