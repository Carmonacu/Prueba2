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
public class Novel extends Book {

    private int nAwards;

    public Novel(String ISBN) {
        super(ISBN);
    }

    public Novel(int nAwards, String ISBN, String title) {
        super(ISBN, title);
        this.nAwards = nAwards;
    }

    public int getnAwards() {
        return nAwards;
    }

    public void setnAwards(int nAwards) {
        this.nAwards = nAwards;
    }

    @Override
    public double ranking(int score) {
        int minimum = (nAwards > 0 ? 2 : 0);
        if ((nAwards > minimum && score < 6)) {
            sumVotes += score;
            ++votes;
        }
        return sumVotes /= votes;
    }
}
