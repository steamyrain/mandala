/*
 * This file is generated by jOOQ.
*/
package database.generated;


import database.generated.tables.Countries;
import database.generated.tables.Logins;
import database.generated.tables.Peneliti;
import database.generated.tables.Roles;
import database.generated.tables.SqliteSequence;
import database.generated.tables.Users;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in 
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>Logins</code>.
     */
    public static final Logins LOGINS = database.generated.tables.Logins.LOGINS;

    /**
     * The table <code>Peneliti</code>.
     */
    public static final Peneliti PENELITI = database.generated.tables.Peneliti.PENELITI;

    /**
     * The table <code>Roles</code>.
     */
    public static final Roles ROLES = database.generated.tables.Roles.ROLES;

    /**
     * The table <code>Users</code>.
     */
    public static final Users USERS = database.generated.tables.Users.USERS;

    /**
     * The table <code>countries</code>.
     */
    public static final Countries COUNTRIES = database.generated.tables.Countries.COUNTRIES;

    /**
     * The table <code>sqlite_sequence</code>.
     */
    public static final SqliteSequence SQLITE_SEQUENCE = database.generated.tables.SqliteSequence.SQLITE_SEQUENCE;
}
