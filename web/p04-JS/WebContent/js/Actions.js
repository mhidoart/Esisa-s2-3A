/**
 * 
 */
function Menu(currentID) {
	this.current=document.getElementById(currentID)
}

Menu.prototype.show=function (id) {
	this.current.style.display="none";
	this.current=document.getElementById(id)
	this.current.style["display"]="block";
}
var menu;
function value(id){
	return document.getElementById(id).value;	

}
function setValue(id,value){
	document.getElementById(id).value=value;	

}
function ajouterProduit(p) {
	if(p==undefined){
		var ref=value("ref");	
		var desig=value("desig");
		var pu=value("pu");
		var qs=value("qs");
		p=new Produit(ref,desig,pu,qs);
		if(stock.add(p)){
			addStockRow(p);
		}
	}
	else
	{
		stock.add(p)
		addStockRow(p);
	}


}
function setContent(id,content) {
	document.getElementById(id).innerHTML=content;
}
function content(id) {
	return document.getElementById(id).innerHTML;
}
function chercherProduit(index) {
	var ref=value("Vente-ref-"+index);
	var p =stock.getByRef(ref);
	if(p!= undefined){
		setContent("Vente-desig-"+ index,p.desig);
		setContent("Vente-pu-"+ index,p.pu);
		setContent("Vente-q-" + index,p.qs);
	}

}