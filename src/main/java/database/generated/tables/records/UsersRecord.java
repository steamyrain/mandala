/*
 * This file is generated by jOOQ.
*/
package database.generated.tables.records;


import database.generated.tables.Users;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record5<Integer, String, String, String, Integer> {

    private static final long serialVersionUID = 1297359763;

    /**
     * Setter for <code>Users.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>Users.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Users.EMAIL</code>.
     */
    public void setEmail(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>Users.EMAIL</code>.
     */
    public String getEmail() {
        return (String) get(1);
    }

    /**
     * Setter for <code>Users.FIRSTNAME</code>.
     */
    public void setFirstname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>Users.FIRSTNAME</code>.
     */
    public String getFirstname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>Users.LASTNAME</code>.
     */
    public void setLastname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>Users.LASTNAME</code>.
     */
    public String getLastname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>Users.COUNTRYID</code>.
     */
    public void setCountryid(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>Users.COUNTRYID</code>.
     */
    public Integer getCountryid() {
        return (Integer) get(4);
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
    // Record5 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row5<Integer, String, String, String, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Users.USERS.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Users.USERS.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Users.USERS.FIRSTNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Users.USERS.LASTNAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field5() {
        return Users.USERS.COUNTRYID;
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
    public String component2() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getFirstname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getLastname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component5() {
        return getCountryid();
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
    public String value2() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getFirstname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getLastname();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value5() {
        return getCountryid();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value2(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value3(String value) {
        setFirstname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value4(String value) {
        setLastname(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord value5(Integer value) {
        setCountryid(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UsersRecord values(Integer value1, String value2, String value3, String value4, Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Integer id, String email, String firstname, String lastname, Integer countryid) {
        super(Users.USERS);

        set(0, id);
        set(1, email);
        set(2, firstname);
        set(3, lastname);
        set(4, countryid);
    }
}