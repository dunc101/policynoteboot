package com.ipacc.policy.note.dao;

import java.util.List;

import com.ipacc.policy.note.domain.Note;

public interface NoteDao {

	public void save(Note note);

	public Note getByPrimaryKey(Note note);

	public List<Note> getByPolicy(Note note);

	public void update(Note note);

	public void delete(Note note);
}
