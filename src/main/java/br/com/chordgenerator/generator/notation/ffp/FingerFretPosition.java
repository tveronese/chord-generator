package br.com.chordgenerator.generator.notation.ffp;

public abstract class FingerFretPosition implements Comparable<FingerFretPosition> {

    private Integer finger;

    private Integer fret;

    public FingerFretPosition(Integer finger, Integer fret) {

        this.finger = finger;
        this.fret = fret;
    }

    public Integer getFinger() {

        return finger;
    }

    public void setFinger(Integer finger) {

        this.finger = finger;
    }

    public Integer getFret() {

        return fret;
    }

    public void setFret(Integer fret) {

        this.fret = fret;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((finger == null) ? 0 : finger.hashCode());
        result = prime * result + ((fret == null) ? 0 : fret.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof FingerFretPosition)) {
            return false;
        }
        FingerFretPosition other = (FingerFretPosition) obj;
        if (finger == null) {
            if (other.finger != null) {
                return false;
            }
        }
        else if (!finger.equals(other.finger)) {
            return false;
        }
        if (fret == null) {
            if (other.fret != null) {
                return false;
            }
        }
        else if (!fret.equals(other.fret)) {
            return false;
        }
        return true;
    }

}
