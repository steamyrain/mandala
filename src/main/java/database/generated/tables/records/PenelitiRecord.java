/*
 * This file is generated by jOOQ.
*/
package database.generated.tables.records;


import database.generated.tables.Peneliti;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PenelitiRecord extends UpdatableRecordImpl<PenelitiRecord> implements Record4<Integer, Integer, String, byte[]> {

    private static final long serialVersionUID = 1416583590;

    /**
     * Setter for <code>Peneliti.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>Peneliti.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Peneliti.ROLEID</code>.
     */
    public void setRoleid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>Peneliti.ROLEID</code>.
     */
    public Integer getRoleid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>Peneliti.BIO</code>.
     */
    public void setBio(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>Peneliti.BIO</code>.
     */
    public String getBio() {
        return (String) get(2);
    }

    /**
     * Setter for <code>Peneliti.PICTURE</code>.
     */
    public void setPicture(byte... value) {
        set(3, value);
    }

    /**
     * Getter for <code>Peneliti.PICTURE</code>.
     */
    public byte[] getPicture() {
        return (byte[]) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, String, byte[]> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, String, byte[]> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Peneliti.PENELITI.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Peneliti.PENELITI.ROLEID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Peneliti.PENELITI.BIO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field4() {
        return Peneliti.PENELITI.PICTURE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getRoleid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getBio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] component4() {
        return getPicture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getRoleid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getBio();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] value4() {
        return getPicture();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PenelitiRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PenelitiRecord value2(Integer value) {
        setRoleid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PenelitiRecord value3(String value) {
        setBio(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PenelitiRecord value4(byte... value) {
        setPicture(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PenelitiRecord values(Integer value1, Integer value2, String value3, byte[] value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PenelitiRecord
     */
    public PenelitiRecord() {
        super(Peneliti.PENELITI);
    }

    /**
     * Create a detached, initialised PenelitiRecord
     */
    public PenelitiRecord(Integer id, Integer roleid, String bio, byte[] picture) {
        super(Peneliti.PENELITI);

        set(0, id);
        set(1, roleid);
        set(2, bio);
        set(3, picture);
    }
}
