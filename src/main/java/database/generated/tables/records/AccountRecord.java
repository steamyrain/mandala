/*
 * This file is generated by jOOQ.
*/
package database.generated.tables.records;


import database.generated.tables.Account;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
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
public class AccountRecord extends UpdatableRecordImpl<AccountRecord> implements Record9<Integer, byte[], String, String, String, String, Integer, Integer, Integer> {

    private static final long serialVersionUID = 316078792;

    /**
     * Setter for <code>Account.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>Account.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Account.USER_TYPE</code>.
     */
    public void setUserType(byte... value) {
        set(1, value);
    }

    /**
     * Getter for <code>Account.USER_TYPE</code>.
     */
    public byte[] getUserType() {
        return (byte[]) get(1);
    }

    /**
     * Setter for <code>Account.NAMA_DEPAN</code>.
     */
    public void setNamaDepan(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>Account.NAMA_DEPAN</code>.
     */
    public String getNamaDepan() {
        return (String) get(2);
    }

    /**
     * Setter for <code>Account.NAMA_BELAKANG</code>.
     */
    public void setNamaBelakang(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>Account.NAMA_BELAKANG</code>.
     */
    public String getNamaBelakang() {
        return (String) get(3);
    }

    /**
     * Setter for <code>Account.email</code>.
     */
    public void setEmail(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>Account.email</code>.
     */
    public String getEmail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>Account.phonenumber</code>.
     */
    public void setPhonenumber(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>Account.phonenumber</code>.
     */
    public String getPhonenumber() {
        return (String) get(5);
    }

    /**
     * Setter for <code>Account.state_id</code>.
     */
    public void setStateId(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>Account.state_id</code>.
     */
    public Integer getStateId() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>Account.country_id</code>.
     */
    public void setCountryId(Integer value) {
        set(7, value);
    }

    /**
     * Getter for <code>Account.country_id</code>.
     */
    public Integer getCountryId() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>Account.city_id</code>.
     */
    public void setCityId(Integer value) {
        set(8, value);
    }

    /**
     * Getter for <code>Account.city_id</code>.
     */
    public Integer getCityId() {
        return (Integer) get(8);
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
    // Record9 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, byte[], String, String, String, String, Integer, Integer, Integer> fieldsRow() {
        return (Row9) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row9<Integer, byte[], String, String, String, String, Integer, Integer, Integer> valuesRow() {
        return (Row9) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Account.ACCOUNT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<byte[]> field2() {
        return Account.ACCOUNT.USER_TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Account.ACCOUNT.NAMA_DEPAN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Account.ACCOUNT.NAMA_BELAKANG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Account.ACCOUNT.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Account.ACCOUNT.PHONENUMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field7() {
        return Account.ACCOUNT.STATE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field8() {
        return Account.ACCOUNT.COUNTRY_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field9() {
        return Account.ACCOUNT.CITY_ID;
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
    public byte[] component2() {
        return getUserType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component3() {
        return getNamaDepan();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getNamaBelakang();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getPhonenumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component7() {
        return getStateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component8() {
        return getCountryId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component9() {
        return getCityId();
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
    public byte[] value2() {
        return getUserType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getNamaDepan();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getNamaBelakang();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getPhonenumber();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value7() {
        return getStateId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value8() {
        return getCountryId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value9() {
        return getCityId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value2(byte... value) {
        setUserType(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value3(String value) {
        setNamaDepan(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value4(String value) {
        setNamaBelakang(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value5(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value6(String value) {
        setPhonenumber(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value7(Integer value) {
        setStateId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value8(Integer value) {
        setCountryId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord value9(Integer value) {
        setCityId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRecord values(Integer value1, byte[] value2, String value3, String value4, String value5, String value6, Integer value7, Integer value8, Integer value9) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AccountRecord
     */
    public AccountRecord() {
        super(Account.ACCOUNT);
    }

    /**
     * Create a detached, initialised AccountRecord
     */
    public AccountRecord(Integer id, byte[] userType, String namaDepan, String namaBelakang, String email, String phonenumber, Integer stateId, Integer countryId, Integer cityId) {
        super(Account.ACCOUNT);

        set(0, id);
        set(1, userType);
        set(2, namaDepan);
        set(3, namaBelakang);
        set(4, email);
        set(5, phonenumber);
        set(6, stateId);
        set(7, countryId);
        set(8, cityId);
    }
}
