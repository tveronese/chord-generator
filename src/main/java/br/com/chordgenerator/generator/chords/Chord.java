package br.com.chordgenerator.generator.chords;

import java.util.ArrayList;
import java.util.List;

import br.com.chordgenerator.generator.Note;

public abstract class Chord {

	protected static final Integer TONE = 2;

	protected static final Integer SEMITONE = 1;

	private Note root;

	private List<Note> notes;

	public Chord(Note root, Integer... offsets) {

		this.root = root;
		this.notes = new ArrayList<Note>();
		this.notes.add(root);

		Note currentNote = root;
		for (Integer offset : offsets) {

			currentNote = currentNote.getRespectiveNote(offset);
			this.notes.add(currentNote);
		}
	}

	public Chord(List<Note> notes) {

		this.notes = notes;
	}

	public List<Note> getNotes() {

		return notes;
	}

	public Note getRoot() {

		return root;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (Note note : getNotes()) {
			sb.append(note.getRepresentation() + "\t");
		}

		return sb.toString();
	}

}
