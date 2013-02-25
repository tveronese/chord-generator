package br.com.chordgenerator.generator.chords;

import java.util.ArrayList;
import java.util.List;

import br.com.chordgenerator.generator.Note;

public abstract class Chord {

	protected static final Integer tone = 2;

	protected static final Integer semitone = 1;

	private List<Note> notes;

	public Chord() {

		this.notes = new ArrayList<Note>();
	}

	public Chord(List<Note> notes) {

		this.notes = notes;
	}

	public void addNote(Note note) {

		this.notes.add(note);
	}

	public List<Note> getNotes() {

		return notes;
	}

	public void setNotes(List<Note> notes) {

		this.notes = notes;
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
