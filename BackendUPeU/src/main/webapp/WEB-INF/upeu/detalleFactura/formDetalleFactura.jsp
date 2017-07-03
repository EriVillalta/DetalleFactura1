<%-- 
    Document   : formPeriodo
    Created on : 23-jun-2015, 10:23:00
    Author     : SistemasUpeu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>        
    </head>
    <body>
        <div>

            <fm:form modelAttribute="modeloDetalleFactura" method="post" action="guardarDetalleFactura">
                <table>

                    <tr>
                        <td><fm:label path="numeroFactura">N° Factura</fm:label> </td>
                        <td><fm:input path="numeroFactura" /></td>
                    </tr>
                    <tr>
                        <td><fm:label path="idProducto">Producto</fm:label> </td>
                        <td><fm:input path="idProducto" size="60" /></td>
                    </tr>  
                    <tr>
                        <td><fm:label path="cantidad">Cantidad</fm:label> </td>
                        <td><fm:input path="cantidad" size="60" /></td>
                    </tr> 
                    <tr>
                        <td><fm:label path="precioVenta">Precio Venta</fm:label> </td>
                        <td><fm:input path="precioVenta" size="60" /></td>
                    </tr> 

                    <tr>                        
                        <td colspan="2"><input type="submit" value="Enviar" > </td>
                    </tr>
                </table>                
            </fm:form>         
        </div>
    </body>
</html>
