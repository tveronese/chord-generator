package br.com.chordgenerator.generator.notation.ffp;

public class FingerFretString extends FingerFretPosition {

    private Integer string;

    public FingerFretString() {

        this(null, null, null);
    }

    public FingerFretString(Integer finger, Integer fret, Integer string) {

        super(finger, fret);
        this.string = string;
    }

    public Integer getString() {

        return string;
    }

    public void setString(Integer string) {

        this.string = string;
    }

    @Override
    public String toString() {

        return String.format("Finger: %d; Fret: %d; String: %d", getFinger(), getFret(), getString() + 1);
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((string == null) ? 0 : string.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof FingerFretString)) {
            return false;
        }
        FingerFretString other = (FingerFretString) obj;
        if (string == null) {
            if (other.string != null) {
                return false;
            }
        }
        else if (!string.equals(other.string)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(FingerFretPosition other) {

        if (other instanceof FingerBarreFret) {
            return 1;
        }

        if (other instanceof FingerFretString) {
            FingerFretString otherFFS = (FingerFretString) other;
            return this.getString() - otherFFS.getString();
        }

        return 0;
    }

}
