

function Actions(){
	this.entreprise=[];
	this.entrepriseID=[];
}
Actions.prototype.add=function(ste){
	if(this.entrepriseID[ste.id]==undefined){
		this.entreprise.push(ste);
		this.entrepriseID[ste.id]=ste;
		return true;
	}
	else
		{
		alert("teb");
		return false;
		
		}
}
Actions.prototype.get =function(index){
	return this.entreprise[index];
}
Actions.prototype.getByID =function(id){
	return this.entrepriseID[id];
}
Actions.prototype.size=function(){
	return this.entreprise.length;
}

var pse=new Actions();