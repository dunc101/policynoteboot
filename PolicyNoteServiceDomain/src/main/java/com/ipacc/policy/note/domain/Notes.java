package com.ipacc.policy.note.domain;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.*;

@Root(strict = false, name = "Notes")
public class Notes extends DataObject {

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@ElementList(required = false, inline = true)
	protected List<Note> notes = new ArrayList<Note>();
}
