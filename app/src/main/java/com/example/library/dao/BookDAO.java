package com.example.library.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.library.ConnectionHelper;
import com.example.library.database.Sqldatabase;
import com.example.library.model.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private SQLiteDatabase db;

    public BookDAO(Context context) {
        Sqldatabase sqldatabase = new Sqldatabase(context);
        db = sqldatabase.getWritableDatabase();
    }
    public long insert(Book book) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenSach", book.tenSach);
        contentValues.put("giaThue", book.giaThue);
        contentValues.put("maLoai", book.maLoai);
        contentValues.put("giamGia", book.giamGia);
        contentValues.put("tacGia", book.tacGia);
        return db.insert("Book", null, contentValues);
    }
    public int update(Book book) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenSach", book.tenSach);
        contentValues.put("giaThue", book.giaThue);
        contentValues.put("maLoai", book.maLoai);
        contentValues.put("giamGia", book.giamGia);
        contentValues.put("tacGia", book.tacGia);
        return db.update("Book", contentValues, "maSach=?",new String[]{String.valueOf(book.maSach)});
    }
    public int delete(String id) {
        return
                db.delete("Book", "maSach=?", new String[]{id});
    }
    public List<Book> getAll() {
        String sql = "select * from Book";
        return getData(sql);
    }
    public Book getID(String id) {
        String sql = "select * from Book where maSach=?";
        List<Book> list2 = new ArrayList<>();
        list2 = getData(sql, id);
        return list2.get(0);

    }

    private List<Book> getData(String sql, String... selectionArgs) {
//        List<Book> list = new ArrayList<>();
//        Cursor cursor = db.rawQuery(sql, selectionArgs);
//
//        while (cursor.moveToNext()) {
//            Book book = new Book();
//            book.maSach = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("maSach")));
//            book.maLoai = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("maLoai")));
//            book.tenSach = cursor.getString(cursor.getColumnIndexOrThrow("tenSach"));
//            book.giaThue = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("giaThue")));
//            book.giamGia = Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow("giamGia")));
//            book.tacGia = cursor.getString(cursor.getColumnIndexOrThrow("tacGia"));
//            list.add(book);
//        }
//        return list;

        List<Book> list = new ArrayList<>();
        Connection connect;
        String ConnectionResult = "";
        Cursor cursor = db.rawQuery(sql, selectionArgs);

        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.connectionclass();
            if(connect != null){
                String query = "SELECT DISTINCT Sach.MaSach, NhaPhatHanh.TenNPH, Sach.TenSach, BanSaoSach.Gia, TacGia.TenTacGia\n" +
                        "FROM Sach, TacGia, ChiTietTacGia, NhaPhatHanh, BanSaoSach\n" +
                        "WHERE (TacGia.MaTacGia = ChiTietTacGia.MaTacGia\n" +
                        "\tand ChiTietTacGia.MaSach = Sach.MaSach" +
                        "\tand BanSaoSach.MaSach = Sach.MaSach\n" +
                        "\tand NhaPhatHanh.MaNPH = Sach.MaNPH\n" +
                        "\tand BanSaoSach.MaSach = ChiTietTacGia.MaSach)" +
                        "ORDER BY Sach.MaSach ASC";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);

                while (rs.next())
                {
                    Book book = new Book();
                    book.maSach = rs.getString(1);
                    book.maLoai = rs.getString(2);
                    book.tenSach = rs.getString(3);
                    book.giaThue = rs.getInt(4);
                    book.giamGia = 1000;
                    book.tacGia = rs.getString(5);
                    list.add(book);
                }
            }
            else
            {
                ConnectionResult = "Check Connection";
            }
        }
        catch (Exception ex){

        }
        return list;
    }
}
