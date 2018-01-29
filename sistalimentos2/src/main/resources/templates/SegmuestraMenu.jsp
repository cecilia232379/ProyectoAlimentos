<%@page import="modelo.bean.UsuarioPerfil"%>
<%@page import="modelo.bean.Modulo"%>
<%@page import="modelo.dao.impl.OpcionImpl"%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    Modulo oModulo = (Modulo) session.getAttribute("moduloSession");
    UsuarioPerfil oPerfil  = (UsuarioPerfil) session.getAttribute("perfilSession");
    OpcionImpl oOpcionImpl = new OpcionImpl();
    request.setAttribute("alMenuN1", oOpcionImpl.listaMenu(Integer.parseInt(oModulo.getIdmodulo()),Integer.parseInt(oPerfil.getUpsperfil())));

%>
<div id="sidebar" class="nav-collapse">
    <br><br><br>
    <form name="FormOpcion" id="FormOpcion" method="post" action="SPrincipal">
    <input type="hidden" name="pAccion" value="">
    <input type="hidden" name="Op" value="">
    <input type="hidden" name="Os" value="">
    <ul class="nav nav-list">
        <!--Inicio menu -->
        <c:set var="N1" value="1" scope="page" />
        <c:set var="sOpcN1" value="${sessionScope.OpcN1Session}" scope="session" />
        <c:set var="sOpcN2" value="${sessionScope.OpcN2Session}" scope="session" />
        <li <c:if test="${(sOpcN1 == 0) and (sOpcN2 == 0)}">class="active"</c:if>>
            <!--<a href="SPrincipal?pAccion=aSesOpcion&&Op=0&&Os=0">-->
            <a href="javascript:CallOpcion(0,0)">
                <i class="icon-dashboard"></i>
                <span>Escritorio</span>
            </a>
        </li>
            <c:forEach var="fila" varStatus="status" items="${alMenuN1}" >
                <c:choose>
                    <c:when test="${ (fila[6] == 10) }">
                        <c:if test="${N1 == 0}">
                            </ul>
                            </li>
                            <c:set var="N1" value="1" scope="page" />
                        </c:if>
                        <li <c:if test="${(sOpcN2 == fila[3])}">class="active"</c:if>>
                        <c:if test="${(fila[9] == 1)}">
                        <a href="#" class="dropdown-toggle">
                            <i class="icon-desktop"></i>
                            <span>${fila[0]}</span>
                            <b class="arrow icon-angle-right"></b>
                        </a>
                        </c:if>
                    </c:when>
                    <c:when  test="${ (fila[6] == 20) }">
                        <c:if test="${N1 == 1}">
                            <c:set var="N1" value="0" scope="page" />
                            <ul class="submenu">
                        </c:if>
                            <li <c:if test="${(sOpcN1 == fila[3]) and (sOpcN2 == fila[8])}">class="active"</c:if>>
                                <c:if test="${(fila[9] == 1)}">
                                <a href="javascript:CallOpcion(${fila[3]},${fila[8]})">
                                    ${fila[0]}
                                </a>
                                </c:if>
                            </li>
                    </c:when>
                </c:choose>
            </c:forEach>
        </li>
        <!--Fin Menu-->
        <li>
            <a href="javascript:CallOpcMain(2)">
                <i class="icon-list-alt"></i>
                <span>Salir</span>
            </a>
        </li>
    </ul>
    </form>
    <div id="sidebar-collapse" class="visible-desktop">
        <i class="icon-double-angle-left"></i>
    </div>
</div>
