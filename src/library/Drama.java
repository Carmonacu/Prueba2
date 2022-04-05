/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author carmo
 */
public class Drama extends Book {

    private String pTheater;

    public Drama(String ISBN) {
        super(ISBN);
    }

    public Drama(String ISBN, String title) {
        super(ISBN, title);
    }

    public Drama(String pTheater, String ISBN, String title) {
        super(ISBN, title);
        this.pTheater = pTheater;
    }

    public String getpTheater() {
        return pTheater;
    }

    @Override
    public String toString() {
        return super.toString() + " Premiere Theatre=" + pTheater; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double ranking(int score) {      //debe de estar entre 1 y 5 , añado nueva votacion al monto y un voto mas
        if (score > 0 && score < 6) {
            sumVotes += score;
            ++votes;
        }
        return sumVotes /= votes;
    }

}
