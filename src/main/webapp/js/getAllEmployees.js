window.onload = function() {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			populateTable(JSON.parse(xhr.responseText));
		}
	};
	xhr.open("POST", "http://localhost:8080/Project_1/getAllEmployees.msp1", true);
	xhr.send();
}

function populateTable(response) {
	if (typeof response != 'undefined') {
		let tbody = document.getElementById("allEmployees");
		for (var i=0; i<response.length; i++) {
			const row = tbody.insertRow(-1);
		      /*row.innerHTML = `
		      <td>${response[i].firstName}</td>
		      <td>${response[i].lastName}</td>
		      <td>${response[i].username}</td>
		      <td>${response[i].email}</td>
		      <td><a href="http://localhost:8080/Project_1/test.msp1">View Requests</a></td>
		      `;*/
			row.innerHTML = `
			      <td>${response[i].firstName}</td>
			      <td>${response[i].lastName}</td>
			      <td>${response[i].username}</td>
			      <td>${response[i].email}</td>
			      <td><a href="#" onclick="viewRequestsLink()">View Requests</a></td>
			      `;
		}
	}
}

function viewRequestsLink() {
	
}
