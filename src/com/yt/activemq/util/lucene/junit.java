package com.yt.activemq.util.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.util.List;

/**
 * Created by Administrator on 2016/1/22 0022.
 */
public class junit {
    public static void main(String[] args) {

        Query query = null;
        try {
            Analyzer analyzer=new StandardAnalyzer();
            CreateIndex.createIndex();
            query=CreateIndex.getQuery("name","人");
            CreateIndex.search(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
}
