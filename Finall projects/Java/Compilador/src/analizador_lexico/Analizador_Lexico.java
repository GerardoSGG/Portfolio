package analizador_lexico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analizador_Lexico {

    //contador de los tokens quen son correctos se utiliza en el arreglo de 
    //tokens correctos para ir asignandolos uno a uno
    int c_correctos = 0;
    //arreglo que almacena los tokens que son correctos y al final del programa 
    //poder imprimirlos
    String[] correctos_t = new String[99999];
    // arregflo que almacena los tokens que son incorrectos y al final poder 
    //imprimirlos
    String[] errores_t = new String[99999];
    //contador que lleva el control del numeor de tokens incorrectos
    int c_errores = 0;
    //expresion regular que valida un id
    String id = "^[a-z][a-z0-9]*[:]$";
    //expresion regular que valida el input
    String input = "input|\\(|" + id + "|\\)|;";
    //Expresion regular que valida cadenas de caracteres
    String Cadena = "¡[^¡]*!";
    //expresion regular que valida la funcion para imprimir
    String print = "print|\\(|" + id + "|" + Cadena + "|\\)|;";
    //expresion regular que valida el abecedario
    String abecedario = "[a-z]{1}";
    //expresion regular que valida los numeros enteros
    String numeros_enteros = "[0-9]+";
    //expresion regular que valida los numeros enteros
    String opa = "\\+|\\-|\\*|\\/|\\%|mod";
    // Expresion regular que valida la asginacion
    String asignacion = "=";
    //expresion regular que valida los operadores condicionales
    String opc = "\\<|\\>|\\<=|\\>=|dif|igual";
    //expresion regular que valida los numeros flotantes
    String numeros_flotantes = "^[0-9]+\\.[0-9]+";
    //expresion regular que valida el si
    String si = "suma|resta|si|\\(|" + id + "|" + opc + "|" + numeros_flotantes
            + "|" + Cadena + "|" + numeros_enteros
            + "|\\)|inicio_si|fin_si";
    //expresion regular que valida la proposicion while
    String WHILE = "while|\\(|" + id + "|" + opc + "|\\)|inicio_while|fin_while";
    //expresion regular que valida la proposicion for
    String FOR = "for|\\(|" + id + "|" + opc + "|" + numeros_flotantes + "|" + Cadena + "|" + numeros_enteros + "|;|" + id + "suma|" + id + "resta|\\)|inicio_for|fin_for";
    //expresion regular que valida la declaracion de variables de tipo entero
    String ent = "ent|\\=|" + id + "|[0-9]|;";
    //expresion regular que valida la declaracion de variables de tipo cadena de caracteres
    String cadena_d = "cadena|\\=|" + id + "|¡!|;";
    //expresion regular que valida la declaracion de variables de tipo numero flotante
    String flotante = "flotante|\\=|" + id + "|;|" + numeros_flotantes + "";
    //expresion que valida la declaracion de variables
    String declaracion_v = "inicio_v:|fin_v:";
    //expresion que valida la declaracion de mi programa
    String programa = "inicio_pro|inicio_v|fin_v|fin_pro";

    Pattern patron; //Indicamos la ER
    Matcher macher;  //Compara ER vs cadena

    //metodo que valida cada caracter escrito en el archivo de texto cadena:texto de la linea que se esta leyendo
    //alfabeto: es la instanciacion de nuestra expresion regular que contiene el alfabeto
    //Error: indica la linea en la que se esta trabajando
    public void Valida_caracteres(String cadena, String alfabeto, int Error) {
        int contador_tokens = 0;
       boolean t= false;
        //separamos la cadena por espacios cada uno de ellos sera un token
        String[] token = cadena.split(" ");
        Pattern pattern = Pattern.compile("¡[^¡]*\\s*!");
            Matcher matcher = pattern.matcher(cadena);
            if (matcher.find()) {
                System.out.println();
            t=true;
            }
        //contador nos ayudara a saber si toda la linea esta bien escrita
        while (contador_tokens < cadena.split(" ").length) {
            boolean token_v = false;

            //validar que el token pertenezca a un id
            patron = Pattern.compile(id);
            macher = patron.matcher(token[contador_tokens]);
            //si el token es valido con la ER
            if (macher.matches()) {
                token_v = true;
                t=true;
            }

               
            
            //validar que el token pertenezca al input
            patron = Pattern.compile(input);
            macher = patron.matcher(token[contador_tokens]);
            //si el token es valido con la ER
            if (macher.matches()) {
                token_v = true;t=true;
            } //else {

            /*
                //en caso de que sea incorrecto almacenamos el token en  el arreglo de errores 
                errores_t[c_errores] = "Error en la linea " + Error + " el token \"" + token[contador_tokens] + "\" es incorrecto";
                //aumentamos el contador de errores 
                c_errores++;*/
            //}
            //validar que el token pertenezca al print
            patron = Pattern.compile(print);
            macher = patron.matcher(token[contador_tokens]);
            //si el token es valido con la ER
            if (macher.matches()) {
                token_v = true;t=true;
            }

            //esta parte hace valida cualquier cosa escrita entre signos de admiracion dado que es una cadena de caracteres
            //extraemos cada caracter de la linea en la posicion x
            try {
                char Caracter_ini = token[contador_tokens].charAt(0);
                char Caracter_fin = token[contador_tokens].charAt((token[contador_tokens].length()) - 1);
                //guardamos el caracter extraido en un string para poder utilizarlo en el matcher
                String Caracter_Ini = "" + Caracter_ini;
                String Caracter_Fin = "" + Caracter_fin;
                //si la comparacion es correcta no se hace nada puesto que el caracter esta en nuestro alfabeto
                //validamos si el token es una cadena de caracteres
                if (Caracter_Ini.matches("¡") || Caracter_Fin.matches("!")) {
                    //en caso de ser una cadena de caracteres cualquier valor que contenga sera valido
                    token_v = true;t=true;
                }

                //validar que el token pertenezca a una letra del abecedario
                patron = Pattern.compile(abecedario);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                //validar que el token pertenezca a un numero entero
                patron = Pattern.compile(numeros_enteros);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                //validar que el token pertenezca a un operador aritmetico
                patron = Pattern.compile(opa);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                //validar que el token pertenezca al si
                patron = Pattern.compile(si);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                //validar que el token pertenezca a la proposicion while
                patron = Pattern.compile(WHILE);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                //validar que el token pertenezca a la proposicion for
                patron = Pattern.compile(FOR);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                //validar que el token pertenezca a la declaracion de variables de tipo entero
                patron = Pattern.compile(ent);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                //validar que el token pertenezca a la declaracion de variables de tipo cadena de caracteres
                patron = Pattern.compile(cadena_d);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                patron = Pattern.compile(Cadena);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                //validar que el token pertenezca a un numero flotante
                patron = Pattern.compile(numeros_flotantes);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                //validar que el token pertenezca a la declaracion de variables de tipo numero flotante
                patron = Pattern.compile(flotante);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }
                //validar que el token pertenezca a la declaracion de variables
                patron = Pattern.compile(declaracion_v);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                //validar que el token pertenezca a la inicializacion del programa
                patron = Pattern.compile(programa);
                macher = patron.matcher(token[contador_tokens]);
                //si el token es valido con la ER
                if (macher.matches()) {
                    token_v = true;t=true;
                }

                if (token_v == false||t==false) {
                    //en caso de que sea incorrecto y no coincida con ningun token de nuestro lenguaje almacenamos el token en  el arreglo de errores 
                    errores_t[c_errores] = "Error en la linea " + Error + " el token \"" + token[contador_tokens] + "\" es incorrecto no pertenece a mi lenguaje";
                    //aumentamos el contador de errores 
                    c_errores++;
                    //ciclo que recorre caracter por caracter cada token incorrecto para buscar cual es el caracter que no pertenece al alfabeto en caso de que exista
                    for (int x = 0; x < token[contador_tokens].length(); x++) {
                        //extraemos cada caracter de la linea en la posicion x
                        char Caracter = token[contador_tokens].charAt(x);
                        //guardamos el caracter ectraido en un string para poder utilizarlo en el matcher
                        String Caracter1 = "" + Caracter;
                        patron = Pattern.compile(alfabeto);
                        //compara la cadena contra la expresion regular en este caso el caracter con la expresion
                        macher = patron.matcher(Caracter1);
                        //si no es una cadena de caracteres asigna un error al caracter que no pertenece al alfabeto
                        if (Caracter_Ini.matches("¡") && Caracter_Fin.matches("!")) {
                        } else if (macher.matches()) {
                        } else {
                            //imprimimos la linea y columna en la que esta nuestro error
                            errores_t[c_errores] = "Error en la linea " + Error + " columna " + x + " El caracter \"" + Caracter1 + "\" no se encuentra en el alfabeto";
                            c_errores++;

                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
            }
            //aumentams al final de la validacion el contador de tokens para pasar al siguiente y validarlo
            contador_tokens++;
        }

    }

    String Ids_D = "";
    String Ids_De = "";
    String Ids_t[] = new String[999];
    int cont_Ids = 0;
    String Gramatica[] = new String[20];
    boolean Declarando_Id = false;
    Hashtable<String, String> Tabla_e = new Hashtable<String, String>();

    public void Sintactico(String linea, int N_Linea, int Linea_fin) {
        boolean Linea_v = false;
        //<letra>::=a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z
        Gramatica[0] = "[a-z]+";
        //expresion regular que valida un id <id>::=<letra>|<letra><letra>|<letra><numero>:
        Gramatica[1] = "^[a-z][a-z0-9]*[:]$";
        // tipo <tipo>::=ent|cadena|flotante
        Gramatica[2] = "ent|cadena|flotante";
        //<declaracion_v>::=<tipo>\\s<asignacion>;
        Gramatica[3] = "(^(ent|cadena|flotante)\\s[a-z][a-z0-9 ]*:\\s=\\s" + Gramatica[7] + "\\s;$)";
        //<digitos>::=<numero>|<numero><digitos>
        Gramatica[4] = "[0-9]+";
        //<cadena_c>::=¡<letra>|<numero>|<puntos>|<cadena_c>(<letra><numero><puntos>)!
        Gramatica[5] = "¡[^¡]*\\s*!";
        //<flotantes>::=<digitos>.<digitos>
        Gramatica[6] = "([0-9]+.[0-9]+)";
        //<dato>::=<numeros>|<cadena_c>|<flotantes>
        Gramatica[7] = "([0-9]+|" + Gramatica[5] + "|" + Gramatica[6] + ")";
        //<valor>::=<id>|<dato>
        Gramatica[8] = "([a-z][a-z0-9]*:|" + Gramatica[7] + ")";
        //<asignacion>::=<id>\\s=\\s<valor>
        Gramatica[9] = "((" + Ids_D + ")\\s=\\s(" + Ids_D + "|" + Gramatica[7] + "))";
        //<opa>::+|-|*|/|mod|%
        Gramatica[10] = "(\\+|\\-|\\*|\\/|mod|\\%)";
        //<expresion>::=<asignacion>|<asignacion>\\s<opa>\\s<valor>
        Gramatica[11] = "(" + Gramatica[9] + "|" + Ids_D + "\\s" + "=\\s(" + Ids_D + "|" + Gramatica[8] + ")\\s(" + Gramatica[10] + "\\s" + Gramatica[8] + ")+|" + Gramatica[9] + "\\s" + Gramatica[10] + "\\s(" + Ids_D + "|" + Gramatica[5] + "|[0-9]+|[0-9]+.[0-9]+|" + Gramatica[12] + "))";
        //<input>::=input\\s(\\s<id>\\s)\\s;
        Gramatica[12] = "(input\\s\\(\\s(" + Ids_D + ")\\s\\)\\s;)";
        //<print>::=print\\s(\\s<Id>\\s)\\s;
        Gramatica[13] = "(print\\s\\(\\s((" + Ids_D + "|salto:|[0-9]+|[0-9]+.[0-9]+))\\s\\)\\s\\;)";
        //<opc>::=<|>|<=|igual|>=|dif 
        Gramatica[14] = "(<|>|<\\=|igual|>\\=|dif)";
        //<si>::=si\\s(\\s(<id><flotantes>|<digito>)\\s<opc>\\s(<id><flotantes>|<digito>)\\s)\\sinicio_si$<s>fin_si-sino<s>fin_sino
        Gramatica[15] = "(^si\\s\\(\\s(" + Ids_D + "|" + Gramatica[4] + "|" + Gramatica[6] + ")\\s" + Gramatica[14] + "\\s(" + Ids_D + "|" + Gramatica[4] + "|" + Gramatica[6] + ")\\s\\)\\sinicio_si$|fin_si)";
        //<for>::=for\\s(\\s<id>;\\s<id>\\s<opc>\\s(<id><flotantes>|<digito>)\\s;\\s<id>\\ssuma|resta\\s)\\sinicio_for$\\s<s>\\sfin_for
        Gramatica[16] = "^for\\s\\(\\s(" + Ids_D + ")\\s;\\s(" + Ids_D + "|" + Gramatica[4] + "|" + Gramatica[6] + ")\\s" + Gramatica[14] + "\\s(" + Ids_D + "|" + Gramatica[4] + "|" + Gramatica[6] + ")\\s;\\s(" + Ids_D + ")\\ssuma\\s\\)\\sinicio_for$|fin_for|^for\\s\\(\\s(" + Ids_D + ")\\s;\\s(" + Ids_D + "|" + Gramatica[4] + "|" + Gramatica[6] + ")\\s" + Gramatica[14] + "\\s(" + Ids_D + "|" + Gramatica[7] + ")\\s;\\s(" + Ids_D + ")\\sresta\\s\\)";
        //<while>::=while\\s(\\s<valor>\\s<opc>\\s<valor>\\s)\\sinicio_while$\\s<s>\\sfin_while
        Gramatica[17] = "^while\\s\\(\\s(" + Ids_D + "|" + Gramatica[4] + "|" + Gramatica[6] + ")\\s" + Gramatica[14] + "\\s(" + Ids_D + "|" + Gramatica[4] + "|" + Gramatica[6] + ")\\s\\)\\sinicio_while$|fin_while";
        //Palabras reservadas
        Gramatica[18] = "print|input|si|inicio_si|fin_si-sino|fin_sino|for|suma|resta|inicio_for|fin_for|while|inicio_while|fin_while|inicio_pro|inicio_v|fin_v|fin_pro|igual|dif|mod|ent|flotante|cadena";
        
        //tabla de errores
        Tabla_e.put("000", "error de sintaxis la primer linea debe ser inicio_pro");
        Tabla_e.put("001", "error de sintaxis la segunda linea debe ser inicio_v");
        Tabla_e.put("002", "error de sintaxis falta un espacio en blanco");
        Tabla_e.put("003", "error de sintaxis hace falta el token: ( ");
        Tabla_e.put("004", "error de sintaxis id incorrecto recuerde que el id debe estar declarado");
        Tabla_e.put("005", "error de sintaxis hace falta el token: ) ");
        Tabla_e.put("006", "error de sintaxis falta el token: ; ");
        Tabla_e.put("007", "error de sintaxis la linea debe iniciar con el token el: input ");
        Tabla_e.put("008", "error de sintaxis la linea debe iniciar con el token el: print ");
        Tabla_e.put("009", "error de sintaxis falta el token valor (id o dato 0 input)");
        Tabla_e.put("010", "error de sintaxis la linea debe iniciar con el token el: si ");
        Tabla_e.put("011", "error de sintaxis falta el token operador condicional (<|>|<=|igual|>=|dif) ");
        Tabla_e.put("012", "error de sintaxis falta el token: inicio_si  ");
        Tabla_e.put("013", "error de sintaxis la linea debe iniciar con el token el: for ");
        Tabla_e.put("014", "error de sintaxis falta el token: suma o resta ");
        Tabla_e.put("016", "error de sintaxis falta el token: inicio_for  ");
        Tabla_e.put("017", "error de sintaxis la linea debe iniciar con el token el: while ");
        Tabla_e.put("018", "error de sintaxis falta el token: inicio_while  ");

        //validamos que la primera linea sea inicio_pro
        if (N_Linea == 0) {
            patron = Pattern.compile("inicio_pro");
            macher = patron.matcher(linea);
            //si es correcto ponemos la bandera en true si no es correcta guardamos el error en nuestro arreglo
            if (macher.matches()) {
                Linea_v = true;
            } else {
                errores_t[c_errores] = "Error semantico en la linea: " + N_Linea + " la primer linea debe ser inicio_pro";
                c_errores++;
            }
        }
        //validamos que la segunda linea sea inicio_v que marca el inicio de declaracion de variables
        if (N_Linea == 1) {
            patron = Pattern.compile("inicio_v");
            macher = patron.matcher(linea);
            //si es correcto ponemos la bandera en true si no es correcta guardamos el error en nuestro arreglo
            if (macher.matches()) {
                Linea_v = true;
                Declarando_Id = true;
            } else {
                errores_t[c_errores] = "Error semantico en la linea: " + N_Linea + " la segunda linea debe ser inicio_v";
                c_errores++;
            }
        }
        if (N_Linea == Linea_fin - 1) {
            patron = Pattern.compile("fin_pro");
            macher = patron.matcher(linea);
            //si es correcto ponemos la bandera en true si no es correcta guardamos el error en nuestro arreglo
            if (macher.matches()) {
                Linea_v = true;
            } else {
                errores_t[c_errores] = "Error semantico en la linea: " + N_Linea + " la ultima linea debe ser fin_pro";
                c_errores++;
            }
        }
        String Separa[] = linea.split("\\s");
        //a partir de la tercera linea validamos si corresponde con alguna sentencia
        if (N_Linea >= 2 && N_Linea != Linea_fin) {

            //si no se estan declarando variables
            if (Declarando_Id == false) {
                for (int x = 0; x < 18; x++) {
                    //en este ciclo validamos si la linea corresponde con alguna sentencia de mis gramaticas
                    patron = Pattern.compile(Gramatica[x]);
                    macher = patron.matcher(linea);
                    //si la linea es valida ponemos la bandera en true
                    if (macher.matches()) {
                        Linea_v = true;
                    }
                }

            } else {
                // si se esta declarando una variable hacemos esta validacion para saber si es el fin de la declaracion
                patron = Pattern.compile("fin_v");
                macher = patron.matcher(linea);
                //si la linea es valida ponemos la bandera en false para indicar que ya no se estan declarando variables
                if (macher.matches()) {
                    Declarando_Id = false;
                    Linea_v = true;
                    for (int c = 0; c < Ids_De.length() - 1; c++) {
                        Ids_D = Ids_D + Ids_De.charAt(c);
                    }
                } else {
                    if (Separa[0].matches(Gramatica[2])) {
                        //Ahora comprobamos que el ID fue escrito de manera correcto
                        if (Separa[1].matches(Gramatica[18])) {
                            System.out.println("Error el nombre del id no puede ser una palabra reservada");
                        }
                        if (linea.matches(Gramatica[3])) {
                            //Si es asi, lo agregamos a la tabla de simbolos, donde comprobaremos de que los ID que se utilicen en las sentencias hayan sido declarados
                            //verificamos que el id no sea una palabra reservada aunque en realidad no podria serlo debido a la gramatica del id 
                            if (!Separa[1].matches(Gramatica[18])) {
                                //este arreglo lo usamos apra validar posteriormente la paridad de tipos en operaciones guardando primero 
                                if (!Separa[1].matches(Ids_De)) {
                                    //el nombre de la variable y posteriormente su tipo para consultarlos despues
                                    //tipo             nombre            valor
                                    Ids_t[cont_Ids] = Separa[0] + "~" + Separa[1] + "~" + Separa[3];
                                    cont_Ids++;
                                    //Esta sentencia va formando un string con todos los ids que se van declarando para despues validar 
                                    //si el id que se sesta utilizando ya fue declarado
                                    Ids_De = Ids_De + Separa[1] + "|";
                                    //una vez cumplidas las condiciones solo ponemos la bandera en true para que no la mande a la tabla de errores
                                    Linea_v = true;
                                } else {
                                    System.out.println("Error nombre de id repetido");
                                }
                            } else {
                                System.out.println("Error el nombre del id no puede ser una palabra reservada");
                            }
                        } else {
                            System.out.println("Error de sintaxis, ID no escrito correctamente");
                        }
                        //Si no fue escrito de manera correcta, o no es ninguna declaracion de variable, error de sintaxis 
                    } else {
                        System.out.println("Error en la declaracion de variables");
                    }
                }
            }
        }
                 
        if (Linea_v == false) {
            boolean sen = false;
            //matriz de predicciones
            //este try catch atrapa la excepcion en caso de que la linea coincida con el input pero le falten tokens para estar completa
            try {
                //busca los tokens que no coinciden con la sentencia del input y el token que deberia de estar en esa posicion
                if (Separa[0].equals("input")) {
                    sen = true;
                    if (!Separa[1].equals("(")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 1 \" " + Separa[1] + " \" este token debe ser ( error 003 " + Tabla_e.get("003");
                        c_errores++;
                    }
                    if (!Separa[2].equals(Ids_De)) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 2 \" " + Separa[2] + " \" este token debe ser un id declarado error 004 " + Tabla_e.get("004");
                        c_errores++;
                    }
                    if (!Separa[3].equals(")")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 3 \" " + Separa[3] + " \" este token debe ser ) error 005 " + Tabla_e.get("005");
                        c_errores++;
                    }
                    if (!Separa[4].equals(";")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 4 \" " + Separa[4] + " \" este token debe ser ; error 006 " + Tabla_e.get("006");
                        c_errores++;
                    }

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                errores_t[c_errores] = "Error en la linea " + N_Linea + " sentecia incompleta recuerde que la sintaxis es la sguiente input\\s\\(\\s(Id declarado)\\s\\)\\s; ";
                c_errores++;
            }

            //este try catch atrapa la excepcion en caso de que la linea coincida con el input pero le falten tokens para estar completa
            try {
                //busca los tokens que no coinciden con la sentencia del input y el token que deberia de estar en esa posicion
                if (Separa[0].equals("print")) {
                    sen = true;
                    if (!Separa[1].equals("(")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 1 \" " + Separa[1] + " \" este token debe ser ( error 003 " + Tabla_e.get("003");
                        c_errores++;
                    }
                    if (!Separa[2].equals(Ids_De + "|" + Gramatica[7])) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 2 \" " + Separa[2] + " \" este token debe ser un id declarado o un dato error 004 " + Tabla_e.get("004");
                        c_errores++;
                    }
                    if (!Separa[3].equals(")")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 3 \" " + Separa[3] + " \" este token debe ser ) error 005 " + Tabla_e.get("005");
                        c_errores++;
                    }
                    if (!Separa[4].equals(";")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 4 \" " + Separa[4] + " \" este token debe ser ; error 006 " + Tabla_e.get("006");
                        c_errores++;
                    }

                }
            } catch (ArrayIndexOutOfBoundsException e) {
                errores_t[c_errores] = "Error en la linea " + N_Linea + " sentecia incompleta recuerde que la sintaxis es la sguiente print\\s\\(\\s(Id declarado|[0-9]+|cadena de caracteres|numero flotante)\\s\\)\\s\\; ";
                c_errores++;
            }

            //este try catch atrapa la excepcion en caso de que la linea coincida con el si pero le falten tokens para estar completa
            try {
                //busca los tokens que no coinciden con la sentencia del si y el token que deberia de estar en esa posicion
                if (Separa[0].equals("si")) {
                    sen = true;
                    if (!Separa[1].equals("(")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 1 \" " + Separa[1] + " \" este token debe ser ( error 003 " + Tabla_e.get("003");
                        c_errores++;
                    }
                    if (!Separa[2].matches(Ids_De)) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 2 \" " + Separa[2] + " \" este token debe ser un id declarado error 004 " + Tabla_e.get("004");
                        c_errores++;
                    }
                    if (!Separa[3].matches("<|>|<=|igual|>=|dif")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 3 \" " + Separa[3] + " \" este token debe ser operador condicional error 011 " + Tabla_e.get("011");
                        c_errores++;
                    }
                    if (!Separa[4].matches(Ids_De + "|" + Gramatica[7])) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 4 \" " + Separa[4] + " \" este token debe ser un id declarado o un dato error 004 " + Tabla_e.get("004");
                        c_errores++;
                    }
                    if (!Separa[5].equals(")")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 5 \" " + Separa[5] + " \" este token debe ser ) error 005 " + Tabla_e.get("005");
                        c_errores++;
                    }
                    if (!Separa[6].equals("inicio_si")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 6 \" " + Separa[6] + " \" este token debe ser inicio_si error 012 " + Tabla_e.get("012");
                        c_errores++;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                errores_t[c_errores] = "Error en la linea " + N_Linea + " sentecia incompleta recuerde que la sintaxis es la sguiente ^si\\s\\(\\s(Id declarado)\\s(<|>|<\\=|igual|>\\=|dif)\\s(Id declarado|[0-9]+|¡[a-z]*[1-9]*:*!|[0-9]+.[0-9]+)\\s\\)\\sinicio_si$";
                c_errores++;
            }

            //este try catch atrapa la excepcion en caso de que la linea coincida con el si pero le falten tokens para estar completa
            try {
                //busca los tokens que no coinciden con la sentencia del for y el token que deberia de estar en esa posicion
                if (Separa[0].equals("for")) {
                    sen = true;
                    if (!Separa[1].equals("(")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 1 \" " + Separa[1] + " \" este token debe ser ( error 003 " + Tabla_e.get("003");
                        c_errores++;
                    }
                    if (!Separa[2].matches(Ids_De)) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 2 \" " + Separa[2] + " \" este token debe ser un id declarado error 004 " + Tabla_e.get("004");
                        c_errores++;
                    }
                    if (!Separa[3].equals(";")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 3 \" " + Separa[3] + " \" este token debe ser ; error 006 " + Tabla_e.get("006");
                        c_errores++;
                    }
                    if (!Separa[4].matches(Separa[2])) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 4 \" " + Separa[4] + " \" este token debe ser la misma variable que al incio ";
                        c_errores++;
                    }
                    if (!Separa[5].matches("<|>|<=|igual|>=|dif")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 5 \" " + Separa[5] + " \" este token debe ser operador condicional error 011 " + Tabla_e.get("011");
                        c_errores++;
                    }
                    if (!Separa[6].matches(Ids_De + "|" + Gramatica[7])) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 6 \" " + Separa[6] + " \" este token debe ser un id declarado o un dato error 004 " + Tabla_e.get("004");
                        c_errores++;
                    }
                    if (!Separa[7].equals(";")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 7 \" " + Separa[7] + " \" este token debe ser ; error 006 " + Tabla_e.get("006");
                        c_errores++;
                    }
                    if (!Separa[8].matches(Separa[2])) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 8 \" " + Separa[8] + " \" este token debe ser el mismo id del inicio " ;
                        c_errores++;
                    }
                    if (!Separa[9].matches("suma|resta")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 9 \" " + Separa[9] + " \" este token debe ser suma|resta error 014 " + Tabla_e.get("014");
                        c_errores++;
                    }
                    if (!Separa[10].equals(")")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 10 \" " + Separa[10] + " \" este token debe ser ) error 005 " + Tabla_e.get("005");
                        c_errores++;
                    }
                    if (!Separa[11].equals("inicio_for")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 11 \" " + Separa[11] + " \" este token debe ser inicio_for error 016 " + Tabla_e.get("016");
                        c_errores++;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                errores_t[c_errores] = "Error en la linea " + N_Linea + " sentecia incompleta recuerde que la sintaxis es la sguiente ^for\\s\\(\\s(Id declarado)\\s;\\s(Id declarado)\\s(<|>|<\\=|igual|>\\=|dif)\\s(Id declarado|([0-9]+|¡[a-z]*[1-9]*:*!|([0-9]+.[0-9]+)))\\s;\\s(Id declarado)\\ssuma|resta\\s\\)\\sinicio_for$";
                c_errores++;
            }

            //este try catch atrapa la excepcion en caso de que la linea coincida con el si pero le falten tokens para estar completa
            try {
                //busca los tokens que no coinciden con la sentencia del while y el token que deberia de estar en esa posicion
                if (Separa[0].equals("while")) {
                    sen = true;
                    if (!Separa[1].equals("(")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 1 \" " + Separa[1] + " \" este token debe ser ( error 003 " + Tabla_e.get("003");
                        c_errores++;
                    }
                    if (!Separa[2].matches(Ids_De)) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 2 \" " + Separa[2] + " \" este token debe ser un id declarado error 004 " + Tabla_e.get("004");
                        c_errores++;
                    }
                    if (!Separa[3].matches("<|>|<=|igual|>=|dif")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 3 \" " + Separa[3] + " \" este token debe ser operador condicional error 011 " + Tabla_e.get("011");
                        c_errores++;
                    }
                    if (!Separa[4].matches(Ids_De + "|" + Gramatica[7])) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 4 \" " + Separa[4] + " \" este token debe ser un id declarado o un dato error 004 " + Tabla_e.get("004");
                        c_errores++;
                    }

                    if (!Separa[5].equals(")")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 5 \" " + Separa[5] + " \" este token debe ser ) error 005 " + Tabla_e.get("005");
                        c_errores++;
                    }
                    if (!Separa[6].equals("inicio_while")) {
                        errores_t[c_errores] = "Linea " + N_Linea + " token 6 \" " + Separa[6] + " \" este token debe ser inicio_while error 018 " + Tabla_e.get("018");
                        c_errores++;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                errores_t[c_errores] = "Error en la linea " + N_Linea + " sentecia incompleta recuerde que la sintaxis es la sguiente ^while\\s\\(\\s(Id declarado)\\s(<|>|<\\=|igual|>\\=|dif)\\s(Id declarado|([0-9]+|¡[a-z]*[1-9]*:*!|([0-9]+.[0-9]+)))\\s\\)\\sinicio_while$";
                c_errores++;
            }

            if (sen == false) {
                errores_t[c_errores] = "Error de sintaxis en la linea: " + N_Linea + linea + " esta sentencia no corresponde a ninguna de mi lenguaje";
                c_errores++;
            }

        }

    }

    //tablas para verificar paridad de bloques
    String[] Tabla_if = new String[999];
    String[] Tabla_while = new String[999];
    String[] Tabla_for = new String[999];
    int S = 0, W = 0, F = 0;

    public void Semantico(String linea, int N_Linea) {
        //paridad de bloque if
        if (linea.matches(Gramatica[15])) {
            if (linea.equals("fin_si")) {
                if (S <= 0) {
                    errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " esta sentecia no cierra ningun bloque esta de mas";
                    c_errores++;
                    S--;
                } else {
                    Tabla_if[S] = "";
                    S = S - 1;
                }
            } else {
                Tabla_if[S] = "Error semantico en la linea " + N_Linea + " falta cerrar la sentencia if";
                S++;
            }
        }

        //paridad de bloque for
        if (linea.matches(Gramatica[16])) {
            if (linea.equals("fin_for")) {
                if (F <= 0) {
                    errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " esta sentecia no cierra ningun bloque esta de mas";
                    c_errores++;
                    F--;
                } else {
                    Tabla_for[F] = "";
                    F = F - 1;
                }
            } else {
                Tabla_for[F] = "Error semantico en la linea " + N_Linea + " falta cerrar la sentencia for";
                F++;
            }
        }

        //paridad de bloque while
        if (linea.matches(Gramatica[17])) {
            if (linea.equals("fin_while")) {
                if (W <= 0) {
                    errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " esta sentecia no cierra ningun bloque esta de mas";
                    c_errores++;
                    W--;
                } else {
                    Tabla_while[W] = "";
                    W = W - 1;
                }
            } else {
                Tabla_while[W] = "Error semantico en la linea " + N_Linea + " falta cerrar la sentencia while";
                W++;
            }
        }

        String token[] = linea.split("\\s");
        String aux = "";
        boolean P_cade = false;
        // verificamos la paridad de signos de admiracion de una cadena de caracteres
        for (int x = 0; x < linea.length(); x++) {
            //extraemos cada caracter de la linea en la posicion x
            char C = linea.charAt(x);
            aux = "" + C;
            if (aux.equals("¡")) {
                P_cade = true;
            }
            if (aux.equals("!")) {
                P_cade = false;
            }
            // System.out.println(aux);
            //System.out.println(P_cade);
        }
        if (P_cade == true) {
            errores_t[c_errores] = "Error en la linea " + N_Linea + " no hay paridad en signos de admiracion";
            c_errores++;
        }
        //si se esta declarando verificamos los tipos
        if (linea.matches(Gramatica[3])) {
            switch (token[0]) {
                case "ent": {
                    if (!token[3].matches("[0-9]+")) {
                        errores_t[c_errores] = "Error en la linea " + N_Linea + " error de tipos ambos deben ser numeros enteros";
                        c_errores++;
                    }
                    break;
                }

                case "cadena": {
                    for (int x = 0; x < linea.length(); x++) {
                        //extraemos cada caracter de la linea en la posicion x
                        char C = linea.charAt(x);
                        aux = "" + C;
                        if (aux.equals("¡")) {
                            P_cade = true;
                        }
                        if (aux.equals("!")) {
                            P_cade = false;
                        }
                        // System.out.println(aux);
                        //System.out.println(P_cade);
                    }
                    if (P_cade == true) {
                        errores_t[c_errores] = "Error en la linea " + N_Linea + " error de tipos se declaro una cadena";
                        c_errores++;
                    }

                    if (token[3].matches("[0-9]+")) {
                        errores_t[c_errores] = "Error en la linea " + N_Linea + " error de tipos se declaro una cadena y se escribio un entero";
                        c_errores++;
                    }
                    if (token[3].matches("[0-9]+.[0-9]+")) {
                        errores_t[c_errores] = "Error en la linea " + N_Linea + " error de tipos se declaro una cadena y se escribio un numero flotante";
                        c_errores++;
                    }
                    break;
                }

                case "flotante": {
                    if (!token[3].matches("[0-9]+.[0-9]+")) {
                        errores_t[c_errores] = "Error en la linea " + N_Linea + " error de tipos ambos deben ser de tipo flotante";
                        c_errores++;
                    }
                    break;
                }
            }
        }

        //verificamos paridad en operaciones
        if (linea.matches(Gramatica[11])) {
            //separamos cada uno de los tokens que conforman la operacion dado que cada uno esta separado por un operador aritmetico
            linea = linea.replaceAll(" ", "");
            String Tokens_o[] = linea.split("\\+|\\-|\\*|\\/|\\=");
            String tipo_o = "";
            boolean paridad_t = true;

            //una vez hecho esto identificaremos el tipo del primer token que es la variable a la cual se asigna el resutlado
            //de acuerdo a lo obtenido entraremos a el caso que concuerde
            for (int p = 0; p < cont_Ids; p++) {
                String Tokens_g[] = Ids_t[p].split("~");
                if (Tokens_g[1].equals(Tokens_o[0])) {
                    tipo_o = Tokens_g[0];
                }
            }
            switch (tipo_o) {
                case "ent": {
                    try {
                        for (int x = 1; x < 20; x++) {
                            //si es un id declarado
                            if (Tokens_o[x].matches(Ids_De)) {
                                for (int p = 0; p < cont_Ids; p++) {
                                    String Tokens_g[] = Ids_t[p].split("~");
                                    //busc su nombre y extrae su tipo
                                    if (Tokens_g[1].equals(Tokens_o[x])) {
                                        if (!Tokens_g[0].equals(tipo_o)) {
                                            paridad_t = false;
                                            errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " token \" " + Tokens_o[x] + "\" este token no es del mimo tipo que el resto";
                                            c_errores++;
                                        }
                                    }
                                }
                            }
                            if (!Tokens_o[x].matches("^[a-z][a-z0-9]*:$")) {
                                if (!Tokens_o[x].matches("[0-9]+")) {
                                    paridad_t = false;
                                    errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " token \" " + Tokens_o[x] + "\" este token no es del mismo tipo que el resto";
                                    c_errores++;
                                }
                            }

                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    if (paridad_t == false) {
                        errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " error de tipos todos los valores deben ser numeros enteros";
                        c_errores++;
                    }
                    break;
                }
                case "flotante": {
                    try {
                        for (int x = 1; x < 20; x++) {
                            if (Tokens_o[x].matches(Ids_De)) {
                                for (int p = 0; p < cont_Ids; p++) {
                                    String Tokens_g[] = Ids_t[p].split("~");

                                    if (Tokens_g[1].equals(Tokens_o[x])) {
                                        if (!Tokens_g[0].equals(tipo_o)) {
                                            paridad_t = false;
                                            errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " token \" " + Tokens_o[x] + "\" este token no es del mimo tipo que el resto";
                                            c_errores++;
                                        }
                                    }
                                }
                            }
                            if (!Tokens_o[x].matches("^[a-z][a-z0-9]*:$")) {
                                if (!Tokens_o[x].matches("[0-9]+.[0-9]+")) {
                                    paridad_t = false;
                                    errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " token \" " + Tokens_o[x] + "\" este token no es del mismo tipo que el resto";
                                    c_errores++;
                                }
                            }

                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    if (paridad_t == false) {
                        errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " error de tipos todos los valores deben ser numeros flotantes";
                        c_errores++;
                    }
                    break;
                }
                case "cadena": {
                    try {
                        for (int x = 1; x < 20; x++) {
                            if (Tokens_o[x].matches(Ids_De)) {
                                for (int p = 0; p < cont_Ids; p++) {
                                    String Tokens_g[] = Ids_t[p].split("~");

                                    if (Tokens_g[1].equals(Tokens_o[x])) {
                                        if (!Tokens_g[0].equals(tipo_o)) {
                                            paridad_t = false;
                                            errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " token \" " + Tokens_o[x] + "\" este token no es del mimo tipo que el resto";
                                            c_errores++;
                                        }
                                    }
                                }
                            }
                            if (!Tokens_o[x].matches("^[a-z][a-z0-9]*:$")) {
                                if (!Tokens_o[x].matches("^¡[^¡!+*/-]*!$")) {
                                    paridad_t = false;
                                    errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " token \" " + Tokens_o[x] + "\" este token no es del mismo tipo que el resto";
                                    c_errores++;
                                }
                            }

                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    if (paridad_t == false) {
                        errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " error de tipos todos los valores deben ser cadenas de caracteres validas";
                        c_errores++;
                    }
                    break;
                }
            }
        }
        //termina paridad de tipos de operaciones

        //paridad de tipos en si y en while
        if (linea.matches(Gramatica[15]) || linea.matches(Gramatica[17])) {
            //separamos cada uno de los tokens que conforman 
            String Tokens_o[] = linea.split(" ");
            String tipo_o = "",tipo_1="";
            boolean cadena = false;

            //una vez hecho esto identificaremos el tipo del primer token que es la variable a la cual se asigna el resutlado
            //de acuerdo a lo obtenido entraremos a el caso que concuerde
            try {

                if (Tokens_o[2].matches(Ids_De)) {
                    for (int p = 0; p < cont_Ids; p++) {
                        String Tokens_g[] = Ids_t[p].split("~");
                        if (Tokens_g[1].equals(Tokens_o[2])) {
                            tipo_o = Tokens_g[0];
                        }
                    }
                }
                if (!Tokens_o[2].matches("^[a-z][a-z0-9]*:$")) {
                    if (Tokens_o[2].matches("[0-9]+.[0-9]+")) {
                        tipo_o = "flotante";
                    }
                    if (Tokens_o[2].matches("[0-9]+")) {
                        tipo_o = "ent";
                    }
                }
                if (tipo_o.equals("") || tipo_o.equals("cadena")) {
                    errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " no se puede realizar esta sentencia usando cadenas en este lenguaje";
                    c_errores++;
                }
                switch (tipo_o) {
                    case "ent": {
                        if (Tokens_o[4].matches("[0-9]+|"+Ids_De)) {
                           
                            if (Tokens_o[4].matches(Ids_De)) {
                            for (int p = 0; p < cont_Ids; p++) {
                            String Tokens_g[] = Ids_t[p].split("~");
                            if (Tokens_g[1].equals(Tokens_o[2])) {
                            tipo_1 = Tokens_g[0];
                            }
                            }
                            
                            if(!tipo_o.equals(tipo_1)){
                            errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " error de tipos los valores deben ser numeros enteros ";
                            c_errores++;
                            }
                            
                            }else{
                            if (!Tokens_o[4].matches("[0-9]+")) {
                            errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " error de tipos los valores deben ser numeros enteros ";
                            c_errores++;
                            }
                            }
                            
                            
                        }
                        break;
                    }
                    case "flotante": {
                        if (!Tokens_o[4].matches("[0-9]+.[0-9]+")) {
                            errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " error de tipos los valores deben ser numeros flotantes";
                            c_errores++;
                        }
                        break;
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
        
        //paridad en for
        if (linea.matches("^for\\s\\(\\s(" + Ids_D + ")\\s;\\s(" + Ids_D + "|" + Gramatica[4] + "|" + Gramatica[6] + ")\\s" + Gramatica[14] + "\\s(" + Ids_D + "|" + Gramatica[4] + "|" + Gramatica[6] + ")\\s;\\s(" + Ids_D + ")\\ssuma\\s\\)\\sinicio_for$|^for\\s\\(\\s(" + Ids_D + ")\\s;\\s(" + Ids_D + "|" + Gramatica[4] + "|" + Gramatica[6] + ")\\s" + Gramatica[14] + "\\s(" + Ids_D + "|" + Gramatica[7] + ")\\s;\\s(" + Ids_D + ")\\sresta\\s\\)")) {
            //separamos cada uno de los tokens
            String Tokens_o[] = linea.split(" ");
            String tipo_o = "";
            boolean cadena = false;

            //una vez hecho esto identificaremos el tipo del primer token que es la variable a la cual se asigna el resutlado
            //de acuerdo a lo obtenido entraremos a el caso que concuerde
            try {

                if (Tokens_o[2].matches(Ids_De)) {
                    if (!Tokens_o[2].equals(Tokens_o[8])) {
                        errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " los tokens 2 y 8 deben seer la misma variable";
                        c_errores++;
                    }
                    for (int p = 0; p < cont_Ids; p++) {
                        String Tokens_g[] = Ids_t[p].split("~");
                        if (Tokens_g[1].equals(Tokens_o[2])) {
                            tipo_o = Tokens_g[0];
                        }
                    }
                } else {
                    errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " los tokens 2 y 8 deben ser una variable declarada";
                    c_errores++;
                }
                if (!Tokens_o[2].matches("^[a-z][a-z0-9]*:$")) {
                    if (Tokens_o[2].matches("[0-9]+.[0-9]+")) {
                        tipo_o = "flotante";
                    }
                    if (Tokens_o[2].matches("[0-9]+")) {
                        tipo_o = "ent";
                    }
                }

                if (tipo_o.equals("") || tipo_o.equals("cadena")) {
                    errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " no se puede realizar esta sentencia usando cadenas en este lenguaje";
                    c_errores++;
                }
                switch (tipo_o) {
                    case "ent": {
                        
                        if (Tokens_o[6].matches(Ids_De)) {
                    for (int p = 0; p < cont_Ids; p++) {
                        String Tokens_g[] = Ids_t[p].split("~");
                        if (Tokens_g[1].equals(Tokens_o[6])) {
                            tipo_o = Tokens_g[0];
                        }
                        if(!tipo_o.equals("ent")){
                        errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " error de tipos la variable  debe ser numero entero";
                            c_errores++;
                        }
                    }
                }else{
                        
                        
                        if (!Tokens_o[6].matches("[0-9]+")) {
                            errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " error de tipos los valores deben ser numeros enteros jejje";
                            c_errores++;
                        }}
                        break;
                    }
                    case "flotante": {
                        if (!Tokens_o[6].matches("[0-9]+")) {
                            errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " error de tipos los valores deben ser numeros flotantes";
                            c_errores++;
                        }
                        break;
                    }
                }
                if (!(Tokens_o[2].equals(Tokens_o[4]))||!(Tokens_o[2].equals(Tokens_o[4]))){
                errores_t[c_errores] = "Error semantico en la linea " + N_Linea + " las tres variables del for deben ser la misma";
                            c_errores++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        }
    }
    int c_data=2,c_code=4;
    String[] Cabecera = new String[999];
    String[] Data = new String[999];
    String[] Code = new String[999];
    String[] fin = new String[999];
    String[] fin_if = new String[999];
    String[] fin_f = new String[999];
    String[] fin_for = new String[999];
    String[] fin_w = new String[999];
    String[] fin_whi = new String[999];
   int N=0,FO=0,O=0,P=0,FOO=0,POO=0;
   String aux="aux";
    public void Generador(String linea, int N_Linea, int Linea_act) {
        
        
        if (correcto == false) { } 
        else {
             if (Linea_act <1&&Linea_act!=N_Linea) {
             Code[0]=".CODE ";
             Code[1]="INICIO:";
             Code[2]="MOV AX, @DATA";
             Code[3]="MOV Ds, AX";
             }
            if (Linea_act == 0) {
                patron = Pattern.compile("inicio_pro");
                macher = patron.matcher(linea);
                //si es correcto ponemos la bandera en true si no es correcta guardamos el error en nuestro arreglo
                if (macher.matches()) {
                    Cabecera[0] = ".MODEL SMALL ";
                    Cabecera[1] = ".STACK ";
                }
            }
            
            //validamos que la segunda linea sea inicio_v que marca el inicio de declaracion de variables
            if (Linea_act == 1) {
                patron = Pattern.compile("inicio_v");
                macher = patron.matcher(linea);
                if (macher.matches()) {
                    Data[0] = ".DATA";
                    Data[1] = "salto db 10,13,10,13,\"$\"";
                }
            }
            if (Linea_act == N_Linea - 1) {
                patron = Pattern.compile("fin_pro");
                macher = patron.matcher(linea);
                //si es correcto ponemos la bandera en true si no es correcta guardamos el error en nuestro arreglo
                if (macher.matches()) {
                    Cabecera[2] = "END INICIO ";
                    Code[c_code]="mov Ax, 4C00h";
                    c_code++;
                    Code[c_code]="int 21h";
                    c_code++;                    
                }
            }
            
            //a partir de la tercera linea validamos si corresponde con alguna sentencia
            if (Linea_act >= 2 && Linea_act != N_Linea) {
            
            //si se estan declarando una variable ponla en data    
            String Valor_c="";
            String Separa[] = linea.split("\\s");
          if (linea.matches(Gramatica[3])) {
             Separa[2]= Separa[2].replaceAll(":", "");
            if(Separa[0].matches("cadena")){
            Pattern pattern = Pattern.compile(Gramatica[5]);
            Matcher matcher = pattern.matcher(linea);
            if (matcher.find()) {
            Valor_c = matcher.group(0);
            }

                    Data[c_data] = Separa[1] + " DB \"" + Valor_c + "\" , 10, 13, \"$\"";
                    c_data++;
                    
              // nombre |tipo| valor   |salto de linea                
              //   M2     DB  "MAYOR B" , 10, 13, "$" 
                }
             if(Separa[0].matches("ent")){
                 Separa[1]= Separa[1].replaceAll(":", "");
                     Data[c_data] = Separa[1] + " db 2,?,2 dup (\"$\"),10,13,\"$\"";
                    c_data++;
                    Code[c_code]="MOV ["+Separa[1]+"+2], 3"+Separa[3]+"h";
                    c_code++;
            }      
            }
            
          if (linea.matches(Gramatica[13])) {
              if(Separa[2].equals("salto:")){
                  Separa[2]= Separa[2].replaceAll(":", "");
                    Code[c_code]="mov Dx, Offset "+Separa[2];
                    c_code++;
                    Code[c_code]="mov Ah, 09h";
                    c_code++; 
                    Code[c_code]="int 21h";
                    c_code++;              
              }
            if(Separa[2].matches(Ids_De)){
                String Tipo="";
                for (int p = 0; p < cont_Ids; p++) {
                                    String Tokens_g[] = Ids_t[p].split("~");
                                    //busc su nombre y extrae su tipo
                                    if (Tokens_g[1].equals(Separa[2])) {
                                      Tipo= Tokens_g[0];
                                    }
                }
            if(Tipo.equals("cadena")){
            Pattern pattern = Pattern.compile(Gramatica[5]);
            Matcher matcher = pattern.matcher(linea);
            if (matcher.find()) {
            Valor_c = matcher.group(0);
            }
            Separa[2]= Separa[2].replaceAll(":", "");
                  
                    Code[c_code]="mov Dx, Offset "+Separa[2];
                    c_code++;
                    Code[c_code]="mov Ah, 09h";
                    c_code++; 
                    Code[c_code]="int 21h";
                    c_code++; 
              // nombre |tipo| valor   |salto de linea                
              //   M2     DB  "MAYOR B" , 10, 13, "$" 
                }
            if(Tipo.equals("ent")){
            Separa[2]= Separa[2].replaceAll(":", "");
                    Code[c_code]="mov Dx, offset ["+Separa[2]+"+2]";
                    c_code++;
                    Code[c_code]="mov Ah, 09h";
                    c_code++; 
                    Code[c_code]="int 21h";
                    c_code++;           
            }
            }else{
            if(Separa[2].matches("[0-9]+")){
                aux="";
                aux=Linea_act+aux;
                Data[c_data] = aux + " db 2,\""+Separa[2]+"\",2 dup (\"$\"),10,13,\"$\"";
                    c_data++;
            Code[c_code]="mov Dx, offset ["+aux+"+1]";
                    c_code++;
                    Code[c_code]="mov Ah, 09h";
                    c_code++; 
                    Code[c_code]="int 21h";
                    c_code++;  
            }else{
            if(Separa[2].matches("[0-9]+.[0-9]+")){
                aux="aux";
                aux=Linea_act+aux;
                Data[c_data] = aux + " db 2,\""+Separa[2]+"\",2 dup (\"$\"),10,13,\"$\"";
                    c_data++;
            Code[c_code]="mov Dx, offset ["+aux+"+1]";
                    c_code++;
                    Code[c_code]="mov Ah, 09h";
                    c_code++; 
                    Code[c_code]="int 21h";
                    c_code++;  
            }}
            }
            
          }
          if (linea.matches(Gramatica[12])) {
              Separa[2]= Separa[2].replaceAll(":", "");
          Code[c_code]="mov Dx, offset "+Separa[2];
                    c_code++;
                    Code[c_code]="mov Ah, 0Ah";
                    c_code++; 
                    Code[c_code]="int 21h";
                    c_code++;  
                    Code[c_code]="MOV AL,["+Separa[2]+"+2]";
                    c_code++;
                    Code[c_code]="MOV ["+Separa[2]+"+2],AL";
                    c_code++;
          }
         
          
          //generador de if
          if (linea.matches(Gramatica[15])) {
          if(!linea.equals("fin_si")){
          fin_if[N]="FIN"+Linea_act+":";
          fin[N]="JMP FIN"+Linea_act;
          N++;
          
          String separa[] = linea.split("\\s");
          
          if(separa[2].matches(Gramatica[1])){
              if(separa[4].matches(Gramatica[1])){
          separa[2]= separa[2].replaceAll(":", "");
          separa[4]= separa[4].replaceAll(":", "");     
          
          Code[c_code]="MOV AH, ["+separa[2]+"+2]";
          c_code++;      
          Code[c_code]="MOV AL, ["+separa[4]+"+2]";
          c_code++;    
          Code[c_code]="CMP AH, AL";
          c_code++; 
          
          if(separa[3].equals(">")){
          Code[c_code]="JA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          if(separa[3].equals("<")){
          Code[c_code]="JB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          if(separa[3].equals("igual")){
          Code[c_code]="JE MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          if(separa[3].equals("<=")){
          Code[c_code]="JNA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
           if(separa[3].equals(">=")){
          Code[c_code]="JNB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
              }
          }
          
          if(separa[2].matches(Gramatica[1])||separa[4].matches("[0-9]+")){
          separa[2]= separa[2].replaceAll(":", "");
             
          
          Code[c_code]="MOV AH, 3"+separa[4]+"h";
          c_code++;      
          Code[c_code]="MOV AL, ["+separa[2]+"+2]";
          c_code++;    
          Code[c_code]="CMP AH, AL";
          c_code++; 
          
          if(separa[3].equals(">")){
          Code[c_code]="JB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          if(separa[3].equals("<")){
          Code[c_code]="JA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          if(separa[3].equals("igual")){
          Code[c_code]="JE MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          if(separa[3].equals("<=")){
          Code[c_code]="JNA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
           if(separa[3].equals(">=")){
          Code[c_code]="JNB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          }
          }
          
          if(separa[2].matches(Gramatica[4])||separa[4].matches(Gramatica[1])){
         
          separa[4]= separa[4].replaceAll(":", "");     
          
          Code[c_code]="MOV AH, ["+separa[4]+"+2]";
          c_code++;      
          Code[c_code]="MOV AL, 3"+separa[2]+"h";
          c_code++;    
          Code[c_code]="CMP AH, AL";
          c_code++; 
          
          if(separa[3].equals(">")){
          Code[c_code]="JB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          if(separa[3].equals("<")){
          Code[c_code]="JA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          if(separa[3].equals("igual")){
          Code[c_code]="JE MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          if(separa[3].equals("<=")){
          Code[c_code]="JNA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
           if(separa[3].equals(">=")){
          Code[c_code]="JNB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          }
          
              }else{
                  //saltos y fin
              Code[c_code]=fin[FO];
              c_code++;
              Code[c_code]=fin_if[FO];
              c_code++;
             FO++;
              
              
              }
          }
          // fin generador if
          
          //inicio generador operaciones
          if (linea.matches(Gramatica[11])&&!linea.matches(Gramatica[9])) {
                   
           if(Separa[2].matches("[0-9]+")){
           Code[c_code]="MOV AL,"+Separa[2];
           c_code++;
           }System.out.println(Separa[2]);
           
           if(Separa[2].matches("[a-z][a-z0-9]*:")){
           Separa[2]= Separa[2].replaceAll(":", "");
           Code[c_code]="ADD ["+Separa[2]+"+2], -30H";
           c_code++;
           Code[c_code]="MOV AL,["+Separa[2]+"+2]";
           c_code++;
           }
           
           if(Separa[4].matches("[a-z][a-z0-9]*:")){
           Separa[4]= Separa[4].replaceAll(":", "");   
           Code[c_code]="ADD ["+Separa[4]+"+2], -30H";
           c_code++;
           Code[c_code]="MOV BL,["+Separa[4]+"+2]";
           c_code++;
           }
           
           if(Separa[4].matches("[0-9]+")){
           Code[c_code]="MOV BL,"+Separa[4];
           c_code++;
           }
           
           if(Separa[2].matches("[0-9]+")){
           Code[c_code]="MOV AL,"+Separa[2];
           c_code++;
           }
           
           if(Separa[4].matches(Gramatica[1])){
           Code[c_code]="ADD ["+Separa[4]+"+2], -30H";
           c_code++;
           Code[c_code]="MOV BL,["+Separa[4]+"+2]";
           c_code++;
           }
           
           if(Separa[3].equals("*")){
           Code[c_code]="MUL BL";
           c_code++;
           }
           
           if(Separa[3].equals("/")){
           Code[c_code]="MOV BH, 0";
           c_code++;    
           Code[c_code]="MOV AH, 0";
           c_code++;   
           Code[c_code]="DIV BL";
           c_code++;
           
           }
           
           if(Separa[3].equals("+")){
           Code[c_code]="ADD AL, BL";
           c_code++;
           }
           
           if(Separa[3].equals("-")){
           Code[c_code]="SUB AL, BL";
           c_code++;
           }
           
          Separa[0]= Separa[0].replaceAll(":", "");
            Code[c_code]="MOV DL, AL";
           c_code++;
            Code[c_code]="ADD DL, 30H";
           c_code++;
            Code[c_code]="MOV ["+Separa[0]+"+2], DL";
           c_code++;
           
           
          }else{
          if (linea.matches(Gramatica[9])) {
             Separa[2]= Separa[2].replaceAll(":", "");
             Separa[0]= Separa[0].replaceAll(":", "");
              if(Separa[2].matches("[0-9]+")){
              Code[c_code]="MOV ["+Separa[0]+"+2], "+Separa[2];
              c_code++;
              }else{
              Code[c_code]="MOV dl, ["+Separa[2]+"+2]";
              c_code++;
              Code[c_code]="MOV ["+Separa[0]+"+2], dl";
              c_code++;
              }
          }
          }
          //FIN OPERACIONES ARITMETICAS
          
          //inicio for
           if (linea.matches(Gramatica[16])) {
          if(!linea.equals("fin_for")){
          fin_for[O]="FIN"+Linea_act+":";
          fin_f[O]="JMP iniciof"+Linea_act;
          O++;
          String separa[] = linea.split("\\s");
          
          if(separa[4].matches(Gramatica[1])){
              if(separa[6].matches(Gramatica[1])){
          separa[4]= separa[4].replaceAll(":", "");
          separa[6]= separa[6].replaceAll(":", "");     
          Code[c_code]="iniciof"+Linea_act+":";
          c_code++; 
          Code[c_code]="MOV AH, ["+separa[4]+"+2]";
          c_code++;      
          Code[c_code]="MOV AL, ["+separa[6]+"+2]";
          c_code++;    
          Code[c_code]="CMP AH, AL";
          c_code++; 
                  System.out.println("holaaaaaaaaaaaaaa");
          if(separa[5].equals(">")){
          Code[c_code]="JA MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          Code[c_code]="ADD ["+separa[4]+"+2], 1";
          c_code++;
          }
          
          if(separa[5].equals("<")){
          Code[c_code]="JB MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          Code[c_code]="ADD ["+separa[4]+"+2], 1";
          c_code++;
          
          }
          if(separa[5].equals("igual")){
          Code[c_code]="JE MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          Code[c_code]="ADD ["+separa[4]+"+2], 1";
          c_code++;
          
          }
          if(separa[5].equals("<=")){
          Code[c_code]="JNA MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          
          }
           if(separa[5].equals(">=")){
          Code[c_code]="JNB MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          
          }
              }
              
          }
          
          if(separa[4].matches(Gramatica[1])||separa[6].matches("[0-9]+")){
          separa[4]= separa[4].replaceAll(":", "");
             
          Code[c_code]="iniciof"+Linea_act+":";
          c_code++; 
          Code[c_code]="MOV AH, 3"+separa[6]+"h";
          c_code++;      
          Code[c_code]="MOV AL, ["+separa[4]+"+2]";
          c_code++;    
          Code[c_code]="CMP AH, AL";
          c_code++; 
          
          if(separa[5].equals(">")){
          Code[c_code]="JB MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          Code[c_code]="ADD ["+separa[4]+"+2], 1";
          c_code++;
          
          }
          
          if(separa[5].equals("<")){
          Code[c_code]="JA MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          Code[c_code]="ADD ["+separa[4]+"+2], 1";
          c_code++;
          
          }
          if(separa[5].equals("igual")){
          Code[c_code]="JE MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          Code[c_code]="ADD ["+separa[4]+"+2], 1";
          c_code++;
          
          if(separa[5].equals("<=")){
          Code[c_code]="JNA MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          
          }
           if(separa[5].equals(">=")){
          Code[c_code]="JNB MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          
          }
          
          }
          }
          
          if(separa[4].matches(Gramatica[6])||separa[6].matches(Gramatica[1])){
         
          separa[6]= separa[6].replaceAll(":", "");     
          Code[c_code]="iniciof"+Linea_act+":";
          c_code++; 
          Code[c_code]="MOV AH, ["+separa[6]+"+2]";
          c_code++;      
          Code[c_code]="MOV AL, 3"+separa[4]+"h";
          c_code++;    
          Code[c_code]="CMP AH, AL";
          c_code++; 
          
          if(separa[5].equals(">")){
          Code[c_code]="JB MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          Code[c_code]="ADD ["+separa[4]+"+2], 1";
          c_code++;
          }
          
          if(separa[5].equals("<")){
          Code[c_code]="JA MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          Code[c_code]="ADD ["+separa[4]+"+2], 1";
          c_code++;
          }
          if(separa[5].equals("igual")){
          Code[c_code]="JE MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          Code[c_code]="ADD ["+separa[4]+"+2], 1";
          c_code++;
          }
          
          if(separa[5].equals("<=")){
          Code[c_code]="JNA MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          
          }
           if(separa[5].equals(">=")){
          Code[c_code]="JNB MAY"+separa[4]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[4]+Linea_act+":";
          c_code++;
          
          }
          
          }
          
              }else{
                  //saltos y fin
              Code[c_code]=fin_f[FOO];
              c_code++;
              Code[c_code]=fin_for[FOO];
              c_code++;
             FOO++;
              
              
              }
          }
           //fin generacion for
          //inicio generacion while
         if (linea.matches(Gramatica[17])) {
          if(!linea.equals("fin_while")){
          fin_whi[P]="FIN"+Linea_act+":";
          fin_w[P]="JMP iniciow"+Linea_act;
          P++;
          
          String separa[] = linea.split("\\s");
          
          if(separa[2].matches(Gramatica[1])){
              if(separa[4].matches(Gramatica[1])){
          separa[2]= separa[2].replaceAll(":", "");
          separa[4]= separa[4].replaceAll(":", "");     
          Code[c_code]="iniciow"+Linea_act+":";
          c_code++; 
          Code[c_code]="MOV AH, ["+separa[2]+"+2]";
          c_code++;      
          Code[c_code]="MOV AL, ["+separa[4]+"+2]";
          c_code++;    
          Code[c_code]="CMP AH, AL";
          c_code++; 
          
          if(separa[3].equals(">")){
          Code[c_code]="JA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          if(separa[3].equals("<")){
          Code[c_code]="JB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          if(separa[3].equals("igual")){
          Code[c_code]="JE MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          if(separa[3].equals("<=")){
          Code[c_code]="JNA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
           if(separa[3].equals(">=")){
          Code[c_code]="JNB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
              }
          }
          
          if(separa[2].matches(Gramatica[1])||separa[4].matches("[0-9]+")){
          separa[2]= separa[2].replaceAll(":", "");
            Code[c_code]="iniciow"+Linea_act+":";
          c_code++;  
          
          Code[c_code]="MOV AH, 3"+separa[4]+"h";
          c_code++;      
          Code[c_code]="MOV AL, ["+separa[2]+"+2]";
          c_code++;    
          Code[c_code]="CMP AH, AL";
          c_code++; 
          
          if(separa[3].equals(">")){
          Code[c_code]="JB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          if(separa[3].equals("<")){
          Code[c_code]="JA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          if(separa[3].equals("igual")){
          Code[c_code]="JE MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          if(separa[3].equals("<=")){
          Code[c_code]="JNA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
           if(separa[3].equals(">=")){
          Code[c_code]="JNB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          }
          }
          
          if(separa[2].matches(Gramatica[4])||separa[4].matches(Gramatica[1])){
         
          separa[4]= separa[4].replaceAll(":", "");     
          Code[c_code]="iniciow"+Linea_act+":";
          c_code++; 
          Code[c_code]="MOV AH, ["+separa[4]+"+2]";
          c_code++;      
          Code[c_code]="MOV AL, 3"+separa[2]+"h";
          c_code++;    
          Code[c_code]="CMP AH, AL";
          c_code++; 
          
          if(separa[3].equals(">")){
          Code[c_code]="JB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          if(separa[3].equals("<")){
          Code[c_code]="JA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          if(separa[3].equals("igual")){
          Code[c_code]="JE MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          if(separa[3].equals("<=")){
          Code[c_code]="JNA MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
           if(separa[3].equals(">=")){
          Code[c_code]="JNB MAY"+separa[2]+Linea_act;
          c_code++; 
          Code[c_code]="JMP FIN"+Linea_act;
              c_code++;
          Code[c_code]="MAY"+separa[2]+Linea_act+":";
          c_code++;
          
          }
          
          }
          
              }else{
                  //saltos y fin
              Code[c_code]=fin_w[POO];
              c_code++;
              Code[c_code]=fin_whi[POO];
              c_code++;
             POO++;
              
              
              }
          }
          //fin generacion while
            } 
        }
    }

    public void imprime_tokens() {
        /*for (int x = 0; x < 20; x++) {
            System.out.println(Gramatica[x]);
        }*/
        if (c_errores != 0) {
            for (int x = 0; x < c_errores; x++) {
                System.out.println(errores_t[x]);
            }
        }
        if (S != 0) {
            for (int x = 0; x < S; x++) {
                System.out.print(Tabla_if[x]);
                System.out.println("");
            }
        }
        if (F != 0) {
            for (int x = 0; x < F; x++) {
                System.out.print(Tabla_for[x]);
                System.out.println("");
            }
        }
        if (W != 0) {
            for (int x = 0; x < W; x++) {
                System.out.print(Tabla_while[x]);
                System.out.println("");
            }
        }

    }
    boolean correcto = true;

    public boolean valida() {
        if (c_errores != 0 || S != 0 || W != 0 || F != 0) {
            correcto = false;
            System.out.println("Este codigo tiene errores no se puede generar lenguaje ensamblador");
        }
        return correcto;
        
    }
    
    public void imprime_Cgenerado() throws IOException{
        File T_genera = new File("src\\analizador_lexico\\Codigo_generado.txt");
        FileWriter fw=new FileWriter(T_genera);
        BufferedWriter bw=new BufferedWriter(fw);
        if(correcto!=false){
            System.out.println("");
            System.out.println("Codigo en lenguaje ensamblador");
            System.out.println("");
            bw.write(""+Cabecera[0]+"\n");
            bw.flush();
            bw.write(""+Cabecera[1]+"\n");
            bw.flush();
            System.out.println(Cabecera[0]);
            System.out.println(Cabecera[1]);
            for(int x=0;x<c_data;x++){
                bw.write(""+Data[x]+"\n");
            bw.flush();
            System.out.println(Data[x]);
            }
            
            for(int x=0;x<c_code;x++){
                 bw.write(""+Code[x]+"\n");
            bw.flush();
            System.out.println(Code[x]);
            }      
                bw.write(""+Cabecera[2]+"\n");
            bw.flush();
            System.out.println(Cabecera[2]);
        }
    }

    public static void main(String[] args) throws IOException {
        int N_lineas = 0, valor = 0;
        //instanciamos un archivo de texto en la ruta de nuestro paquete
        File Texto = new File("src\\analizador_lexico\\Texto_Leer.txt");
        //creamos el archivo de texto
        Texto.createNewFile();
        //variable que guarda la linea en la que se esta trabajando inicia en menos uno para que la primer linea sea 0
        int Errores_Linea = -1;
        // para poder leer
        Scanner leer = new Scanner(System.in);
        //la usamos para hacer la instanciacion y enviar la cadena al metodo
        String Cadena = "";
        //alfabeto valido de mi caso de estudio
        String Alfabeto = "[a-z 0-9 < > = \\+ \\- \\* \\/ \\. \\, \\& ,; ,\\s ,\\( ,\\) ,: ,!, ¡, _ ,\\( ,\\)]";

        //instanciamos el metodo
        Analizador_Lexico E = new Analizador_Lexico();
        //extrae el archivo de texto
        BufferedReader Bre = new BufferedReader(new FileReader(Texto));
        while (Bre.readLine() != null) {
            N_lineas++;
        }
        System.out.println(N_lineas);
        FileReader Fr = new FileReader(Texto);
        //extrae el contenido del archivo de texto y lo lee
        BufferedReader Br = new BufferedReader(Fr);

        //ciclo que trabajara linea a linea hasta que ya no haya mas cadenas con que trabajar
        while (Cadena != null) {
            //aumenta errores para llevar el contador de la linea en que se esta trabajando
            Errores_Linea++;

            //lee el contenido de la linea y lo guarda en la variable cadena
            Cadena = Br.readLine();
            //si cadena es distinto de null entonces
            if (Cadena != null) {
                //imprime la cadena
                System.out.println(Errores_Linea + " " + Cadena);

                //llamamos al metodo para validar que cada caracter pertenezca a nuestro alfabeto y saber en caso contrario en cual caracter esta el error y le enviamos parametros para que trabaje
                E.Valida_caracteres(Cadena, Alfabeto, Errores_Linea);
                E.Sintactico(Cadena, Errores_Linea, N_lineas);
                E.Semantico(Cadena, Errores_Linea);
            }
        }
        //imprimimos los tokens validos y los errores
        E.imprime_tokens();
        //cerramos el archivo de texto
        Br.close();
        int Error_Linea = 0;
        FileReader F = new FileReader(Texto);
        //extrae el contenido del archivo de texto y lo lee
        BufferedReader Ge = new BufferedReader(F);
        E.valida();
        Cadena = "";
        //ciclo que trabajara linea a linea hasta que ya no haya mas cadenas con que trabajar
        while (Cadena != null) {
            //lee el contenido de la linea y lo guarda en la variable cadena
            Cadena = Ge.readLine();
            //si cadena es distinto de null entonces
            if (Cadena != null) {
                E.Generador(Cadena, N_lineas, Error_Linea);
            }
            //aumenta errores para llevar el contador de la linea en que se esta trabajando
            Error_Linea++;
        }
        E.imprime_Cgenerado();

    }
}
