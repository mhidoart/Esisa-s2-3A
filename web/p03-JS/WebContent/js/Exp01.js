/**
  scripte externe  
 */
var counter=0;
counter++;
function afficher(msg) {
	alert(msg + " : counter : " + counter);
	counter++;

}
var f1=afficher;
afficher("script Extreame");