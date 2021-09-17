//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.sql;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ConverterArchive {
    private String m_izipName;
    private FileOutputStream m_ifStream = null;
    private ZipOutputStream m_izStream = null;
    private InputStream m_riStream = null;
    private ZipFile m_rzipFile = null;
    private static final String TEMPFILE = "gsstemp.zip";
    private static final String _Copyright_2007_Oracle_All_Rights_Reserved_ = null;
    public static final String BUILD_DATE = "Thu_Apr_04_15:09:24_PDT_2013";
    public static final boolean TRACE = false;

    public ConverterArchive() {
    }

    public void openArchiveforInsert(String var1) {
        this.m_izipName = var1;

        try {
            this.m_ifStream = new FileOutputStream(this.m_izipName);
            this.m_izStream = new ZipOutputStream(this.m_ifStream);
        } catch (FileNotFoundException var3) {
        }

    }

    public void closeArchiveforInsert() {
        try {
            this.m_izStream.close();
            this.m_ifStream.close();
        } catch (IOException var2) {
        }

    }

    public void insertObj(Object var1, String var2) {
        ZipEntry var3 = null;
        ObjectOutputStream var4 = null;
        var3 = new ZipEntry(var2);

        try {
            this.m_izStream.putNextEntry(var3);
            var4 = new ObjectOutputStream(this.m_izStream);
            var4.writeObject(var1);
            var4.close();
            this.m_izStream.closeEntry();
        } catch (IOException var6) {
        }

    }

    public void insertSingleObj(String var1, Object var2, String var3) throws IOException {
        FileInputStream var4 = null;
        ZipInputStream var5 = null;
        FileOutputStream var6 = null;
        ZipOutputStream var7 = null;
        ZipEntry var8 = null;
        ObjectInputStream var10 = null;
        ObjectOutputStream var11 = null;
        File var12 = new File(var1);
        if (var12.isFile()) {
            try {
                var4 = new FileInputStream(var1);
                var5 = new ZipInputStream(var4);
                var6 = new FileOutputStream("gsstemp.zip");
                var7 = new ZipOutputStream(var6);

                while((var8 = var5.getNextEntry()) != null) {
                    if (!var8.getName().equals(var3)) {
                        var7.putNextEntry(var8);
                        var10 = new ObjectInputStream(var5);
                        var11 = new ObjectOutputStream(var7);
                        Object var9 = var10.readObject();
                        var11.writeObject(var9);
                    }
                }

                var8 = new ZipEntry(var3);
                var7.putNextEntry(var8);
                var11 = new ObjectOutputStream(var7);
                var11.writeObject(var2);
                var11.close();
                var5.close();
            } catch (FileNotFoundException var20) {
                throw new IOException(var20.getMessage());
            } catch (StreamCorruptedException var21) {
                throw new IOException(var21.getMessage());
            } catch (IOException var22) {
                throw var22;
            } catch (ClassNotFoundException var23) {
                throw new IOException(var23.getMessage());
            }

            File var13 = new File("gsstemp.zip");
            var12.delete();

            try {
                if (!var13.renameTo(var12)) {
                    throw new IOException("can't write to target file " + var1);
                }
            } catch (SecurityException var18) {
                throw new IOException(var18.getMessage());
            } catch (NullPointerException var19) {
                throw new IOException(var19.getMessage());
            }
        } else {
            try {
                var6 = new FileOutputStream(var1);
                var7 = new ZipOutputStream(var6);
                var8 = new ZipEntry(var3);
                var7.putNextEntry(var8);
                var11 = new ObjectOutputStream(var7);
                var11.writeObject(var2);
                var11.close();
            } catch (FileNotFoundException var15) {
                throw new IOException(var15.getMessage());
            } catch (StreamCorruptedException var16) {
                throw new IOException(var16.getMessage());
            } catch (IOException var17) {
                throw var17;
            }
        }

        System.out.print(var3 + " has been successfully stored in ");
        System.out.println(var1);
    }

    public void insertObjtoFile(String var1, String var2, Object var3) throws IOException {
        File var4 = new File(var1);
        File var5 = new File(var1 + var2);
        if (!var4.isDirectory()) {
            throw new IOException("directory " + var1 + " doesn't exist");
        } else {
            if (var5.exists()) {
                try {
                    var5.delete();
                } catch (SecurityException var10) {
                    throw new IOException("file exist,can't overwrite file.");
                }
            }

            try {
                FileOutputStream var6 = new FileOutputStream(var5);
                ObjectOutputStream var7 = new ObjectOutputStream(var6);
                var7.writeObject(var3);
                var7.close();
            } catch (FileNotFoundException var9) {
                throw new IOException("file can't be created.");
            }

            System.out.print(var2 + " has been successfully stored in ");
            System.out.println(var1);
        }
    }

    public void openArchiveforRead() {
        try {
            this.m_rzipFile = new ZipFile(this.m_izipName);
        } catch (IOException var2) {
            var2.printStackTrace();
            System.exit(0);
        }

    }

    public void closeArchiveforRead() {
        try {
            this.m_rzipFile.close();
        } catch (IOException var2) {
            var2.printStackTrace();
            System.exit(0);
        }

    }

    public Object readObj(String var1) {
        URL var2 = this.getClass().getResource(var1);
        Object var3 = null;
        ObjectInputStream var4 = null;
        InputStream var5 = null;
        if (var2 == null) {
            return null;
        } else {
            try {
                var5 = var2.openStream();
                var4 = new ObjectInputStream(var5);
                var3 = var4.readObject();
                Object var6 = var3;
                return var6;
            } catch (IOException var18) {
            } catch (ClassNotFoundException var19) {
            } finally {
                try {
                    if (var4 != null) {
                        var4.close();
                    }

                    if (var5 != null) {
                        var5.close();
                    }
                } catch (IOException var17) {
                }

            }

            return null;
        }
    }

    public Object readObj(String var1, String var2) {
        try {
            FileInputStream var3 = new FileInputStream(var1);
            ZipInputStream var4 = new ZipInputStream(var3);
            ZipEntry var5 = null;
            ObjectInputStream var6 = null;
            Object var7 = null;

            while(var4.available() != 0) {
                var5 = var4.getNextEntry();
                if (var5 != null && var5.getName().equals(var2)) {
                    var6 = new ObjectInputStream(var4);
                    var7 = var6.readObject();
                    break;
                }
            }

            var4.close();
            return var7;
        } catch (IOException var8) {
        } catch (ClassNotFoundException var9) {
        }

        return null;
    }
}
