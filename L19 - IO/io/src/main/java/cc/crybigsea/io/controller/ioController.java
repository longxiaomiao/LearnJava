package cc.crybigsea.io.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ioController {
    @RequestMapping("/hello")
    public String hello() {
        File f = new File("d:/sea");
        System.out.println(f.getAbsolutePath());
        File f2 = new File("iodemo.txt");
        System.out.println(f2.getAbsolutePath());
        File f3 = new File(f, "iodemo.txt");
        System.out.println(f3.getAbsolutePath());

        System.out.println();
        System.out.println("当前文件:" + f2);
        System.out.println("文件是否存在：" + f2.exists());
        System.out.println("是否是文件夹：" + f2.isDirectory());
        System.out.println("获取文件大小：" + f2.length());
        System.out.println("文件最后修改时间：" + new Date(f2.lastModified()));
        System.out.println("设置文件修改时间为当前时间");
        f2.setLastModified((new Date()).getTime());
        System.out.println("文件最后修改时间：" + new Date(f2.lastModified()));

        System.out.println("");
        System.out.println("修改文件名");
        f2.renameTo(new File("iotest.txt"));

        return "hello";
    }

    @RequestMapping("/hello2")
    public String hello2() throws IOException {

        File f = new File("iotest.txt");
        String[] list = f.list();
        File[] fList = f.listFiles();
        String d = f.getParent();
        f.getParentFile();
        f.mkdir();
        f.mkdirs();
        f.createNewFile();
        f.getParentFile().mkdir();
        f.listRoots();
        f.delete();
        f.deleteOnExit();
        return "hello2";
    }

    @RequestMapping("/hello3")
    public String hello3() {

        Long min = Long.MAX_VALUE;
        Long max = 0l;
        String maxFile = "";
        String minFile = "";

        File f = new File("C:\\WINDOWS");
        File[] list = f.listFiles();
        for (File file : list) {
            if (file.isDirectory())
                continue;
            Long fileLength = file.length();
            if (fileLength == 0)
                continue;
            if (fileLength > max) {
                max = fileLength;
                maxFile = file.getAbsolutePath();
            }
            if (fileLength < min) {
                min = fileLength;
                minFile = file.getAbsolutePath();
            }
        }

        return "minFile:" + minFile + ";min:" + min + "\r\nmaxFile:" + maxFile + ";max:" + max;
    }

    @RequestMapping("/hello4")
    public String hello4() {
        FindFile(new File("C:\\WINDOWS"));
        return "minFile:" + minFile + ";min:" + minLength + "\r\nmaxFile:" + maxFile + ";max:" + maxLength;
    }

    private Long minLength = Long.MAX_VALUE;
    private Long maxLength = 0l;
    private String minFile = "";
    private String maxFile = "";

    private void FindFile(File file) {
        File[] list = file.listFiles();
        if (list == null)
            return;
        for (File f : list) {
            if (f.isDirectory())
                FindFile(f);
            Long fileLength = f.length();
            if (fileLength == 0)
                continue;
            if (fileLength > maxLength) {
                maxLength = fileLength;
                maxFile = file.getAbsolutePath();
            }
            if (fileLength < minLength) {
                minLength = fileLength;
                minFile = file.getAbsolutePath();
            }
        }
    }
}