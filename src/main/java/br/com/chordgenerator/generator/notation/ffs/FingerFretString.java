package br.com.chordgenerator.generator.notation.ffs;

public class FingerFretString {

	private Finger finger;

	private Integer fret;

	private Integer string;

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

		return String.format("Finger: %s; Fret: %d; String: %d.", finger.name(), fret, string + 1);
	}

}
