<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ page contentType="text/html; charset=UTF-8" %>


<%@include file="../dynamic/css.jspf" %>


<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Utwórz konto!</h1>
                        </div>
                        <form name="send" method="post" action='<c:url value="/addUser"/>'>
                            <div class="form-group row">

                                <input type="text" class="form-control form-control-user" id="exampleFirstName"
                                       name="username" placeholder="user">
                                <input type="text" class="form-control form-control-user" id="exampleFirstName"
                                       name="password" placeholder="password">

                                <%--                  <div class="col-sm-6 mb-3 mb-sm-0">--%>
                                <%--                    <input type="text" class="form-control form-control-user" id="exampleFirstName" name="name" placeholder="Imię">--%>
                                <%--                  </div>--%>
                                <%--                  <div class="col-sm-6">--%>
                                <%--                    <input type="text" class="form-control form-control-user" id="exampleLastName" name="surname" placeholder="Nazwisko">--%>
                                <%--                  </div>--%>
                            </div>
                            <%--                <div class="form-group">--%>
                            <%--                  <input type="email" class="form-control form-control-user" id="exampleInputEmail" name="email" placeholder="adres Email">--%>
                            <%--                </div>--%>
                            <%--                <div class="form-group row">--%>
                            <%--                  <div class="col-sm-6 mb-3 mb-sm-0">--%>
                            <%--                    <input type="password" class="form-control form-control-user" id="exampleInputPassword" name="password" placeholder="Hasło">--%>
                            <%--                  </div>--%>
                            <%--                  <div class="col-sm-6">--%>
                            <%--                    <input type="password" class="form-control form-control-user" id="exampleRepeatPassword" placeholder="Powtórz ">--%>
                            <%--                  </div>--%>
                            <%--                </div>--%>
                            <input class="btn btn-primary btn-user btn-block" type="submit" value="Rejestruj">


                            <hr>

                        </form>
                        <div class="text-center">
                            <a class="small" href="login.jsp">Masz już konto? Zaloguj się!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

</body>

</html>
