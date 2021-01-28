function Stock() {
	this.tabSte = [];
	this.tabSteParRef = [];//tableau associative
}

Stock.prototype.add = function(p) {
	if(this.tabSteParRef[p.id] == undefined){
		this.tabSte.push(p);
		this.tabSteParRef[p.id] = p;
		return true;
	}
	else{
		alert("sté déja exist");
		return false;
	}
}

Stock.prototype.get = function(index) {
	return this.tabSte[index];
}
Stock.prototype.deletebyid=function(id){
	this.tabSte.splice(id,1);
}
Stock.prototype.getByRef = function(ref) {
	return this.tabSteParRef[ref];
}

Stock.prototype.size = function() {
	return this.tabSte.length;
}

var stock = new Stock();