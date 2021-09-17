package oracle.jdbc.replay.driver;

import java.sql.SQLException;
import java.sql.SQLRecoverableException;

interface Replayable {
   void fillInChecksum(FailoverManagerImpl.CallHistoryEntry var1) throws SQLException;

   Object replayOneCall(FailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2) throws SQLException;

   void addToSameProxyList(FailoverManagerImpl.CallHistoryEntry var1);

   void removeFromSameProxyList(FailoverManagerImpl.CallHistoryEntry var1);

   void purgeSameProxyList();

   void setReplayingCallContext(FailoverManagerImpl.CallHistoryEntry var1, SQLRecoverableException var2);

   FailoverManagerImpl getFailoverManager();

   void setFailoverManager(FailoverManagerImpl var1);
}
