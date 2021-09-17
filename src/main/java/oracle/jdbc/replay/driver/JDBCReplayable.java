package oracle.jdbc.replay.driver;

import java.sql.SQLException;
import java.sql.SQLRecoverableException;

interface JDBCReplayable {
   Object replayOneCall(TxnFailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2) throws SQLException;

   void addToSameProxyList(TxnFailoverManagerImpl.CallHistoryEntry var1);

   void removeFromSameProxyList(TxnFailoverManagerImpl.CallHistoryEntry var1);

   void purgeSameProxyList();

   void setReplayingCallContext(TxnFailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2);

   TxnFailoverManagerImpl getFailoverManager();

   void setFailoverManager(TxnFailoverManagerImpl var1);
}
