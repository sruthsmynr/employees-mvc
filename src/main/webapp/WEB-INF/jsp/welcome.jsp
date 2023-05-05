<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Employee mvc application</title>
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js
"></script>
<script src="https://cdn.datatables.net/1.13.4/js/dataTables.bootstrap4.min.js
"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css"/>

<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap4.min.css
" />

</head>
<body>
<c:if test="${role=='EMP'}">
<p>Welcome  ${employee.firstName} to our website</p>
<p>Email is ${employee.email}</p>
<p>Date Of Birth is ${employee.dob}</p>
<p>Designation is ${employee.designation}</p>
</c:if>
<c:if test="${role=='ADMIN' }">
<h2>Employee Dashboard</h2>
<table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th>Employee Name</th>
                <th>Email_Id</th>
                <th>ID</th>
                <th>Desg</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${employees}" var="element"> 
  <tr>
    <td>${element.firstName}</td>
    <td>${element.email}</td>
    <td>${element.id}</td>
    <td>${element.designation}</td>
    <td>
        <button class="btn btn-primary">Read One</button>
    <button class="btn btn-secondary">Edit</button>
        <button class="btn btn-danger">Delete</button>
    
    </td>
  </tr>
</c:forEach>
            
             
                
               
            
            </tbody>
            </table>
</c:if>

<script>
$(document).ready(function () {
    $('#example').DataTable();
});
</script>
</body>
</html>