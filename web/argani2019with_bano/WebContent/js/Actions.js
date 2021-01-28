function Menu(current) {
	this.current = document.getElementById(current);
}

Menu.prototype.show = function(id) {
	this.current.style.display = "none";
	this.current = document.getElementById(id);
	this.current.style.display = "block";
}

/*************************************************************/

function ajouterSte(p) {
	if( p == undefined) {
		p = new Ste(value("id"), value("nom"), value("ville"));		
	}
	if(stock.add(p)){
		addStockRow(p);
	}
	
}

function chercherSte(index) {   ////mrriiiiida
	var ref = value("ventes-ref-" + index);
	var p = stock.RechercheMulti(ref);
	if(p != undefined){
		setContent("ventes-desig-" + index, p.id);
		setContent("ventes-pu-" + index, p.nom);
		setContent("ventes-q-" + index, p.ville);
		
	}
	Search(p);
}