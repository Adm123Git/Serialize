package ru.adm123.serialize;

import com.sun.istack.internal.Nullable;

import java.io.Serializable;

/**
 * @author Dmitry Ushakov on 15.07.21
 */
public class ClsSerializable implements Serializable {

    private final static long serialVersionUID = "ClsSerializable_1".hashCode();

    private int id;
    private String name;
    private String description;

    public ClsSerializable(int id,
                           @Nullable String name,
                           @Nullable String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=\"" + name + "\"" +
                ", description=\"" + description + "\"" +
                "}";
    }

}
