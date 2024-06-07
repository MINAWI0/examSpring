<!DOCTYPE html>
<html>
<head>
    <title>Employee Assignment</title>
</head>
<body>
<h1>Assign Employee to Project</h1>
<form action="/assign" method="post">
    <label for="employee">Employee:</label>
    <select name="employeeId" id="employee">
        <c:forEach var="employee" items="${employees}">
            <option value="${employee.id}">${employee.name}</option>
        </c:forEach>
    </select>
    <br/>
    <label for="project">Project:</label>
    <select name="projectId" id="project">
        <c:forEach var="project" items="${projects}">
            <option value="${project.id}">${project.name}</option>
        </c:forEach>
    </select>
    <br/>
    <input type="submit" value="Assign">
</form>
</body>
</html>
