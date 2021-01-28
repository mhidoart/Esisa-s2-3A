function Biblio(titre, ...livres) {
	this.titre=titre;
	this.livres=[];
	for (i=0; i<livres.length; i++) {
	    alert(params[i])
	  }

}
Biblio.prototype.AjouterLivre=function(livre){
	this.livre.push(livre);
}
var biblio=new Biblio();