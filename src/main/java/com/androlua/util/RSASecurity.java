package com.androlua.util;

import com.androlua.LuaApplication;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;

public class RSASecurity {

    /* renamed from: a */
    private static String f2793a = LuaApplication.getInstance().getLuaExtDir("PublicKey");

    /* renamed from: b */
    private static String f2794b = LuaApplication.getInstance().getLuaExtDir("PrivateKey");

    public static byte[] decrypt(byte[] bArr) {
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(f2794b));
            try {
                Key key = (Key) objectInputStream2.readObject();
                objectInputStream2.close();
                Cipher instance = Cipher.getInstance("RSA");
                instance.init(2, key);
                return instance.doFinal(bArr);
            } catch (Exception e) {
                e = e;
                objectInputStream = objectInputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = objectInputStream2;
                objectInputStream.close();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            throw e;
        }
    }

    public static byte[] encrypt(String str) {
        generateKeyPair();
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(f2793a));
            try {
                Key key = (Key) objectInputStream2.readObject();
                objectInputStream2.close();
                Cipher instance = Cipher.getInstance("RSA");
                instance.init(1, key);
                return instance.doFinal(str.getBytes());
            } catch (Exception e) {
                e = e;
                objectInputStream = objectInputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = objectInputStream2;
                objectInputStream.close();
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            throw e;
        }
    }

    public static void generateKeyPair() {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(1024, secureRandom);
        instance.initialize(1024);
        KeyPair generateKeyPair = instance.generateKeyPair();
        PublicKey publicKey = generateKeyPair.getPublic();
        PrivateKey privateKey = generateKeyPair.getPrivate();
        ObjectOutputStream objectOutputStream3 = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(f2793a));
            try {
                objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(f2794b));
            } catch (Exception e) {
                e = e;
                objectOutputStream2 = null;
                objectOutputStream3 = objectOutputStream;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream3;
                }
            } catch (Throwable th2) {
                th = th2;
                objectOutputStream.close();
                objectOutputStream3.close();
                throw th;
            }
            try {
                objectOutputStream.writeObject(publicKey);
                objectOutputStream2.writeObject(privateKey);
                objectOutputStream.close();
                objectOutputStream2.close();
            } catch (Exception e2) {
                e = e2;
                objectOutputStream3 = objectOutputStream;
                throw e;
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream3 = objectOutputStream2;
                objectOutputStream.close();
                objectOutputStream3.close();
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            objectOutputStream2 = null;
            throw e;
        } catch (Throwable th4) {
            th = th4;
            objectOutputStream = null;
            objectOutputStream.close();
            objectOutputStream3.close();
            throw th;
        }
    }
}
