var counter=1;
var cp=1;
function addStockRow(p,tab_id) {
	
	var table = document.getElementById(tab_id);
	var row = table.insertRow(counter);
	
	row.insertCell().innerHTML = p.id;
	row.insertCell().innerHTML = p.nom;
	row.insertCell().innerHTML = p.ville;
	params= ",'" +p.id + "','" + p.nom + "','" + p.ville + "'";
	row.insertCell().innerHTML = '<button onclick="DeleteEntreprise('+ counter + params +')">delete </button>';
	counter++;
}
function addStockRow2(p,tab_id) {
	
	var table = document.getElementById(tab_id);
	var row = table.insertRow(cp);
	
	row.insertCell().innerHTML = p.id;
	row.insertCell().innerHTML = p.nom;
	row.insertCell().innerHTML = p.ville;
	cp++;
	
}
function reload_tab(tab_id,tableau) {
	counter=1;
	var table = document.getElementById(tab_id);
	var row;
	tableau.forEach(function(p) {
		row = table.insertRow(counter);
		row.insertCell().innerHTML = p.id;
		row.insertCell().innerHTML = p.nom;
		row.insertCell().innerHTML = p.ville;
		params= ",'" +p.id + "','" + p.nom + "','" + p.ville + "'";
		row.insertCell().innerHTML = '<button onclick="DeleteEntreprise('+ counter + params +')">delete </button>';
		counter++;
		
	});
	
}
function deleteallrows_byid(tab_id) {
	 cp=1;
	 var table=document.getElementById(tab_id);

	 undefined
	 var row;
	 var count = table.rows.length - 1;

	 undefined
	 if(count !=0){
	 for(var i=count;i>0;i--){row=table.deleteRow(i)}
	 }		 
	 
}
function deleteRowbyID(key) {
	
}
function deleteRow(index){
    document.getElementById("table-stock").deleteRow(index);
    counter--;

}
function searchbyId() {
	stock.searchbyID(value("byId"));
}
function searchbyName() {
stock.SearchName(value("byName"));
}

function value(id) {
	return document.getElementById(id).value;
}

function setValue(id, value) {
	 document.getElementById(id).value = value;
}

function setContent(id, content) {
	document.getElementById(id).innerHTML = content;
}

function content(id) {
	return document.getElementById(id).innerHTML;
}

function addContent(id, content) {
	document.getElementById(id).innerHTML += content;
}

function addTextBox() {
	counter++;
	var textbox = '<div class="TextBox">' 
	+ '<input type="text" id="ventes-ref-' + counter + '"' 
	+ 'onkeyup="chercherProduit(' + counter + ')"'
	+ 'placeholder="Référence Produit" />'
	+ '<div id="ventes-desig-' + counter + '"></div>'
	+ '<div id="ventes-pu-' + counter + '"></div>'
	+ '<input type="text" id="ventes-q-' + counter + '"'
	+ 'placeholder="Quantité" />'
	+ '</div>'
	
	addContent("ventes-produits", textbox);
}




