package Root;

import java.io.*;
import java.nio.charset.Charset;




public  class CopyFileUsingStream {
    private static void copyFileUsingStream(File source, Charset sourceEnc, File dest, Charset descEnc) throws IOException {
        Reader fis = new FileReader(String.valueOf(sourceEnc));
        Writer fos = new FileWriter(String.valueOf(descEnc));
        char[] buffer = new char[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }

}
