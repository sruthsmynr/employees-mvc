<html>
<head>
<title>Employee mvc application</title>
</head>
<body>
<font color="red">${errorMessage}</font>
<font color="red">${successMessage}</font>
<form method="post" action="/login">
Name: <input type="email" name="email"/>
Password: <input type="password" name="password"/>
<input type="submit">
</form>
<form method="get" action="register">
<input type="submit" value="Register">
</form>
</body>
</html>