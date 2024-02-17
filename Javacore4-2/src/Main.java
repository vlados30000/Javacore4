import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Main {

    public static void serialObject (String path, GameProgress gamer) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gamer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeZip (String arch, List<String> list) {
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(arch))) {
            for (int i = 0; i < list.size(); i++) {
                File file = new File(list.get(i));
                FileInputStream fis = new FileInputStream(file);
                ZipEntry entry = new ZipEntry(file.getName());
                zos.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zos.write(buffer);
                zos.closeEntry();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void delObject (List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            File file = new File(list.get(i));
            file.delete();
        }
    }

    public static void openZip (String arch) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(arch))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fos = new FileOutputStream(name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fos.write(c);
                }
                fos.flush();
                zin.closeEntry();
                fos.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static GameProgress openProgress(String path) {
        GameProgress gameProgress = null;
        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return gameProgress;
    }


    public static void main(String[] args) {
        GameProgress gamer1 = new GameProgress(87, 4, 6, 373.12);
        GameProgress gamer2 = new GameProgress(65, 8, 7, 541.89);
        GameProgress gamer3 = new GameProgress(37, 1, 4, 117);

        String path1 = "C://Games//savegames//save1.dat";
        String path2 = "C://Games//savegames//save2.dat";
        String path3 = "C://Games//savegames//save3.dat";

        serialObject(path1, gamer1);
        serialObject(path2, gamer2);
        serialObject(path3, gamer3);

        String arch = "C://Games//savegames//zip_output.zip";

        List<String> list = new ArrayList<>();
        list.add("C://Games//savegames//save1.dat");
        list.add("C://Games//savegames//save2.dat");
        list.add("C://Games//savegames//save3.dat");
        writeZip(arch, list);
        delObject(list);
        //openZip(arch);
        //System.out.println(openProgress(path1));

    }
}