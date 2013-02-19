package br.com.chordgenerator.generator;

import java.util.Arrays;
import java.util.List;

public class Chord {

	private List<Note> notes;

	public Chord(Note... notes) {

		this.notes = Arrays.asList(notes);
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
