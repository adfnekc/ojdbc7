package oracle.jdbc.proxy;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ProxyExport {
   public static void main(String[] var0) throws ClassNotFoundException, IOException {
      if (0 == var0.length) {
         System.out.println("Usage:");
         System.out.println("java -classpath ojdbc6.jar oracle.jdbc.proxy.ProxyExport [-d dir] class1 class2 class3 ...");
         System.out.println("  dir - directory to store exported proxy classes");
         System.out.println("  class1 class2 class3 ... - superclasses equipped with @ProxyFor annotation");
      } else {
         int var1 = 0;
         String var2 = "";
         if ("-d".equals(var0[0])) {
            if (var0.length < 2) {
               System.out.println("wrong directory");
               return;
            }

            var2 = var0[1];
            var1 = 2;
            if (!(new File(var2)).exists()) {
               System.out.println("target directory does not exist");
               return;
            }

            if (0 != var2.length() && !var2.endsWith(File.separator)) {
               var2 = var2 + File.separator;
            }
         }

         ArrayList var3;
         for(var3 = new ArrayList(); var1 < var0.length; ++var1) {
            var3.add(Class.forName(var0[var1]));
         }

         ProxyFactory var4 = ProxyFactory.createProxyFactory((Class[])var3.toArray(new Class[0]));
         AnnotationsRegistry var5 = var4.annotationsRegistry;
         Iterator var6 = var5.values().iterator();

         while(var6.hasNext()) {
            AnnotationsRegistry.Value var7 = (AnnotationsRegistry.Value)var6.next();
            Class var8 = var7.getSuperclass();
            Iterator var9 = var7.getIfacesToProxy().iterator();

            while(var9.hasNext()) {
               Class var10 = (Class)var9.next();
               GeneratedProxiesRegistry.Key var11 = new GeneratedProxiesRegistry.Key(var10, var8);
               byte[] var12 = ClassGenerator.generateBytecode(var11, var4.annotationsRegistry);
               String var13 = var11.makePathname();
               int var14 = var13.lastIndexOf(File.separator);
               if (-1 != var14) {
                  String var15 = var13.substring(0, var14);
                  (new File(var2 + var15)).mkdirs();
               }

               BufferedOutputStream var16 = new BufferedOutputStream(new FileOutputStream(var2 + var13));
               var16.write(var12);
               var16.close();
            }
         }

      }
   }
}
