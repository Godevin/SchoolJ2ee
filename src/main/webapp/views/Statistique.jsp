<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Synapse Gaming | Home</title>
    <!-- Meta -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- CSS -->
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/img/favicon.ico" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/common.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/home.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/header.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/menu.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/news.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/slider.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/videos.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/blogs.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/achievement.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/recruitment.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/footer.css" />">
    <!-- JS -->
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-2.0.3.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/menu.js" />"></script>
</head>
<body>
<div id="page-wrapper">
    <div id="header-wrapper">
        <jsp:include page="portal/Header.jsp"/>
    </div>
    <div id="persistent-menu-wrapper">
        <jsp:include page="portal/PersistentMenu.jsp"/>
    </div>
    <div id="menu-wrapper">
        <jsp:include page="portal/Menu.jsp"/>
    </div>
    <div id="middle-full-wrapper">
        <div id="stats-full-container">
            <h3>
                <span>Statistiques</span>
            </h3>
            <div id="statClasses">
                <div class="topClazz">
					<h4>Top 5 des Classes</h4>
					<c:forEach items="${classes}" var="classe">
					<div>
						<div>${ classe.key.name } : <span>${ classe.value  }</span></div>
					</div>
					</c:forEach>
				</div>
                <div class="topRaces">
                    <h4>Top 5 des races</h4>
                    <c:forEach items="${races}" var="race">
                        <div>
                            <div>${ race.key.name } : <span>${ race.value }</span></div>
                        </div>
                    </c:forEach>
                </div>
                <div class="topSpecs">
                    <h4>Top 5 des specialisations</h4>
                    <c:forEach items="${specializations}" var="specialization">
                        <div>
                            <img src="<c:url value="${ specialization.key.img }" />" alt="${ specialization.key.name } avatar">
                            <div>${ specialization.key.name } : <span>${ specialization.value }</span></div>
                        </div>
                    </c:forEach>
                </div>
                 <div class="UserNoAvatar">
                    <h4>Liste des utilisateurs sans avatar (pseudo)</h4>
                    <c:forEach items="${noavatar}" var="user">
                        <div>
                            <div>${user}</div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <div id="footer-wrapper">
        <jsp:include page="portal/Footer.jsp"/>
    </div>
</div>
</body>
</html>