//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package oracle.jdbc.dcn;

import oracle.jdbc.dcn.TableChangeDescription.TableOperation;
import oracle.sql.ROWID;

public interface RowChangeDescription {
    RowChangeDescription.RowOperation getRowOperation();

    ROWID getRowid();

    public static enum RowOperation {
        INSERT(TableOperation.INSERT.getCode()),
        UPDATE(TableOperation.UPDATE.getCode()),
        DELETE(TableOperation.DELETE.getCode());

        private final int code;

        private RowOperation(int var3) {
            this.code = var3;
        }

        public final int getCode() {
            return this.code;
        }

        public static final RowChangeDescription.RowOperation getRowOperation(int var0) {
            if (var0 == INSERT.getCode()) {
                return INSERT;
            } else {
                return var0 == UPDATE.getCode() ? UPDATE : DELETE;
            }
        }
    }
}
