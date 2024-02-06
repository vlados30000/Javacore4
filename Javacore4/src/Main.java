import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        File dirSrc = new File("C://Games/src");
        if (dirSrc.mkdir()) {
            sb.append("В каталоге Games успешно создан каталог src");
        } else {
            sb.append("При создании каталога src в каталоге Games произошла ошибка");
        }

        File dirRes = new File("C://Games/res");
        if (dirRes.mkdir()) {
            sb.append("В каталоге Games успешно создан каталог res");
        } else {
            sb.append("При создании каталога res в каталоге Games произошла ошибка");
        }

        File dirSaveGames = new File("C://Games/savegames");
        if (dirSaveGames.mkdir()) {
            sb.append("В каталоге Games успешно создан каталог savegames");
        } else {
            sb.append("При создании каталога savegames в каталоге Games произошла ошибка");
        }

        File dirTemp = new File("C://Games/temp");
        if (dirTemp.mkdir()) {
            sb.append("В каталоге Games успешно создан каталог temp");
        } else {
            sb.append("При создании каталога temp в каталоге Games произошла ошибка");
        }

        File dirSrcMain = new File("C://Games/src/main");
        if (dirSrcMain.mkdir()) {
            sb.append("В каталоге Src успешно создан каталог main");
        } else {
            sb.append("При создании каталога main в каталоге Src произошла ошибка");
        }

        File fileMain = new File(dirSrcMain, "Main.java");
        try {
            if (fileMain.createNewFile())
                sb.append("В каталоге С:/Games/src/main был успешно создан файл Main.java");
        } catch (IOException ex) {
            sb.append("При создании файла Main.java произошла ошибка");
            sb.append(ex.getMessage());
        }


        File fileUtils = new File(dirSrcMain, "Utils.java");
        try {
            if (fileUtils.createNewFile())
                sb.append("В каталоге С:/Games/src/main был успешно создан файл Utils.java");
        } catch (IOException ex) {
            sb.append("При создании файла Main.java произошла ошибка");
            sb.append(ex.getMessage());
        }


        File dirResDrawables = new File("C://Games/res/drawables");
        if (dirResDrawables.mkdir()) {
            sb.append("В каталоге res успешно создан каталог drawables");
        } else {
            sb.append("При создании каталога drawables в каталоге res произошла ошибка");
        }


        File dirResVectors = new File("C://Games/res/vectors");
        if (dirResVectors.mkdir()) {
            sb.append("В каталоге res успешно создан каталог vectors");
        } else {
            sb.append("При создании каталога vectors в каталоге res произошла ошибка");
        }


        File dirResIcons = new File("C://Games/res/icons");
        if (dirResIcons.mkdir()) {
            sb.append("В каталоге res успешно создан каталог icons");
        } else {
            sb.append("При создании каталога icons в каталоге res произошла ошибка");
        }


        File fileTemp = new File(dirTemp, "Temp.txt");
        try {
            if (fileTemp.createNewFile())
                sb.append("В каталоге temp был создан файл Temp.txt");
        } catch (IOException ex) {
            sb.append("При создании файла Temp.txt произошла ошибка: ");
            sb.append(ex.getMessage());
        }
        String text = sb.toString();
        try (FileWriter writer = new FileWriter(fileTemp, false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
