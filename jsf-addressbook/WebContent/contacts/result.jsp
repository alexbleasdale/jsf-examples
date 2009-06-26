<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Details for: <h:outputText value="#{PersonBean.firstName} #{PersonBean.surName}" /></title>
</head>
<body>
	<h3><h:outputText value="#{PersonBean.firstName} #{PersonBean.surName}" /></h3>
	<h4><h:outputText value="#{AddressBean.state} #{AddressBean.country}" /></h4>
</body>
</html>
</f:view>