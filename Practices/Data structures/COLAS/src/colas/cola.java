/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author mi bodega poncitlan
 */
public class cola {
 nodocola inicio,fin;
 int tamaño;
 public cola(){
 inicio=null;
 fin=null;
 tamaño=0;
 }

 public boolean colavacia(){
 return inicio==null;
 }
 public void insertar(int elemento){
 nodocola nuevo=new nodocola(elemento);
 if(colavacia()){
     inicio=nuevo;
     
     
 }else{fin.siguiente=nuevo;}
 
 fin=nuevo;
 tamaño++;
 }
 public int quitar(){
 int aux=inicio.dato;
 inicio=inicio.siguiente;
 tamaño--;
 return aux;
 }
 public int iniciocola(){
 return inicio.dato;
 }
 public int tamañocola(){
 return tamaño;
 }
}
