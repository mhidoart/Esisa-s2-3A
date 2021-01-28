function Stock() {
	this.produits = [];
	this.produitsParRef = [];//tableau associative
}

Stock.prototype.add = function(p) {
	if(this.produitsParRef[p.ref] == undefined){
		this.produits.push(p);
		this.produitsParRef[p.ref] = p;
		return true;
	}
	else{
		alert("Produit déja exist");
		return false;
	}
}

Stock.prototype.get = function(index) {
	return this.produits[index];
}

Stock.prototype.getByRef = function(ref) {
	return this.produitsParRef[ref];
}

Stock.prototype.size = function() {
	return this.produits.length;
}

var stock = new Stock();