var counter=0;

function addSteRow(ste) {
	alert("rani hna f add row");
	var table=document.getElementById('ste_table');
	var row = table.insertRow();
	row.insertCell().innerHTML=ste.id;
	row.insertCell().innerHTML=ste.nom;
	row.insertCell().innerHTML=ste.ville;


}