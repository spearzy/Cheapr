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
<title>Pricer</title>
</head>
<body>
	<div class="container center-align">
		<h2>Cheapr</h2>
		<br />
		<div class="row">
			<div class="col s4 offset-s4">
				<form action="/web-scraper/Search" method="post" class="searchForm">
					<input type="text" name="searchTerm"
						placeholder="Enter a search term" /> <input type="submit"
						value="Submit" />
				</form>
			</div>
		</div>
		<br />
		<div id="result">
			<table>
				<tbody id="table">
					<tr>
						<th>Title</th>
						<th>Price</th>
						<th>URL</th>
					</tr>
					<%
						ArrayList<GameTitle> result = (ArrayList<GameTitle>) request.getAttribute("data");
						String json = new Gson().toJson(result);
					%>
					<script>
						var jsonObj =
					<%=json%>
						;
						var body = document.getElementById("table");
						for (i = 0; i < jsonObj.length; i++) {
							var tr = document.createElement("tr");
							for (data in jsonObj[i]) {
								var obj = jsonObj[i];
								var td = document.createElement("td");
								if (obj[data].includes("http")) {
									var a = document.createElement("a");
									a.setAttribute("href", obj[data]);
									a.appendChild(document
											.createTextNode(obj[data]));
									td.appendChild(a);
								} else {
									td.appendChild(document
											.createTextNode(obj[data]));
								}

								tr.appendChild(td);
							}
							body.appendChild(tr);
						}
					</script>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>