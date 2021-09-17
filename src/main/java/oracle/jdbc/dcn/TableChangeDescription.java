//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.dcn;

import java.util.EnumSet;

public interface TableChangeDescription {
    EnumSet<TableChangeDescription.TableOperation> getTableOperations();

    String getTableName();

    int getObjectNumber();

    RowChangeDescription[] getRowChangeDescription();

    public static enum TableOperation {
        ALL_ROWS(1),
        INSERT(2),
        UPDATE(4),
        DELETE(8),
        ALTER(16),
        DROP(32);

        private final int code;

        private TableOperation(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }

        public static final EnumSet<TableChangeDescription.TableOperation> getTableOperations(int var0) {
            EnumSet var1 = EnumSet.noneOf(TableChangeDescription.TableOperation.class);
            if ((var0 & ALL_ROWS.getCode()) != 0) {
                var1.add(ALL_ROWS);
            }

            if ((var0 & INSERT.getCode()) != 0) {
                var1.add(INSERT);
            }

            if ((var0 & UPDATE.getCode()) != 0) {
                var1.add(UPDATE);
            }

            if ((var0 & DELETE.getCode()) != 0) {
                var1.add(DELETE);
            }

            if ((var0 & ALTER.getCode()) != 0) {
                var1.add(ALTER);
            }

            if ((var0 & DROP.getCode()) != 0) {
                var1.add(DROP);
            }

            return var1;
        }
    }
}
