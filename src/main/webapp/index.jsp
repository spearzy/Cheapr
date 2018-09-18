<%@page import="org.json.JSONObject"%>
<%@page import="com.google.gson.annotations.JsonAdapter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.*"%>
<%@page import="scraper.GameTitle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="main.js"></script>
<script src="tablesort.js"></script>
<script src="tablesort.number.js"></script>
<script src="tablesort.dotsep.js"></script>
<title>Pricer</title>
</head>
<body>
	<div class="container center-align" id="container">
		<h2>Cheapr</h2>
		<br />
		<div class="row">
			<div class="col s4 offset-s4">
				<form action="/web-scraper/Search" method="post" class="searchForm">
					<input type="text" name="searchTerm"
						placeholder="Enter a search term" /> 
						<button class="btn btn-large waves waves-effect blue" type="submit" value="Submit">Submit</button>
				</form>
			</div>
		</div>
		<br />
		<div id="result">
			<table id="resultsTable">
				<tbody id="table">
					<%
						String json = "";
						ArrayList<GameTitle> result = (ArrayList<GameTitle>) request.getAttribute("data");
						if (result == null) {
					%>
					<script>
						var container = document.getElementById("container");
						var noResults = document.createElement('p');
						noResults.appendChild(document
								.createTextNode("No results Found"));
						container.appendChild(noResults);
					</script>
					<%
						} else {
							json = new Gson().toJson(result);
					%>
					<thead>
					<tr>
						<th>Title</th>
						<th data-sort-default>Price</th>
						<th data-sort-method='none'>Console</th>
						<th data-sort-method='none'>URL</th>
						<th data-sort-method='none'>Image</th>
					</tr>
					</thead>
					<script>
						generateTable(<%=json%>);
						  new Tablesort(document.getElementById('resultsTable'));
					</script>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>