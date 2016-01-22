package com.yt.activemq.util.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by Administrator on 2016/1/22 0022.
 */
public class CreateIndex {
    private static final String driverClassName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf-8";
    private static final String username = "root";
    private static final String password = "root";
    private Connection conn;
    private static ResultSet rs = null;
    private static Statement stmt = null;
    //索引生成目录
    private static final String paths = "D:/testluncene";
    public Connection getConnection() {
        if (this.conn == null) {
            try {
                Class.forName(driverClassName);
                conn = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


    public List<biao> getResult(String queryStr) throws Exception {
        List<biao> result = null;
        conn = this.getConnection();
        if(conn == null) {
            throw new Exception("数据库连接失败！");
        }
        String sql = "select id,name  from biao";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            //只有第一次的时候创建索引
            if(!new File(paths).exists()){
                new File(paths).mkdirs();
                this.createIndex(rs);   //给数据库创建索引,此处执行一次，不要每次运行都创建索引，以后数据有更新可以后台调用更新索引
            }

            Query query=this.getQuery("name",queryStr);
            TopDocs topDocs = this.search(query);
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        } catch(Exception e) {
            e.printStackTrace();
            throw new Exception("数据库查询sql出错！ sql : " + sql);
        } finally {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
        }
        return result;
    }





    public static Analyzer getAnalyzer() {
        Analyzer analyzer = new StandardAnalyzer();
        analyzer.setVersion(Version.LUCENE_5_4_0);
        return analyzer;
    }

    /**
     * @return
     */
    public static IndexWriter createIndexWriter() {
        IndexWriter indexWriter = null;
        try {
            Directory directory = FSDirectory.open(Paths.get(paths));
            IndexWriterConfig iwc = new IndexWriterConfig(getAnalyzer());
            indexWriter = new IndexWriter(directory, iwc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return indexWriter;
    }

    public static void closeIndexWriter(IndexWriter writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (CorruptIndexException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public IndexReader getIndexReader(boolean enableNRTReader) {
        Directory dir = null;
        IndexReader reader = null;
        try {
            dir = FSDirectory.open(Paths.get(paths));
            if (null == reader) {
                reader = DirectoryReader.open(dir);
            } else {
                if (enableNRTReader && reader instanceof DirectoryReader) {
                    //开启近实时Reader,能立即看到动态添加/删除的索引变化
                    reader = DirectoryReader.openIfChanged((DirectoryReader) reader);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }


    /**
     * 获取IndexSearcher对象
     *
     * @param reader IndexReader对象实例
     * @return
     */
    public IndexSearcher getIndexSearcher(IndexReader reader) {
        IndexSearcher searcher = null;
        if (null == reader) {
            throw new IllegalArgumentException("The indexReader can not be null.");
        }
        if (null == searcher) {
            searcher = new IndexSearcher(reader);
        }
        return searcher;
    }

    /**
     * 存储方式分为3种：1、完全存储（Field.Store.YES）；2、不存储（Field.Store.NO）；3、压缩存储（Field.Store.COMPRESS）。
     * 索引方式分为4种：1、不索引（Field.Index.NO）；2、 Field.Index.ANALYZED ；3、 Field.Index.NOT_ANALYZED；4、Field.Index.NOT_ANALYZED_NO_NORMS
     * 创建索引
     */
    public static void createIndex(ResultSet rs) {
        IndexWriter writer = null;
        Document doc = null;
        try {
            //创建索引写入者
            writer = createIndexWriter();
            while (rs.next()){
                System.out.println(rs.getString(1)+","+rs.getString(2));
                doc = new Document();
                Field id = new Field("id", String.valueOf(rs.getInt("id")), Field.Store.YES, Field.Index.NOT_ANALYZED, Field.TermVector.NO);
                Field username = new Field("name", rs.getString("name") == null ? "" : rs.getString("name"), Field.Store.YES,Field.Index.ANALYZED, Field.TermVector.NO);
                doc.add(id);
                doc.add(username);
                writer.addDocument(doc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeIndexWriter(writer);
        }
    }


    public static Query getQuery(String field, String content) {
        Query query = null;
        try {
            QueryParser parser = LuceneUtils.createQueryParser(field, getAnalyzer());
            query = parser.parse(content);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return query;
    }

    /**
     * 搜索
     *
     * @param query
     * @throws Exception
     */
    public static TopDocs search(Query query) throws Exception {
        Directory dire = FSDirectory.open(Paths.get(paths));
        IndexReader ir = DirectoryReader.open(dire);
        IndexSearcher is = new IndexSearcher(ir);
        TopDocs td = is.search(query, 1000);
        System.out.println("共为您查找到" + td.totalHits + "条结果");
        ScoreDoc[] sds = td.scoreDocs;
        for (ScoreDoc sd : sds) {
            Document d = is.doc(sd.doc);
            System.out.println(d.getFields().get(0).name()+":"+d.getFields().get(0).stringValue());
            System.out.println(d.getFields().get(1).name()+":"+d.getFields().get(1).stringValue());
        }
        return td;
    }

}
