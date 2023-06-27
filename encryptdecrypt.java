import java.io.*;

public class encryptdecrypt
{
    public static void encryptdecrypt(String[] args)
    {
        File inputFile = new File("input.txt");
        File encryptedFile = new File("encrypted.txt");
        File decryptedFile = new File("decrypted.txt");

        encryptFile(inputFile, encryptedFile);
        decryptFile(encryptedFile,decryptedFile);
    }

    public static void encryptFile(File inputFile, File encryptedFile)
    {
        try
        {
            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(encryptedFile);

            int key = 4; // KeyShift

            int data;

            while ((data = fis.read()) != -1)
            {
                data += key;
                fos.write(data);
            }
            System.out.println("File enrypted successfully!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void decryptFile(File encryptedFile, File decryptedFile)
    {
        try
        {
            FileInputStream fis = new FileInputStream(encryptedFile);
            FileOutputStream fos = new FileOutputStream(decryptedFile);

            int key = 4;

            int data;
            while ((data = fis.read()) != -1)
            {
                data -= key;
                fos.write(data);
            }

            System.out.println("File decrypted successfully!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}