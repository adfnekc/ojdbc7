package oracle.jdbc.diagnostics;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;

public class DemultiplexingLogHandler extends FileHandler {
   static final String PROPERTY_PATTERN = "oracle.jdbc.diagnostics.DemultiplexingLogHandler.pattern";
   static final String PROPERTY_LIMIT = "oracle.jdbc.diagnostics.DemultiplexingLogHandler.limit";
   static final String PROPERTY_COUNT = "oracle.jdbc.diagnostics.DemultiplexingLogHandler.count";
   static final String PROPERTY_APPEND = "oracle.jdbc.diagnostics.DemultiplexingLogHandler.append";
   static final String DEFAULT_PATTERN = "%h/ojdbc_%s.trc";
   static final String DEFAULT_APPEND = String.valueOf(false);
   static final String DEFAULT_LIMIT = String.valueOf(Integer.MAX_VALUE);
   static final String DEFAULT_COUNT = String.valueOf(1);
   String localPattern;
   boolean localAppend;
   int localLimit;
   int localCount;
   Hashtable handlerList = new Hashtable(50);

   public DemultiplexingLogHandler() throws IOException {
      super(getFilename(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.pattern", "%h/ojdbc_%s.trc"), "MAIN"), Integer.parseInt(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.limit", DEFAULT_LIMIT)), Integer.parseInt(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.count", DEFAULT_COUNT)), Boolean.getBoolean(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.append", DEFAULT_APPEND)));
   }

   public DemultiplexingLogHandler(String var1) throws IOException {
      super(getFilename(var1, "MAIN"), Integer.parseInt(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.limit", DEFAULT_LIMIT)), Integer.parseInt(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.count", DEFAULT_COUNT)), Boolean.getBoolean(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.append", DEFAULT_APPEND)));
   }

   public DemultiplexingLogHandler(String var1, boolean var2) throws IOException {
      super(getFilename(var1, "MAIN"), Integer.parseInt(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.limit", DEFAULT_LIMIT)), Integer.parseInt(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.count", DEFAULT_COUNT)), var2);
   }

   public DemultiplexingLogHandler(String var1, int var2, int var3) throws IOException {
      super(getFilename(var1, "MAIN"), var2, var3, Boolean.getBoolean(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.append", DEFAULT_APPEND)));
   }

   public DemultiplexingLogHandler(String var1, int var2, int var3, boolean var4) throws IOException {
      super(getFilename(var1, "MAIN"), var2, var3, var4);
   }

   void initValues() {
      this.localPattern = getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.pattern", "%h/ojdbc_%s.trc");
      this.localLimit = Integer.parseInt(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.limit", DEFAULT_LIMIT));
      this.localCount = Integer.parseInt(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.count", DEFAULT_COUNT));
      this.localAppend = Boolean.getBoolean(getProperty("oracle.jdbc.diagnostics.DemultiplexingLogHandler.append", DEFAULT_APPEND));
   }

   static final String getFilename(String var0, String var1) {
      if (var0 == null) {
         var0 = "%h/ojdbc_%s.trc";
      }

      return var0.contains("%s") ? var0.replaceAll("%s", var1) : var0 + "." + var1;
   }

   static String getProperty(String var0, String var1) {
      String var2 = LogManager.getLogManager().getProperty(var0);
      return var2 != null ? var2 : var1;
   }

   public void publish(LogRecord var1) {
      Object[] var2 = var1.getParameters();
      if (var2 != null && var2.length > 0) {
         Object var3 = (Handler)this.handlerList.get(var2[0]);
         if (var3 == null) {
            if (this.localPattern == null) {
               this.initValues();
            }

            try {
               var3 = new FileHandler(getFilename(this.localPattern, (String)var2[0]), this.localLimit, this.localCount, this.localAppend);
               ((Handler)var3).setFormatter(this.getFormatter());
               ((Handler)var3).setFilter(this.getFilter());
               ((Handler)var3).setLevel(this.getLevel());
               ((Handler)var3).setEncoding(this.getEncoding());
               ((Handler)var3).setErrorManager(this.getErrorManager());
            } catch (IOException var5) {
               this.reportError("Unable open FileHandler", var5, 0);
            }

            this.handlerList.put(var2[0], var3);
         }

         ((Handler)var3).publish(var1);
      } else {
         super.publish(var1);
      }

   }

   public void close() {
      Iterator var1 = this.handlerList.values().iterator();

      while(var1.hasNext()) {
         Handler var2 = (Handler)var1.next();
         var2.close();
      }

      super.close();
   }
}
