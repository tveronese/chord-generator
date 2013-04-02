package br.com.chordgenerator.generator.notation.ffp;

import java.util.ArrayList;
import java.util.List;
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

	public int getMinimumFret(boolean ignoreFretZero) {

		int minFret = 100;
		for (FingerFretPosition ffp : this.getPositions()) {

			Integer fret = ffp.getFret();
			boolean fretZero = fret == 0;
			if (!ignoreFretZero || !fretZero) {
				minFret = Math.min(minFret, fret);
			}
		}

		return minFret;
	}

	public int getMaximumFret() {

		int maxFret = 0;
		for (FingerFretPosition ffp : this.getPositions()) {
			maxFret = Math.max(maxFret, ffp.getFret());
		}

		return maxFret;
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

	@Override
	public int compareTo(PositionalNotation o) {

		if (!(o instanceof FFSNotation)) {
			return 1;
		}

		FFSNotation other = (FFSNotation) o;

		int minimumFret = this.getMinimumFret(false);
		int minimumFretOther = other.getMinimumFret(false);
		if (minimumFret != minimumFretOther) {
			return minimumFret - minimumFretOther;
		}

		int thisDistance = this.getMaximumFret() - minimumFret;
		int otherDistance = other.getMaximumFret() - minimumFretOther;
		if (thisDistance != otherDistance) {
			return thisDistance - otherDistance;
		}

		if (this.hasBarreFret()) {
			return -1;
		}
		else if (other.hasBarreFret()) {
			return 1;
		}

		int thisStrings = this.getPositions().size();
		int otherStrings = other.getPositions().size();
		if (thisStrings != otherStrings) {
			return thisStrings - otherStrings;
		}

		return 0;
	}

	private boolean hasBarreFret() {

		for (FingerFretPosition ffp : getPositions()) {

			if (ffp instanceof FingerBarreFret) {
				return true;
			}
		}

		return false;
	}

	public int getNumberOfFingersNeeded() {

		int fingersNeeded = 0;
		for (FingerFretPosition ffp : this.getPositions()) {
			if (ffp.getFret() != 0) {
				fingersNeeded++;
			}
		}

		return fingersNeeded;
	}

	public List<FingerFretString> getPositionsAtFret(Integer minFret) {

		List<FingerFretString> positions = new ArrayList<FingerFretString>();
		for (FingerFretPosition ffp : this.getPositions()) {

			if (!(ffp instanceof FingerFretString)) {
				continue;
			}

			FingerFretString ffs = (FingerFretString) ffp;
			if (ffs.getFret().equals(minFret)) {
				positions.add(ffs);
			}
		}

		return positions;
	}

}
