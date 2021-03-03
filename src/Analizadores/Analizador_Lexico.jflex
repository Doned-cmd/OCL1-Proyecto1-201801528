/*--------------------------------------------------
 ------------  1ra Area: Codigo de Usuario ---------
 ---------------------------------------------------*/

//------> Paquetes,importaciones
package Analizadores;
import java_cup.runtime.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;


/*----------------------------------------------------------
  ------------  2da Area: Opciones y Declaraciones ---------
  ----------------------------------------------------------*/
%%
%{
    //----> Codigo de usuario en sintaxis java


%}

//-------> Directivas
%public 
%class Analizador_Lexico
%cupsym Simbolos
%cup
%char
%column
%full
%ignorecase
%line
%unicode

//------> Expresiones Regulares
digito              = [0-9]
Caracter            = [a-zA-ZñÑ]
cualquiercaracter = .
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]        
valor = ([0-9]|[a-zA-ZñÑ])*


Tk_CONJ = CONJ

Tk_Flecha = ->

comentariosimple    = "//" {cualquiercaracter}* 

comentarioencerrado = "<!" ({valor}|\n|\s|","|".")* "!>"

CadenaEnComillas = \" (.*?) \"

Tk_Inicio_Conjuntos = "////// CONJUNTOS"

TK_Inicio_ER = "/////// EXPRESIONES REGULARES"

Tk_Inicio_Ejercicios = %%

Tk_caracter_esp = \\\'|\\(n)|\\\"

Tk_id = {Caracter}({Caracter}|"_"|{digito})*


//------> Estados

%%

/*------------------------------------------------
  ------------  3ra Area: Reglas Lexicas ---------
  ------------------------------------------------*/

//-----> Simbolos

"+"         { System.out.println("Reconocio "+yytext()+" Tk_cer_positiva"); return new Symbol(Simbolos.Tk_cer_positiva, yycolumn, yyline, yytext()); }
"*"         { System.out.println("Reconocio "+yytext()+" Tk_kleene"); return new Symbol(Simbolos.Tk_kleene, yycolumn, yyline, yytext()); }
"|"         { System.out.println("Reconocio "+yytext()+" Tk_or"); return new Symbol(Simbolos.Tk_or, yycolumn, yyline, yytext()); }
"~"         { System.out.println("Reconocio "+yytext()+" Tk_guion"); return new Symbol(Simbolos.Tk_guion, yycolumn, yyline, yytext()); }
"."         { System.out.println("Reconocio "+yytext()+" Tk_concat"); return new Symbol(Simbolos.Tk_concat, yycolumn, yyline, yytext()); }
","         { System.out.println("Reconocio "+yytext()+" Tk_coma"); return new Symbol(Simbolos.Tk_coma, yycolumn, yyline, yytext()); }
"{"         { System.out.println("Reconocio "+yytext()+" Tk_llavea"); return new Symbol(Simbolos.Tk_llavea, yycolumn, yyline, yytext()); }
"}"         { System.out.println("Reconocio "+yytext()+" Tk_llavec"); return new Symbol(Simbolos.Tk_llavec, yycolumn, yyline, yytext()); }
";"         { System.out.println("Reconocio "+yytext()+" Tk_pcoma"); return new Symbol(Simbolos.Tk_pcoma, yycolumn, yyline, yytext()); }
":"         { System.out.println("Reconocio "+yytext()+" Tk_dosp"); return new Symbol(Simbolos.Tk_dosp, yycolumn, yyline, yytext()); }
"?"         { System.out.println("Reconocio "+yytext()+" Tk_inter"); return new Symbol(Simbolos.Tk_inter, yycolumn, yyline, yytext()); }
 
//-----> Palabras reservadas
     

"CONJ"   { System.out.println("Reconocio "+yytext()+" Tk_CONJ"); return new Symbol(Simbolos.Tk_CONJ, yycolumn, yyline, yytext());}


//--> Simbolos ER

{Tk_Inicio_Ejercicios} {{System.out.println("Reconocio "+yytext()+" Tk_Inicio_Ejercicios"); return new Symbol(Simbolos.Tk_inicio_Ejercicios, yycolumn, yyline, yytext());}}

  

{digito}    {{System.out.println("Reconocio "+yytext()+" Tk_digito"); return new Symbol(Simbolos.Tk_digito, yycolumn, yyline, yytext());}}
{Tk_caracter_esp} {{System.out.println("Reconocio "+yytext()+" Tk_caracter"); return new Symbol(Simbolos.Tk_caracter, yycolumn, yyline, yytext());}}
{Caracter}  {{System.out.println("Reconocio "+yytext()+" Tk_caracter"); return new Symbol(Simbolos.Tk_caracter, yycolumn, yyline, yytext());}}
{Tk_id}  {{System.out.println("Reconocio "+yytext()+" Tk_id"); return new Symbol(Simbolos.Tk_id, yycolumn, yyline, yytext());}}


{Tk_Flecha}      { System.out.println("Reconocio "+yytext()+" Tk_flecha"); return new Symbol(Simbolos.Tk_flecha, yycolumn, yyline, yytext());}
{CadenaEnComillas} { String buffer = "" ;for (int i = 0; i < yytext().length(); i++) {if(!(yytext().charAt(i) == 34)){buffer = buffer + buffer.valueOf(yytext().charAt(i));}}; System.out.println("Reconocio "+buffer+" Tk_valor_comillas");  return new Symbol(Simbolos.Tk_valor_comillas, yycolumn, yyline,buffer);}



//----------> Espacios
{comentarioencerrado} { System.out.println("Reconocio "+yytext()+" Tk_Comentario_Encerrado");}
{comentariosimple}      {System.out.println("Comentario: "+yytext()+" Tk_Comentario_abierto"); }


[ \t\r\n\f]             {/* Espacios en blanco, se ignoran */}

//--> Errores Lexicos
.                       { System.out.println("Error Lexico"+yytext()+" Linea "+yyline+" Columna "+yycolumn);}

