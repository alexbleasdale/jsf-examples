<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<f:view>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Contact</title>
</head>
<body>
	<h:form>
		<fieldset>
	   			<legend><h:outputText value="Contact's Name"/></legend>
	   			<!-- TODO - move all the output text into an external file and work out how to load different languages from the config files -->
	   			<p>
					<h:outputText value="First Name"/>
					<h:inputText id="firstName" value="#{PersonBean.firstName}" required="true" />
					<h:message style="color: red" for="firstName" />
				</p>
				<p>
					<h:outputText value="Middle Name"/>
					<h:inputText value="#{PersonBean.middleName}" />
				</p>
				<p>
					<h:outputText value="Last Name"/>
					<h:inputText id="lastName" value="#{PersonBean.surName}" required="true" />
					<h:message style="color: red" for="lastName" />
				</p>
	   	</fieldset>
	   	
	   	<fieldset>
	   			<legend><h:outputText value="Contact's Address"/></legend>
	   			<p>
					<h:outputText value="Address 1"/>
					<h:inputText id="address" value="#{AddressBean.streetAddress1}" required="true" />
					<h:message style="color: red" for="address" />
				</p>
				<p>	
					<h:outputText value="Address 2"/>
					<h:inputText value="#{AddressBean.streetAddress2}" />
				</p>
				<p>	
					<h:outputText value="Locality"/>
					<h:inputText value="#{AddressBean.locality}" />
				</p>
	   			<p>	
					<h:outputText value="City"/>
					<h:inputText value="#{AddressBean.city}" />
				</p>
				<p>
					<h:outputText value="State"/>
					<h:selectOneMenu binding="#{StateMappingBean.usStateMappingSelectOneMenu}" styleClass="common-dropdown" value="#{AddressBean.state}">
						<f:selectItem itemLabel="Please select state" />
					</h:selectOneMenu>
				</p>
				<p>
					<h:outputText value="Country"/>	
					<h:selectOneMenu id="country" binding="#{CountryMappingBean.countryMappingSelectOneMenu}" styleClass="common-dropdown" value="#{AddressBean.country}" required="true">
						<f:selectItem itemLabel="Please select a Country" />
					</h:selectOneMenu>
					<h:message style="color: red" for="country" />
				</p>
	   	</fieldset>
	   	<fieldset>
	   			<legend><h:outputText value="Contact's Phone and Email"/></legend>
	   			<p>
					<h:outputText value="Home Telephone" />
					<h:inputText value="#{ContactDetailsBean.homeTelephone}" />
				</p>
				<p>
					<h:outputText value="Mobile Telephone" />
					<h:inputText value="#{ContactDetailsBean.mobileTelephone}" />
				</p>
				<p>
					<h:outputText value="Email" />
					<h:inputText value="#{ContactDetailsBean.email}" />
				</p>
	   	</fieldset>
	   	
	   	<h:commandButton action="result" value="Submit" />
	</h:form>
</body>
</html>
</f:view>