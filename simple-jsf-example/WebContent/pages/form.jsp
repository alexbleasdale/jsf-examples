<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<f:loadBundle basename="com.example.jsf.beans.messages" var="message"/>
<html>
	<head>
		<title>Please enter your details</title>
	</head>
	<body>
		<h:form>
			<h1><h:outputText value="#{message.inputname_header}"/></h1>
			
			<fieldset>
	   			<legend><h:outputText value="Your Details"/></legend>
				
				<p>
					<h:outputText value="#{message.forename}"/>
					<h:inputText value="#{StoreNameBean.forename}" />
				</p>
				
				<p>
					<h:outputText value="#{message.surname}"/>
					<h:inputText value="#{StoreNameBean.surname}" />
				</p>
				
				<p>
					<h:outputText value="#{message.email}"/>
					<h:inputText value="#{StoreNameBean.email}" />
				</p>
				
				<h:commandButton action="result" value="#{message.button_text}" />
			</fieldset>
		</h:form>
	</body>
</html>
</f:view>