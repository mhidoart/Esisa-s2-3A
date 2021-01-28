function print(data) {
	var screen = document.getElementById("screen");
	screen.innerHTML = screen.innerHTML + data + "<br />";
	
}

function clear() {
	var screen = document.getElementById("screen");
	screen.innerHTML = "";
	
}
function separator() {
	var screen = document.getElementById("screen");
	screen.innerHTML =  screen.innerHTML + "<hr width=100% />";
	
}