package br.com.chordgenerator.generator.notation.ffs;

import java.util.ArrayList;
import java.util.List;

import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;

public class FFSNotation extends PositionalNotation {

	private List<FingerFretString> positions;

	public FFSNotation(Chord chord) {

		super(chord);
		this.positions = new ArrayList<>();
	}

	public List<FingerFretString> getPositions() {

		return positions;
	}

	public void setPositions(List<FingerFretString> positions) {

		this.positions = positions;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (FingerFretString ffs : getPositions()) {
			sb.append(ffs + "\n");
		}

		return sb.toString();
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((positions == null) ? 0 : positions.hashCode());
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
		FFSNotation other = (FFSNotation) obj;
		if (positions == null) {
			if (other.positions != null) {
				return false;
			}
		}
		else if (!positions.equals(other.positions)) {
			return false;
		}
		return true;
	}

}
