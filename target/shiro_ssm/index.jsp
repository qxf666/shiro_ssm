<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Hello World!</h2>

<hr>

  已登录 欢迎您,
    <shiro:user>
        <shiro:principal/>
        <div style="float:right;">
        <a href="${pageContext.request.contextPath}/user/logout">登出</a>
        </div>
    </shiro:user>
    <shiro:guest>
        <a href="${pageContext.request.contextPath}/user/login">游客请登录</a>
    </shiro:guest>
    <shiro:guest>
        游客~~
    </shiro:guest>
    <hr>
    <shiro:hasRole name="bangzhang">
        <a href="#">班长操作</a>
    </shiro:hasRole>
    <shiro:lacksRole name="bangzhang">
        <a href="#">同学操作</a>
    </shiro:lacksRole>

    <shiro:hasAnyRoles name="bangzhang,student">
        <a href="#">进班学习</a>
    </shiro:hasAnyRoles>

    <hr>
    <shiro:hasPermission name="student:yq">
        <a href="#">收罚款</a>
    </shiro:hasPermission>
    <shiro:lacksPermission name="student:yq">
        <a href="#">进班学习</a>
    </shiro:lacksPermission>
    <shiro:hasPermission name="bangzhang:shouqian">班长收钱看看就看见看见就看见看见看见看见了 了解了解</shiro:hasPermission>
<shiro:hasRole name="bangzhang">
    <table>
        <tr>
            <th>古诗词名称</th>
            <th>古诗词作者</th>
            <th>古诗词朝代</th>
            <th>古诗词内容</th>
        </tr>
        <!-- JSTL标签，请参考本书的相关内容 -->
        <c:forEach items="${poems}" var="poem">
        <tr>
            <td>${poem.name}</td>
            <td>
               ${poem.author}
            </td>
            <td>
              ${poem.dyname}
            </td>
            <td>${poem.context }</td>
        </tr>
        </c:forEach>
    </table>
</shiro:hasRole>
<hr>
</body>
</html>
