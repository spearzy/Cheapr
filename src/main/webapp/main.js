//function sortTable() {
//	  var table, rows, switching, i, x, y, shouldSwitch, tmp1, tmp2;
//	  table = document.getElementById("resultsTable");
//	  switching = true;
//	  while (switching) {
//	    switching = false;
//	    rows = table.rows;
//	    for (i = 1; i < (rows.length - 1); i++) {
//	      shouldSwitch = false;
//	      tmp1 = rows[i].getElementsByTagName("TD")[1];
//	      tmp2 = rows[i + 1].getElementsByTagName("TD")[1];
//	      x = tmp1.innerHTML.substring(1);
//	      y = tmp2.innerHTML.substring(1);
//	      if (x > y) {
//	        shouldSwitch = true;
//	        break;
//	      }
//	    }
//	    if (shouldSwitch) {
//	      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
//	      switching = true;
//	    }
//	  }
//	}

function generateTable(json) {
	var jsonObj =json;
	var body = document.getElementById("table");
	for (i = 0; i < jsonObj.length; i++) {
		var tr = document.createElement("tr");
		for (data in jsonObj[i]) {
			var obj = jsonObj[i];
			var td = document.createElement("td");
			if(obj[data].includes(".png") || obj[data].includes("Groceries")) {
				var img = document.createElement("img");
				img.setAttribute("src", obj[data]);
				img.appendChild(document
						.createTextNode(obj[data]));
				td.appendChild(img);
			}
			else if (obj[data].includes("http")) {
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
}