package br.com.chordgenerator.generator.notation.ffp;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.List;

public class FingerBarreFret extends FingerFretPosition {

    private List<FingerFretString> replaced;

    private Integer lastString;

    public FingerBarreFret(Integer finger, Integer fret) {

        super(finger, fret);
        this.replaced = new ArrayList<FingerFretString>();
    }

    @Override
    public String toString() {

        return format("Finger: %d; Barre fret: %d; Last string: %d", getFinger(), getFret(), getLastString() + 1);
    }

    public List<FingerFretString> getReplaced() {

        return replaced;
    }

    public Integer getLastString() {

        return lastString;
    }

    public void addReplacedPositions(List<FingerFretString> list) {

        int maxString = 0;
        for (FingerFretString ffp : list) {

            maxString = Math.max(maxString, ffp.getString());
        }

        this.lastString = maxString;
        this.replaced.addAll(list);
    }

    @Override
    public int compareTo(FingerFretPosition other) {

        if (other instanceof FingerFretString) {
            return -1;
        }

        return 1;
    }

}
