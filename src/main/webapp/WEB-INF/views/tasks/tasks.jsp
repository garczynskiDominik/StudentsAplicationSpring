<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<%@include file="../dynamic/css.jspf" %>


<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">
    <%@include file="../dynamic/navigationMain.jspf" %>

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>


                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>


                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <sec:authorize access="hasRole('USER')">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">USER</span>
                            </sec:authorize>
                            <sec:authorize access="hasRole('ADMIN')">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">ADMIN</span>
                            </sec:authorize>

                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">

                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->


            <form name="send" method="post" action='<c:url value="/addTask"/>'>


                <!-- Begin Page Content -->
                <div class="container-fluid">


                    <div class="col-lg-12">
                        <a href='<c:url value="/addTasks"/>' class="btn btn-warning btn-block"
                           style="margin-bottom: 25px;"><i
                                class="fas fa-exclamation-triangle"></i><strong> Dodaj
                            taska</strong></a>
                    </div>


                    <div class="col-lg-12">
                        <div class="row">

                            <div class="col-lg-2">
                                <div class="card bg-success text-white shadow">
                                    <div class="card-body">
                                        <strong>Nowiciusz</strong>
                                        <div class="text-white-10 small">poziom junior</div>
                                    </div>
                                </div>


                                <div class="card bg-info text-white shadow">
                                    <div class="card-body">
                                        <strong>Dojrzewajacy</strong>
                                        <div class="text-white-10 small">poziom junior+</div>
                                    </div>
                                </div>


                                <div class="card bg-secondary text-white shadow">
                                    <div class="card-body">
                                        <strong>Wie co robi</strong>
                                        <div class="text-white-10 small">poziom mid</div>
                                    </div>
                                </div>


                                <div class="card bg-primary text-white shadow">
                                    <div class="card-body">
                                        <strong>Doświadczony</strong>
                                        <div class="text-white-10 small">poziom mid+</div>
                                    </div>
                                </div>


                                <div class="card bg-danger text-white shadow">
                                    <div class="card-body">
                                        <strong>Wyjadacz</strong>
                                        <div class="text-white-10 small">poziom senior</div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-10">


                                <c:forEach items="${task}" var="title">


                                    <sec:authorize access="hasRole('ADMIN')">
                                        <a href="<c:url value="/editTask/${title.id}"/>">
                                    </sec:authorize>

                                    <div class="card mb-4 py-3 <c:choose>
                                 <c:when test="${title.checkbox eq '0'}">border-left-success</c:when>
                                   <c:when test="${title.checkbox eq '1'}">border-left-info</c:when>
                                     <c:when test="${title.checkbox eq '2'}"> border-left-secondary</c:when>
                                    <c:when test="${title.checkbox eq '3'}">border-left-primary</c:when>
                                    <c:when test="${title.checkbox eq '4'}">border-left-danger</c:when>
                                </c:choose>">
                                        <div class="card-body">
                                            <div class="text-xs font-weight-bold
                                           text-primary text-uppercase mb-1">${title.person.firstName} ${title.person.lastName}
                                                <strong>Dodano:</strong> ${title.dateAdd}|
                                                <strong>Deadline:</strong>${title.deadline}
                                            </div>
                                                ${title.contentTask}
                                        </div>
                                    </div>
                                    </a>
                                </c:forEach>

                            </div>
                        </div>
                    </div>
                    <!-- /.container-fluid -->
                </div>
            </form>

        </div>
        <!-- End of Main Content -->

        <%@include file="../dynamic/boad.jspf" %>


        <%@include file="../dynamic/javaScript.jspf" %>
</body>

</html>
