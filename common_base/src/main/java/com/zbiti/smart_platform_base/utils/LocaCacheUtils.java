package com.zbiti.smart_platform_base.utils;

import android.graphics.Bitmap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by ywb on 2018/4/26.
 * 本地持久化缓存数据
 */

public class LocaCacheUtils {

  public static void saveObjectCache(Serializable content,String fileDir, String cacheFileName) {
    ObjectOutputStream  fos = null;
    File file = new File(fileDir,cacheFileName);
   try {
     fos = new ObjectOutputStream(new FileOutputStream(file));
     fos.writeObject(content);
   } catch (IOException e) {
     e.printStackTrace();
   } finally {
     if(fos != null) {
       try {
         fos.close();
       } catch (IOException e) {
         e.printStackTrace();
       }
     }
   }
  }


  public static Serializable getObjectCache(String fileDir, String cacheFileName){

    File file = new File(fileDir,cacheFileName);//新建文件
    if (!file.getParentFile().exists()) {
      file.getParentFile().mkdirs();
    }
    if (file.exists()) {
      //如果文件存在
      FileInputStream fileInputStream = null;//打开文件输入流
      ObjectInputStream objectInputStream = null;//打开对象输入流
      try {
        fileInputStream = new FileInputStream(file.toString());//将新建的文件写入文件输入流
        objectInputStream = new ObjectInputStream(fileInputStream);//将文件输入流写入对象输入流
        Serializable serializable = (Serializable) objectInputStream.readObject();//获取对象输入流的对象
        return serializable;
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }finally {
        try {
          objectInputStream.close();//关闭对象输入流
          fileInputStream.close();//关闭文件输入流
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } else {
      return null;
    }
    return null;
  }

  public static void cleanCache(String fileDir, String cacheFileName){
    File file = new File(fileDir,cacheFileName);//新建文件
    if (!file.getParentFile().exists()) {
      return;
    }
    if (file.exists()){
      file.delete();
    }

  }

  /**
   * 清空文件夹下所有文件
   * @param directory
   */
  private static void deleteFilesByDirectory(File directory) {
    if (directory != null && directory.exists() && directory.isDirectory()) {
      for (File item : directory.listFiles()) {
        item.delete();
      }
    }
  }


  /**
   * 将广告图缓存到本地
   * @param bitmap
   */
  public static void saveBitmapCache(Bitmap bitmap,String path,String fileName){
    File file = new File(path, fileName);
    File fileParent = file.getParentFile();
    if (!fileParent.exists()) {
      fileParent.mkdirs();
    }
    try {
      bitmap.compress(Bitmap.CompressFormat.JPEG, 100,
          new FileOutputStream(file));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

}