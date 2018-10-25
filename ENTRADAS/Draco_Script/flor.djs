Var a;
for (a :=: 0; a < 3; a++) {
	print ("Se Inicio para dibujar la flor ...." + a);
}

print ( "---------------------------- ++++++++++++++++++ -------------------" );


print ("Se empezara a dibujar una  flor");

print ("Dibujara un cuadrado de 100 pixeles");

Quadrate (1, 1,"#03A9f4", 100, 100);


print ("Dibujara 4 lineas al dibujo de color diferentes.... ");

Line  (1, 1, 20, 20, "#E53935", 1);
Line  (100, 100, 80, 80, "#E53935", 1);
Line  (1, 100, 21, 80, "#7B1FA2", 1);
Line  (100, 1, 82, 19, "#7B1FA2", 1);
 

print ("Dibujara un cuadrado como el tallo de una flor...");
Quadrate (71, 39,"#64DD17", 9, 61);


$$ llamada a las funciones de D++ --> DASM
RunDasm ("Dibujar_Flor.dasm");

$$terminara de dibujar la flor
point 	(52, 49, "#D50000", 16*2); $$centro
String 	(14, 95, "#000000", "FLOR");


print ( "---------------------------- ++++++++++++++++++ -------------------" );
for (a :=: 0; a < 3; a++) {
	print ("Se termino de dibujar la flor ...." + a);
}
