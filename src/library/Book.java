/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Objects;

/**
 *
 * @author carmo
 */
public abstract class Book implements Comparable { //abstracta porque no crearemos un libro como tal si no un drama o una novela
    //implementamos la interfaz comparable para poder acceder al metodo compareTo

    private String ISBN;
    private String title;
    protected double sumVotes = 0;    //por que es protected
    protected int votes = 0;                  //con protected el constructor por defecto no los trae
    private State state = State.LIBRARY;  //state del libro que puede estar en prestamo, etc

    //constructores de menor a mayor siempre
    public Book(String ISBN) {      //constructor solo con el ISBN para crear un libro y buscarlo mediante ISBN
        this.ISBN = ISBN;
    }

    public Book(String ISBN, String title) {    //constructor general
        this.ISBN = ISBN;
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract double ranking(int score);  //se desarrolla luego en casa clase pero lo ponemos aqui para obligar a tenerlo a las clases hijas       

    @Override
    public boolean equals(Object o) {   //metodo equals necesario ademas de compareTo?
        if (this == o) {                                //si es igual al objeto que le pasamos como parámetro pos true
            return true;
        }
        if (o == null) {                                //si el objeto que le pasamos como parametro es nulo pos falso
            return false;
        }
        if (getClass() != o.getClass()) {           //si tienen diferente clase, novela o drama
            return false;
        }
        final Book other = (Book) o;          //crea "otro" libro con el objeto que le pasas como parametro. dos libros iguales?
        if (!Objects.equals(this.ISBN, other.ISBN)) {     //le paso ambos objetos al equals por defecto para comparar sus isbn
            return false;                                           //se lo paso al equals por defecto para poder comparar 2 pasandoselo por parametro?
        }
        return true;
    }

    @Override
    public String toString() {              //toString que poner el nombre de la clase (novela o drama) isbn y titulo
        return getClass().getSimpleName() + " {ISBN=" + ISBN + ", title=" + title + "}";
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int compareTo(Object t) {         //comparación por titulo
        Book b = (Book) t;
        return this.title.compareToIgnoreCase(b.title);
    }

}
