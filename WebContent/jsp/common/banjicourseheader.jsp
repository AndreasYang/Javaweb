<%@ page language="java"
    pageEncoding="utf-8"%>
<!--导航-->
<nav class="navbar navbar-default">
    <div class="container">
        
        <div class="navbar-header">
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="index.html" class="navbar-brand">教务管理系统</a>
        </div>
       
        <!--导航-->
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/student?method=PageList"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;学生管理</a></li>
                <li><a href="${pageContext.request.contextPath}/student?method=BanjiList"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;班级管理</a></li>
                <li><a href="${pageContext.request.contextPath}/student?method=CourseList"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;课程管理</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/student?method=BanjiCoursePageList"><span class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;教务管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="${pageContext.request.contextPath}/student?method=getOnLineList" id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       ${admin.name}
                       
                    </a>
                  
                </li>
                <li><a href="/Java1707web/Logout"><span class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
            </ul>
        </div>
        <!--导航-->

    </div>
</nav>
<!--导航-->