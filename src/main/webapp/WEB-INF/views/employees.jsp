<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees List</title>
</head>
<body>
    <h2>List of Employees</h2>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Department</th>
        </tr>
        ${employees.get(0).name}
    </table>
</body>
</html>
