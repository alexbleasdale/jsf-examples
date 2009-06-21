<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<f:loadBundle basename="com.example.jsf.beans.messages" var="message"/>
<html>
	<head>
		<title>Thanks, <h:outputText value="#{StoreNameBean.forename} #{StoreNameBean.surname}" /></title>
	</head>
	<body>
			<h3>Hello, <h:outputText value="#{StoreNameBean.forename} #{StoreNameBean.surname}" /></h3>
			<p>Thanks for signing up...</p>
			<h4>Your email address is: 
				<h:outputLink value="mailto:#{StoreNameBean.email}">
	  				<f:verbatim><h:outputText value="#{StoreNameBean.email}" /></f:verbatim>
				</h:outputLink>
			</h4>
			<div id="greeting"><h:outputText value="#{message.greeting_text}" /></div>
	</body>
</html>
</f:view>