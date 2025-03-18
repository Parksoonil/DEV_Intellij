<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MEMBER</title>
</head>
<body>
    <div class="container">
        <table>
            <tbody>
                <tr>
                    <td>${member.id}</td>
                    <td>${member.name}</td>
                    <td>${member.email}</td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>