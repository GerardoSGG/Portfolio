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
 int tama�o;
 public cola(){
 inicio=null;
 fin=null;
 tama�o=0;
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
 tama�o++;
 }
 public int quitar(){
 int aux=inicio.dato;
 inicio=inicio.siguiente;
 tama�o--;
 return aux;
 }
 public int iniciocola(){
 return inicio.dato;
 }
 public int tama�ocola(){
 return tama�o;
 }
}
