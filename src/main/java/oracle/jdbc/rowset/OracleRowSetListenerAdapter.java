package oracle.jdbc.rowset;

import java.io.Serializable;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public abstract class OracleRowSetListenerAdapter implements RowSetListener, Serializable {
   public void cursorMoved(RowSetEvent var1) {
   }

   public void rowChanged(RowSetEvent var1) {
   }

   public void rowSetChanged(RowSetEvent var1) {
   }
}
