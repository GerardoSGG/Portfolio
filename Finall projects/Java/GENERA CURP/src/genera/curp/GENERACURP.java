package genera.curp;

import java.util.*;

public class GENERACURP {

    private String nombre,nombre2;
    private String dia, mes, año, diaa, mesa, añoa;
    private String lugar;
    private String sexo;
    private String homoclave;
    private String curp = "";
    int año2 = 0;

    void formacurp() {
        String fechaa = "";
        int avanza = 0, avanza1 = 0, x, y = 1, avanza2 = 0, avanza3 = 0, avanza4 = 0, avanza5 = 0, aaño = 0, ames = 0, adia = 0;
        Calendar c = Calendar.getInstance();
        Scanner leer = new Scanner(System.in);
        diaa = Integer.toString(c.get(Calendar.DATE));
        mesa = Integer.toString(c.get(Calendar.MONTH));
        añoa = Integer.toString(c.get(Calendar.YEAR));
        aaño = Integer.parseInt(añoa);
        ames = Integer.parseInt(mesa) + 1;
        adia = Integer.parseInt(diaa);
        fechaa = fechaa + aaño + ames + adia;
        String fecha2 = "2017130";
        // si la fecha2 es mayor que fechaa entonces:
        if (fecha2.equals(fechaa)) {
            System.out.println("la fecha que escribiste es mayor" + fecha2);
        } else {
            System.out.println("LA FECHA QUE INTRODUJISTE ES menor LA FECHA ACTUAL" + fechaa);
        }
        System.out.println("fecha actual " + fechaa + "fecha" + fecha2);
        //esta parte pide y valida el nombre
        while (avanza == 0) {
            System.out.println("ESCRIBE TU NOMBRE INICIANDO POR APELLIDOS");
            nombre = leer.nextLine();
            nombre = nombre.toUpperCase();
            if (!nombre.matches("[a-z A-Z \\s ñ Ñ ]*")) {
                System.err.println("SU NOMBRE ESTA MAL ESCRITO ESCRIBALO NUEVAMENTE POR FAVOR RECUERDE USAR SOLO LETRAS SI SU NOMBRE CONTIENE LETRAS Ñ FAVOR DE CAMBIARLAS POR X ");
                System.err.println("POR EJEMPLO: IBAÑEZ = IBAXEZ  :::::::: XARIÑANA = XARIXANA");
            } else {
                nombre2=nombre;
                String nombreArray[] = nombre.split(" ");
                curp = curp + (nombreArray[0].charAt(0));
                String apellido2 = nombreArray[0];
                if (y == 1) {
                    for (x = 0; x < apellido2.length(); x++) {
                        String l2 = "";
                        l2 = l2 + apellido2.charAt(x);
                        if (l2.matches("[A E I O U]*")) {
                            curp = curp + l2;
                            y = y + 1;
                            x = apellido2.length();
                        }
                    }
                }

                curp = curp + nombreArray[1].charAt(0);
                curp = curp + nombreArray[2].charAt(0);
                System.out.println("SU NOMBRE ESTA BIEN ESCRITO SIGAMOS ");
                avanza++;
            }
        }
//aqui inicia la fecha de nacimiento
        while (avanza1 == 0) {
            System.out.println("ESCRIBE TU AÑO DE NACIMIENTO CON 4 CARACTERES");
            System.err.println("EJEMPLO: 1997");
            año = leer.nextLine();
            int tam = año.length();
            while (4 == tam) {
                tam++;
                try {
                    año2 = Integer.parseInt(año);
                    if ((año2 < (aaño + 1)) && (año2 > 1900)) {
                        avanza1++;
                    } else {
                        System.out.println("SU AÑO DE NACIMIENTO NO ESTA DENTRO DEL MARGEN A MENOS QUE PROVENGA DEL FUTURO O TENGA MAS DE 117 AÑOS xD");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO NUMEROS POR FAVOR");
                }
                System.out.println("AÑO" + año);
            }

            if ((año2 % 4) == 0) {

                System.out.println("ES BICIESTO");
            } else {
                System.out.println("NO ES BICIESTO");
            }
        }
        while (avanza2 == 0) {
            String opc;
            int opc1 = 0;
            int dias = 0;
            System.out.println("SELECCIONE SU MES DE NACIMIENTO");
            System.out.println("1-ENERO   :: 7-JULIO");
            System.out.println("2-FEBRERO :: 8-AGOSTO");
            System.out.println("3-MARZO   :: 9-SEPTIEMBRE");
            System.out.println("4-ABRIL   :: 10-OCTUBRE");
            System.out.println("5-MAYO    :: 11-NOVIEMBRE");
            System.out.println("6-JUNIO   :: 12-DICIEMBRE");
            opc = leer.nextLine();
            try {
                opc1 = Integer.parseInt(opc);
                if (opc1 < 13 && opc1 > 0) {
                    avanza2++;
                } else {
                    System.err.println("TIPO DATO NO VALIDO SELECCIONE UN NUMERO DE LA LISTA POR FAVOR");
                }
            } catch (NumberFormatException e) {
                System.err.println("TIPO DATO NO VALIDO SELECCIONE UN NUMERO DE LA LISTA POR FAVOR");
            }

            switch (opc1) {
                case 1: {
                    mes = "01";
                    if (opc1 == ames) {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia) {
                                        if (dias < 32) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("ENERO SOLO TIENE 31 DIAS ESCRIBA");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 32) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("ENERO SOLO TIENE 31 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    mes = "02";
                    if (opc1 == ames) {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);

                                    if (año2 % 4 == 0) {
                                        if (dias < adia) {
                                            if (dias < 30) {
                                                avanza3++;
                                                System.out.println("MUY BIEN SIGAMOS");
                                            } else {
                                                System.out.println("FEBRERO SOLO TIENE 29 DIAS EN AÑO BICIESTO");
                                            }

                                            if (dias < 29) {
                                                avanza3++;
                                                System.out.println("MUY BIEN SIGAMOS");
                                            } else {
                                                System.err.println("FEBRERO SOLO TIENE 28 DIAS EN AÑO NO BICIESTO");
                                            }
                                        } else {
                                            System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (año2 % 4 == 0) {
                                        if (dias < 30) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.out.println("FEBRERO SOLO TIENE 29 DIAS EN AÑO BICIESTO");
                                        }
                                    } else {
                                        if (dias < 29) {
                                        } else {
                                            System.err.println("FEBRERO SOLO TIENE 28 DIAS EN AÑO NO BICIESTO");
                                        }
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 3: {
                    mes = "03";
                    if (opc1 == ames) {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia + 1) {
                                        if (dias < 32) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("MARZO SOLO TIENE 31 DIAS ");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 32) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("MARZO SOLO TIENE 31 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    mes = "04";
                    if (opc1 == ames) {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia + 1) {
                                        if (dias < 31) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("ABRIL SOLO TIENE 30 DIAS ");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 31) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("ABRIL SOLO TIENE 30 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    mes = "05";
                    if (opc1 == ames) {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia + 1) {
                                        if (dias < 32) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("MAYO SOLO TIENE 31 DIAS ");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 32) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("MAYO SOLO TIENE 31 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 6: {
                    mes = "06";
                    if (opc1 == ames) { //esto nos valida si el mes es igual al mes actual
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia + 1) {
                                        if (dias < 31) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("JUNIO SOLO TIENE 30 DIAS ");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 31) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("JUNIO SOLO TIENE 30 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 7: {
                    mes = "07";
                    if (opc1 == ames) { //esto nos valida si el mes es igual al mes actual
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia + 1) {
                                        if (dias < 32) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("JULIO SOLO TIENE 31 DIAS ");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 32) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("JULIO SOLO TIENE 31 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 8: {
                    mes = "08";
                    if (opc1 == ames) { //esto nos valida si el mes es igual al mes actual
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia + 1) {
                                        if (dias < 32) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("AGOSTO SOLO TIENE 31 DIAS ");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 32) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("AGOSTO SOLO TIENE 31 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 9: {
                    mes = "09";
                    if (opc1 == ames) { //esto nos valida si el mes es igual al mes actual
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia + 1) {
                                        if (dias < 31) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("SEPTIEMBRE SOLO TIENE 30 DIAS ");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 31) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("SEPTIEMBRE SOLO TIENE 30 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 10: {
                    mes = "10";
                    if (opc1 == ames) { //esto nos valida si el mes es igual al mes actual
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia + 1) {
                                        if (dias < 32) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("OCTUBRE SOLO TIENE 31 DIAS ");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 32) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("OCTUBRE SOLO TIENE 31 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 11: {
                    mes = "11";
                    if (opc1 == ames) { //esto nos valida si el mes es igual al mes actual
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia + 1) {
                                        if (dias < 31) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("NOVIEMBRE SOLO TIENE 30 DIAS ");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 31) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("NOVIEMBRE SOLO TIENE 30 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }
                case 12: {
                    mes = "12";
                    if (opc1 == ames) { //esto nos valida si el mes es igual al mes actual
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < adia + 1) {
                                        if (dias < 32) {
                                            avanza3++;
                                            System.out.println("MUY BIEN SIGAMOS");
                                        } else {
                                            System.err.println("DICIEMBRE SOLO TIENE 31 DIAS ");
                                        }
                                    } else {
                                        System.out.println("ESTE DIA AUN NO EXISTE USTED PROVIENE DEL FUTURO??? ");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    } else {
                        while (avanza3 == 0) {

                            System.out.println("ESCRIBA SU DIA DE NACIMIENTO CON DOS NUMEROS POR FAVOR");
                            System.out.println("EJEMPLO: 01 ,02,03,04.........29,30,31");
                            dia = leer.nextLine();
                            int tam1 = dia.length();
                            while (2 == tam1) {
                                tam1++;
                                try {
                                    dias = Integer.parseInt(dia);
                                    if (dias < 32) {
                                        avanza3++;
                                        System.out.println("MUY BIEN SIGAMOS");
                                    } else {
                                        System.err.println("DICIEMBRE SOLO TIENE 31 DIAS ESCRIBA");
                                    }
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
                        }
                    }
                    break;
                }

            }

        }
        //aqui termina la fecha de nacimiento
        //aqui inicia el sexo xD
        while (avanza4 == 0) {
            String opc2;
            int opc3 = 0;
            System.out.println("SELECCIONE SU SEXO");
            System.out.println("1-MUJER");
            System.out.println("2-HOMBRE");
            opc2 = leer.nextLine();
            try {
                opc3 = Integer.parseInt(opc2);
            } catch (NumberFormatException e) {
                System.err.println("TIPO DATO NO VALIDO SELECCIONE UN NUMERO DE LA LISTA POR FAVOR");
            }
            switch (opc3) {
                case 1: {
                    sexo = "M";
                    curp = curp + año.charAt(2) + año.charAt(3) + mes + dia + sexo;
                    avanza4++;
                    break;

                }
                case 2: {
                    sexo = "H";
                    curp = curp + año.charAt(2) + año.charAt(3) + mes + dia + sexo;
                    avanza4++;
                }

            }
        }
        //aqui termina el sexo :(
        //aqui inicia el estado
        while (avanza5 == 0) {
            String opc4;
            int opc = 0;
            System.out.println("SELECCIONE SU ESTADO");
            System.out.println("1-AGUAS CALIENTES :: 2-BAJA CALIFORNIA :: 3-COAHUILA :: 4-CHIAPAS     :: 5-DISTRITO FEDERAL :: 6-GUANAJUATO ");
            System.out.println("7-HIDALGO         :: 8-MEXICO          :: 9-MORELOS  :: 10-NUEVO LEON :: 11-PUEBLA          :: 12-QUINTANA ROO");
            System.out.println("13-SINALOA        :: 14-TABASCO        :: 15-TLAXCALA:: 16-YUCATAN    :: 17-BAJA CALIFORNIA :: 18-CAMPECHE ");
            System.out.println("19-COLIMA         :: 20-CHIHUAHUA      :: 21-DURANGO :: 22-GUERRERO   :: 23-JALISCO         :: 24-MICHOACAN");
            System.out.println("25-NAYARIT        :: 26-OAXACA         ::27-QUERETARO:: 28-SAN LUIS POTOSI :: 29-SONORA     :: 30-TAMAULIPAS ");
            System.out.println("31-TAMAULIPAS     :: 32-VERACRUZ       :: 33-ZACATECAS:: 34-NACIDO EN EL EXTRANJERO");
            opc4 = leer.nextLine();
            try {
                opc = Integer.parseInt(opc4);
            } catch (NumberFormatException e) {
                System.err.println("TIPO DATO NO VALIDO SELECCIONE UN NUMERO DE LA LISTA POR FAVOR");
            }
            switch (opc) {
                case 1: {
                    curp = curp + "AS";
                    avanza5++;
                    break;

                }
                case 2: {
                    curp = curp + "BS";
                    avanza5++;
                }
                case 3: {
                    curp = curp + "CL";
                    avanza5++;
                    break;

                }
                case 4: {
                    curp = curp + "CS";
                    avanza5++;
                    break;

                }
                case 5: {
                    curp = curp + "DF";
                    avanza5++;
                    break;

                }
                case 6: {
                    curp = curp + "GT";
                    avanza5++;
                    break;

                }
                case 7: {
                    curp = curp + "HG";
                    avanza5++;
                    break;

                }
                case 8: {
                    curp = curp + "MC";
                    avanza5++;
                    break;

                }
                case 9: {
                    curp = curp + "MS";
                    avanza5++;
                    break;

                }
                case 10: {
                    curp = curp + "NL";
                    avanza5++;
                    break;

                }
                case 11: {
                    curp = curp + "PL";
                    avanza5++;
                    break;

                }
                case 12: {
                    curp = curp + "QR";
                    avanza5++;
                    break;

                }
                case 13: {
                    curp = curp + "SL";
                    avanza5++;
                    break;

                }
                case 14: {
                    curp = curp + "TC";
                    avanza5++;
                    break;

                }
                case 15: {
                    curp = curp + "TL";
                    avanza5++;
                    break;

                }
                case 16: {
                    curp = curp + "YN";
                    avanza5++;
                    break;

                }
                case 17: {
                    curp = curp + "BC";
                    avanza5++;
                    break;

                }
                case 18: {
                    curp = curp + "CC";
                    avanza5++;
                    break;

                }
                case 19: {
                    curp = curp + "CM";
                    avanza5++;
                    break;

                }
                case 20: {
                    curp = curp + "CH";
                    avanza5++;
                    break;

                }
                case 21: {
                    curp = curp + "DG";
                    avanza5++;
                    break;

                }
                case 22: {
                    curp = curp + "GR";
                    avanza5++;
                    break;

                }
                case 23: {
                    curp = curp + "JC";
                    avanza5++;
                    break;

                }
                case 24: {
                    curp = curp + "MN";
                    avanza5++;
                    break;

                }
                case 25: {
                    curp = curp + "NT";
                    avanza5++;
                    break;

                }
                case 26: {
                    curp = curp + "OC";
                    avanza5++;
                    break;

                }
                case 27: {
                    curp = curp + "QT";
                    avanza5++;
                    break;

                }
                case 28: {
                    curp = curp + "SP";
                    avanza5++;
                    break;

                }
                case 29: {
                    curp = curp + "SR";
                    avanza5++;
                    break;

                }
                case 30: {
                    curp = curp + "TS";
                    avanza5++;
                    break;

                }
                case 31: {
                    curp = curp + "VZ";
                    avanza5++;
                    break;

                }
                case 32: {
                    curp = curp + "ZS";
                    avanza5++;
                    break;

                }
                case 33: {
                    curp = curp + "NE";
                    avanza5++;
                    break;

                }
            }
        }
// AQUI TERMINA EL ESTADO
System.out.println(nombre2);
        int w=0, z=0,g=0;
        String nombre1Array[] = nombre2.split(" ");
        String apellido2 = nombre1Array[0];
        while(w == 0) {
                    for (x = 1; x < apellido2.length(); x++) {
                        String l2 = "";
                        l2 = l2 + apellido2.charAt(x);
                        if (l2.matches("[B C D F G H J K L M N P Q R S T V W X Y Z]*")) {
                            curp = curp + l2;
                            w= w + 1;
                            x = apellido2.length()+1;
                        }
                    }
                }
        String apellido3 = nombre1Array[1];
        while (z == 0) {
                    for (x = 1; x < apellido3.length(); x++) {
                        String l2 = "";
                        l2 = l2 + apellido3.charAt(x);
                        if (l2.matches("[B C D F G H J K L M N P Q R S T V W X Y Z]*")) {
                            curp = curp + l2;
                            z = z + 1;
                            x = apellido2.length()+1;
                        }
                    }
                }
        String apellido4 = nombre1Array[2];
        while (g == 0) {
                    for (x = 1; x < apellido4.length(); x++) {
                        String l2 = "";
                        l2 = l2 + apellido4.charAt(x);
                        if (l2.matches("[B C D F G H J K L M N P Q R S T V W X Y Z]*")) {
                            curp = curp + l2;
                            g = g + 1;
                            x = apellido2.length()+1;
                        }
                    }
                }
//AQUI INICIA LA HOMOCLAVE
int avanza6=0,h;
while(avanza6==0){
    System.out.println("ESCRIBA SU HOMOCLAVE DE 2 NUEROS POR FAVOR");
    homoclave=leer.nextLine();
                       int tam2 = homoclave.length();
                            while (2 == tam2) {
                                tam2++;
                                try {
                                    h = Integer.parseInt(homoclave);
                                            avanza6++;
                                            curp=curp+homoclave;
                                            System.out.println("MUY BIEN SIGAMOS");
                                } catch (NumberFormatException e) {
                                    System.err.println("TIPO DATO NO VALIDO ESCRIBA SOLO 2 NUMEROS POR FAVOR");
                                }
                            }
}
//aqui termina la homoclave
        System.err.println("SU CURP ES: " + curp);
    }
    

    public static void main(String[] args) {
        GENERACURP este = new GENERACURP();
        este.formacurp();
    }

}
