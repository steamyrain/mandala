/*
 * This file is generated by jOOQ.
*/
package database.generated.tables;


import database.generated.DefaultSchema;
import database.generated.Keys;
import database.generated.tables.records.RolesRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Roles extends TableImpl<RolesRecord> {

    private static final long serialVersionUID = 6908584;

    /**
     * The reference instance of <code>Roles</code>
     */
    public static final Roles ROLES = new Roles();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RolesRecord> getRecordType() {
        return RolesRecord.class;
    }

    /**
     * The column <code>Roles.ID</code>.
     */
    public final TableField<RolesRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * @deprecated Unknown data type. Please define an explicit {@link org.jooq.Binding} to specify how this type should be handled.
     */
    @java.lang.Deprecated
    public final TableField<RolesRecord, Object> USERID = createField("USERID", org.jooq.impl.DefaultDataType.getDefaultDataType(""), this, "");

    /**
     * The column <code>Roles.ROLE</code>.
     */
    public final TableField<RolesRecord, String> ROLE = createField("ROLE", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false).defaultValue(org.jooq.impl.DSL.field("PENGUNJUNG", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>Roles.STATUS</code>.
     */
    public final TableField<RolesRecord, String> STATUS = createField("STATUS", org.jooq.impl.SQLDataType.VARCHAR(7).nullable(false).defaultValue(org.jooq.impl.DSL.field("PENDING", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>Roles</code> table reference
     */
    public Roles() {
        this(DSL.name("Roles"), null);
    }

    /**
     * Create an aliased <code>Roles</code> table reference
     */
    public Roles(String alias) {
        this(DSL.name(alias), ROLES);
    }

    /**
     * Create an aliased <code>Roles</code> table reference
     */
    public Roles(Name alias) {
        this(alias, ROLES);
    }

    private Roles(Name alias, Table<RolesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Roles(Name alias, Table<RolesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RolesRecord> getPrimaryKey() {
        return Keys.PK_ROLES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RolesRecord>> getKeys() {
        return Arrays.<UniqueKey<RolesRecord>>asList(Keys.PK_ROLES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<RolesRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<RolesRecord, ?>>asList(Keys.FK_ROLES_USERS_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Roles as(String alias) {
        return new Roles(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Roles as(Name alias) {
        return new Roles(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Roles rename(String name) {
        return new Roles(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Roles rename(Name name) {
        return new Roles(name, null);
    }
}
