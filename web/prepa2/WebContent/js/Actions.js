function Menu(current) {
	this.current = document.getElementById(current);
}

Menu.prototype.show = function(id) {
	this.current.style.display = "none";
	this.current = document.getElementById(id);
	this.current.style.display = "block";
}

/*************************************************************/

function ajouterProduit(p) {
	if( p == undefined) {
		p = new Ste(value("id_ste"), value("nom"), value("ville"));		
	}
	if(stock.add(p)){
		addStockRow(p);
	}
	
}
Menu.prototype.suppr =function(id,btn){
	alert("suppr");
	var row = btn.parentNode.parentNode;
	  row.parentNode.removeChild(row);
	  stock.deletebyid(id);
}
function chercherProduit(index) {
	var ref = value("ventes-ref-" + index);
	var p = stock.getByRef(ref);
	if(p != undefined){
		setContent("ventes-desig-" + index, p.nom);
		setContent("ventes-pu-" + index, p.ville);
	}
}