<%@ page import="logic.Model"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Title</title>
</head>
<body>
<h1>Домашнаяя страница по работе с пользователями</h1>
Введите Id пользователя (0- для вывода всего списка пользователей)
<br/>
Доступно: <%
Model model =  Model.getInstance();
out.print(model.getFromList().size());
%>
<form method="get" action="get">
<label>ID:
<input type="text" name="id"><br/>
</label>
<button type="submit">Поиск</button>
</form>

<a href="addUser.html">Создать нового пользователя</a><br/>
<a href="delUser.html">Удалить пользователя по Id</a><br/>
<a href="putUser.html">Изменить пользователя по Id</a>
</body>
</html>