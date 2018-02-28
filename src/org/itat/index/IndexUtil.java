package org.itat.index;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018/2/28.
 */
public class IndexUtil {
    private String[] ids = {"1","2","3","4","5","6"};
    private String[] emails = {"aa@itat.org","bb@163.com","cc@sina.com","dd@itat.edu.org","ee@163.com","ff@edu.cn"};
    private String[] contents = new String[]{"welcome to visited the space,I like book", "hello boy, I like pingpeng ball", "my name is cc I like game", "I like football", "I like football and I like basketball too", "I like movie and swim"};
    private int[] attachs = new int[]{2, 3, 1, 4, 5, 5};
    private String[] names = new String[]{"zhangsan", "lisi", "john", "jetty", "mike", "jake"};
    Directory directory = null;

    public IndexUtil(){
        try {
            directory = FSDirectory.open(new File("D:/GitHub_workspace/lucene/index02"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void index(){
        IndexWriter writer = null;
        try {
            writer = IndexWriter(directory,new IndexWriterConfig(Version.LUCENE_35,new StandardAnalyzer(Version.LUCENE_35)));
            Document doc = null;
            for(int i = 0; i < ids.length; i++){
                doc.add(new Field("id",ids[i],Field.Store.YES,));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null) writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
