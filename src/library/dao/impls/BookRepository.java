package library.dao.impls;

import library.dao.interfaces.IBookRepository;
import library.entities.Book;
import library.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

import static assignment1.book.list.Controller.editItem;

public class BookRepository implements IBookRepository {
    @Override
    public ArrayList<Book> all() {
        ArrayList<Book> list = new ArrayList<>();
        try {
            String sql_txt = "select * from books";
            Connector connector = Connector.getInstance();
            ResultSet resultSet = connector.query(sql_txt);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                int qty = resultSet.getInt("qty");
                Book book = new Book(id,name,author,qty);
                list.add(book);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public boolean create(Book book) {
        try {
            String sql_txt = "INSERT INTO books(name,author,qty) VALUES (?,?,?)";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(book.getName());
            arrayList.add(book.getAuthor());
            arrayList.add(book.getQty());
            if (connector.execute(sql_txt,arrayList)) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        try {
            String sql_txt = "update books set name=?, author=?,qty=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getName());
            arr.add(book.getAuthor());
            arr.add(book.getQty());
            arr.add(book.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Book book) {
        try {
            String sql_txt = "delete from books where id = ?";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(book.getId());
            if (connector.execute(sql_txt,arrayList)) {
                return true;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Book findOne(Integer id) {
        try {
            String sql_txt = "select * from books where id = ?";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(id);
            ResultSet resultSet = connector.executeQuery(sql_txt,arrayList);
            while (resultSet.next()){
                int Id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                int qty = resultSet.getInt("qty");
                return new Book(Id,name,author,qty);
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
