package oracle.jdbc.replay.driver;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReplayLoggerFactory {
   private static final Logger logger = Logger.getLogger(ReplayLoggerFactory.class.getCanonicalName());

   public static Logger getLogger(String var0) {
      return Logger.getLogger(var0);
   }

   public static synchronized void setLogLevel(Level var0) {
      try {
         Logger.getLogger("oracle.jdbc.internal.replay").setLevel(var0);
         if (var0 != null) {
            Handler[] var1 = Logger.getLogger("").getHandlers();

            for(int var2 = 0; var2 < var1.length; ++var2) {
               var1[var2].setLevel(var0);
            }
         }
      } catch (Exception var3) {
         logger.log(Level.FINEST, "setLogLevel", var3);
      }

   }

   public static Level getLogLevel() {
      return Logger.getLogger("oracle.jdbc.internal.replay").getLevel();
   }
}
