<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
</head>
<body>
<form:form action="/saveData" method="post" modelAttribute="emp">
<p><form:label path="firstname">Firstname:</form:label> <form:input name="firstname" path="firstname"/></p>
<p><form:label path="middlename">Middlename:</form:label> <form:input name="middlename"  path="middlename" /></p>
<p><form:label path="lastname">Lastname:</form:label> <form:input  name="lastname"  path="lastname" /></p>
<p><form:label path="dob">Date Of Birth[yyyy-mm-dd]:</form:label> <form:input type="text" name="dob" path="dob" /></p>
<p><form:label path="designation">Designation:</form:label> <form:input name="designation"  path="designation"/></p>
<p><form:label path="phone">Phone:</form:label> <form:input name="phone"  path="phone"  /></p>
<p><form:label  path="email">Email:</form:label> <form:input name="email"   path="email"  /></p>
<p><form:label  path="password">Password:</form:label> <form:input name="password" path="password"  /></p>
<p><form:button>Register</form:button></p>
</form:form>
</body>
</html>  