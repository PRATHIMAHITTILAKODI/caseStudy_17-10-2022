<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1 style="color:red">
<u><i>Enlist Offers</i></u>
</h1>
<form:form action="offerList" method="post" modelAttribute="offerRecord">
<h2>
Offer Id:<form:input type="hidden" path="id" />
<br/><br/>
 Days:<form:input type="text" path="days"/>
<br/><br/>
 Talk Time:<form:input type="text" path="talkTime"/>
<br/><br/>
Data:<form:input type="text" path="data"/>
<br/><br/>
Price:<form:input type="text" path="price"/>
<br/><br/>
<button type="submit" style="color:green">Submit</button>
</h2>
</form:form>
</div>
</body>
</html>