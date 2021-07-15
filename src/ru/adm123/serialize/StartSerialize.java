package ru.adm123.serialize;

import java.io.*;

/**
 * @author Dmitry Ushakov on 15.07.21
 */
public class StartSerialize {

    public static void main(String[] args) {
        ClsSerializable obj = new ClsSerializable(1, "name_1", "description_1");
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream ous = new ObjectOutputStream(bos)) {
            ous.writeObject(obj);
            byte[] objectBytes = bos.toByteArray();
            try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(objectBytes))) {
                System.out.println("===============");
                System.out.println(ois.readObject());
                System.out.println("===============");
            } catch (IOException e) {
                throw new IOException(e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new ClassNotFoundException(e.getMessage());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
