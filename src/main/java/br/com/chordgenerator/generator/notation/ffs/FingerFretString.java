package br.com.chordgenerator.generator.notation.ffs;

public class FingerFretString {

	private Finger finger;

	private Integer fret;

	private Integer string;

	public FingerFretString() {

		this(null, null, null);
	}

	public FingerFretString(Finger finger, Integer fret, Integer string) {

		this.finger = finger;
		this.fret = fret;
		this.string = string;
	}

	public Finger getFinger() {

		return finger;
	}

	public void setFinger(Finger finger) {

		this.finger = finger;
	}

	public Integer getFret() {

		return fret;
	}

	public void setFret(Integer fret) {

		this.fret = fret;
	}

	public Integer getString() {

		return string;
	}

	public void setString(Integer string) {

		this.string = string;
	}

	@Override
	public String toString() {

		return String.format("Finger: %s; Fret: %d; String: %d", finger.name(), fret, string + 1);
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((finger == null) ? 0 : finger.hashCode());
		result = prime * result + ((fret == null) ? 0 : fret.hashCode());
		result = prime * result + ((string == null) ? 0 : string.hashCode());
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
		if (getClass() != obj.getClass()) {
			return false;
		}
		FingerFretString other = (FingerFretString) obj;
		if (finger != other.finger) {
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

}
