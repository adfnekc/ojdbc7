package oracle.net.ano;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import oracle.net.ns.NetException;
import oracle.net.ns.SessionAtts;

public class AnoComm {
   private OutputStream a;
   private InputStream b;

   public AnoComm(SessionAtts var1) {
      this.a = var1.getOutputStream();
      this.b = var1.getInputStream();
   }

   protected final void a() throws IOException {
      this.a.flush();
   }

   protected final void a(short var1) throws IOException {
      this.a(1, 2);
      this.a.write(255 & var1);
   }

   protected final void a(int var1) throws IOException {
      this.a(2, 3);
      this.c(var1);
   }

   protected final void a(long var1) throws IOException {
      this.a(4, 4);
      this.b(var1);
   }

   protected final void a(int[] var1) throws IOException {
      this.a(10 + (var1.length << 1), 1);
      this.b(-559038737L);
      this.c(3);
      this.b((long)var1.length);

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.c(var1[var2] & '\uffff');
      }

   }

   protected final void b(int var1) throws IOException {
      this.a(2, 6);
      this.c(var1);
   }

   protected final void b() throws IOException {
      this.a(4, 5);
      this.b(169869312L);
   }

   protected final void a(String var1) throws IOException {
      this.a(var1.length(), 0);
      this.a.write(var1.getBytes());
   }

   protected final void a(byte[] var1) throws IOException {
      this.a(var1.length, 1);
      this.a.write(var1);
   }

   private void a(int var1, int var2) throws IOException {
      if (var2 >= 0 && var2 <= 7) {
         switch(var2) {
         case 0:
         case 1:
            break;
         case 2:
            if (var1 > 1) {
               throw new NetException(312);
            }
            break;
         case 3:
         case 6:
            if (var1 > 2) {
               throw new NetException(312);
            }
            break;
         case 4:
         case 5:
            if (var1 > 4) {
               throw new NetException(312);
            }
            break;
         case 7:
            if (var1 < 10) {
               throw new NetException(312);
            }
            break;
         default:
            throw new NetException(313);
         }

         this.c(var1);
         this.c(var2);
      } else {
         throw new NetException(313);
      }
   }

   protected final void c() throws IOException {
      this.b(169869312L);
   }

   protected final void b(short var1) throws IOException {
      this.a.write(0);
   }

   protected final void c(int var1) throws IOException {
      byte[] var2 = new byte[2];
      byte var3 = a((short)('\uffff' & var1), var2);
      this.a.write(var2, 0, var3);
   }

   protected final void b(long var1) throws IOException {
      byte[] var3 = new byte[4];
      byte var4 = a((int)(-1L & var1), var3);
      this.a.write(var3, 0, var4);
   }

   protected final short d() throws IOException {
      this.e(2);
      return this.l();
   }

   protected final int e() throws IOException {
      this.e(3);
      return this.m() & '\uffff';
   }

   protected final long f() throws IOException {
      this.e(4);
      return this.n();
   }

   protected final int[] g() throws IOException {
      this.e(1);
      long var1 = this.n();
      int var3 = this.m();
      int[] var4 = new int[(int)this.n()];
      if (var1 == -559038737L && var3 == 3) {
         for(int var5 = 0; var5 < var4.length; ++var5) {
            var4[var5] = this.m();
         }

         return var4;
      } else {
         throw new NetException(310);
      }
   }

   protected final int h() throws IOException {
      this.e(6);
      return this.m();
   }

   protected final long i() throws IOException {
      this.e(5);
      return this.n();
   }

   protected final String j() throws IOException {
      int var1 = this.e(0);
      return new String(this.d(var1));
   }

   protected final byte[] k() throws IOException {
      int var1 = this.e(1);
      return this.d(var1);
   }

   protected final short l() throws IOException {
      boolean var1 = false;

      try {
         short var3;
         if ((var3 = (short)this.b.read()) < 0) {
            throw new NetException(0);
         } else {
            return var3;
         }
      } catch (NetException var2) {
         throw new IOException(var2.getMessage());
      }
   }

   protected final int m() throws IOException {
      byte[] var1 = new byte[2];
      return (int)this.b(var1) & '\uffff';
   }

   protected final long n() throws IOException {
      byte[] var1 = new byte[4];
      return this.b(var1);
   }

   private byte[] d(int var1) throws IOException {
      byte[] var3 = new byte[var1];

      try {
         if (this.b.read(var3) < 0) {
            throw new NetException(0);
         } else {
            return var3;
         }
      } catch (NetException var2) {
         throw new IOException(var2.getMessage());
      }
   }

   private int e(int var1) throws IOException {
      int var2 = this.m();
      int var3 = this.m();
      int var10000 = var2;
      var2 = var1;
      var1 = var10000;
      if (var3 >= 0 && var3 <= 7) {
         if (var3 != var2) {
            throw new NetException(314);
         } else {
            switch(var2) {
            case 0:
            case 1:
               break;
            case 2:
               if (var1 > 1) {
                  throw new NetException(312);
               }
               break;
            case 3:
            case 6:
               if (var1 > 2) {
                  throw new NetException(312);
               }
               break;
            case 4:
            case 5:
               if (var1 > 4) {
                  throw new NetException(312);
               }
               break;
            case 7:
               if (var1 < 10) {
                  throw new NetException(312);
               }
               break;
            default:
               throw new NetException(313);
            }

            return var1;
         }
      } else {
         throw new NetException(313);
      }
   }

   private long b(byte[] var1) throws IOException {
      long var2 = 0L;

      try {
         if (this.b.read(var1) < 0) {
            throw new NetException(0);
         }
      } catch (NetException var5) {
         throw new IOException(var5.getMessage());
      }

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var2 |= (long)((var1[var4] & 255) << 8 * (var1.length - 1 - var4));
      }

      return var2;
   }

   private static byte a(int var0, byte[] var1) {
      byte var2 = 0;

      for(int var3 = var1.length - 1; var3 >= 0; --var3) {
         var1[var2++] = (byte)(var0 >>> (var3 << 3));
      }

      return var2;
   }
}
