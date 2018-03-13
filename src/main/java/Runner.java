import db.DBHelper;
import models.File;
import models.Folder;
import models.Owner;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Owner owner1 = new Owner("Ria", "Koronidi");
        DBHelper.save(owner1);

        Folder folder1 = new Folder("pictures", owner1);
        DBHelper.save(folder1);

        Folder folder2 = new Folder("Documents", owner1);
        DBHelper.save(folder2);

        File file1 = new File("holidays","jpg",2,folder1);
        DBHelper.save(file1);

        File file2 = new File("family","jpg",3,folder1);
        DBHelper.save(file2);

        File file3 = new File("notes","txt",3,folder2);
        DBHelper.save(file3);

        file1.setSize(5);
        DBHelper.update(file1);

        folder1.setTitle("Pictures");
        DBHelper.update(folder1);

        List<File> listOfFiles = DBHelper.getAll(File.class);
        List<File> listOfFolders = DBHelper.getAll(Folder.class);

        List<File> filesByFolder = DBHelper.getFilesByFolder(folder1);

        List<Folder> foldersByOwner = DBHelper.getFoldersByOwner(owner1);

    }
}
