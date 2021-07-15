package ru.adm123.serialize;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Base64;

/**
 * @author Dmitry Ushakov on 15.07.21
 */
public class ClsExternalizable implements Externalizable {

    private static final long SERIAL_VERSION_UID = "ClsExternalizable_1".hashCode();

    private int id;
    private String name;
    private String description;

    public ClsExternalizable() {
    }

    public ClsExternalizable(int id,
                             @Nullable String name,
                             @Nullable String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public void writeExternal(@NotNull ObjectOutput out) throws IOException {
        out.writeObject(id);
        out.writeObject(encryptString(name));
        out.writeObject(encryptString(description));
    }

    @Override
    public void readExternal(@NotNull ObjectInput in) throws IOException, ClassNotFoundException {
        id = (int) in.readObject();
        name = decryptString((String) in.readObject());
        description = decryptString((String) in.readObject());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=\"" + name + "\"" +
                ", description=\"" + description + "\"" +
                "}";
    }

    private String encryptString(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

    private String decryptString(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return new String(Base64.getDecoder().decode(str));
    }

}
