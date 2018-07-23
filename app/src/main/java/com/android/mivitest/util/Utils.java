package com.android.mivitest.util;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class Utils {
    public static String readFromCollectionJSON(AssetManager mgr) {
        String filename = null;
        String fileContent = null;
        try {
            filename = "collection.json";
            System.out.println("filename : " + filename);
            InputStream in = mgr.open(filename, AssetManager.ACCESS_BUFFER);
            fileContent = StreamToString(in);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public static String StreamToString(InputStream in) throws IOException {
        if (in == null) {
            return "";
        }
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } finally {
        }
        return writer.toString();
    }
}
