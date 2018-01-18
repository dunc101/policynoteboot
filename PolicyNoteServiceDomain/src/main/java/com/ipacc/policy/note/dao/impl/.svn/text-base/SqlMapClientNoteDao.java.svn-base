package com.ipacc.policy.note.dao.impl;

import java.util.List;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ipacc.policy.note.dao.NoteDao;
import com.ipacc.policy.note.domain.Note;

public class SqlMapClientNoteDao extends SqlMapClientDaoSupport implements NoteDao {

	public void save(Note note) {
		String policyID = note.getPolicyID();
		if (policyID.length() > 14) {
			getSqlMapClientTemplate().insert("insertTGNote", note);
		} else {
			getSqlMapClientTemplate().insert("insertMFProcNote", note);
		}
	}

	public Note getByPrimaryKey(Note note) {
		Note rtnNote = (Note) getSqlMapClientTemplate().queryForObject("selectTGNoteByPrimaryKey", note);
		if (rtnNote == null) {
			throw new ObjectRetrievalFailureException(Note.class, note.getPolicyID());
		}
		return rtnNote;
	}

	public List<Note> getByPolicy(Note note) {
		if (note.getVersion() > 0) {
			return getSqlMapClientTemplate().queryForList("selectTGNoteForPolicyVersion", note);
		} else {
			return getSqlMapClientTemplate().queryForList("selectTGNoteForPolicyID", note);
		}
	}

	public void update(Note note) {
		getSqlMapClientTemplate().delete("updateTGNote", note);
	}

	public void delete(Note note) {
		getSqlMapClientTemplate().delete("deleteTGNote", note);
	}

}
