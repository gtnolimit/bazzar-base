package com.bazzar.base.domain.lookup;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOOOKUP_NOTETYPE")
public class NoteTypeLookup extends AbstractLookupType  {

private static final long serialVersionUID = 3212625355790851086L;
	
	public static final NoteTypeLookup OR = createConstant("OR", "ORDER NOTE", NoteTypeLookup.class);
	public static final NoteTypeLookup OCL = createConstant("OCL", "ORDER CANCEL NOTE", NoteTypeLookup.class);
	
	@Id
    @Column(name="CODE")
    @Override
    public String getCode() {
        return super.getCode();
    }

    @Column(name="DESCRIPTION")
    @Override
    public String getDescription() {
        return super.getDescription();
    }
}
