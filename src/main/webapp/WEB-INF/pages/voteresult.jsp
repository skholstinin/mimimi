<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<t:base-page>
    <html lang="en">

    <div style="text-align: center">
        <h1 align="center">Результат голосования</h1>
    </div>

    <div style="float:left">
        <div class="card" style="width: 15rem;">
            <c:if test="${not empty cats.get(0).ava_link}">
                <img src="${cats.get(0).ava_link}" class="card-img-top">
            </c:if>
            <div class="card-body p-0">
                <h5 class="card-title pt-3 px-3">${cats.get(0).name}</h5>
            </div>
        </div>
    </div>


    <div style="float:right">
        <div class="card" style="width: 15rem;">
            <c:if test="${not empty cats.get(1).ava_link}">
                <img src="${cats.get(1).ava_link}" class="card-img-top">
            </c:if>
            <div class="card-body p-0">
                <h5 class="card-title pt-3 px-3">${cats.get(1).name}</h5>
            </div>
        </div>
    </div>
    </html>
</t:base-page>