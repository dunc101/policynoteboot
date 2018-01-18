package com.ipacc.policy.note.service.impl;

import java.util.Iterator;
import java.util.List;

import com.ipacc.policy.note.dao.NoteDao;
import com.ipacc.policy.note.domain.Note;
import com.ipacc.policy.note.domain.Notes;
import com.ipacc.policy.note.service.NotesService;

public class NotesServiceImpl implements NotesService {

	public void save(Notes notes) throws Exception {
		if (notes.getNotes() != null && !notes.getNotes().isEmpty()) {
			for (Iterator<Note> noteIt = notes.getNotes().iterator(); noteIt.hasNext();) {
				Note note = noteIt.next();
				note.setPolicyID(notes.getPolicyID());
				note.setVersion(notes.getVersion());
				if (note.getUserID() == null) {
					note.setUserID(noteUploaderUserId);
				}
				if (note.getAuthorID() == null) {
					note.setAuthorID(note.getUserID());
				}
				note.setOwnerName(notes.getOwnerName());
				save(note);
			}
		} else {
			throw new Exception("No Notes found.");
		}
	}

	public void save(Note note) {
		this.noteDao.save(note);
	}

	public void update(Note note) {
		this.noteDao.update(note);
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}

	public List<Note> select(Note note) {
		return this.noteDao.getByPolicy(note);
	}

	private NoteDao noteDao;
	private static final String noteUploaderUserId = "NotSvc";

}
