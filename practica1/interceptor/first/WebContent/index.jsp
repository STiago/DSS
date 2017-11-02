<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acelerometro</title>
</head>
<body>
	<f:view>
		<h:form>
			<h:commandButton style="#{controlador.color}" action="#{controlador.Opciones}"
				value="#{controlador.texto}"></h:commandButton>
			<h:commandButton action="#{controlador.Acelerar}"
				value="#{controlador.textoAcelerar}"></h:commandButton>
			<h:messages layout="table"></h:messages>
		</h:form>
		<br>
		<br>
		<p style="color: red"><h:outputLabel value="#{controlador.textoEstado}"></h:outputLabel></p>
		<br>
		<br>
		<h:panelGroup rendered="#{controlador.initial!=true}">
			<h:form>
				<h:panelGrid columns="2">
					<h:outputLabel value="Inserta la velocidad:"></h:outputLabel>
					<h:inputText value="#{controlador.distancia}"></h:inputText>
				</h:panelGrid>
				<h:commandButton action="#{controlador.distanciaTovelocidad}"
					value="Acelerar"></h:commandButton>
				<h:commandButton action="#{controlador.reset}" value="Reset"></h:commandButton>
				<h:messages layout="table"></h:messages>
			</h:form>
			<br>
			<br>
			<h3>Result</h3>
			<br>
			<h:outputLabel value="Velocidad total: "></h:outputLabel>
			<h:outputLabel style="color:green" value="#{controlador.velocidad}"></h:outputLabel>
		</h:panelGroup>
	</f:view>
</body>
</html>