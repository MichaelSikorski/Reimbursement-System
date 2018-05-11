/**
 * Author: Michael Sikorski 
 * Date: 4/23/18
 * 
 * Javascript functions for logging in to Project 1 RRS (Reimbursement Request
 * System)
 */

function loginEmployee() {
	let email = document.getElementById("email").value;
	let password = document.getElementById("password").value;
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			resolveLogin(JSON.parse(xhr.responseText));
		}
	};
	xhr.open("POST", "http://ec2-52-90-175-141.compute-1.amazonaws.com/Reimbursement-System/loginEmployee.msp1", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	if (email != "" && password != "") {
		xhr.send("email="+email+"&password="+password);
	} else {
		document.getElementById("message").innerHTML = "Invalid username or password";
	}	
}

function loginManager() {
	let email = document.getElementById("email").value;
	let password = document.getElementById("password").value;
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			resolveLogin(JSON.parse(xhr.responseText));
		}
	};
	xhr.open("POST", "http://localhost:8090/Reimbursement-System/loginManager.msp1", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	if (email != "" && password != "") {
		xhr.send("email=" + email + "&password=" + password);
	} else {
		document.getElementById("message").innerHTML = "Invalid username or password";
	}
}

function setCookie(cname, cvalue, cminutes) {
	console.log("in set cookie");
    var d = new Date();
    d.setTime(d.getTime() + (cminutes*60000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function deleteCookie(cname) {
	console.log("deleting cookie" + cname);
	document.cookie = cname +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

function resolveLogin(ajaxObject) {
	let email = ajaxObject.email;
	let type = ajaxObject.type;
	if (email == "") {
		if (type == "unregistered") {
			alert("unregistered");
		}
		else {
			document.getElementById("message").innerHTML = "Email or password is incorrect";
		}
	} else {
		setCookie("email", email, 15);
		setCookie("type", type, 15);
		if (type == "employee") {
			//setCookie("email", email, 15);
			//setCookie("type", type, 15);
			document.getElementById("pipContent").src = "http://localhost:8090/Reimbursement-System/html/employeeHome.html";
		} else {
			//document.cookie = "email="+email+";path=/";
			//document.cookie = "type=manager;path=/";
			document.getElementById("pipContent").src = "http://localhost:8090/Reimbursement-System/html/managerHome.html";
		}
		document.getElementById("form").style = "display:none";
		var link = document.getElementsByClassName("nav-link")[0];
		link.innerHTML = "Logout";
		link.href="#";
		link.onclick = function() {
			logout();
		};
	}
}

function logout() {
	let email = getCookie("email");
	let type = getCookie("type");
	if (email != '') {
		deleteCookie('email');
	} 
	if (type != '') {
		deleteCookie('type');
	}
	if (type == 'employee') {
		document.location.href = "http://localhost:8090/Reimbursement-System/html/EmployeeLogin.html";
	} else {
		document.location.href = "http://localhost:8090/Reimbursement-System/html/ManagerLogin.html";
	}
}

function resolveEmployeeLogin(ajaxObject) {
	/*if (ajaxObject == "unregistered") {
		document.getElementById("message").innerHTML = "unregistered";
	} else if (ajaxObject == "Good email, bad password") {
		document.getElementById("message").innerHTML = "Your password was incorrect";
	} else {
		alert("Login employee");
		document.cookie = "email="+ajaxObject+";path=/";
		window.location.href = "http://localhost:8090/Reimbursement-System/html/employeeHome.html";
	}*/
	let email = ajaxObject.email;
	let type = ajaxObject.type;
	console.log(email);
	console.log(type);
	if (email == "") {
		if (type == "unregistered") {
			alert("unregisterd");
		}
		else {
			document.getElementById("message").innerHTML = "Email or password is incorrect";
		}
	} else {
		alert("Login employee");
		document.cookie = "email="+email+";path=/";
		document.cookie = "type="+type+";path=/";
		document.getElementById("pipContent").src = "http://localhost:8090/Reimbursement-System/html/employeeHome.html";
	}
}

function resolveManagerLogin(ajaxObject) {
	if (ajaxObject == "unregistered") {
		document.getElementById("message").innerHTML = "unregistered";
	} else if (ajaxObject == "Good email, bad password") {
		document.getElementById("message").innerHTML = "Your password was incorrect";
	} else {
		document.cookie = "email="+ajaxObject+";path=/";
		window.location.href = "http://localhost:8090/Reimbursement-System/html/managerHome.html";
	}
}
