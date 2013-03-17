package br.com.chordgenerator.generator.notation.ffp;

import java.util.Set;
import java.util.TreeSet;

import br.com.chordgenerator.generator.chords.Chord;
import br.com.chordgenerator.generator.notation.PositionalNotation;

public class FFSNotation extends PositionalNotation {

	private Set<FingerFretPosition> positions;

	public FFSNotation(Chord chord) {

		super(chord);
		this.positions = new TreeSet<FingerFretPosition>();
	}

	public Set<FingerFretPosition> getPositions() {

		return positions;
	}

	public void setPositions(Set<FingerFretPosition> positions) {

		this.positions = positions;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (FingerFretPosition ffs : getPositions()) {
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
