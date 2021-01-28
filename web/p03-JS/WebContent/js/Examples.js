function exp01() {
	print("Ceci est un test");
}
function exp02() {
	clear();
}
function exp03() {
	var x1 = 20;
	var x2=new Number(20);
	var x3 = new Number(20);
	print(x1 + "de type : " +typeof x1);
	print(x2 + "de type : " +typeof x2);
	print("(x1==x2)= " + (x1==x2));
	print("(x1==x3)= " + (x1==x3));
	print("(x2==x3)= " + (x2==x3));
	separator();
	print("(x1===x2)= " + (x1===x2));
	print("(x1===20)= " + (x1===20));
}
function exp04() {
	var s1="une chaine de caractere bien determiner";
	var s2=new String("une chaine de caractere bien determiner");
	print(s1 + " de type : "+ typeof s1);
	print(s2 + " de type : "+ typeof s2);
	print("s1==s2 = " + (s1 === s2) );
}
function exp05() {
	function somme(x,y) {
		return x+y;
	}
	print( "Somme  de type : "+ typeof somme);
	print("somme.name: "+somme.name);
	print("somme.length : "+somme.length);
	var f=somme;
	print( "f  de type : "+ typeof f);
	print("f.name: "+f.name);
	print("f.length : "+f.length);
	
	var s=f(20,30);
	print("s= " + s + " type of s : " + typeof s);
	s=f("java" ,"script");
	print("s= " + s + "  type of s : " + typeof s);
}
function exp06() {
	function somme(x,y) {
		return x+y;
	}
	var f = function(x,y) {//function anonyme
		return x+y;
	};
	var mul = function(x,y) {//function anonyme
		return x*y;
	};
	print( "f  de type : "+ typeof f);
	print( "mul  de type : "+ typeof mul);
	function traitement(x,y,op){
		return 2* op(x,y);
	}
	var t1=traitement(20,30,somme);
	var t2=traitement(20,30,mul);
	var t3= traitement(20,30,function(x,y){return x-y;});
	print("t1= " + t1);
	print("t2= " + t2);
	print("t3= " + t3);
}
function exp07(){
	var x;
	print("x= " + x);
//	print("x= " + y);// >>> erreur y not defined
	print( " x== undefined :  " +(x==undefined))
	x=30
	print( " x== undefined :  " +(x==undefined))
	
}
function exp08(){
	function somme(x,y){
		if(x==undefined) x=0
		if(y==undefined) y=0

		return x+y;
	}
	var s1=somme(20,30);
	print("s1 = "+ s1);
	var s2=somme(20);
	print("s2 = "+ s2);
	var s3=somme(20,30,50,60,70);
	print("s3 = "+ s3);
}
function exp09() {
	function somme() {
	print("Nombre d'arguments : " +	arguments.lenght);
	var s=0;
	for (var i = 0; i < arguments.length; i++) {
		s=s+arguments[i]
	}
	return s;
	}
	var s1=somme(20,30);
	print("s1 = "+ s1);
	var s2=somme(20);
	print("s2 = "+ s2);
	var s3=somme(20,30,10,60,70);
	print("s3 = "+ s3);
	var s4=somme("this",30,10,60,70);
	print("s4 = "+ s4);
}
function exp10() {
	var t1=[];
	t1=[20,56,12];
	var t2=new Array(23,14,65);
	print("t1={ "+ t1 + " } : type : " + typeof t1);
	print("t2={ "+ t2 + " } : type : " + typeof t2);
	t1[5]=17;
	print("t1.length : "+t1.length + " => { " + t1 + " }");
	separator();
	for (var i = 0; i < t1.length; i++) {
		print("t1[" + i + "]= " +t1[i])
	}
	separator();
	for(var index in t1){
		print("t1[" + index + "]= " +t1[index])
	}
}
function exp11() {
	var t1=[];
	var t2=new Array();
	t1.push("A");
	t1.push(20);
	t1.push("java script");
	t1.push([1,2,3]);
	t1.push(function() {
		print("ayeh a sidi  function fost tableau")
	});
	t1.push(new Number(30));
	print(t1);
	for (var i = 0; i < t1.length; i++) {
		print("t1[" + i + "]= " +t1[i] + "  typeof : " + typeof t1)
	}
	t1[4]();
	
	var x=t1.pop();
	print("elem supprimé est : " +x);
	for (var i = 0; i < t1.length; i++) {
		print("t1[" + i + "]= " +t1[i] + "  typeof : " + typeof t1)
	}
}
//POO
function exp12() {
	var p1=new Object();
	p1.x=20;
	p1.y=30;
	
	p1.toString = function() {
		return "Point(" +this.x + ", " +this.y +")";
	}
	
	print(p1)
	var p2 = Object.create(p1) // p1 est le prototype de p2
								//prtotypage
	p2.x=100;
	print("p1 = " +p1)
	print("p2 = " +p2)// Heritage prototypal
}
function exp13() {
	var p1={//JSON      java sscript  object notation  //p1 est appeler un prototype
			//proprietes:
			x : 20,
			y : 30,
			// Méthodes:
			toString : function() {
				return "Point(" +this.x + ", " +this.y +")";
 
			}
	};
	print(p1)
	var p2=Object.create(p1)//Object.create(prototype)
	separator()
	print(p2)
}
function exp14() {
	function Point(x,y,name) {
		if (name == undefined) this.name="Point"
		//proprietes
		this.name=name;
		this.x=x;
		this.y=y;
		//Methodes : Mauvaise solution
		this.toString = function() {
			return this.name +"(" +this.x +", "+this.y + ") ";
		}
		this.print=function(){
			print("Point : "+this);
		}
	}
	var p1=new Point(20,30);
	var p2=new Point(10,15,"p2");
	p1.print()
	p2.print()
	
}
function exp15(){
	var p0={
			name: "p0",
			x: 20,
			y:30,
			toString : function(){
				return this.name +"("+this.x+", "+this.y+")"
			}
	}
	Object.prototype.toString=function(){
		return "(object)"
	}
	Object.prototype.id="110"
	p1=Object.create(p0);
	p1.name="p1";
	print(p0)
	print(p1)
	var proto=Object.getPrototypeOf(Object.getPrototypeOf(p0))  //heritage prototypal arboressente(proto==Object.prototype)
	print("Le prototype de p1 :  "+Object.getPrototypeOf(p1))
	print("Le prototype de p0 :  "+Object.getPrototypeOf(p0))
	print("(proto==Object.prototype) : "+ (proto==Object.prototype))
	print("Le prototype de object :  "+Object.getPrototypeOf(Object.getPrototypeOf(p0)))
	print("Le prototype de p0 :  "+Object.Prototype)
	
}
function exp16() {
	function Point(x,y,name) {
		if (name != undefined) this.name=name
		//proprietes
	
		this.x=x;
		this.y=y;
		Point.cp++;
		
	}
	//Methodes :
	Point.prototype.toString = function() {
		return this.name +"(" +this.x +", "+this.y + ") ";
	}
	Point.prototype.print=function(){
		print("Point : "+this);
	}
	Point.prototype.name="Un Point" //sera herite par tous les points
		
	Point.cp=0;//conpteur d'instance
	var p1=new Point(20,30);
	var p2=new Point(10,15,"p2");
	p1.print()
	p2.print()
	print(Point.cp+"")
	
}