var counter=0;

function addStockRow(p) {
	var table=document.getElementById('stock-table');
	var row = table.insertRow();
	row.insertCell().innerHTML=p.ref;
	row.insertCell().innerHTML=p.desig;
	row.insertCell().innerHTML=p.pu;

	row.insertCell().innerHTML=p.qs;

}
function addcontent(id,content) 
{	document.getElementById(id).innerHTML+=content;

	}
function addTextBox() {
	counter++;
	var textbox='<div class="Textbox" >'
	+' <div id="Vente-desig-' + counter + '"></div>'
	+' <div id="Vente-pu-' + counter + '"></div>'
	+' 		<input type="text" size="10" id="Vente-ref-' + counter + '" onkeyup="chercherProduit(' + counter + ')" placeholder="ref du  produits"/>'
	+' 		<input type="text" size="10" id="Vente-q-' + counter + '"  placeholder="Quantité"/>'
	+'</div>'
	addcontent("Vente-produits", textbox);
}
function setContent(id,content) {
	document.getElementById(id).innerHTML=content;
}
function content(id) {
	return document.getElementById(id).innerHTML;
}
function value(id){
	return document.getElementById(id).value;	

}
function setValue(id,value){
	 document.getElementById(id).value=value;	

}