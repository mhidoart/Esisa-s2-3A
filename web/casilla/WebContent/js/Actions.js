function Menu(current) {
	this.current = document.getElementById(current);
}

Menu.prototype.show = function(id) {
	this.current.style.display = "none";
	this.current = document.getElementById(id);
	this.current.style.display = "block";
}

/*************************************************************/

function AddEntreprise(p) {
	if( p == undefined) {
		p = new Entreprise(value("id_ets"), value("nom_ets"), value("ville_ets"));	
		
	}
	if(stock.add(p)){
		addStockRow(p,'table-stock');
		setValue("id_ets","");
		setValue("nom_ets","");
		setValue("ville_ets","");
	}
	
}
function DeleteEntreprise(row,id,nom,ville) {
	stock.del(row,id,nom,ville);
}
function searchbyId(){
	key = value("byId");
	stock.searchbyID(key);
}
function chercherProduit(index) {
	var ref = value("ventes-ref-" + index);
	var p = stock.getByRef(ref);
	if(p != undefined){
		setContent("ventes-desig-" + index, p.desig);
		setContent("ventes-pu-" + index, p.pu);
	}
}