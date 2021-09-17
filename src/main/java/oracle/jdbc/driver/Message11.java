package oracle.jdbc.driver;

import java.util.ResourceBundle;

class Message11 implements Message {
   private static ResourceBundle bundle;
   private static final String messageFile = "oracle.jdbc.driver.Messages";
   private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
   public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
   public static final boolean TRACE = false;

   public Message11() {
   }

   public String msg(String var1, Object var2) {
      if (bundle == null) {
         try {
            bundle = ResourceBundle.getBundle("oracle.jdbc.driver.Messages");
         } catch (Exception var5) {
            return "Message file 'oracle.jdbc.driver.Messages' is missing.";
         }
      }

      try {
         return var2 != null ? bundle.getString(var1) + ": " + var2 : bundle.getString(var1);
      } catch (Exception var4) {
         return "Message [" + var1 + "] not found in '" + "oracle.jdbc.driver.Messages" + "'.";
      }
   }
}
