/* GeneralDObject.java
 * @autor student Miro Maric 1031/16,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * 4.11.2018
 */
package DomainClasses;

import java.sql.*;

public interface GeneralDObject {

    String getAtrValue();

    String setAtrValue();

    String getClassName();

    String getWhereCondition();

    String getNameByColumn(int column);

    GeneralDObject getNewRecord(ResultSet rs) throws SQLException;
    
}
